package com.lobito.dictionary.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "spanish_words")
public class SpanishWord extends DictionaryEntity {

    public SpanishWord(String word) {
        super(word);
    }

    //@OneToMany(mappedBy = "spanishWord")
    //private Set<SlovenianSpanishDictionary> slovenianSpanishDictionarySet;
}
