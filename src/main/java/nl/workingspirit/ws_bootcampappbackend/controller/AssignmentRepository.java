package nl.workingspirit.ws_bootcampappbackend.controller;

import org.springframework.data.repository.CrudRepository;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;

public interface AssignmentRepository extends CrudRepository<Assignment,Long>{
	Iterable<Assignment> findAllByVisible(boolean visible);


}
