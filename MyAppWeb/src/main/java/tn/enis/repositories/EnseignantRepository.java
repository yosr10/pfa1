package tn.enis.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Enseignant;
import tn.enis.entities.Etudiant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	public List<Enseignant> findByNom(String n);
	public Page<Enseignant> findByNom(String n, Pageable pageable);
	
	
	

}

