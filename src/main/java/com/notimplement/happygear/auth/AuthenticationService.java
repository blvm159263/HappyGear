package com.notimplement.happygear.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.repositories.RoleRepository;
import com.notimplement.happygear.repositories.UserRepository;
import com.notimplement.happygear.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository userRepo;
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepo;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request) {
		var user = User.builder().fullName(request.getFullName()).address(request.getAddress())
				.gender(request.getGender()).email(request.getEmail()).phoneNumber(request.getPhoneNumber())
				.password(passwordEncoder.encode(request.getPassword())).username(request.getUsername()).status(true)
				.role(roleRepo.findByRoleId(request.getRoleId())).build();
		userRepo.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		var user = userRepo.findByUsername(request.getUsername())
				.orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		var roleName = user.getRole().getRoleName();
		return AuthenticationResponse.builder().token(jwtToken).roleName(roleName).build();
	}

}
