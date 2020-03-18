package swe425.project.MIUScheduler.service;

import java.util.List;

import swe425.project.MIUScheduler.model.Location;


public interface LocationService {
	 List<Location> findAll();
	 Location save(Location location);
	 Location findOne(Integer id);
	 void delete(Integer id);
}
