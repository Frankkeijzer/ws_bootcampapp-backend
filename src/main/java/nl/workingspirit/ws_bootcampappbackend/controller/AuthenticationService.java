package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

@Service
@Transactional
public class AuthenticationService {

	public boolean userAuthentication(User user, String password) {
		return user != null && user.getPassword().equals(password);
	}
}