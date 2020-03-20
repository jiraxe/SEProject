package swe425.project.MIUScheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.model.User;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT t FROM Student t where t.email = :email")
    Student findByEmail(String email);
}
