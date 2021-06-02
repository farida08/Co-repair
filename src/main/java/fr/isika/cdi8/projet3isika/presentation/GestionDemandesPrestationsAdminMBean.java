package fr.isika.cdi8.projet3isika.presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Transaction;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import fr.isika.cdi8.projet3isika.idao.DemandeIDao;
import fr.isika.cdi8.projet3isika.idao.PrestationFournisseurIDao;
import fr.isika.cdi8.projet3isika.idao.TransactionIDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class GestionDemandesPrestationsAdminMBean {

	private GestionDemandesClientsDTO gestionDemandesClientsDTO = new GestionDemandesClientsDTO();

	private Demande demandeClient;
	private Prestation prestation;
	private Transaction transaction;

	private List<Demande> listeDemande;
	private List<Prestation> listePrestations;
//	private List<Transaction> listeTransactions;

	Map<Long, List<Transaction>> transactionsParDemande;

	@Autowired
	private DemandeIDao demandeClientIDao;

	@Autowired
	private TransactionIDao transactionIDao;
	@Autowired
	private PrestationFournisseurIDao prestationFournisseurIDao;

	@PostConstruct
	public void init() {
		transactionsParDemande = new HashMap<>();
		listeDemande = demandeClientIDao.all();
		listeDemande.forEach(dmd -> {
			transactionsParDemande.put(dmd.getReferncedemande(), getListeTransactions(dmd.getReferncedemande()));
		});
	}

	public List<Transaction> filterTransactions(Long id) {
		
		return transactionsParDemande.get(id);
	}

	public List<Demande> getListeDemandes() {

		return listeDemande;
	}

	private List<Transaction> getListeTransactions(Long id) {
		return transactionIDao.transactionsByDemandeId(id);
	}

//	public String afficherDetailsDemandeClient(Integer idDemande) {
//		this.demandeClient = demandeClientIDao.findById(idDemande);
//		return "";
//	}

	public List<Prestation> getListePrestations() {
		return prestationFournisseurIDao.all();
	}

}
