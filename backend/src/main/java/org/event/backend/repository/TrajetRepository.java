package org.event.backend.repository;


import org.event.backend.Entity.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Long> {
    // Custom methods later if needed
}

