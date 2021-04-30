package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Seance;
import tn.enis.repositories.SeanceRepository;

@Service
@Slf4j

public class SeanceService {

	@Autowired
	private SeanceRepository seanceRepository;

	public List<Seance> getAll() {
		log.info("liste des seances");
		return seanceRepository.findAll();
	}

	public Long save(Seance seance) {
		seanceRepository.saveAndFlush(seance);
		return seance.getSeanceId();
	}

	public Long update(Seance seance) {
		seanceRepository.saveAndFlush(seance);
		return seance.getSeanceId();
	}

	public void delete(long id) {
		seanceRepository.delete(id);
	}

	public Seance find(long id) {
		return seanceRepository.findOne(id);
	}

}