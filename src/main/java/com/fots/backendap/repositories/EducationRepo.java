package com.fots.backendap.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fots.backendap.model.Education;

@Repository
public interface EducationRepo extends JpaRepository<Education,Long>{
}
