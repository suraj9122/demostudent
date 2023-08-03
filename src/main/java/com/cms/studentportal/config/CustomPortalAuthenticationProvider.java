package com.cms.studentportal.config;

import com.cms.studentportal.domain.Student;
import com.cms.studentportal.service.StudentServiceIfc;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomPortalAuthenticationProvider implements AuthenticationProvider {

	private StudentServiceIfc studentServiceIfc;

	CustomPortalAuthenticationProvider(StudentServiceIfc studentServiceIfc) {
		this.studentServiceIfc = studentServiceIfc;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		Student loginStudent = studentServiceIfc.loginStudent(username, password);
		return new UsernamePasswordAuthenticationToken(loginStudent, password, new ArrayList<>());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}