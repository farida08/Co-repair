package fr.isika.cdi8.projet3isika.entities.demandes_client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Demande")

@NamedQueries({ @NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d") })
public class Demande {

	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long referncedemande;

	@Column(name = "datedemande")
	private Date datedemande;

	@Column(name = "dateSouhaitee")
	private Date dateSouhaitee;

	@OneToMany(mappedBy = "demande", cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<Transaction>();

	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

	public void add(Transaction newDemandeReparationClient) {
		newDemandeReparationClient.setDemande(this);
		this.transactions.add(newDemandeReparationClient);
	}

	@Override
	public String toString() {
		return "Demande [referncedemande=" + referncedemande + ", datedemande=" + datedemande + ", dateSouhaitee="
				+ dateSouhaitee + "]";
	}
	public Demande(Long referncedemande, Date datedemande, Date dateSouhaitee, Client client) {
	
		this.referncedemande = referncedemande;
		this.datedemande = datedemande;
		this.dateSouhaitee = dateSouhaitee;
		this.client = client;
	}


}
