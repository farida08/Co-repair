package fr.isika.cdi8.projet3isika.services_metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import fr.isika.cdi8.projet3isika.idao.PrestationFournisseurIDao;

@Service
public class PrestationFournisseurService {

	@Autowired
	private PrestationFournisseurIDao prestationFournisseurIDao;

	public void creerNouvellePrestation(Prestation newPrestationFournisseur) {
		prestationFournisseurIDao.save(newPrestationFournisseur);

	}

}
