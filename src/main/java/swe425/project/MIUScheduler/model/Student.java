package swe425.project.MIUScheduler.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Student extends User{
	public static Student currentUser;


	@Column(unique = true)
	private Long studentId;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Section> sections = new ArrayList<>();

	public Student(String firstName, String lastName, String email, String username, String password) {
		super(firstName, lastName, email, username, password);

	}

	public Student(){
	super();
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
