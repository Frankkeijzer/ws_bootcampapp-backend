package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;

public interface UserRepository extends CrudRepository<User,Long>{
	Optional<User> findByEmailaddress(String emailaddress);
	Optional<User> findByPassword(String password);
	Iterable<User> findByRoleOrderByLastNameAsc(Role role);

}
