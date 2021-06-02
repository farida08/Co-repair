package fr.isika.cdi8.projet3isika.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Devis;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Transaction;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import fr.isika.cdi8.projet3isika.services_metier.DevisService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@RequestScoped
public class DevisMBean {
	@Inject
	DevisService devisService;
	@Inject
	DemandeClientMBean demandeClientMBean;

	Demande demande = null;
	List<Devis> listDevis = new ArrayList();
	List<AffichageDevis> affichageDevis = new ArrayList<>();

	public List<Devis> validateDevis() {
		devisService.validateListDevis(listDevis);

		return listDevis;

	}

	public List<Devis> annulerDevis() {
		devisService.annulerListDevis(listDevis);
		return listDevis;
	}

	@PostConstruct
	public void init() {
		demande = (Demande) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("DEMANDE");
		String choice = String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getFlash().get("CHOICE"));
		System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + choice);

		List<Transaction> listTransactions = demande.getTransactions();
		switch (choice) {
		case "PRIX":
			for (Transaction t : listTransactions) {
				Devis meilleurDEvis = devisService.getLowestCostPrestation(t.getSousType().getNom());
				listDevis.add(meilleurDEvis);
				AffichageDevis devis = new AffichageDevis(meilleurDEvis.getStatus(), t.getType(), t.getSousType().getNom(),
						meilleurDEvis.getPrestationFournisseur().getCoutTotal(), new Date());
				affichageDevis.add(devis);
			}
			break;

		case "DATE":
			for (Transaction t : listTransactions) {

				Devis meilleurDEvis = devisService.getBetterPrestationByDate(t.getSousType().getNom(),
						t.getDemande().getDateSouhaitee());
				listDevis.add(meilleurDEvis);
				AffichageDevis devis = new AffichageDevis(meilleurDEvis.getStatus(), t.getType(), t.getSousType().getNom(),
						meilleurDEvis.getPrestationFournisseur().getCoutTotal(), new Date());
				affichageDevis.add(devis);
			}
			break;

		default:
			for (Transaction t : listTransactions) {
				Devis meilleurDEvis = devisService.getEarlierPrestation(t.getSousType().getNom());
				listDevis.add(meilleurDEvis);
				AffichageDevis devis = new AffichageDevis(meilleurDEvis.getStatus(), t.getType(), t.getSousType().getNom(),
						meilleurDEvis.getPrestationFournisseur().getCoutTotal(), new Date());
				affichageDevis.add(devis);
			}
			break;
		}
		devisService.createListDevis(listDevis);

	}

	
}
