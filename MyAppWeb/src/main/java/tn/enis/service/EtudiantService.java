package tn.enis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Etudiant;
import tn.enis.repositories.EtudiantRepository;
import tn.enis.repositories.MatiereRepository;
@Service
@Slf4j
public class EtudiantService {
	@Autowired
	private  EtudiantRepository  etudiantRepository;

	

	public List<Etudiant> getAll() {
		System.out.println("yosr");
		return etudiantRepository.findAll();
	}
	
	public Long save(Etudiant etudiant) {
		etudiantRepository.saveAndFlush(etudiant);
		return etudiant.getId();
	}

	public Long update(Etudiant etudiant) {
		etudiantRepository.saveAndFlush(etudiant);
		return etudiant.getId();
	}

	public void delete(long id) {
		etudiantRepository.delete(id);
	}

	public Etudiant find(long id) {
		return etudiantRepository.findOne(id);
	}


}
