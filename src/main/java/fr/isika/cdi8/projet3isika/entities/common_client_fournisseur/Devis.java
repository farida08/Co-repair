package fr.isika.cdi8.projet3isika.entities.common_client_fournisseur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
@Entity
@NamedQueries({
	
	@NamedQuery(name = "Devis.findAll", query = "SELECT d FROM Devis d")
})
public class Devis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id ;
	@OneToOne
	private Transaction transaction;
	
	@OneToOne
	private Prestation prestationFournisseur ;
	
	private String Status;
	
}
