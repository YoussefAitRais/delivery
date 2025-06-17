package org.event.backend.repository;

import org.event.backend.Entity.Demande;
import org.event.backend.Entity.Expediteur;
import org.event.backend.Entity.Trajet;
import org.event.backend.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {

    List<Demande> findByExpediteur(Expediteur expediteur);

    List<Demande> findByTrajet(Trajet trajet);

    List<Demande> findByStatus(Status status);

    List<Demande> findByTrajetAndStatus(Trajet trajet, Status status);
}
