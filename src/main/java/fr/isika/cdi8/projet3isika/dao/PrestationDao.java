package fr.isika.cdi8.projet3isika.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Fournisseur;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import fr.isika.cdi8.projet3isika.idao.PrestationFournisseurIDao;

@Repository
@Transactional
public class PrestationDao implements PrestationFournisseurIDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<Prestation> findById(Integer id) {
		return Optional.of(em.find(Prestation.class, id));
	}

	@Override
	public Prestation save(Prestation prestationFournisseur) {
		System.err.println("------------------------------------------------------------------befor save "+prestationFournisseur);
		
		if (prestationFournisseur.getReferncePrestation() == null)
			em.persist(prestationFournisseur);
		else
			em.merge(prestationFournisseur);
		return prestationFournisseur;
	}

	@Override
	public Prestation delete(Prestation prestationFournisseur) {
		em.remove(em.contains(prestationFournisseur) ? prestationFournisseur : em.merge(prestationFournisseur));

		return (prestationFournisseur);
	}

	public List<Prestation> all() {
		return em.createNamedQuery("Prestation.findAll", Prestation.class).getResultList();
	}

	@Override
	public List<Prestation> findByQuery(String query) {
		return em.createQuery(query, Prestation.class).getResultList();
	}

	@Override
	public List<Prestation> getPrestationBySousType(String sousType) {
		String query = " select pf from  Prestation pf inner join pf.sousType st with st.nom = ?1"		;

		List<Prestation> results = em.createQuery(query, Prestation.class).setParameter(1, sousType).getResultList();
		System.err.println("la taille de la liste : " + results.size());
		return results;

	}

	@Override
	public List<Prestation> getPrestationBySousTypeByDateAndPrice(String sousType, Date date) {
		String query = 	" select pf "
				+ " from  Prestation pf " 
				+ " inner join pf.sousType st with st.nom = ?1"
				+ " where pf.coutTotal = "
									+ " (select min (p.coutTotal) "
									+ " from Prestation p JOIN p.dateDisponibilite date "
									+ " where  date = ?2)";

		List<Prestation> results = em.createQuery(query, Prestation.class).setParameter(1, sousType)
				.setParameter(2, date).getResultList();
		System.err.println("la taille de la liste : " + results.size());
		return results;
	}

	@Override
	public List<Prestation> findByFournisseur(Fournisseur fournisseur) {
		return em.createQuery("SELECT p FROM Prestation p WHERE p.client := Parameter", Prestation.class)
				.setParameter("Parameter", fournisseur).getResultList();
	}

}
