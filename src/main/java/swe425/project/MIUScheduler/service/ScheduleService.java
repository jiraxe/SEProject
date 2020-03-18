package swe425.project.MIUScheduler.service;

import java.util.List;

import swe425.project.MIUScheduler.model.Schedule;


public interface ScheduleService {
	 List<Schedule> findAll();
	 Schedule save(Schedule schedule);
	 Schedule findOne(Long id);
	 void delete(Long id);
}
