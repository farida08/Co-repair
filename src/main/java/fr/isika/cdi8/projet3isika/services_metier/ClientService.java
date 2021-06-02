package fr.isika.cdi8.projet3isika.services_metier;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import fr.isika.cdi8.projet3isika.entities.demandes_client.Client;
import fr.isika.cdi8.projet3isika.idao.ClientIDao;

@Service
public class ClientService {

	private final static Logger logger = LogManager.getLogger(ClientService.class);

	@Inject
	private ClientIDao clientIDao;

	public void creer(Client client) {
		logger.error("START Demande a créer : " + client);
		clientIDao.save(client);

	}

	public Client findByMail(String mail) {
		return clientIDao.findByMail(mail);
	}

}
