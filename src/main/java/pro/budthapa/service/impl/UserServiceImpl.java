package pro.budthapa.service.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pro.budthapa.domain.Role;
import pro.budthapa.domain.User;
import pro.budthapa.repository.RoleRepository;
import pro.budthapa.repository.UserRepository;
import pro.budthapa.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		userRepository.findByEmail(email);
		return null;
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role role = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<>(Arrays.asList(role)));
		
		return userRepository.save(user);
	}

}
