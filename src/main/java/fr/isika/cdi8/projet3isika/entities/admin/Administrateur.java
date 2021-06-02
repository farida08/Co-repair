package fr.isika.cdi8.projet3isika.entities.admin;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import fr.isika.cdi8.projet3isika.entities.common.Adresse;
import fr.isika.cdi8.projet3isika.entities.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("Administrateur")
@NamedQueries({
	@NamedQuery(name="Administrateur.autentifier",query ="SELECT a FROM Administrateur a WHERE a.moderateur = :moderateur AND a.motPasse = :motPasse"),
	@NamedQuery(name="Administrateur.findByModerateur",query ="SELECT a FROM Administrateur a WHERE a.moderateur = :moderateur"),
	@NamedQuery(name = "Administrateur.findAll", query = "SELECT a FROM Administrateur a")
})
public class Administrateur extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3345211431062146054L;
	
	@Column(unique = true)
	private String moderateur;

	public Administrateur(Long id, String nom, String prenom, String motPasse, String mail, String numTel, String photo,
			Adresse adresse, String moderateur) {
		super(id, nom, prenom, motPasse, mail, numTel, photo, adresse);
		this.moderateur = moderateur;
	}

	

}
