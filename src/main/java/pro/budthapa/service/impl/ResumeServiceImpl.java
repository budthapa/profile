package pro.budthapa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.budthapa.domain.Resume;
import pro.budthapa.repository.ResumeRepository;
import pro.budthapa.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService{
	
	@Autowired
	private ResumeRepository resumeRepository;

	@Override
	public Resume save(Resume resume) {
		return resumeRepository.save(resume);
	}

	@Override
	public Resume update(Resume resume) {
		return resumeRepository.save(resume);
	}

	@Override
	public Resume findByEmail(String email) {
		return resumeRepository.findByEmail(email);
	}

}