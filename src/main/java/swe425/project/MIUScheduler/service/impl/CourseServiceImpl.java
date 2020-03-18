package swe425.project.MIUScheduler.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Course;
import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.repo.CourseRepository;
import swe425.project.MIUScheduler.service.CourseService;



@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course findOne(Integer id) {
		return courseRepository.getOne(id);
	}

	@Override
	public void delete(Integer id) {
		courseRepository.deleteById(id);
	}

	@Override
	public List<Section> checkPrerequisite(List<Section> sectionList) {
		int i,j;
		List<Section> coursesMissingPrerequisite = new ArrayList<>();
		for ( i = 0; i < sectionList.size(); i++) {
			Course course = sectionList.get(i).getCourse();
			Course prerequisite = course.getPrerequisite();
			if (prerequisite == null) continue;
			else {
				for ( j = 0; j < i; j++)
				{
					if (sectionList.get(j).getCourse().equals(prerequisite)) break;
					System.out.println(course.getCourseTitle()+" "+prerequisite.getCourseTitle());
	
				}
					if(j==i) coursesMissingPrerequisite.add(sectionList.get(i));
			}
		}

		return coursesMissingPrerequisite;

	}
}
