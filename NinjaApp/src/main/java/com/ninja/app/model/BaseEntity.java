package com.ninja.app.model;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

	@Convert(converter = OffsetDateTimeConverter.class)
	@Column(name = "created_on" ,updatable = false)
	@JsonProperty(access = Access.READ_ONLY)
	@JsonFormat(shape = Shape.STRING , pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private OffsetDateTime createdOn;
	
	@Convert(converter = OffsetDateTimeConverter.class)
	@Column(name = "modified_on")
	@JsonProperty(access = Access.READ_ONLY)
	@JsonFormat(shape = Shape.STRING , pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private OffsetDateTime modifiedOn;
	
    @PrePersist
    public void prePersist() {

        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        createdOn = now;
        modifiedOn = now;
    }

    @PreUpdate
    public void preUpdate() {
        modifiedOn = OffsetDateTime.now(ZoneOffset.UTC);
    }
}
