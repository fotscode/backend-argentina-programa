package com.fots.backendap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fots.backendap.model.Skill;

public interface SkillRepo extends JpaRepository<Skill,Long>{
}
