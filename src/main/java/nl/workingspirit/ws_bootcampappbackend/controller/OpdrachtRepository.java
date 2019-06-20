package nl.workingspirit.ws_bootcampappbackend.controller;

import org.springframework.data.repository.CrudRepository;

import nl.workingspirit.ws_bootcampappbackend.domein.Uitwerking;

public interface OpdrachtRepository extends CrudRepository<Uitwerking,Long>{

}
