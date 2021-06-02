package fr.isika.cdi8.projet3isika.presentation;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.SousType;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Transaction;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Client;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Fournisseur;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import fr.isika.cdi8.projet3isika.services_metier.FournisseurService;
import fr.isika.cdi8.projet3isika.services_metier.PrestationFournisseurService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class PrestationFournisseurMBean {

	@Autowired
	private PrestationFournisseurService prestationFournisseurService;
	@Autowired
	private FournisseurService fournisseurService;
	@Autowired
	private FournisseurMBean fournisseurMBean;
	@Autowired
	private UserMBean userMBean;

	private CreationPrestationFournisseurDTO creationPrestationFournisseurDTO = new CreationPrestationFournisseurDTO();

	public void createPrestationFournisseur() {

		System.err.println(creationPrestationFournisseurDTO.toString());
		System.err.println(creationPrestationFournisseurDTO.estUneReparation());
		System.err.println(creationPrestationFournisseurDTO.estUneLocationGarage());
		System.err.println(creationPrestationFournisseurDTO.estUneLocationOutillage());
		System.err.println(creationPrestationFournisseurDTO.estUneMainOuvre());

		Fournisseur fournisseur = fournisseurService.findFournisseurByMail("@");

		Prestation prestation = new Prestation();
		prestation.setFournisseur(fournisseur);

		if (creationPrestationFournisseurDTO.estUneReparation()) {
			prestation.setType("reparation");
			prestation.setCoutTotal(creationPrestationFournisseurDTO.getPrixReparation());
			prestation.setDateDisponibilite(creationPrestationFournisseurDTO.getMultiReparationDate());
			SousType sousType = new SousType();
			sousType.setNom(creationPrestationFournisseurDTO.getNomReparation());
			prestation.setSousType(sousType);
		}

		if (creationPrestationFournisseurDTO.estUneLocationGarage()) {
			prestation.setType("locationGarage");
			prestation.setCoutTotal(creationPrestationFournisseurDTO.getPrixGarage());
			prestation.setDateDisponibilite(creationPrestationFournisseurDTO.getMultiGarageDate());
			SousType sousType = new SousType();
			sousType.setNom(creationPrestationFournisseurDTO.getNomGarage());
			prestation.setSousType(sousType);
		}

		if (creationPrestationFournisseurDTO.estUneMainOuvre()) {
			prestation.setType("mainOuvre");
			prestation.setCoutTotal(creationPrestationFournisseurDTO.getPrixMainOuvre());
			prestation.setDateDisponibilite(creationPrestationFournisseurDTO.getMultiMainOeuvreDate());
			SousType sousType = new SousType();
			sousType.setNom(creationPrestationFournisseurDTO.getNomMainOuvre());
			prestation.setSousType(sousType);
		}

		if (creationPrestationFournisseurDTO.estUneLocationOutillage()) {
			prestation.setType("locationOutillage");
			prestation.setCoutTotal(creationPrestationFournisseurDTO.getPrixOutillage());
			prestation.setDateDisponibilite(creationPrestationFournisseurDTO.getMultiLocationOutillageDate());
			SousType sousType = new SousType();
			sousType.setNom(creationPrestationFournisseurDTO.getNomOutillage());
			prestation.setSousType(sousType);
		}
		System.err.println(
				"***********************************************************************" + prestation.toString());
		prestationFournisseurService.creerNouvellePrestation(prestation);

	}

	public void addMessage() {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("summary"));
	}
}
