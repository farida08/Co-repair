package fr.isika.cdi8.projet3isika.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.net.server.Client;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import fr.isika.cdi8.projet3isika.idao.DemandeIDao;
import fr.isika.cdi8.projet3isika.presentation.DemandeClientMBean;

@Repository
@Transactional
public class DemandeDao implements DemandeIDao {

	private static Logger logger = LogManager.getLogger(DemandeDao.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<Demande> findById(Integer id) {
		return Optional.of(em.find(Demande.class, id));
	}

	@Override
	public Demande save(Demande demandeclient) {
		logger.info("Start Save Demande a créer " + demandeclient);
		if (demandeclient.getReferncedemande() == null)
			em.persist(demandeclient);
		else
			em.merge(demandeclient);

		logger.info("End Save Demande créée " + demandeclient);

		return demandeclient;
	}

	@Override
	public Demande delete(Demande demandeclient) {
		em.remove(em.contains(demandeclient) ? demandeclient : em.merge(demandeclient));

		return (demandeclient);
	}

	@Override
	public List<Demande> findByQuery(String query) {
		return em.createQuery(query, Demande.class).getResultList();
	}

//	@Override
//	public List<DemandeClient> getAllDemandeClients() {
//		List <DemandeClient> listDemandesClients = em.createQuery("select c from Client c").getResultList();
//		return listDemandesClients;
//	}
	@Override
	public List<Demande> all() {
		return em.createNamedQuery("Demande.findAll", Demande.class).getResultList();
	}

	@Override
	public List<Demande> findByClientId(Client client) {
		return em.createQuery("SELECT d FROM Demande d WHERE d.client := Parameter", Demande.class)
				.setParameter("Parameter", client).getResultList();
	}

}
