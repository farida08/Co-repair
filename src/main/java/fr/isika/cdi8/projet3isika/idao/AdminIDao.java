package fr.isika.cdi8.projet3isika.idao;

import java.util.List;
import java.util.Optional;

import fr.isika.cdi8.projet3isika.entities.admin.Administrateur;

public interface AdminIDao {

	List<Administrateur> autentifier(Administrateur admin);

	List<Administrateur> all();

	List<Administrateur> findByQuery(String query);

	Administrateur delete(Administrateur admin);

	Administrateur save(Administrateur admin);

	Optional<Administrateur> findById(Integer id);

}
