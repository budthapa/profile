package pro.budthapa.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pro.budthapa.domain.Career;
import pro.budthapa.domain.Education;
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
	public String addResume(@Valid Resume resume, BindingResult result, Model model, 
			Principal principal){
		
		resume.setEmail(principal.getName());
		System.out.println("career size "+resume.getCareer().size());
		
		List<Career> careerList = new ArrayList<>();
		Career career;
		for(int i=0;i<resume.getCareer().size();i++){
			career=new Career();
			career.setName(resume.getCareer().get(i).getName());
			career.setName(resume.getCareer().get(i).getTitle());
			career.setJoinDate(resume.getCareer().get(i).getJoinDate());
			career.setEndDate(resume.getCareer().get(i).getEndDate());
			career.setLocation(resume.getCareer().get(i).getLocation());
			career.setWebsite(resume.getCareer().get(i).getWebsite());
			career.setCreateDate(LocalDate.now());
			
			
			careerList.add(career);
			career.setResume(resume);
		}
		
		System.out.println("education size "+resume.getEducation().size());
		List<Education> educationList = new ArrayList<>();
		Education education ;
		for(int i=0;i<educationList.size();i++){
			education = new Education();
			education.setName(resume.getEducation().get(i).getName());
			education.setCourse(resume.getEducation().get(i).getCourse());
			education.setStartDate(resume.getEducation().get(i).getStartDate());
			education.setEndDate(resume.getEducation().get(i).getEndDate());
			
			
			educationList.add(education);
			education.setResume(resume);
		}
		

		resume.setCareer(careerList);
		resume.setEducation(educationList);
		
		resumeService.save(resume);
		
		model.addAttribute("resume",resume);
		return ADD_RESUME;
	}
}
