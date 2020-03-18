package swe425.project.MIUScheduler.service;

import java.util.List;

import swe425.project.MIUScheduler.model.Admin;


public interface AdminService {
	 List<Admin> findAll();
	 Admin save(Admin admin);
	 Admin findOne(Long id);
	 void delete(Long id);
}
