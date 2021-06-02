package fr.isika.cdi8.projet3isika.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreationPrestationFournisseurDTO {

	private List<Prestation> prestations = new ArrayList<Prestation>();

	private List<Date> dateDisponibilite;
	private boolean reparation;
	private boolean mainOuvre;
	private boolean locationOutillage;
	private boolean locationGarage;

	private String nomReparation;
	private String nomMainOuvre;
	private String nomGarage;
	private String nomOutillage;

	private Double prixReparation = Double.valueOf(0);
	private Double prixMainOuvre = Double.valueOf(0);
	private Double prixGarage = Double.valueOf(0);
	private Double prixOutillage = Double.valueOf(0);


	private List<Date> multiReparationDate;
	private List<Date> multiGarageDate;
	private List<Date> multiLocationOutillageDate;
	private List<Date> multiMainOeuvreDate;
	public boolean estUneMainOuvre() {
		return mainOuvre;
	}

	public boolean estUneReparation() {
		return reparation;
	}

	public boolean estUneLocationOutillage() {
		return locationOutillage;
	}

	public boolean estUneLocationGarage() {
		return locationGarage;
	}

	public void setLocationOutillageAndOthersToFalse() {
		setReparation(false);
		setMainOuvre(false);
		setLocationGarage(false);
		setLocationOutillage(true);
	}

	public void setRepratationAndOthersToFalse() {
		setReparation(true);
		setMainOuvre(false);
		setLocationGarage(false);
		setLocationOutillage(false);
	}

	public void setMainOuvreAndOthersToFalse() {
		setReparation(false);
		setMainOuvre(true);
		setLocationGarage(false);
		setLocationOutillage(false);
	}

	public void setLocationGarageAndOthersToFalse() {
		setReparation(false);
		setMainOuvre(false);
		setLocationGarage(true);
		setLocationOutillage(false);
	}

	@Override
	public String toString() {
		return "CreationPrestationFournisseurDTO [prestations=" + prestations + ", dateDisponibilite="
				+ dateDisponibilite + ", reparation=" + reparation + ", mainOuvre=" + mainOuvre + ", locationOutillage="
				+ locationOutillage + ", locationGarage=" + locationGarage + ", nomReparation=" + nomReparation
				+ ", nomMainOuvre=" + nomMainOuvre + ", nomGarage=" + nomGarage + ", nomOutillage=" + nomOutillage
				+ ", prixReparation=" + prixReparation + ", prixMainOuvre=" + prixMainOuvre + ", prixGarage="
				+ prixGarage + ", prixOutillage=" + prixOutillage + "]";
	}

}
