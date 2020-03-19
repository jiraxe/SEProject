package swe425.project.MIUScheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe425.project.MIUScheduler.model.Admin;
import swe425.project.MIUScheduler.model.Faculty;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.model.User;
import swe425.project.MIUScheduler.repo.UserRepository;
import swe425.project.MIUScheduler.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User verify(User user) {
        return userRepository.searchUsers(user.getUsername(), user.getPassword());
    }
}
