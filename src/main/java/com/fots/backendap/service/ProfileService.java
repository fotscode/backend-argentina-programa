package com.fots.backendap.service;

import com.fots.backendap.model.Profile;

public interface ProfileService {
    Profile get(Long id);
    Profile update(Profile profile);
}
