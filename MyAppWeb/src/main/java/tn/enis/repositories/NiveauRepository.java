package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Niveau;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {

}
