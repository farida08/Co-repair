package fr.isika.cdi8.projet3isika.presentation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import fr.isika.cdi8.projet3isika.entities.common.Adresse;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Client;
import fr.isika.cdi8.projet3isika.idao.ClientIDao;
import fr.isika.cdi8.projet3isika.services_metier.DevisService;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
@ManagedBean
@SessionScoped
public class ClientMBean {
	private static Logger logger = LogManager.getLogger(ClientMBean.class);
	@Inject
	private ClientIDao clientIDao;
	@Inject
	DevisService devisService;
	private Client newClient = new Client();
	private Adresse newAdresse = new Adresse();
	private List<Client> clients = new ArrayList<Client>();
	private String messagePwdLoginIntouvable;
	
	public void  createClient() {
		logger.info("Create user :" + newClient.toString());
		if(!StringUtils.isEmpty(newClient.getUsername())) {
			newClient.setAdresse(newAdresse);
			clientIDao.save(newClient);
			logger.info("redirect to login 2.0" );
			FacesContext currentInstance = FacesContext.getCurrentInstance();
			try {
				currentInstance.getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("Une erreur est survenue lors de la redirection : ",e);
				e.printStackTrace();
			}
		}else {
			logger.info("User is empty");
		}
	}
	Client connected() {
		return newClient;
	}
	public void getBetterPrestation() {
//		Prestation pf = devisService.getBetterPrestation("prix", "Peinture");
//		System.err.println(pf.toString());
//		Prestation pf = devisService.getBetterPrestation("date", "Peinture");
//
//		logger.error("#####################################",pf == null ? pf : pf.toString());
//		devisService.getBetterPrestationByDate("Peinture", new Date("2023/12/12"));
		//Ctrl + 1
		Client findByDemandeId = clientIDao.findByDemandeId(1);
		logger.info("Client retourné : ", findByDemandeId == null ? findByDemandeId : findByDemandeId.toString());
		System.err.println(findByDemandeId);
		
	}
}