package fr.isika.cdi8.projet3isika.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.isika.cdi8.projet3isika.entities.admin.Administrateur;
import fr.isika.cdi8.projet3isika.entities.common.Adresse;
import fr.isika.cdi8.projet3isika.idao.AdminIDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ManagedBean
@SessionScoped
public class AdminMBean {
	@Autowired
	private AdminIDao adminIDao;

	private Administrateur newAdmin = new Administrateur();
	private Adresse newAdresse = new Adresse();
	private List<Administrateur> administrateurs = new ArrayList<Administrateur>();

	private String messagePwdLoginIntouvable;

	public void createAdmin() {
		newAdmin.setAdresse(newAdresse);
		adminIDao.save(newAdmin);
	}

	public String connecterAdmin() {
		administrateurs = adminIDao.autentifier(newAdmin);
		if (!administrateurs.isEmpty()) {
			newAdmin = administrateurs.get(0);
		} else {
			messagePwdLoginIntouvable = "Login et/ou mot de passe introuvable";
		}
		return "index.xhtml";
	}

//	Client connected() {
//		return newClient;
//	}
}


