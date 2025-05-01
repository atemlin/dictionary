package com.lobito.dictionary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Getter
public enum Gender {
    MALE("M"),
    FEMALE("F"),
    NEUTER("N"),
    MALE_PLURAL("M PL"),
    FEMALE_PLURAL("F PL"),
    NEUTER_PLURAL("N PL");

    private String type;
}
