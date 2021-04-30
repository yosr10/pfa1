package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Etablissement;
import tn.enis.entities.Etudiant;
import tn.enis.repositories.EtablissementRepository;

@Service
@Slf4j

public class EtablissementService {

	@Autowired
	private EtablissementRepository etablissementRepository;

	
//	public List<Etablissement> findTeamByName(String mc){
//		return etablissementRepository.findByNomContains(mc);
//		
//	};
		
	public List<Etablissement> getAll() {
		log.info("liste des etablissements");
		return etablissementRepository.findAll();
	}

	public Long save(Etablissement etablissement) {
		etablissementRepository.saveAndFlush(etablissement);
		return etablissement.getEtablissementId();
	}

	public Long update(Etablissement etablissement) {
		etablissementRepository.saveAndFlush(etablissement);
		return etablissement.getEtablissementId();
	}

	public void delete(long id) {
		etablissementRepository.delete(id);
	}

	public Etablissement find(long id) {
		return etablissementRepository.findOne(id);
	}

}