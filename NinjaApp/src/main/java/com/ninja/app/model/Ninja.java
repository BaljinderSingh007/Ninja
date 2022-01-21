package com.ninja.app.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.ListArrayType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TypeDefs({@TypeDef(name = "list-array", typeClass = ListArrayType.class)})
public class Ninja extends BaseEntity{
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column(name = "name",unique = true)
	private String name;
	
    @Type(type = "list-array")
    @Column(name = "jutsu_categories", columnDefinition = "text[]")
	private List<String> jutsuCategories;
	
    @Type(type = "list-array")
    @Column(name = "jutsu", columnDefinition = "text[]")
	private List<String> jutsu;
	
	private Integer powerLevel;
	
	@ManyToMany
	private List<ChakraType> chakraType;	// Fire, water, earth, lightning, Wind
	
	@ManyToOne
	private Village village;
}
