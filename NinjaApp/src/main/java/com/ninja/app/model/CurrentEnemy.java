package com.ninja.app.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties("current-enemy")
public class CurrentEnemy {

	private String name;
}
