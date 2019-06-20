package nl.workingspirit.ws_bootcampappbackend.controller;

import org.springframework.data.repository.CrudRepository;

import nl.workingspirit.ws_bootcampappbackend.domein.CodeAnswerSubmit;

public interface AssignmentRepository extends CrudRepository<CodeAnswerSubmit,Long>{

}
