package swe425.project.MIUScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import swe425.project.MIUScheduler.model.Block;
import swe425.project.MIUScheduler.model.Location;
import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.model.Course;
import swe425.project.MIUScheduler.model.Faculty;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.service.BlockService;
import swe425.project.MIUScheduler.service.CourseService;
import swe425.project.MIUScheduler.service.FacultyService;
import swe425.project.MIUScheduler.service.LocationService;
import swe425.project.MIUScheduler.service.SectionService;
import swe425.project.MIUScheduler.service.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class MiuSchedulerApplication implements CommandLineRunner {

	@Autowired
	SectionService sectionService;
	@Autowired
	CourseService courseService;
	@Autowired
	BlockService blockService;
	@Autowired
	FacultyService facultyService;
	@Autowired
	LocationService locationService;
	@Autowired
	StudentService studentService;


	public static void main(String[] args) {
		SpringApplication.run(MiuSchedulerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
