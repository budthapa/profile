package pro.budthapa.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
public class PasswordHelper {
	
	@Autowired
	private BCryptPasswordEncoder enc;
	
	public boolean decryptPassword(String rawPassword, String hashedPassword){
		return enc.matches(rawPassword, hashedPassword);
	}

	public String hashPassword(String plainPassword) {
		return enc.encode(plainPassword);
	}
}
