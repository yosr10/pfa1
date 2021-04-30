package tn.enis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Departement;
import tn.enis.repositories.DepartementRepository;

@Service
@Slf4j

public class DepartementService {

	@Autowired
	private DepartementRepository departementRepository;

	public List<Departement> getAll() {
		log.info("liste de departements");
		return departementRepository.findAll();
	}

	public Long save(Departement departement) {
		departementRepository.saveAndFlush(departement);
		return departement.getDepartementId();
	}

	public Long update(Departement departement) {
		departementRepository.saveAndFlush(departement);
		return departement.getDepartementId();
	}

	public void delete(long id) {
		departementRepository.delete(id);
	}

	public Departement find(long id) {
		return departementRepository.findOne(id);
	}

}