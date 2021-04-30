package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Disponibilite;

@Repository
public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Long> {

}
