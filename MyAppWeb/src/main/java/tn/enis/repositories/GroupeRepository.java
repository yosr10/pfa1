package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
