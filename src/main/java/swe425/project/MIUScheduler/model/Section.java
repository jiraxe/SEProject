package swe425.project.MIUScheduler.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sectionId;


	@OneToOne
	private Course course;

	@ManyToOne
	private Block block;

	@OneToOne
	private Location location;

	@OneToOne(fetch = FetchType.EAGER)
	private Faculty faculty;

	@ManyToMany(mappedBy = "sections",fetch = FetchType.EAGER)
	private List<Student> students;



	private Integer capacity;

	public Section(Course course, Block block, Location location, Faculty faculty, Integer capacity) {	
		this.course = course;
		this.block = block;
		this.location = location;
		this.faculty = faculty;
		this.capacity = capacity;
	}

	public Section() {
	}
	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
