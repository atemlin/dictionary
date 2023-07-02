package com.lobito.dictionary.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "slovenian_words")
public class SlovenianDictionary extends DictionaryEntity {

    public SlovenianDictionary(String word) {
        super(word);
    }

}

// public SpanishDictionary(Long id, String word) {
//      super(id, word);
//  }