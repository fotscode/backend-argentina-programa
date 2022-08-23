package com.fots.backendap.service.implementations;

import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fots.backendap.model.Skill;
import com.fots.backendap.repositories.SkillRepo;
import com.fots.backendap.service.SkillService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class SkillServiceImpl implements SkillService{
    private final SkillRepo skillRepo;

    @Override
    public Skill get(Long id) {
        log.info("Fetching skill with id {}",id);
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public Collection<Skill> list(int limit) {
        log.info("Fetching skills");
        return skillRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Skill create(Skill skill) {
        log.info("Saving new skill w/ title: {}",skill.getTitle());
        return skillRepo.save(skill);
    }

    @Override
    public Skill update(Skill skill) {
        log.info("Updating skill w/ title: {}",skill.getTitle());
        return skillRepo.save(skill);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting skill with id {}",id);
        skillRepo.deleteById(id);
        return true;
    }
 
}
