//package fr.isika.cdi8.projet3isika.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;

//import common_client_fournisseur.PrestationReparationAvecGarage;
//import common_client_fournisseur.PrestationReparationSansGarage;
//import common_client_fournisseur.ReparationAvecGarage;
//import fr.isika.cdi8.projet3isika.idao.PrestationReparationAvecGarageIDao;
//@Repository
//@Transactional
//public class PrestationReparationAvecGarageDao implements PrestationReparationAvecGarageIDao {
//	@PersistenceContext
//	private EntityManager em ;
//
//	@Override
//	public List<PrestationReparationAvecGarage> findByQuery(String query) {
//		return em.createQuery(query, PrestationReparationAvecGarage.class).getResultList();
//	}
//
//	@Override
//	public List<PrestationReparationAvecGarage> selectionnerReparationAvecGarage(
//			ReparationAvecGarage reparationAvecGarage) {
//		return em.createQuery("SELECT p FROM PrestationReparationAvecGarage p WHERE p.typeReparation := typeReparationParameter", PrestationReparationAvecGarage.class)
//				.setParameter("typeReparationParameter", reparationAvecGarage.getTypeReparation())
//				.getResultList();
//	}
//}
