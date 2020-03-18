package swe425.project.MIUScheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Block;
import swe425.project.MIUScheduler.repo.BlockRepository;
import swe425.project.MIUScheduler.service.BlockService;



@Service
public class BlockServiceImpl implements BlockService {

	@Autowired
	BlockRepository blockRepository;
	
	@Override
	public List<Block> findAll() {
		return blockRepository.findAll();
	}

	@Override
	public Block save(Block block) {
		return blockRepository.save(block);
	}

	@Override
	public Block findOne(Integer id) {
		return blockRepository.getOne(id);
	}

	@Override
	public void delete(Integer id) {
		blockRepository.deleteById(id);
	}

}
