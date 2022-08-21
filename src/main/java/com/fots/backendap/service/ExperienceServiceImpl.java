package com.fots.backendap.service;

import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fots.backendap.model.Experience;
import com.fots.backendap.repositories.ExperienceRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ExperienceServiceImpl implements ExperienceService{
    private final ExperienceRepo experienceRepo;

    @Override
    public Experience get(Long id) {
        log.info("Fetching experience with id {}",id);
        return experienceRepo.findById(id).orElse(null);
    }

    @Override
    public Collection<Experience> list(int limit) {
        log.info("Fetching experiences");
        return experienceRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Experience create(Experience experience) {
        log.info("Saving new experience w/ title: {}",experience.getTitle());
        return experienceRepo.save(experience);
    }

    @Override
    public Experience update(Experience experience) {
        log.info("Updating experience w/ title: {}",experience.getTitle());
        return experienceRepo.save(experience);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting experience with id {}",id);
        experienceRepo.deleteById(id);
        return true;
    }
    
}
