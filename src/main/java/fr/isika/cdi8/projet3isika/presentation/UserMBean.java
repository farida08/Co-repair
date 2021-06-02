package fr.isika.cdi8.projet3isika.presentation;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import fr.isika.cdi8.projet3isika.entities.user.User;
import fr.isika.cdi8.projet3isika.idao.UserIDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ManagedBean
@SessionScoped
public class UserMBean implements Serializable {

	private static final long serialVersionUID = 4125630907255534395L;

	private UserDto userDto = new UserDto();
	
	@Inject
	private UserIDao userIDao;
	
	private String messagePwdLoginIntouvable;
	
	public String connecter() {
		Optional<User> optionalUser = userIDao.autentifierUser(userDto);
		if (optionalUser.isPresent()) {
			return resolveViewByUserType(optionalUser.get());
		} else {
			messagePwdLoginIntouvable = "Login et/ou mot de passe introuvable";
		}
		return "../index.xhtml";
	}
	
	private String resolveViewByUserType(User user) {
		return resolve(user);
	}
	
	private String resolve(User user) {
		return "espace" + user.getClass().getSimpleName() + ".xhtml";
	}
	public String connectedMail() {
		return userDto.getMail();
	}
}
