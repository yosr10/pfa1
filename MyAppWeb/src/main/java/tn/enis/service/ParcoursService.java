package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Parcours;
import tn.enis.repositories.ParcoursRepository;

@Service
@Slf4j

public class ParcoursService {

	@Autowired
	private ParcoursRepository parcoursRepository;

	public List<Parcours> getAll() {
		log.info("liste de parcours");
		return parcoursRepository.findAll();
	}

	public Long save(Parcours parcours) {
		parcoursRepository.saveAndFlush(parcours);
		return parcours.getParcoursId();
	}

	public Long update(Parcours parcours) {
		parcoursRepository.saveAndFlush(parcours);
		return parcours.getParcoursId();
	}

	public void delete(long id) {
		parcoursRepository.delete(id);
	}

	public Parcours find(long id) {
		return parcoursRepository.findOne(id);
	}

}