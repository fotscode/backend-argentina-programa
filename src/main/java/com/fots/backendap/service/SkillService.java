package com.fots.backendap.service;

import java.util.Collection;

import com.fots.backendap.model.Skill;

public interface SkillService {
    Skill get(Long id);
    Collection<Skill> list(int limit);
    Skill create(Skill skill);
    Skill update(Skill skill);
    Boolean delete(Long id);   
}
