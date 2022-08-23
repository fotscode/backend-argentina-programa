package com.fots.backendap.service.implementations;

import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fots.backendap.model.Project;
import com.fots.backendap.repositories.ProjectRepo;
import com.fots.backendap.service.ProjectService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepo projectRepo;

    @Override
    public Project get(Long id) {
        log.info("Fetching project with id {}", id);
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public Collection<Project> list(int limit) {
        log.info("Fetching projects");
        return projectRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Project create(Project project) {
        log.info("Saving new project w/ title: {}", project.getTitle());
        return projectRepo.save(project);
    }

    @Override
    public Project update(Project project) {
        log.info("Updating project w/ title: {}", project.getTitle());
        return projectRepo.save(project);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting project with id {}", id);
        projectRepo.deleteById(id);
        return true;
    }

}
