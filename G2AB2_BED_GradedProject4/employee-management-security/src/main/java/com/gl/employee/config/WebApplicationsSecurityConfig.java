package com.gl.employee.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gl.employee.service.DomainUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebApplicationsSecurityConfig extends WebSecurityConfigurerAdapter {
	private final DomainUserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// user authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");

	}

	// user authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/employee/**", "/employee", "/employee/**", "/employee/user",
						"/employee/**", "/employee/role")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/employee/**", "/employee/{id}", "/employee/**", "employee/search/{name}",
						"/employee/sort**", "/employee/**", "/employee/list")
				.authenticated()
				.antMatchers(HttpMethod.PUT, "/employee/**", "/employee/{id}").authenticated()
				.antMatchers(HttpMethod.DELETE, "/employee/**", "/employee/{id}").hasRole("ADMIN").and()
				.exceptionHandling()
				.authenticationEntryPoint((request, response, exception) -> response
						.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"))
				.and().cors().disable().csrf().disable()
				.headers().frameOptions().disable();
	}
}
