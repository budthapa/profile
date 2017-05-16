package pro.budthapa.service;

import pro.budthapa.domain.Resume;

public interface ResumeService {
	public Resume save(Resume resume);
	public Resume update(Resume resume);
	public Resume findByEmail(String email);
}
