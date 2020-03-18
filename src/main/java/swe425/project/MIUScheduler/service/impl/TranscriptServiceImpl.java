package swe425.project.MIUScheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Transcript;
import swe425.project.MIUScheduler.repo.TranscriptRepository;
import swe425.project.MIUScheduler.service.TranscriptService;



@Service
public class TranscriptServiceImpl implements TranscriptService {

	@Autowired
	TranscriptRepository transcriptRepository;
	
	@Override
	public List<Transcript> findAll() {
		return transcriptRepository.findAll();
	}

	@Override
	public Transcript save(Transcript transcript) {
		return transcriptRepository.save(transcript);
	}

	@Override
	public Transcript findOne(Long id) {
		return transcriptRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		transcriptRepository.deleteById(id);
	}

}
