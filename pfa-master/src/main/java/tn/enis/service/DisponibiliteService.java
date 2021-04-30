package tn.enis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Disponibilite;
import tn.enis.repositories.DisponibiliteRepository;

@Service
@Slf4j

public class DisponibiliteService {

	@Autowired
	private DisponibiliteRepository disponibiliteRepository;

	public List<Disponibilite> getAll() {
		log.info("liste de disponibilite");
		return disponibiliteRepository.findAll();
	}

	public Long save(Disponibilite disponibilite) {
		disponibiliteRepository.saveAndFlush(disponibilite);
		return disponibilite.getDisponibiliteId();
	}

	public Long update(Disponibilite disponibilite) {
		disponibiliteRepository.saveAndFlush(disponibilite);
		return disponibilite.getDisponibiliteId();
	}

	public void delete(long id) {
		disponibiliteRepository.delete(id);
	}

	public Disponibilite find(long id) {
		return disponibiliteRepository.findOne(id);
	}

}