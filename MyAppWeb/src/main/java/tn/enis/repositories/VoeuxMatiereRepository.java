package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.VoeuxMatiere;

@Repository
public interface VoeuxMatiereRepository extends JpaRepository<VoeuxMatiere, Long> {

}
