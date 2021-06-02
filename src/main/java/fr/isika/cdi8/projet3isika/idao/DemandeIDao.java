package fr.isika.cdi8.projet3isika.idao;

import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.net.server.Client;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;

public interface DemandeIDao {
	Optional<Demande> findById(Integer id); 
	Demande save(Demande demandeclient);
	Demande delete(Demande demandeclient);
	List<Demande> findByQuery(String query);
	List<Demande> all();
	List<Demande> findByClientId(Client client);

}
