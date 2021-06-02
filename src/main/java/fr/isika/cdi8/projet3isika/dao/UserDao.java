package fr.isika.cdi8.projet3isika.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.isika.cdi8.projet3isika.entities.user.User;
import fr.isika.cdi8.projet3isika.idao.UserIDao;
import fr.isika.cdi8.projet3isika.presentation.UserDto;

@Repository
@Transactional
public class UserDao implements UserIDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<User> autentifierUser(UserDto user) {
		return Optional.ofNullable(
				em.createNamedQuery("User.autentifier", User.class)
					.setParameter("mail", user.getMail())
					.setParameter("motPasse", user.getPassword()).getSingleResult()
				);
	}

}
