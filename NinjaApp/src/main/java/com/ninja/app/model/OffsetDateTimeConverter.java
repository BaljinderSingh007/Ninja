package com.ninja.app.model;


import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import static org.springframework.data.convert.Jsr310Converters.DateToLocalDateTimeConverter;
import static org.springframework.data.convert.Jsr310Converters.LocalDateTimeToDateConverter;

@Converter(autoApply = true)
@Component
public class OffsetDateTimeConverter implements AttributeConverter<OffsetDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }

        return LocalDateTimeToDateConverter.INSTANCE.convert(
                offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC).toLocalDateTime()
        );
    }

    @Override
    public OffsetDateTime convertToEntityAttribute(Date dbDate) {

        if (dbDate == null) {
            return null;
        }
        return DateToLocalDateTimeConverter.INSTANCE.convert(dbDate).atOffset(ZoneOffset.UTC);
    }
}