package com.fots.backendap.service;


import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fots.backendap.model.Education;
import com.fots.backendap.repositories.EducationRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class EducationServiceImpl implements EducationService{
     private final EducationRepo educationRepo;

    @Override
    public Education get(Long id) {
        log.info("Fetching education with id {}",id);
        return educationRepo.findById(id).orElse(null);
    }

    @Override
    public Collection<Education> list(int limit) {
        log.info("Fetching educations");
        return educationRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Education create(Education education) {
        log.info("Saving new education w/ title: {}",education.getTitle());
        return educationRepo.save(education);
    }

    @Override
    public Education update(Education education) {
        log.info("Updating education w/ title: {}",education.getTitle());
        return educationRepo.save(education);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting education with id {}",id);
        educationRepo.deleteById(id);
        return true;
    }
    
}
