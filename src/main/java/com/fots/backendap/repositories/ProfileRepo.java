package com.fots.backendap.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fots.backendap.model.Profile;;

public interface ProfileRepo extends JpaRepository<Profile,Long>{
}
