package fr.isika.cdi8.projet3isika.services_metier;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fr.isika.cdi8.projet3isika.dao.DevisDao;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Devis;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.SousType;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import fr.isika.cdi8.projet3isika.idao.DavisIDao;
import fr.isika.cdi8.projet3isika.idao.PrestationFournisseurIDao;

@Service
public class DevisService {

	@Inject
	PrestationFournisseurIDao prestationFournisseurDao;

	@Inject
	DavisIDao devisDAO;

	private Devis newDevis = new Devis();

	@PostConstruct
	private void createJeuDeDonnees() {
		Prestation pFournisseur = new Prestation();
		pFournisseur.setCoutTotal(10.00);
		pFournisseur.setType("LocationGarage");
		pFournisseur.setDateDisponibilite(
				Arrays.asList(new Date("2021/12/12"), new Date("2021/06/12"), new Date("2021/08/12")));
		SousType sousType = new SousType();
		sousType.setNom("Peinture");
		sousType.setDureeEstime(123);
		sousType.setReference("ref1");
		sousType.setPrestationFournisseur(pFournisseur);

		pFournisseur.setSousType(sousType);

		Prestation pFournisseur1 = new Prestation();
		pFournisseur1.setCoutTotal(5.00);
		pFournisseur1.setType("Reparation");
		pFournisseur1.setDateDisponibilite(
				Arrays.asList(new Date("2022/12/12"), new Date("2022/06/12"), new Date("2022/08/12")));
		SousType sousType1 = new SousType();
		sousType1.setNom("car");
		sousType1.setDureeEstime(123);
		sousType1.setReference("ref2");
		sousType1.setPrestationFournisseur(pFournisseur1);

		pFournisseur1.setSousType(sousType1);

		Prestation pFournisseur2 = new Prestation();
		pFournisseur2.setCoutTotal(15.00);
		pFournisseur2.setType("LocationGarage");
		pFournisseur2.setDateDisponibilite(
				Arrays.asList(new Date("2023/12/12"), new Date("2023/06/12"), new Date("2023/08/12")));
		SousType sousType2 = new SousType();
		sousType2.setNom("Peinture");
		sousType2.setDureeEstime(123);
		sousType2.setReference("ref1");
		sousType2.setPrestationFournisseur(pFournisseur2);
		pFournisseur2.setSousType(sousType2);

		prestationFournisseurDao.save(pFournisseur);
		prestationFournisseurDao.save(pFournisseur1);
		prestationFournisseurDao.save(pFournisseur2);

	}

	public Devis getLowestCostPrestation(String sousType) {
		Prestation result = null;
		List<Prestation> prestationFournisseurs = prestationFournisseurDao.getPrestationBySousType(sousType);
		if (prestationFournisseurs != null && prestationFournisseurs.size() > 0) {
			Comparator<Prestation> comparatorPrix = Comparator.comparing(Prestation::getCoutTotal);
			result = prestationFournisseurs.stream().filter(pf -> pf.getCoutTotal() != null).min(comparatorPrix).get();
		}
		if (result != null && (result.getDateDisponibilite() == null || result.getDateDisponibilite().isEmpty())) {
			result = null;
		}
		if (result != null) {

			newDevis.setPrestationFournisseur(result);
			newDevis.setStatus("Init");
			devisDAO.save(newDevis);
		}

		return newDevis;

	}

	public Devis getEarlierPrestation(String sousType) {
		Prestation result = null;
		List<Prestation> prestationFournisseurs = prestationFournisseurDao.getPrestationBySousType(sousType);
		Date plustotDate = null;
		for (Prestation prestation : prestationFournisseurs) {
			Date dateTempo = prestation.getDateDisponibilite().stream().min(Date::compareTo).get();

			if (dateTempo != null) {
				if (plustotDate == null) {
					plustotDate = dateTempo;
				}
				if ((dateTempo.after(new Date()) && dateTempo.before(plustotDate))
						|| (result == null && dateTempo.after(new Date()))) {
					plustotDate = dateTempo;
					result = prestation;
				}
			}
		}

		if (result != null && (result.getDateDisponibilite() == null || result.getDateDisponibilite().isEmpty())) {
			result = null;
		}
		if (result != null) {

			newDevis.setPrestationFournisseur(result);
			newDevis.setStatus("Init");
			devisDAO.save(newDevis);
		}

		return newDevis;
	}

	public Devis getBetterPrestation(String criter, String sousType) {
		Prestation result = null;
		List<Prestation> prestationFournisseurs = prestationFournisseurDao.getPrestationBySousType(sousType);
		if (prestationFournisseurs != null && prestationFournisseurs.size() > 0) {

			if ("Prix".equalsIgnoreCase(criter)) {
				Comparator<Prestation> comparatorPrix = Comparator.comparing(Prestation::getCoutTotal);
				result = prestationFournisseurs.stream().filter(pf -> pf.getCoutTotal() != null).min(comparatorPrix)
						.get();
			} else if ("Date".equalsIgnoreCase(criter)) {
				// date a implementer
				Date plustotDate = null;
				for (Prestation prestation : prestationFournisseurs) {
					Date dateTempo = prestation.getDateDisponibilite().stream().min(Date::compareTo).get();

					if (dateTempo != null) {
						if (plustotDate == null) {
							plustotDate = dateTempo;
						}
						if ((dateTempo.after(new Date()) && dateTempo.before(plustotDate))
								|| (result == null && dateTempo.after(new Date()))) {
							plustotDate = dateTempo;
							result = prestation;
						}
					}
				}
			}
		}
		if (result != null && (result.getDateDisponibilite() == null || result.getDateDisponibilite().isEmpty())) {
			result = null;
		}
		// code a mettre dans la methode qui crée le devis
		if (result != null) {
			Devis newDevis = new Devis();
			newDevis.setPrestationFournisseur(result);
			newDevis.setStatus("Init");
			devisDAO.save(newDevis);
		}

		return newDevis;
	}

	public Devis getBetterPrestationByDate(String sousType, Date date) {
		Prestation result = null;
		List<Prestation> prestations = prestationFournisseurDao.getPrestationBySousTypeByDateAndPrice(sousType, date);
		if (prestations != null && prestations.size() > 0) {
			Comparator<Prestation> comparatorPrix = Comparator.comparing(Prestation::getCoutTotal);
			result = prestations.stream().filter(pf -> pf.getCoutTotal() != null).min(comparatorPrix).get();
		}
		if (result != null && (result.getDateDisponibilite() == null || result.getDateDisponibilite().isEmpty())) {
			result = null;
		}
		if (result != null) {

			newDevis.setPrestationFournisseur(result);
			// newDevis.setStatus("Init");

		}

		return newDevis;
	}

	public List<Devis> validateListDevis(List<Devis> listDevis) {
		for (Devis devis : listDevis) {
			if (devis != null) {
				devis.setStatus("validé");
				devisDAO.save(devis);
				List<Date> dateDispo = devis.getPrestationFournisseur().getDateDisponibilite();

				for (int i = dateDispo.size() - 1; i >= 0; i--) {
					if (dateDispo.get(i).equals(devis.getTransaction().getDemande().getDateSouhaitee())) {
						dateDispo.remove(i);
					}
				}
				devis.getPrestationFournisseur().setDateDisponibilite(dateDispo);
				
				prestationFournisseurDao.save(devis.getPrestationFournisseur());
			}
		}
		return listDevis;
	}

	public List<Devis> annulerListDevis(List<Devis> list) {
		for (Devis d : list) {
			if (d != null) {
				d.setStatus("annulé");
				devisDAO.save(d);
			}
		}
		return list;
	}

	public List<Devis> createListDevis(List<Devis> list) {
		for (Devis d : list) {
			if (d != null) {
				d.setStatus("non validé");
				devisDAO.save(d);
			}
		}
		return list;
	}
}
