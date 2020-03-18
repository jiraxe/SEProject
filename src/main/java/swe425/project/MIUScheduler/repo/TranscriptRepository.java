package swe425.project.MIUScheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swe425.project.MIUScheduler.model.Transcript;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
