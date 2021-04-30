package tn.enis.repositories;
import tn.enis.entities.Etudiant;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	public List<Etudiant> findByNom(String n);
	public Page<Etudiant> findByNom(String n, Pageable pageable);
	
	
	

}
