package fr.isika.cdi8.projet3isika.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.isika.cdi8.projet3isika.entities.demandes_client.Client;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import fr.isika.cdi8.projet3isika.idao.ClientIDao;

@Repository
@Transactional
public class ClientDao implements ClientIDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<Client> findById(Integer id) {

		return Optional.of(em.find(Client.class, id));
	}

	@Override
	public Client save(Client client) {
		if (client.getId() == null)
			em.persist(client);
		else
			em.merge(client);
		return client;
	}

	@Override
	public Client delete(Client client) {
		em.remove(em.contains(client) ? client : em.merge(client));

		return (client);

	}

	@Override
	public List<Client> findByQuery(String query) {
		return em.createQuery(query, Client.class).getResultList();
	}

	@Override
	public List<Client> all() {
		return em.createNamedQuery("Client.findAll", Client.class).getResultList();
	}

	@Override
	public List<Client> autentifier(Client client) {
		return em.createNamedQuery("Client.autentifier", Client.class).setParameter("mail", client.getMail())
				.setParameter("motPasse", client.getMotPasse()).getResultList();

	}

	public Client findByUsername(String username) {
		return em.createNamedQuery("Client.findByUsername", Client.class).setParameter("username", username)
				.getSingleResult();
	}

	@Override
	public Client findByDemande(Demande demande) {
		return em.createQuery("SELECT c FROM Client c JOIN c.demandesClient demande WHERE demande = ?1"  , Client.class)
				.setParameter(1, demande).getSingleResult();
	}
	@Override
	public Client findByDemandeId(long demandeId) {
		return em.createQuery("SELECT c FROM Client c JOIN c.demandesClient demande WHERE demande.referncedemande = ?1"  , Client.class)
				.setParameter(1, demandeId).getSingleResult();
	}

	@Override
	public Client findByMail(String mail) {
		return em.createNamedQuery("Client.findByMail", Client.class).setParameter("mail", mail)
				.getSingleResult();
	}

}
