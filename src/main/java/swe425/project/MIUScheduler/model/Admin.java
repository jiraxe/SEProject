package swe425.project.MIUScheduler.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long adminId;

	public Long getadminId() {
		return adminId;
	}

	public void setadminId(Long adminId) {
		this.adminId = adminId;
	}
	
	public Admin() {
		
		
	}
	

	public Admin(@NotEmpty(message = "*Please provide first name") String firstName,
			@NotEmpty(message = "*Please provide last name") String lastName,
			@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	@Column(name = "first_name")
	@NotEmpty(message = "*Please provide first name")
	protected String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide last name")
	protected String lastName;

	@Column(name = "email", unique = true)
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	protected String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	
}
