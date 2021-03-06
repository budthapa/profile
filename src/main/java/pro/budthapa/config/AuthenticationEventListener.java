package pro.budthapa.config;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {

	private static Logger logger = Logger.getLogger(AuthenticationEventListener.class);

	@Autowired
	RedisTemplate<String, Object> template;
	
	@Override
	public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {
		if (authenticationEvent instanceof InteractiveAuthenticationSuccessEvent) {
			// ignores to prevent duplicate logging with
			// AuthenticationSuccessEvent
			return;
		}
		Authentication authentication = authenticationEvent.getAuthentication();
		logger.info(authentication.getDetails());
		logger.info(authentication.getPrincipal());
		String auditMessage = "Login attempt with username: " + authentication.getName() + " Success: "
				+ authentication.isAuthenticated();

		logger.info(auditMessage);
		if(authentication.isAuthenticated()){
			template.opsForValue().set("loggedInEmail", authentication.getName());			
		}
	}

}