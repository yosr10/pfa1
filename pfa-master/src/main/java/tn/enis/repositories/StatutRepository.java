package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Statut;

@Repository
public interface StatutRepository extends JpaRepository<Statut, Long> {

}
