package com.lobito.dictionary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum Gender {
    MALE('M'),
    FEMALE('F'),
    NEUTER('N');

    private char sign;

    private Gender(char sign) {
        this.sign = sign;
    }
}
