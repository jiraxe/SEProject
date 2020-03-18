package swe425.project.MIUScheduler.service;

import java.util.List;

import swe425.project.MIUScheduler.model.Faculty;


public interface FacultyService {
	 List<Faculty> findAll();
	 Faculty save(Faculty faculty);
	 Faculty findOne(Long id);
	 void delete(Long id);
}
