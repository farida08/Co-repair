package fr.isika.cdi8.projet3isika.entities.prestations_fournisseur;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import fr.isika.cdi8.projet3isika.entities.common.Adresse;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import fr.isika.cdi8.projet3isika.entities.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter @Getter
@Entity
@DiscriminatorValue (value= "Fournisseur")
@NamedQueries({
	@NamedQuery(name="Fournisseur.autentifier",query ="SELECT f FROM Fournisseur f WHERE f.mail = :mail AND f.motPasse = :motPasse"),

	@NamedQuery(name="Fournisseur.findByMail",query ="SELECT f FROM Fournisseur f WHERE f.mail = :mail"),
	@NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f")
})
public class Fournisseur extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1057438997285981106L;
	
	@Inject
	@Column(name="numeroSiret")
	private String numeroSiret ;
	@Column(name="nomSociete")
	private String nomSociete;
	
//	@Inject
//	@Column(unique = true)
//	private String username;

	public Fournisseur(Long id, String nom, String prenom, String motPasse, String mail, String numTel, String photo,
			Adresse adresse, String numeroSiret, String nomSociete, List<Prestation> prestationsFournisseur) {
		super(id, nom, prenom, motPasse, mail, numTel, photo, adresse);
		this.numeroSiret = numeroSiret;
		this.nomSociete = nomSociete;
		this.prestationsFournisseur = prestationsFournisseur;
	}

	public Fournisseur(Long id, String nom, String prenom, String motPasse, String mail, String numTel, String photo,
			Adresse adresse, String numeroSiret, String nomSociete) {
		super(id, nom, prenom, motPasse, mail, numTel, photo, adresse);
		this.numeroSiret = numeroSiret;
		this.nomSociete = nomSociete;
	}

	@OneToMany(mappedBy = "fournisseur")
	private List<Prestation> prestationsFournisseur;
	
	
	/*@OneToMany(mappedBy = "ServiceFournisseur")
	private List<ServiceFournisseur> ServicesFournisseur;*/

}
