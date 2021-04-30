package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.Unite;

@Repository
public interface UniteRepository extends JpaRepository<Unite, Long> {

}
