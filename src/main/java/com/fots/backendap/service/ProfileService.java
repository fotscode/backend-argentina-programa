package com.fots.backendap.service;

import java.util.Collection;

import com.fots.backendap.model.Profile;

public interface ProfileService {
    Profile get(Long id);
    Profile update(Profile profile);
    Collection<Profile> list(int limit);
}
