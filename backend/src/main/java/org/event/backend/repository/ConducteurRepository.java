package org.event.backend.repository;

import org.event.backend.Entity.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {

    Optional<Conducteur> findByEmail(String email);

    boolean existsByEmail(String email);
}
