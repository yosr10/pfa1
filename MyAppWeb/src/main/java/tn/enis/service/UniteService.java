package tn.enis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groovy.util.logging.Slf4j;
import tn.enis.entities.Unite;
import tn.enis.repositories.UniteRepository;

@Service
@Slf4j

public class UniteService {


	@Autowired
	private  UniteRepository  uniteRepository;

	

	public List<Unite> getAll() {
		return uniteRepository.findAll();
	}

		

}
