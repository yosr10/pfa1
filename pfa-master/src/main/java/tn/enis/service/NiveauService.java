package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Niveau;
import tn.enis.repositories.NiveauRepository;

@Service
@Slf4j

public class NiveauService {

	@Autowired
	private NiveauRepository niveauRepository;

	public List<Niveau> getAll() {
		log.info("liste de année academique");
		return niveauRepository.findAll();
	}

	public Long save(Niveau niveau) {
		niveauRepository.saveAndFlush(niveau);
		return niveau.getNiveauId();
	}

	public Long update(Niveau niveau) {
		niveauRepository.saveAndFlush(niveau);
		return niveau.getNiveauId();
	}

	public void delete(long id) {
		niveauRepository.delete(id);
	}

	public Niveau find(long id) {
		return niveauRepository.findOne(id);
	}

}