package swe425.project.MIUScheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Faculty;
import swe425.project.MIUScheduler.repo.FacultyRepository;
import swe425.project.MIUScheduler.service.FacultyService;
import swe425.project.MIUScheduler.service.FacultyService;



@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	FacultyRepository facultyRepository;
	
	@Override
	public List<Faculty> findAll() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty save(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty findOne(Long id) {
		return facultyRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		facultyRepository.deleteById(id);
	}

}
