package tn.enis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Matiere;
import tn.enis.repositories.MatiereRepository;

@Service
@Slf4j

public class MatiereService {


	@Autowired
	private  MatiereRepository  matiereRepository;

	

	public List<Matiere> getAll() {
		return matiereRepository.findAll();
	}
	
	public Long save(Matiere matiere) {
		matiereRepository.saveAndFlush(matiere);
		return matiere.getMatiereId();
	}

	public Long update(Matiere matiere) {
		matiereRepository.saveAndFlush(matiere);
		return matiere.getMatiereId();
	}

	public void delete(long id) {
		matiereRepository.delete(id);
	}

	public Matiere find(long id) {
		return matiereRepository.findOne(id);
	}



		

}