package tn.enis.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Departement;



@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {

			
}
