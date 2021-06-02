package fr.isika.cdi8.projet3isika.idao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Fournisseur;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;


public interface PrestationFournisseurIDao {
	Optional<Prestation> findById(Integer id); 
	Prestation save(Prestation prestationFournisseur);
	Prestation delete(Prestation prestationFournisseur);
	List<Prestation> findByQuery(String query);
	List<Prestation> all();
	List<Prestation> getPrestationBySousType(String sousType);
	List<Prestation> getPrestationBySousTypeByDateAndPrice(String sousType, Date date);
	List<Prestation> findByFournisseur(Fournisseur fournisseur);
}
