package com.fots.backendap.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fots.backendap.model.Education;

public interface EducationRepo extends JpaRepository<Education,Long>{
}
