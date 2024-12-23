package org.sports.sport.repositories;

import java.util.List;
import java.util.Optional;

import org.sports.sport.dto.sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface sportRepository extends JpaRepository<sport, Integer> {

    boolean existsByName(String name);

    Optional<sport> findByName(String name);

    List<sport> findByType(String type);

}
