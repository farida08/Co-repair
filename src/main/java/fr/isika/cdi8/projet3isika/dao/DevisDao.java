package fr.isika.cdi8.projet3isika.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Devis;
import fr.isika.cdi8.projet3isika.idao.DavisIDao;


@Repository
@Transactional
public class DevisDao implements DavisIDao {

	@PersistenceContext
	private EntityManager em ;

	@Override
	public Optional<Devis> findById(Integer id) {

		return Optional.of(em.find(Devis.class, id));
	}

	@Override
	public Devis save(Devis devis) {	
		if (devis.getId()== null) 
			em.persist(devis);
		else
			em.merge(devis);
		return devis;
	}

	@Override
	public Devis delete(Devis devis) {
		em.remove(em.contains(devis) ? devis : em.merge(devis));

		return (devis);

	}

	@Override
	public List<Devis> findByQuery(String query) {
		return em.createQuery(query, Devis.class).getResultList();
	}

	@Override
	public List<Devis> all() {
		return em.createNamedQuery("Devis.findAll", Devis.class).getResultList();
	}

	@Override
	public List<Devis> devisByDemandeId(Long id) {
		List<Devis> resultList = em.createQuery("from Devis s", Devis.class).getResultList();
		return resultList.stream()
				.filter(devis -> devis.getTransaction().getDemande().getReferncedemande() == id)
				.collect(Collectors.toList());
	}

}
