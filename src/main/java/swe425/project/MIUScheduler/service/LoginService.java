package swe425.project.MIUScheduler.service;

import swe425.project.MIUScheduler.model.Login;

public interface LoginService {
    boolean verify(Login login);
    void save(Login login);
}
