package swe425.project.MIUScheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe425.project.MIUScheduler.model.User;
import swe425.project.MIUScheduler.repo.UserRepository;
import swe425.project.MIUScheduler.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean verify(User User) {
        List<User> accounts = userRepository.findAll();
        for (User account : accounts) {
            if(account.getUsername().equals(User.getUsername()) && account.getPassword().equals(User.getPassword())) {

                return true;
            }
        }
        return false;
    }

//    @Override
//    public void save(User User) {
//        userRepository.save(User);
//    }

}
