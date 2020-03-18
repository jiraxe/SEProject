package swe425.project.MIUScheduler.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.repo.SectionRepository;
import swe425.project.MIUScheduler.service.SectionService;



@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	SectionRepository sectionRepository;
	
	@Override
	public List<Section> findAll() {
		return sectionRepository.findAll();
	}

	@Override
	public Section save(Section section) {
		return sectionRepository.save(section);
	}

	@Override
	public Section findOne(Integer id) {
		return sectionRepository.getOne(id);
	}

	@Override
	public void delete(Integer id) {
		sectionRepository.deleteById(id);
	}
	
	@Override
	public List<Section> checkCapacity(List<Section> sectionList) {
		List<Section> fullSectionList = new ArrayList<>();
		sectionList.stream().filter(section -> section.getCapacity()==0)
							.forEach(section -> fullSectionList.add(section));

		return fullSectionList;


	}

}
