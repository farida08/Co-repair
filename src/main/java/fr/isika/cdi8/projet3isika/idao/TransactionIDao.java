package fr.isika.cdi8.projet3isika.idao;

import java.util.List;

import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Transaction;


public interface TransactionIDao {

	List<Transaction> transactionsByDemandeId(Long referncedemande);
	Transaction save(Transaction transaction); 


}
