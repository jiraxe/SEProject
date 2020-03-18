package swe425.project.MIUScheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Schedule;
import swe425.project.MIUScheduler.repo.ScheduleRepository;
import swe425.project.MIUScheduler.service.ScheduleService;



@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Override
	public List<Schedule> findAll() {
		return scheduleRepository.findAll();
	}

	@Override
	public Schedule save(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public Schedule findOne(Long id) {
		return scheduleRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		scheduleRepository.deleteById(id);
	}

}
