package fr.isika.cdi8.projet3isika.idao;

import java.util.List;
import java.util.Optional;

import fr.isika.cdi8.projet3isika.entities.demandes_client.Client;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;

public interface ClientIDao {

	List<Client> autentifier(Client client);

	List<Client> all();

	List<Client> findByQuery(String query);

	Client delete(Client client);

	Client save(Client client);

	Optional<Client> findById(Integer id);

	Client findByDemande(Demande demande);
	Client findByDemandeId(long demandeId);

	Client findByMail(String mail);

}
