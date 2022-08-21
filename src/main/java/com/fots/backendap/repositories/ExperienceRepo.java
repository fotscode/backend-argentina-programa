package com.fots.backendap.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fots.backendap.model.Experience;
public interface ExperienceRepo extends JpaRepository<Experience, Long> {
}
