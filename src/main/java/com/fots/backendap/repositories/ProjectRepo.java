package com.fots.backendap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fots.backendap.model.Project;

public interface ProjectRepo extends JpaRepository<Project,Long>{
}
