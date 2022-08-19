package com.fots.backendap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fots.backendap.model.Profile;
import com.fots.backendap.repositories.ProfileRepo;

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
}
