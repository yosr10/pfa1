package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Ressource;
import tn.enis.repositories.RessourceRepository;

@Service
@Slf4j

public class RessourceService {

	@Autowired
	private RessourceRepository ressourceRepository;

	public List<Ressource> getAll() {
		log.info("liste de ressources");
		return ressourceRepository.findAll();
	}

	public Long save(Ressource ressource) {
		ressourceRepository.saveAndFlush(ressource);
		return ressource.getRessourceId();
	}

	public Long update(Ressource ressource) {
		ressourceRepository.saveAndFlush(ressource);
		return ressource.getRessourceId();
	}

	public void delete(long id) {
		ressourceRepository.delete(id);
	}

	public Ressource find(long id) {
		return ressourceRepository.findOne(id);
	}

}