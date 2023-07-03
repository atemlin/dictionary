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
public class SlovenianWord extends DictionaryEntity {

    public SlovenianWord(String word) {
        super(word);
    }

}

// public SpanishDictionary(Long id, String word) {
//      super(id, word);
//  }