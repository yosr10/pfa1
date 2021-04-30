package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Emploi;
import tn.enis.repositories.EmploiRepository;

@Service
@Slf4j

public class EmploiService {

	@Autowired
	private EmploiRepository emploiRepository;

	public List<Emploi> getAll() {
		log.info("liste de année academique");
		return emploiRepository.findAll();
	}

	public Long save(Emploi emploi) {
		emploiRepository.saveAndFlush(emploi);
		return emploi.getEmploiId();
	}

	public Long update(Emploi emploi) {
		emploiRepository.saveAndFlush(emploi);
		return emploi.getEmploiId();
	}

	public void delete(long id) {
		emploiRepository.delete(id);
	}

	public Emploi find(long id) {
		return emploiRepository.findOne(id);
	}

}