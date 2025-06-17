package org.event.backend.repository;

import org.event.backend.Entity.Expediteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpediteurRepository extends JpaRepository<Expediteur, Long> {

    Optional<Expediteur> findByEmail(String email);

    boolean existsByEmail(String email);
}
