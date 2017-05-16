package pro.budthapa.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pro.budthapa.domain.Resume;
import pro.budthapa.service.ResumeService;

@Controller
public class ResumeController {
	Logger log = LoggerFactory.getLogger(ResumeController.class);
	
	private static final String ADD_RESUME="resume/addResume";
	
	@Autowired
	private ResumeService resumeService;
	
	@GetMapping("/resume/new")
	public String addResume(Resume resume, Model model){
		model.addAttribute("resume",resume);
		return ADD_RESUME;
	}
	
	@PostMapping("/resume/new")
	public String addResume(@Valid Resume resume, BindingResult result, Model model){
		
		resumeService.save(resume);
		
		model.addAttribute("resume",resume);
		return ADD_RESUME;
	}
}
