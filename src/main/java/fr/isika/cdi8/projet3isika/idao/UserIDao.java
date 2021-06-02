package fr.isika.cdi8.projet3isika.idao;

import java.util.Optional;

import fr.isika.cdi8.projet3isika.entities.user.User;
import fr.isika.cdi8.projet3isika.presentation.UserDto;

public interface UserIDao {

	Optional<User> autentifierUser(UserDto userDto);

}
