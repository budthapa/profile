package pro.budthapa.service.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.budthapa.domain.Role;
import pro.budthapa.domain.User;
import pro.budthapa.repository.RoleRepository;
import pro.budthapa.repository.UserRepository;
import pro.budthapa.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User findUserByEmail(String email) {
		User user=userRepository.findByEmail(email);
		System.out.println("User "+user.getEmail()+" pass "+user.getPassword());
		return user;
	}

	@Override
	public User saveUser(User user) {

		Role role = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<>(Arrays.asList(role)));

		return userRepository.save(user);
	}

}
