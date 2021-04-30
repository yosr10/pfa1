package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Groupe;
import tn.enis.repositories.GroupeRepository;

@Service
@Slf4j

public class GroupeService {

	@Autowired
	private GroupeRepository groupeRepository;

	public List<Groupe> getAll() {
		log.info("liste des groupes");
		return groupeRepository.findAll();
	}

	public Long save(Groupe groupe) {
		groupeRepository.saveAndFlush(groupe);
		return groupe.getGroupeId();
	}

	public Long update(Groupe groupe) {
		groupeRepository.saveAndFlush(groupe);
		return groupe.getGroupeId();
	}

	public void delete(long id) {
		groupeRepository.delete(id);
	}

	public Groupe find(long id) {
		return groupeRepository.findOne(id);
	}

}