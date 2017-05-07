package pro.budthapa.service;

import pro.budthapa.domain.User;

public interface UserService {
	public User findUserByEmail(String email);
	public User saveUser(User user);
	public User findUserByAuthenticationCode(String authenticationCode);
	public User updateUser(User user);
}
