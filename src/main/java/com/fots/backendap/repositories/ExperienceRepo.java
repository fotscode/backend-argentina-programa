package com.fots.backendap.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fots.backendap.model.Experience;

@Repository
public interface ExperienceRepo extends JpaRepository<Experience, Long> {
}
