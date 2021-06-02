package fr.isika.cdi8.projet3isika.services_metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.cdi8.projet3isika.dao.FournisseurDao;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Fournisseur;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurDao fournisseurDao;



	public Fournisseur findFournisseurByMail(String connectedMail) {
		return fournisseurDao.findByMail(connectedMail);
	}
}
