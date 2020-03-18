package swe425.project.MIUScheduler.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.repo.StudentRepository;
import swe425.project.MIUScheduler.service.CourseService;
import swe425.project.MIUScheduler.service.SectionService;
import swe425.project.MIUScheduler.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {


	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	SectionService sectionService;

	@Autowired
	private CourseService courseService;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student findOne(Long id) {
		return studentRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
	
	@Override
	public HashMap<String, List<Section>> register(Student student, List<Section> sectionList) {

		List<Section> fullSectionList = this.sectionService.checkCapacity(sectionList);
		List<Section> coursesMissingPrerequisite = this.courseService.checkPrerequisite(sectionList);
		HashMap<String, List<Section>> infos = new HashMap<>();
		infos.put("capacity",fullSectionList);
		infos.put("prerequisite",coursesMissingPrerequisite);

		if(fullSectionList.size()==0 && coursesMissingPrerequisite.size()==0)
		{
			sectionList.forEach(section ->section.setCapacity(section.getCapacity()-1));
			student.setSections(sectionList);
			this.studentRepository.save(student);

		}

		return infos;
	}

}
