package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {

}
