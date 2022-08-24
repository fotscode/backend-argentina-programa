package com.fots.backendap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fots.backendap.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long>{
}
