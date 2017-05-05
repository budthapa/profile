package pro.budthapa.service;

import pro.budthapa.domain.User;

public interface UserService {
	public User findUserByEmail(String email);
	public User saveUser(User user);
}
