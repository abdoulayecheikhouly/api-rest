package com.ly.api.testapi.repository;

import com.ly.api.testapi.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonneRepository extends JpaRepository <Personne,Long> {
}
