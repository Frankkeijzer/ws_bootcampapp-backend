package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

public interface LessonSubjectsRepository extends CrudRepository<LessonSubjects,Long>{
	LessonSubjects findByDay(String day);
	List<LessonSubjects> findAll();
}
