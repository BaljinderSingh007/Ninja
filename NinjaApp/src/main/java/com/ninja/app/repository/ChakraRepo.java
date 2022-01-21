package com.ninja.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninja.app.model.ChakraType;

@Repository
public interface ChakraRepo extends JpaRepository<ChakraType, UUID>{

	ChakraType findByChakra(String chakra);
	
}
