package tn.enis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Creneau;
import tn.enis.repositories.CreneauRepository;

@Service
@Slf4j
public class CreneauService {


	@Autowired
	private  CreneauRepository  creneauRepository;
	public List<Creneau> getAll() {
		log.info("liste de créneau");
		return creneauRepository.findAll();
	}

	public Long save(Creneau creneau) {
		creneauRepository.saveAndFlush(creneau);
		return creneau.getCreneauId();
	}

	public Long update(Creneau creneau) {
		creneauRepository.saveAndFlush(creneau);
		return creneau.getCreneauId();
	}

	public void delete(long id) {
		creneauRepository.delete(id);
	}

	public Creneau find(long id) {
		return creneauRepository.findOne(id);
	}

}