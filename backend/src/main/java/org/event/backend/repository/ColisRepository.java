package org.event.backend.repository;

import org.event.backend.Entity.Colis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColisRepository extends JpaRepository<Colis, Long> {
    List<Colis> findByTypeColis(String typeColis);

    List<Colis> findByPoidsLessThan(double poids);

    List<Colis> findByPoidsGreaterThanEqual(double poids);

    List<Colis> findByLongueurLessThanAndLargeurLessThanAndHauteurLessThan(
            double longueur, double largeur, double hauteur);
}
