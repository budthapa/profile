package pro.budthapa.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlayerController {
	Logger log = LoggerFactory.getLogger(PlayerController.class);
	
	private static final String INDEX_PAGE = "player/index";

	@GetMapping("/player")
	public String index() {
		return INDEX_PAGE;
	}

	@ResponseBody
	@PostMapping(value = { "/player/link" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Object extractUrl(@RequestBody String videoLink) {
		log.info("Got video link from user. Now getting the playable link for "+videoLink);
		String unescapeUrl=new String();
		try {
			unescapeUrl = URLDecoder.decode(videoLink, "UTF-8");
			unescapeUrl =unescapeUrl.substring(unescapeUrl.indexOf("=")+1,unescapeUrl.indexOf("&_csrf"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		String url;
		String link=new String();
		Process process;
		try {
			process = Runtime.getRuntime().exec("youtube-dl -f 171 -g "+unescapeUrl);
//			process = Runtime.getRuntime().exec("youtube-dl -f 22,17,18 -g https://www.youtube.com/watch?v=5dKGK81z4js");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((url = br.readLine()) != null){
				link=url;
			}
			process.waitFor();
			process.destroy();
		} catch (Exception e) {
			e.getMessage();
		}

		/*
		 * System.out.println("video-link "+videoLink); ObjectMapper map = new
		 * ObjectMapper(); try { JsonNode node = map.readTree(videoLink); String
		 * str = node.get("videolink").asText(); System.out.println(str);
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		log.info("Generated link: "+link.trim());
		Map<String,Object> jsonData = new HashMap<>();
		jsonData.put("link", link.trim());
		return jsonData;
	}

	class VideoLink {
		public String videoLink;

	}
}
