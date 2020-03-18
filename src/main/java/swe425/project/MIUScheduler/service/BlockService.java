package swe425.project.MIUScheduler.service;

import java.util.List;

import swe425.project.MIUScheduler.model.Block;
import swe425.project.MIUScheduler.model.Section;


public interface BlockService {
	 List<Block> findAll();
	 Block save(Block block);
	 Block findOne(Integer id);
	 void delete(Integer id);

     List<Block> findAvailableSections();
}
