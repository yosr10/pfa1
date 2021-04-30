package tn.enis.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
	
	
}
