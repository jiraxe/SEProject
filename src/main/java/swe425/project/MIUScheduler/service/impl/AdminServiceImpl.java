package swe425.project.MIUScheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Admin;
import swe425.project.MIUScheduler.repo.AdminRepository;
import swe425.project.MIUScheduler.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public Admin save(Admin admin) {

		return adminRepository.save(admin);
	}

	@Override
	public Admin findOne(Long adminId) {
		return adminRepository.getOne(adminId);
	}

	@Override
	public void delete(Long id) {
		adminRepository.deleteById(id);
	}

}
