package swe425.project.MIUScheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swe425.project.MIUScheduler.model.Faculty;
import swe425.project.MIUScheduler.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
