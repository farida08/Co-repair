package fr.isika.cdi8.projet3isika.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Transaction;
import fr.isika.cdi8.projet3isika.idao.TransactionIDao;

@Repository
public class TransactionDao implements TransactionIDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Transaction> transactionsByDemandeId(Long referncedemande) {
		List<Transaction> resultList = em.createQuery("from Transaction t", Transaction.class).getResultList();
		return resultList.stream()
				.filter(transaction -> transaction.getDemande().getReferncedemande() == referncedemande)
				.collect(Collectors.toList());
	}

	@Override
	public Transaction save(Transaction transaction) {
		if (transaction.getId()== null) 
			em.persist(transaction);
		else
			em.merge(transaction);
		return transaction;
		
	}

}
