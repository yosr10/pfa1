package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.PlanEtude;
import tn.enis.repositories.PlanEtudeRepository;

@Service
@Slf4j

public class PlanEtudeService {

	@Autowired
	private PlanEtudeRepository planEtudeRepository;

	public List<PlanEtude> getAll() {
		log.info("liste de année academique");
		return planEtudeRepository.findAll();
	}

	public Long save(PlanEtude planEtude) {
		planEtudeRepository.saveAndFlush(planEtude);
		return planEtude.getPlanEtudeId();
	}

	public Long update(PlanEtude planEtude) {
		planEtudeRepository.saveAndFlush(planEtude);
		return planEtude.getPlanEtudeId();
	}

	public void delete(long id) {
		planEtudeRepository.delete(id);
	}

	public PlanEtude find(long id) {
		return planEtudeRepository.findOne(id);
	}

}