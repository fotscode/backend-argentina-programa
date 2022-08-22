package com.fots.backendap.service;

import java.util.Collection;

import com.fots.backendap.model.Education;

public interface EducationService {
    Education get(Long id);
    Collection<Education> list(int limit);
    Education create(Education education);
    Education update(Education education);
    Boolean delete(Long id);   
}
