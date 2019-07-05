package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment,Long>{
	List<Assignment> findAllByVisible(boolean visible);
	List<Assignment> findAll();
	Optional<Assignment> findById(Long id);
	


}
