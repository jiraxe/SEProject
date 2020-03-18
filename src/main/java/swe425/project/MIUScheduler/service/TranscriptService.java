package swe425.project.MIUScheduler.service;

import java.util.List;

import swe425.project.MIUScheduler.model.Transcript;


public interface TranscriptService {
	 List<Transcript> findAll();
	 Transcript save(Transcript transcript);
	 Transcript findOne(Long id);
	 void delete(Long id);
}
