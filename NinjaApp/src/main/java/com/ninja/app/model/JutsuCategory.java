package com.ninja.app.model;

import java.util.Arrays;

public enum JutsuCategory {

	NINJUTSU("Ninjutsu"),
	TAIJUTSU("Taijutsu"),
	GENJUTSU("Genjutsu");

	public final String value;
	
	JutsuCategory(String value) {
		this.value = value;
	}
	
    public static JutsuCategory getValue(String value) {
        return Arrays.stream(JutsuCategory.values())
                .filter(e -> e.getValue().equalsIgnoreCase(value)).findAny().orElse(null);
    }
    
    public String getValue() {
        return value;
    }
}
