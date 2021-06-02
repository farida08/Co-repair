package fr.isika.cdi8.projet3isika.entities.prestations_fournisseur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Devis;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.SousType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter 
@Entity
@NamedQueries({
	
	@NamedQuery(name = "Prestation.findAll", query = "SELECT p FROM Prestation p")
})
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type_service",discriminatorType = DiscriminatorType.STRING)
public class Prestation {

	



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long referncePrestation ;
	
	@ElementCollection
	@CollectionTable(name="prestation_dateDisponibilite",joinColumns =@JoinColumn(name="prestation_id"))
	@Column(name = "dateDisponibilite")
	private List<Date> dateDisponibilite= new ArrayList<Date>();

	@Column(name = "coutHoraire")
	private double coutHoraire;
	@Column(name="coutTotal")
	private Double  coutTotal;


	public Prestation(Long referncePrestation, List<Date> dateDisponibilite, double coutTotal,
			Fournisseur fournisseur) {
		
		this.referncePrestation = referncePrestation;
		this.dateDisponibilite = dateDisponibilite;
		this.coutTotal = coutTotal;
		this.fournisseur = fournisseur;
	}
	public Prestation(Long referncePrestation, List<Date> dateDisponibilite, Double coutTotal, Fournisseur fournisseur,
			String type, SousType sousType) {
	
		this.referncePrestation = referncePrestation;
		this.dateDisponibilite = dateDisponibilite;
		this.coutTotal = coutTotal;
		this.fournisseur = fournisseur;
		Type = type;
		this.sousType = sousType;
	}
	

	@ManyToOne
	@JoinColumn(name = "idfournisseur")
	private Fournisseur fournisseur;
	
	@OneToOne (mappedBy = "prestationFournisseur")
	private Devis devis ;
	
	private String Type;
	
	@OneToOne (mappedBy = "prestationFournisseur", cascade = CascadeType.ALL)
	private SousType sousType;


	@Override
	public String toString() {
		return "PrestationFournisseur [referncePrestation=" + referncePrestation + ", dateDisponibilite="
				+ dateDisponibilite + ", coutHoraire=" + coutHoraire + ", coutTotal=" + coutTotal + ", fournisseur="
				+ fournisseur + ", devis=" + devis + ", Type=" + Type + ", sousType=" + sousType + "]";
	}
	
	
	
}
