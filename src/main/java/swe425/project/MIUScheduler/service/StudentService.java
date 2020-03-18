package swe425.project.MIUScheduler.service;

import java.util.HashMap;
import java.util.List;

import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.model.Student;


public interface StudentService {
	 List<Student> findAll();
	 Student save(Student student);
	 Student findOne(Long id);
	 void delete(Long id);
	HashMap<String, List<Section>> register(Student student, List<Section> sectionList);
}
