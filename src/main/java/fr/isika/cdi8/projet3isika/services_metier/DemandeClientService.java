package fr.isika.cdi8.projet3isika.services_metier;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import fr.isika.cdi8.projet3isika.idao.DemandeIDao;

@Service
@Transactional
public class DemandeClientService {

	private static Logger logger = LogManager.getLogger(DemandeClientService.class);


	@Inject
	private DemandeIDao demandeClientIDao;
	
	
	
	public void creerNouvelleDemande(Demande newDemandeClient) {
		logger.error("START Demande a créer : "+newDemandeClient);
		demandeClientIDao.save(newDemandeClient);
//		logger.info("END Demande créée : "+newDemandeClient);

	}
	
}
