package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Creneau;

@Repository
public interface CreneauRepository extends JpaRepository<Creneau, Long> {

}
