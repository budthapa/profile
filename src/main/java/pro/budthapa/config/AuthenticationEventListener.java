package pro.budthapa.config;

import org.jboss.logging.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {

   private static Logger logger = Logger.getLogger(AuthenticationEventListener.class);

   @Override
   public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {
      if (authenticationEvent instanceof InteractiveAuthenticationSuccessEvent) {
         // ignores to prevent duplicate logging with AuthenticationSuccessEvent
         return;
      }
      Authentication authentication = authenticationEvent.getAuthentication();
      logger.info(authentication.getDetails());
      String auditMessage = "Login attempt with username: " + authentication.getName() + 
    		  " Credentials: "+ authentication.getCredentials() +" Success: " + authentication.isAuthenticated();
      logger.info(auditMessage);
   }

}