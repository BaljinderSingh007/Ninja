package com.ninja.app.model;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="",url="")
@FeignClient(name="NINJA-WEAPONS-APP")
public interface NinjaWeaponProxy {

	@GetMapping("/api/weapon/{name}")
	public EntityModel<WeaponModel> findWeaponByName(@PathVariable String name);
	
	@GetMapping("/api/weapons")
	public List<WeaponModel> findAllWeapons();
}
