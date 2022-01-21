package com.ninja.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.app.model.ChakraType;
import com.ninja.app.model.CurrentEnemy;
import com.ninja.app.model.Ninja;
import com.ninja.app.model.Village;
import com.ninja.app.model.WeaponModel;
import com.ninja.app.service.NinjaService;

@RestController
@RequestMapping("/api")
public class NinjaController {

	CurrentEnemy enemyModel;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/enemy")
	private String currentEnemy() {	
		return enemyModel.getName();
	}
	
	@PostMapping("/chakra")
	private ChakraType createChakraType(@RequestBody ChakraType chakraType) {
		return ninjaService.createChakraType(chakraType);
	}
	
	@DeleteMapping("/chakra/{id}")
	private void deleteChakraById(@PathVariable("id") String id) {
		 ninjaService.deleteChakraById(UUID.fromString(id));
	}
	
	@GetMapping("/chakra/{id}")
	private void findChakraById(@PathVariable("id") String id) {
		 ninjaService.findChakraById(UUID.fromString(id));
	}
	
	@PostMapping("/ninja")
	public Ninja createNinja(@RequestBody Ninja ninja) {
		return ninjaService.createNinja(ninja);
	}

	@DeleteMapping("/ninja/{id}")
	public void deleteNinjaById(@PathVariable UUID id) {
	    ninjaService.deleteNinjaById(id);
	}
	
	@GetMapping("/ninja/{id}")
	public Ninja findNinjaById(@PathVariable UUID id) {
		return ninjaService.findNinjaById(id);
	}

	@PostMapping("/village")
	public Village createVillage(@RequestBody Village village) {
		return ninjaService.createVillage(village);
	}

	@GetMapping("/village/{id}")
	public Village findVillageById(@PathVariable UUID id) {
		return ninjaService.findVillageById(id);
	}

	@GetMapping("/village/{name}")
	public Village findVillageByName(@PathVariable String name) {
		return ninjaService.findVillageByName(name);
	}

	@DeleteMapping("/village/{id}")
	public void deleteVillageById(@PathVariable UUID id) {
		ninjaService.deleteVillageById(id);
	}
	
	@GetMapping("/weapons")
	private List<WeaponModel> findAllWeapons() {
		return ninjaService.findAllWeapons();
	}
	
	@GetMapping("/weapon/{id}")
	private EntityModel<WeaponModel> findWeaponByName(@PathVariable("name") String name) {
		return ninjaService.findWeaponByName(name);
	}
}
