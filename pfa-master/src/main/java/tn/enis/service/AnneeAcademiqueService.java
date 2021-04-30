package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.AnneeAcademique;
import tn.enis.repositories.AnneeAcademiqueRepository;

@Service
@Slf4j

public class AnneeAcademiqueService {

	@Autowired
	private AnneeAcademiqueRepository anneeAcademiqueRepository;

	public List<AnneeAcademique> getAll() {
		log.info("All Academic years");
		return anneeAcademiqueRepository.findAll();
	}

	public Long save(AnneeAcademique anneeAcademique) {
		anneeAcademiqueRepository.saveAndFlush(anneeAcademique);
		return anneeAcademique.getAnneeId();
	}

	public Long update(AnneeAcademique anneeAcademique) {
		anneeAcademiqueRepository.saveAndFlush(anneeAcademique);
		return anneeAcademique.getAnneeId();
	}

	public void delete(long id) {
		anneeAcademiqueRepository.delete(id);
	}

	public AnneeAcademique find(long id) {
		return anneeAcademiqueRepository.findOne(id);
	}

}