package com.ninjaweapon.app.repo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninjaweapon.app.model.WeaponModel;

@Repository
public interface WeaponRepo extends JpaRepository<WeaponModel, UUID>{

	WeaponModel findByName(String name);
}
