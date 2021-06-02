package fr.isika.cdi8.projet3isika.idao;

import java.util.List;
import java.util.Optional;

import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Fournisseur;

public interface FournisseurIDao {
	
	Fournisseur save(Fournisseur fournisseur);
	Optional<Fournisseur> findByIdFournisseur(Integer id);
	
	Fournisseur delete(Fournisseur fournisseur);
	List<Fournisseur> findByQuery(String query);
	List<Fournisseur> getAllFournisseurs();
	
	List<Fournisseur> autentifier(Fournisseur newFournisseur) ;
		
	

}
