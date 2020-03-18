package swe425.project.MIUScheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swe425.project.MIUScheduler.model.Faculty;
import swe425.project.MIUScheduler.model.Section;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

    @Query("from Section s where s.capacity > 0")
    List<Section> findAvailableSections();
}
