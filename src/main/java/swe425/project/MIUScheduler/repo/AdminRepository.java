package swe425.project.MIUScheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swe425.project.MIUScheduler.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {


}
