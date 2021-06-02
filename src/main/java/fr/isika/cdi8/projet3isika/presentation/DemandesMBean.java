package fr.isika.cdi8.projet3isika.presentation;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.net.server.Client;
import fr.isika.cdi8.projet3isika.dao.DevisDao;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Devis;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Transaction;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import fr.isika.cdi8.projet3isika.idao.DavisIDao;
import fr.isika.cdi8.projet3isika.idao.DemandeIDao;
import fr.isika.cdi8.projet3isika.idao.TransactionIDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ManagedBean
@RequestScoped
public class DemandesMBean {
	
	private Client client ;
	private Demande demandeClient;
	//private Transaction transaction;
	private Devis devis ;
	
	private List<Demande> listeDemande;
	
	//Map<Long, List<Transaction>> transactionsParDemande;
	Map<Long, List<Devis>> devisParDemande;

	@Autowired
	private DemandeIDao demandeClientIDao;
	
	//@Autowired
	//private TransactionIDao transactionIDao;
	@Autowired
	private DavisIDao devisIDao;
	
	@PostConstruct
	public void init() {
		devisParDemande = new HashMap<>();
		listeDemande = demandeClientIDao.findByClientId(client);
		listeDemande.forEach(dmd -> {
			devisParDemande.put(dmd.getReferncedemande(), getListeDevis(dmd.getReferncedemande()));
		});
	}
	public List<Devis> filterDevis(Long id) {
		
		return devisParDemande.get(id);
	}
	public List<Demande> getListeDemandes() {
		return listeDemande;
	}
	
	private List<Devis> getListeDevis(Long id) {
		return devisIDao.devisByDemandeId(id);
	}
}
