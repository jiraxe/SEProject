package swe425.project.MIUScheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Faculty extends  User{


	@Column(unique = true)
	private Long facultyId;

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long id) {
		this.facultyId = id;
	}
	
	public Faculty() {
		
	}
	
	@Override
	public String toString() {
		return firstName;
	}

	public Faculty(@NotEmpty(message = "*Please provide first name") String firstName,
			@NotEmpty(message = "*Please provide last name") String lastName,
			@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email) {
		super(firstName, lastName, email);

	}




	

}
