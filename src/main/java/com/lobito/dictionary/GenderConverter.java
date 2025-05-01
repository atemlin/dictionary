package com.lobito.dictionary.converters;

import com.lobito.dictionary.domain.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender gender) {
        if (gender == null) {
            return null;
        }
        return gender.getType();
    }

    @Override
    public Gender convertToEntityAttribute(String type) {
        if (type == null) {
            return null;
        }

        return Stream.of(Gender.values())
            .filter(gender -> gender.getType().equals(type))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
