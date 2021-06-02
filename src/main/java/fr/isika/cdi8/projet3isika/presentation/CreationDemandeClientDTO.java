package fr.isika.cdi8.projet3isika.presentation;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;


import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Transaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreationDemandeClientDTO {

	private LocalDate dateCreation = LocalDate.now();
	private List<Transaction> demandes = new ArrayList<Transaction>();

	private Date dateSouhaitee;

	private boolean reparation = false ;
	private boolean locationOutillage  = false ;
	private boolean locationGarage = false ;
	private boolean mainOuvre = false ;

	private String nomReparation;
	private String nomMain;
	private String nomGarage;
	private String nomOutillage;
	private String[] selectedTransactions;
	private List<Date> multi;
	

//	private List<String> sousTypeGarage = Stream.of("peinture", "mecanique", "electrique").collect(Collectors.toList());
//	private List<String> sousTypeReparation = Stream.of("freinage", "révision et vidange", "pièces moteurs",
//			" embrayage", " suspensions", "démaragge", "climatisation").collect(Collectors.toList());
//	private List<String> sousTypeMateriel = Stream.of("pompe", "manomètre", "compresseur", "pince à collier")
//			.collect(Collectors.toList());
//	private List<String> sousTypeMainOuvre = Stream.of("peinture", "mecanique", "electrique")
//			.collect(Collectors.toList());

	public boolean estUneReparation() {
		for (String s :selectedTransactions) {
			if(s.equals("reparation")) {
				reparation = true;
			}
		}
		return reparation;
		
	}

	public boolean estUneLocationOutillage() {
		for (String s :selectedTransactions) {
			if(s.equals("locationOutillage")) {
				locationOutillage =true  ;
			}
		}
			return locationOutillage;
	}

	public boolean estUneLocationGarage() {
		for (String s :selectedTransactions) {
			if(s.equals("locationGarage")) {
				locationGarage =true;
			}
		}
			return locationGarage;
	}

	public boolean estUneMainOuvre() {
		for (String s :selectedTransactions) {
			if(s.equals("mainOeuvre")) {
				mainOuvre =true;
			}
		}
		return mainOuvre;
}
}
