package swe425.project.MIUScheduler.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class User {

    @Id@GeneratedValue(strategy = GenerationType.TABLE)
    protected Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "first_name")
    @NotEmpty(message = "*Please provide first name")
    public String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide last name")
    public String lastName;

    @Column(name = "email", unique = true)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    public String email;

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

    public User(){

    }

    public User(@NotEmpty(message = "*Please provide first name") String firstName, @NotEmpty(message = "*Please provide last name") String lastName, @Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
