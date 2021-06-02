package fr.isika.cdi8.projet3isika.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.isika.cdi8.projet3isika.entities.demandes_client.Client;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Fournisseur;
import fr.isika.cdi8.projet3isika.idao.FournisseurIDao;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Repository
@Transactional
public class FournisseurDao implements FournisseurIDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Fournisseur save(Fournisseur fournisseur) {

		if (fournisseur.getId() == null)
			em.persist(fournisseur);
		else
			em.merge(fournisseur);

		return fournisseur;
	}

	@Override
	public Optional<Fournisseur> findByIdFournisseur(Integer id) {

		return Optional.of(em.find(Fournisseur.class, id));
	}

	@Override
	public Fournisseur delete(Fournisseur fournisseur) {

		em.remove(em.contains(fournisseur) ? fournisseur : em.merge(fournisseur));

		return (fournisseur);

	}

	@Override
	public List<Fournisseur> findByQuery(String query) {
		return em.createQuery(query, Fournisseur.class).getResultList();
	}

	@Override
	public List<Fournisseur> getAllFournisseurs() {
		return em.createQuery("select f from Client f", Fournisseur.class).getResultList();
	}

	

	@Override
	public List<Fournisseur> autentifier(Fournisseur fournisseur) {
		return em.createNamedQuery("Fournisseur.autentifier",Fournisseur.class).setParameter("mail", fournisseur.getMail()).setParameter("motPasse", fournisseur.getMotPasse()).getResultList();
	}

	public Fournisseur findByMail(String mail) {
		return em.createNamedQuery("Fournisseur.findByMail", Fournisseur.class).setParameter("mail", mail).getSingleResult();
	}

}
