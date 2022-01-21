package com.ninja.app.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import com.ninja.app.model.ChakraType;
import com.ninja.app.model.JutsuCategory;
import com.ninja.app.model.Ninja;
import com.ninja.app.model.NinjaWeaponProxy;
import com.ninja.app.model.Village;
import com.ninja.app.model.WeaponModel;
import com.ninja.app.repository.ChakraRepo;
import com.ninja.app.repository.NinjaRepo;
import com.ninja.app.repository.VillageRepo;

@Service
public class NinjaService {

	@Autowired
	ChakraRepo chakraRepo;

	@Autowired
	VillageRepo villageRepo;

	@Autowired
	NinjaRepo ninjaRepo;
	
	@Autowired
	NinjaWeaponProxy proxy;

	public ChakraType createChakraType(ChakraType chakraType) {
		return chakraRepo.save(chakraType);
	}

	public void deleteChakraById(UUID id) {
		chakraRepo.deleteById(id);
	}

	public ChakraType findChakraById(UUID id) {
		return chakraRepo.findById(id).get();
	}

	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	public void deleteNinjaById(UUID id) {
		ninjaRepo.deleteById(id);
	}

	public Ninja findNinjaById(UUID id) {
		return ninjaRepo.findById(id).get();
	}

	public Village createVillage(Village village) {
		return villageRepo.save(village);
	}

	public Village findVillageById(UUID id) {
		return villageRepo.findById(id).get();
	}

	public Village findVillageByName(String name) {
		return villageRepo.findByName(name);
	}

	public void deleteVillageById(UUID id) {
		villageRepo.deleteById(id);
	}

	public EntityModel<WeaponModel> findWeaponByName(String name) {
		return proxy.findWeaponByName(name);
	}
	
	public List<WeaponModel> findAllWeapons() {
		return proxy.findAllWeapons();
	}
	
	@PostConstruct
	private void createDefaultData() {
		this.createDefaultVillage();
		this.createDefaultChakraType();
		this.createDefaultNinja();
	}

	public void createDefaultVillage() {
		this.createVillage(Village.builder().name("Hidden Leaf Village").build());
		this.createVillage(Village.builder().name("Hidden Stone Village").build());
		this.createVillage(Village.builder().name("Heat Devil Village").build());
		this.createVillage(Village.builder().name("Hidden Mist Village").build());
		this.createVillage(Village.builder().name("Hidden Cloud Village").build());
		this.createVillage(Village.builder().name("Hidden Sound Village").build());
		this.createVillage(Village.builder().name("Village Hidden by Sand").build());
	}

	public void createDefaultChakraType() {
		this.createChakraType(ChakraType.builder().chakra("water").build());
		this.createChakraType(ChakraType.builder().chakra("fire").build());
		this.createChakraType(ChakraType.builder().chakra("wind").build());
		this.createChakraType(ChakraType.builder().chakra("lightning").build());
		this.createChakraType(ChakraType.builder().chakra("earth").build());
	}

	public void createDefaultNinja() {
		List<String> jutsuCategoryJTG = List.of(JutsuCategory.getValue("NINJUTSU").getValue(),
				JutsuCategory.getValue("TAIJUTSU").getValue(), JutsuCategory.getValue("GENJUTSU").getValue());
		List<String> jutsuCategoryJT = List.of(JutsuCategory.getValue("NINJUTSU").getValue(),
				JutsuCategory.getValue("TAIJUTSU").getValue());
		List<String> jutsuCategoryT = List.of(JutsuCategory.getValue("TAIJUTSU").getValue());
		List<String> jutsuCategoryN = List.of(JutsuCategory.getValue("NINJUTSU").getValue());

		this.createNinja(Ninja.builder().name("Naruto Uzumaki").jutsuCategories(jutsuCategoryJT)
				.jutsu(List.of("Summoning Technique", "Sage Mode", "Shadow Clone Technique", "Rasengan",
						"Chakra Transfer Technique"))
				.powerLevel(100000).village(this.findVillageByName("Hidden Leaf Village"))
				.chakraType(List.of(this.chakraRepo.findByChakra("Wind".toLowerCase()))).build());

		this.createNinja(Ninja.builder().name("Rock Lee").jutsuCategories(jutsuCategoryT)
				.jutsu(List.of("Eight Gates", "Drunken Fist", "Reverse Lotus", "Youth Full Power",
						"Shadow of the Dancing Leaf"))
				.powerLevel(60000).village(this.findVillageByName("Hidden Leaf Village")).build());

		this.createNinja(Ninja.builder().name("Sasuke Uchiha").jutsuCategories(jutsuCategoryJTG)
				.jutsu(List.of("Genjutsu", "Chidori Current", "Amaterasu", "Susanoo", "Summoning Technique"))
				.powerLevel(95000).village(this.findVillageByName("Hidden Leaf Village"))
				.chakraType(List.of(this.chakraRepo.findByChakra("Lightning".toLowerCase()),
						this.chakraRepo.findByChakra("Fire".toLowerCase())))
				.build());

		this.createNinja(Ninja.builder().name("Gaara").jutsuCategories(jutsuCategoryN)
				.jutsu(List.of("Sand Clone", "Sand Shuriken", "Prison Sand Burial", "Armour of Sand", "Third Eye"))
				.powerLevel(90000).village(this.findVillageByName("Village Hidden by Sand"))
				.chakraType(List.of(this.chakraRepo.findByChakra("Lightning".toLowerCase()),
						this.chakraRepo.findByChakra("Earth".toLowerCase()),
						this.chakraRepo.findByChakra("Wind".toLowerCase())))
				.build());
	}

}
