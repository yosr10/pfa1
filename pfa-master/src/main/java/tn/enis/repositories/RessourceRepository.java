package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Ressource;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Long> {

}
