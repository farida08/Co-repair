package fr.isika.cdi8.projet3isika.idao;

import java.util.List;
import java.util.Optional;

import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Devis;


public interface DavisIDao {
	List<Devis> all();

	List<Devis> findByQuery(String query);

	Devis delete(Devis devis);

	Devis save(Devis devis);

	Optional<Devis> findById(Integer id);

	List<Devis> devisByDemandeId(Long id);

}
