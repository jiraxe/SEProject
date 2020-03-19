package swe425.project.MIUScheduler.service.security;

public interface SecurityService {
	public String findLoggedInUsername();
	public void login(String username, String password);
}
