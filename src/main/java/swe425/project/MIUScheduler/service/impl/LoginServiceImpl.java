package swe425.project.MIUScheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe425.project.MIUScheduler.model.Login;
import swe425.project.MIUScheduler.repo.LoginRepository;
import swe425.project.MIUScheduler.service.LoginService;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepository loginRepository;

    @Override
    public boolean verify(Login login) {
        List<Login> accounts = loginRepository.findAll();
        for (Login account : accounts) {
            if(account.getUsername().equals(login.getUsername()) && account.getPassword().equals(login.getPassword()))
                return true;
        }
        return false;
    }

    @Override
    public void save(Login login) {
        loginRepository.save(login);
    }

}
