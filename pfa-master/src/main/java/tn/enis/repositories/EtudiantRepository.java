package tn.enis.repositories;
import tn.enis.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	public Page<Etudiant> findByNomContains(String mc,Pageable pageable);
	

}
