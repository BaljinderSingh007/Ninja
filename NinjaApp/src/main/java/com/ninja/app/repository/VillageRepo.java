package com.ninja.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ninja.app.model.Village;

@Repository
public interface VillageRepo extends JpaRepository<Village, UUID>{

	Village findByName(String name);	
}
