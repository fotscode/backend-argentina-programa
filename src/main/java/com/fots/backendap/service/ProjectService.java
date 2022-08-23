package com.fots.backendap.service;

import java.util.Collection;

import com.fots.backendap.model.Project;

public interface ProjectService {
    Project get(Long id);
    Collection<Project> list(int limit);
    Project create(Project project);
    Project update(Project project);
    Boolean delete(Long id);
}
