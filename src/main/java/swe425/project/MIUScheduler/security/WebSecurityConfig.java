package swe425.project.MIUScheduler.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import swe425.project.MIUScheduler.service.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/css/**", "/js/**");
	}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.csrf().disable()
					.authorizeRequests()
					.antMatchers("/resources/static/**","/resources/**","/login").permitAll()

					.antMatchers("/v2/api-docs",
							"/configuration/ui",
							"/swagger-resources/**",
							"/configuration/security",
							"/swagger-ui.html",
							"/webjars/**").permitAll()

					.antMatchers("/course/list").hasAnyRole("STUDENT","ADMIN")
					.antMatchers("/course/**").hasRole("ADMIN")
					.antMatchers("/student/register/**").hasRole("STUDENT")
					.anyRequest().authenticated()
					.and()
					.formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()

					.logout()
					.logoutUrl("/logout")
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
	                .permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}