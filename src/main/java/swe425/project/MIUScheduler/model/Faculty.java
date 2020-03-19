package swe425.project.MIUScheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Faculty extends User{



	public Faculty() {
		super();

	}

	
	@Override
	public String toString() {
		return firstName;
	}

	public Faculty(@NotEmpty(message = "*Please provide first name") String firstName,
			@NotEmpty(message = "*Please provide last name") String lastName,
			@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email,
				   String username, String password) {
		super(firstName, lastName, email, username, password);
	}




	

}
