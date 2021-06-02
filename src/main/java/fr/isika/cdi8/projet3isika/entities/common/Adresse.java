package fr.isika.cdi8.projet3isika.entities.common;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.isika.cdi8.projet3isika.entities.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdAdresse;
	
	@Column(name = "numero")
	private String numero;
	@Column(name = "rue")
	private String rue;
	@Column(name = "ville")
	private String ville;
	@Column(name = "codePostale")
	private String codePostale;
	@Column(name = "region")
	private String region;
	@Column(name = "pays")
	private String pays;
	@OneToMany(mappedBy = "adresse")
	private List<User> users;

	public Adresse(long idAdresse, String numero, String rue, String ville, String codePostale, String region,
			String pays) {

		IdAdresse = idAdresse;
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostale = codePostale;
		this.region = region;
		this.pays = pays;
	}

}
