package tn.enis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Enseignant;

import tn.enis.repositories.EnseignantRepository;

import tn.enis.repositories.MatiereRepository;
@Service
@Slf4j
public class EnseignantService {
	@Autowired
	private  EnseignantRepository  enseignantRepository;

	

	public List<Enseignant> getAll() {
	
		return enseignantRepository.findAll();
	}
	
	public Long save(Enseignant enseignant) {
		enseignantRepository.saveAndFlush(enseignant);
		return enseignant.getId();
	}

	public Long update(Enseignant enseignant) {
		enseignantRepository.saveAndFlush(enseignant);
		return enseignant.getId();
	}

	public void delete(long id) {
		enseignantRepository.delete(id);
	}

	public Enseignant find(long id) {
		return enseignantRepository.findOne(id);
	}


}
