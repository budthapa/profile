package pro.budthapa.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import redis.clients.jedis.Jedis;

@Controller
public class DashboardController {
	Logger log = LoggerFactory.getLogger(DashboardController.class);
	public static final String INDEX_PAGE = "dashboard/index";
	
	@GetMapping("/dashboard")
	public String index(Principal principal){
		System.out.println(principal.getName());
		
		Jedis jedis = new Jedis("localhost",6379);
		
		jedis.set("foo", "bar");
		System.out.println(jedis.get("foo"));
		jedis.close();
		return INDEX_PAGE;
	}
}
