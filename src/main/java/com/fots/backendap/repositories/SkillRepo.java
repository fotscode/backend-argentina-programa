package com.fots.backendap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fots.backendap.model.Skill;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Long>{
}
