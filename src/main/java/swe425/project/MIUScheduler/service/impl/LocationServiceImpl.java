package swe425.project.MIUScheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Location;
import swe425.project.MIUScheduler.repo.LocationRepository;
import swe425.project.MIUScheduler.service.LocationService;



@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepository;
	
	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public Location save(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location findOne(Integer id) {
		return locationRepository.getOne(id);
	}

	@Override
	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}

}
