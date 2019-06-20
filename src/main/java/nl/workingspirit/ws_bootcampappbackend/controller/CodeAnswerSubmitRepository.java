package nl.workingspirit.ws_bootcampappbackend.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.workingspirit.ws_bootcampappbackend.domein.CodeAnswerSubmit;

public interface CodeAnswerSubmitRepository extends CrudRepository<CodeAnswerSubmit,Long>{

}
