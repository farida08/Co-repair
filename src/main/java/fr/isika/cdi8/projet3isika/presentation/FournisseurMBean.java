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
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Fournisseur;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import fr.isika.cdi8.projet3isika.idao.FournisseurIDao;
import fr.isika.cdi8.projet3isika.idao.PrestationFournisseurIDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ManagedBean
@SessionScoped
public class FournisseurMBean {

	private static Logger logger = LogManager.getLogger(FournisseurMBean.class);

	@Inject
	private FournisseurIDao fournisseurIDao;
	@Inject
	private PrestationFournisseurIDao prestationFournisseurIDao;

	private Fournisseur newFournisseur = new Fournisseur();
	private Adresse newAdresse = new Adresse();


	private String messagePwdLoginIntouvable;

	public void createFournisseur() {
		
		logger.info("Create user :" + newFournisseur.toString());
		if (!StringUtils.isEmpty(newFournisseur.getNumeroSiret())) {
			newFournisseur.setAdresse(newAdresse);
			fournisseurIDao.save(newFournisseur);
			logger.info("redirect to login 2.0");
			FacesContext currentInstance = FacesContext.getCurrentInstance();
			try {
				currentInstance.getExternalContext().redirect("login.xhtml");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("Une erreur est survenue lors de la redirection : ", e);
				e.printStackTrace();
			} 
			
		} else {
			logger.info("User is empty");
		}
	}
	public List<Prestation> getListePrestations(){
		List<Prestation> prestas = new ArrayList();
		prestas =prestationFournisseurIDao.findByFournisseur(newFournisseur);
		return prestas;
		
	}
	Fournisseur connected() {
		return newFournisseur;
	}
}
