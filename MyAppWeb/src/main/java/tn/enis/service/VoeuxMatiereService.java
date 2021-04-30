package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.VoeuxMatiere;
import tn.enis.repositories.VoeuxMatiereRepository;

@Service
@Slf4j

public class VoeuxMatiereService {

	@Autowired
	private VoeuxMatiereRepository voeuxMatiereRepository;

	public List<VoeuxMatiere> getAll() {
		log.info("liste de voeux matieres");
		return voeuxMatiereRepository.findAll();
	}

	public Long save(VoeuxMatiere voeuxMatiere) {
		voeuxMatiereRepository.saveAndFlush(voeuxMatiere);
		return voeuxMatiere.getVoeuxMatiereId();
	}

	public Long update(VoeuxMatiere voeuxMatiere) {
		voeuxMatiereRepository.saveAndFlush(voeuxMatiere);
		return voeuxMatiere.getVoeuxMatiereId();
	}

	public void delete(long id) {
		voeuxMatiereRepository.delete(id);
	}

	public VoeuxMatiere find(long id) {
		return voeuxMatiereRepository.findOne(id);
	}

}