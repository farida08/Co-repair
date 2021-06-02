package fr.isika.cdi8.projet3isika.entities.common_client_fournisseur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQueries({

		@NamedQuery(name = "SousType.findAll", query = "SELECT p FROM SousType p") })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SousType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	private String reference;

	@Column(name = "dureeEstime")
	private Integer dureeEstime;

	@OneToOne
	private Prestation prestationFournisseur;

	@OneToOne
	private Transaction transaction;

	@Override
	public String toString() {
		return "SousType [id=" + id + ", nom=" + nom + ", reference=" + reference + ", dureeEstime=" + dureeEstime+"]";
	}

	public SousType(Long id, String nom) {
	
		this.id = id;
		this.nom = nom;
	}

}
