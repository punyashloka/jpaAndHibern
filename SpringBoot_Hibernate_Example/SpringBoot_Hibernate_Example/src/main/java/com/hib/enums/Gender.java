package com.hib.enums;

public enum Gender {
	MALE( 'M' ),
    FEMALE( 'F' );

    private final char code;

    private Gender(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Gender fromCode(char code) {
        if ( code == 'M' || code == 'm' ) {
            return MALE;
        }
        if ( code == 'F' || code == 'f' ) {
            return FEMALE;
        }
        throw new IllegalArgumentException("notr a valid gender");
    }
}