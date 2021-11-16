package com.T3H.Project_1;

import com.T3H.Project_1.service.impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class Project1Application extends WebSecurityConfigurerAdapter {
	@Autowired
	UserLoginServiceImpl userLoginService;

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/*").permitAll().antMatchers("/admin/**")
				.hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/hi?e=username")
				.failureUrl("/login?e=error").permitAll().and().logout().logoutSuccessUrl("/hi").permitAll().and().exceptionHandling().accessDeniedPage("/login?e=deny");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userLoginService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**");
	}

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
