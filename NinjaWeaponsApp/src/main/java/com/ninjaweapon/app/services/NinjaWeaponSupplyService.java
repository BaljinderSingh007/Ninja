package com.ninjaweapon.app.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninjaweapon.app.model.WeaponModel;
import com.ninjaweapon.app.repo.WeaponRepo;

@Service
public class NinjaWeaponSupplyService {

	@Autowired
	WeaponRepo repo;
	
	public WeaponModel createWeapon(WeaponModel weapon) {
		return repo.save(weapon);
	}
	
	public List<WeaponModel> findAllWeapons() {
		return repo.findAll();
	}
	
	public WeaponModel findWeaponByName(String name) {
		return repo.findByName(name);
	}
	
	@PostConstruct
	public void defaultWeapons() {

		this.createWeapon(WeaponModel.builder().name("Chakra Blade").power(35).build());
		this.createWeapon(WeaponModel.builder().name("Katana").power(30).build());
		this.createWeapon(WeaponModel.builder().name("Kunai").power(10).build());
		this.createWeapon(WeaponModel.builder().name("Metal Threads").power(18).build());
		this.createWeapon(WeaponModel.builder().name("Smoke Bomb").power(0).build());
		this.createWeapon(WeaponModel.builder().name("Windmill Shuriken").power(25).build());
	}
}
