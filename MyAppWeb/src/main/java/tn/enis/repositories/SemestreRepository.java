package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Semestre;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {

}
