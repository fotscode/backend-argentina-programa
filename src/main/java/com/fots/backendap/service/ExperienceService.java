package com.fots.backendap.service;

import java.util.Collection;

import com.fots.backendap.model.Experience;

public interface ExperienceService {
    Experience get(Long id);
    Collection<Experience> list(int limit);
    Experience create(Experience experience);
    Experience update(Experience experience);
    Boolean delete(Long id);
}
