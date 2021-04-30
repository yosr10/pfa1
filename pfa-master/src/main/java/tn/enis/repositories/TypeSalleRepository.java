package tn.enis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.entities.TypeSalle;

@Repository
public interface TypeSalleRepository extends JpaRepository<TypeSalle, Long> {

}

