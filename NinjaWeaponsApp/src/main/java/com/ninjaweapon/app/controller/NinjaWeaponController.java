package com.ninjaweapon.app.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ninjaweapon.app.model.WeaponModel;
import com.ninjaweapon.app.services.NinjaWeaponSupplyService;
@RestController("/api")
public class NinjaWeaponController {

	@Autowired
	NinjaWeaponSupplyService service;
	
	@GetMapping("/weapons")
	public List<WeaponModel> findAllWeapons() {
		return service.findAllWeapons();
	}
	
	@GetMapping("/weapon/{name}")
	public EntityModel<WeaponModel> findWeaponByName(@PathVariable @Min(3) @NotNull String name) {
		EntityModel<WeaponModel> model = EntityModel.of(service.findWeaponByName(name));
		WebMvcLinkBuilder builder = linkTo(methodOn(this.getClass()).findAllWeapons());
		model.add(builder.withSelfRel());
		return model;
	}

	@PostMapping("/weapon")
	public EntityModel<WeaponModel> createWeapon(@RequestBody WeaponModel weapon) {
		EntityModel<WeaponModel> model = EntityModel.of(service.createWeapon(weapon));
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findWeaponByName(weapon.getName()));
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findAllWeapons());
		model.add(link1.withSelfRel());
		model.add(link2.withSelfRel());
		return model;
	}
}
