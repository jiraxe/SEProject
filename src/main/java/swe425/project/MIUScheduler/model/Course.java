package swe425.project.MIUScheduler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;

	@NotBlank
	private String courseTitle;

	

	public Integer getCourseId() {
		return courseId;
	}
	
	@OneToOne
	private Course prerequisite;

	public Course getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(Course prerequisite) {
		this.prerequisite = prerequisite;
	}
	
	

	@Override
	public String toString() {
		return courseTitle;
	}



	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	

	public Course(@NotBlank String courseTitle) {
		
		this.courseTitle = courseTitle;
		
	}

	public Course() {

	}
}
