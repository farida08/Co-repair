package fr.isika.cdi8.projet3isika.entities.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import fr.isika.cdi8.projet3isika.entities.common.Adresse;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Client;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Fournisseur;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_user", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
	@NamedQuery(name="User.autentifier",query ="SELECT u FROM User u WHERE u.mail = :mail AND u.motPasse = :motPasse"),})
public class User implements Serializable {

	private static final long serialVersionUID = 8476456368775476903L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "motPasse")
	private String motPasse;
	@Column(unique = true)
	private String mail;
	@Column(name = "numTel")
	private String numTel;
	@Column (name="photo")
	private String photo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Adresse adresse;
	


	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", motPasse=" + motPasse + ", mail=" + mail
				+ ", numTel=" + numTel + ", adresse=" + adresse + "]";
	}

	boolean isClient() {
		return this instanceof Client;
	}
	
	boolean isFournisseur() {
		return this instanceof Fournisseur;
	}

	public User(Long id, String nom, String prenom, String motPasse, String mail, String numTel, String photo,
			Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.motPasse = motPasse;
		this.mail = mail;
		this.numTel = numTel;
		this.photo = photo;
		this.adresse = adresse;
	}


	
}
