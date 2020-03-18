package swe425.project.MIUScheduler.model;

import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student extends User{
	public static Student currentUser;


	@Column(unique = true)
	private Long studentId;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Section> sections = new ArrayList<>();

	public Student(String firstName, String lastName, String email) {
		super(firstName, lastName, email);

	}

	public Student() {

	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long id) {
		this.studentId = id;
	}


	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void addSection(Section section) {
		this.sections.add(section);
	}
}
