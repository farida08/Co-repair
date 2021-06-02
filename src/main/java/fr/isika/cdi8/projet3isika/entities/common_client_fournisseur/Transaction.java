package fr.isika.cdi8.projet3isika.entities.common_client_fournisseur;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_service", discriminatorType = DiscriminatorType.STRING)
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "transaction")
	private Devis devis;

	@ManyToOne
	private Demande demande;
	
	private String Type;

	@OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
	private SousType sousType;

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", devis=" + devis + ", demande=" + demande + ", Type=" + Type + ", sousType="
				+ sousType + "]";
	}

	public Transaction(Long id, Demande demande, String type, SousType sousType) {
		super();
		this.id = id;
		this.demande = demande;
		Type = type;
		this.sousType = sousType;
	}
	
	
	
}
