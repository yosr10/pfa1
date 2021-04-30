package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Grade;
import tn.enis.repositories.GradeRepository;

@Service
@Slf4j

public class GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	public List<Grade> getAll() {
		log.info("liste de grade");
		return gradeRepository.findAll();
	}

	public Long save(Grade grade) {
		gradeRepository.saveAndFlush(grade);
		return grade.getGradeId();
	}

	public Long update(Grade grade) {
		gradeRepository.saveAndFlush(grade);
		return grade.getGradeId();
	}

	public void delete(long id) {
		gradeRepository.delete(id);
	}

	public Grade find(long id) {
		return gradeRepository.findOne(id);
	}

}