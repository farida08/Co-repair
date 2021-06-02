package fr.isika.cdi8.projet3isika.presentation;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.isika.cdi8.projet3isika.entities.demandes_client.Client;
import fr.isika.cdi8.projet3isika.idao.ClientIDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ManagedBean
@RequestScoped

public class InfosClientMBean {

	@Autowired
	private UserMBean userMBean;
	
	@Inject
	private ClientIDao clientIDao;

	private Client newclient;

	public Client getClient() {
		String mail = userMBean.connectedMail();
		newclient = clientIDao.findByMail(mail);
		return newclient;
	}

}
