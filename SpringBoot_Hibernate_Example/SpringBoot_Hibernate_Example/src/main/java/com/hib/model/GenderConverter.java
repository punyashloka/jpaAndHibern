package com.hib.model;

import javax.persistence.AttributeConverter;

import com.hib.enums.Gender;

public class GenderConverter implements AttributeConverter<Gender, Character> {

    public Character convertToDatabaseColumn(Gender value) {
        if ( value == null ) {
            return null;
        }

        return value.getCode();
    }

    public Gender convertToEntityAttribute(Character value) {
        if ( value == null ) {
            return null;
        }

        return Gender.fromCode( value );
    }
}