package swe425.project.MIUScheduler.service.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swe425.project.MIUScheduler.model.Admin;
import swe425.project.MIUScheduler.model.Faculty;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.model.User;
import swe425.project.MIUScheduler.repo.UserRepository;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	String ROLE_PREFIX = "ROLE_";
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	    User user = userRepository.findByUsername(username);
	    Set grantedAuthorities = new HashSet<>();
	    String roleString = "NONE";
	    if(user instanceof Student) {
	    	roleString = "STUDENT";
	    }else if(user instanceof Faculty){
	    	roleString = "FACULTY";
	    }else if(user instanceof Admin) {
	    	roleString = "ADMIN";
	    }
		User.currentUser=user;

	    System.out.println("---------" + roleString +" LOGGED IN-------------");
	    grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + roleString));
	    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}