package com.fots.backendap.service.implementations;

import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fots.backendap.model.Profile;
import com.fots.backendap.repositories.ProfileRepo;
import com.fots.backendap.service.ProfileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepo profileRepo;
    @Override
    public Profile update(Profile profile) {
        log.info("Updating profile {}", profile.getId());
        return profileRepo.save(profile);
    }

    @Override
    public Profile get(Long id) {
        log.info("Fetching id: {}", id);
        return profileRepo.findById(id).orElse(null);
    }

    @Override
    public Collection<Profile> list(int limit) {
        log.info("Fetching profiles");
        return profileRepo.findAll(PageRequest.of(0,limit)).toList();

    }
}
