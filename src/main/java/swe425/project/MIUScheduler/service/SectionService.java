package swe425.project.MIUScheduler.service;

import java.util.List;

import swe425.project.MIUScheduler.model.Section;


public interface SectionService {
	 List<Section> findAll();
	 Section save(Section section);
	 Section findOne(Integer id);
	 void delete(Integer id);
	List<Section> checkCapacity(List<Section> sectionList);
}
