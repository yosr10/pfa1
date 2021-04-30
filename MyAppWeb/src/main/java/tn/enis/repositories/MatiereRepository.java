package tn.enis.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Etudiant;
import tn.enis.entities.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
	public List<Matiere> findByNom(String n);
	public Page<Matiere> findByNom(String n, Pageable pageable);
	
}
