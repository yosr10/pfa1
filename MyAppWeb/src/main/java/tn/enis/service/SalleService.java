package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Salle;
import tn.enis.repositories.SalleRepository;

@Service
@Slf4j

public class SalleService {

	@Autowired
	private SalleRepository salleRepository;

	public List<Salle> getAll() {
		log.info("liste de année academique");
		return salleRepository.findAll();
	}

	public Long save(Salle salle) {
		salleRepository.saveAndFlush(salle);
		return salle.getSalleId();
	}

	public Long update(Salle salle) {
		salleRepository.saveAndFlush(salle);
		return salle.getSalleId();
	}

	public void delete(long id) {
		salleRepository.delete(id);
	}

	public Salle find(long id) {
		return salleRepository.findOne(id);
	}

}