package fr.isika.cdi8.projet3isika.entities.demandes_client;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import fr.isika.cdi8.projet3isika.entities.common.Adresse;
import fr.isika.cdi8.projet3isika.entities.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity

@DiscriminatorValue("Client")
@NamedQueries({
	@NamedQuery(name="Client.autentifier",query ="SELECT c FROM Client c WHERE c.username = :username AND c.motPasse = :motPasse"),
	@NamedQuery(name="Client.findByUsername",query ="SELECT c FROM Client c WHERE c.username = :username"),
	@NamedQuery(name="Client.findByMail",query ="SELECT c FROM Client c WHERE c.mail= :mail"),
	@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
})
public class Client extends User {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4725377685770834229L;

	@Inject
	@Column(unique = true)
	private String username;
	
	@OneToMany(mappedBy = "client")
	private List<Demande> demandesClient;

	

	@Override
	public String toString() {
		return "Client [username=" + username + ", demandesClient=" + demandesClient + "]";
	}



	public Client(Long id, String nom, String prenom, String motPasse, String mail, String numTel, String photo,
			Adresse adresse, String username, List<Demande> demandesClient) {
		super(id, nom, prenom, motPasse, mail, numTel, photo, adresse);
		this.username = username;
		this.demandesClient = demandesClient;
		}



	public Client(Long id, String nom, String prenom, String motPasse, String mail, String numTel, String photo,
			Adresse adresse, String username) {
		super(id, nom, prenom, motPasse, mail, numTel, photo, adresse);
		this.username = username;
	}
	

	
}
