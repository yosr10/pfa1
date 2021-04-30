package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.PlanEtude;

@Repository
public interface PlanEtudeRepository extends JpaRepository<PlanEtude, Long> {

}

