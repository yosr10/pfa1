package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.TypeSalle;
import tn.enis.repositories.TypeSalleRepository;

@Service
@Slf4j

public class TypeSalleService {

	@Autowired
	private TypeSalleRepository typeSalleRepository;

	public List<TypeSalle> getAll() {
		log.info("liste de type salle");
		return typeSalleRepository.findAll();
	}

	public Long save(TypeSalle typeSalle) {
		typeSalleRepository.saveAndFlush(typeSalle);
		return typeSalle.getTypeSalleId();
	}

	public Long update(TypeSalle typeSalle) {
		typeSalleRepository.saveAndFlush(typeSalle);
		return typeSalle.getTypeSalleId();
	}

	public void delete(long id) {
		typeSalleRepository.delete(id);
	}

	public TypeSalle find(long id) {
		return typeSalleRepository.findOne(id);
	}

}