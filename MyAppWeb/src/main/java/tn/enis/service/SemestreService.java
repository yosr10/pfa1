package tn.enis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groovy.util.logging.Slf4j;
import tn.enis.entities.Semestre;
import tn.enis.repositories.SemestreRepository;

@Service
@Slf4j

public class SemestreService {


	@Autowired
	private  SemestreRepository  semestreRepository;

	

	public List<Semestre> getAll() {
		return semestreRepository.findAll();
	}

		

}