package fr.isika.cdi8.projet3isika.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.isika.cdi8.projet3isika.entities.admin.Administrateur;

import fr.isika.cdi8.projet3isika.idao.AdminIDao;
@Repository
@Transactional
public class AdministrateurDao implements AdminIDao   {
	
	@PersistenceContext
	private EntityManager em ;


	@Override
	public List<Administrateur> autentifier(Administrateur admin) {
		return em.createNamedQuery("Administrateur.autentifier",Administrateur.class).setParameter("mail", admin.getMail()).setParameter("motPasse", admin.getMotPasse()).getResultList();	
	}

	@Override
	public List<Administrateur> all() {
		return em.createNamedQuery("Administrateur.findAll", Administrateur.class).getResultList();
	}

	@Override
	public List<Administrateur> findByQuery(String query) {
		return em.createQuery(query, Administrateur.class).getResultList();
	}

	@Override
	public Administrateur delete(Administrateur admin) {
		em.remove(em.contains(admin) ? admin : em.merge(admin));

		return (admin);
	}

	@Override
	public Administrateur save(Administrateur admin) {
		if (admin.getId()== null) 
			em.persist(admin);
		else
			em.merge(admin);
		return admin;
		
	}
	public Administrateur findByModerateur(String moderateur) {
		return em.createNamedQuery("Administrateur.findByUModerateur", Administrateur.class).setParameter("moderateur", moderateur).getSingleResult();
	}

	@Override
	public Optional<Administrateur> findById(Integer id) {
		return Optional.of(em.find(Administrateur.class, id));
		
	}

}
