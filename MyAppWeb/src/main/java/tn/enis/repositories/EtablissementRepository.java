package tn.enis.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Etablissement;
import tn.enis.entities.Etudiant;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
	public Page<Etablissement> findByNomContains(String mc,Pageable pageable);
	
}
