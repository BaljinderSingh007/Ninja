package com.ninja.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninja.app.model.Ninja;

@Repository
public interface NinjaRepo extends JpaRepository<Ninja, UUID>{

}
