package tn.enis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groovy.util.logging.Slf4j;
import tn.enis.entities.Statut;
import tn.enis.repositories.StatutRepository;

@Service
@Slf4j

public class StatutService {


	@Autowired
	private  StatutRepository  statutRepository;

	

	public List<Statut> getAll() {
		return statutRepository.findAll();
	}

		

}