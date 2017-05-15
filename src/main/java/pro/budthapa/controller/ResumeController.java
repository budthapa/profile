package pro.budthapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pro.budthapa.domain.Resume;

@Controller
public class ResumeController {
	private static final String ADD_RESUME="resume/addResume";
	
	@GetMapping("/resume/new")
	public String addResume(Resume resume){
		return ADD_RESUME;
	}
}
