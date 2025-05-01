package com.lobito.dictionary.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@NoArgsConstructor //@AllArgsConstructor
@Data
@Embeddable
public class SlovenianSpanishWordId implements Serializable {
     @Column(name = "slovenian_word_id")
     Long slovenianWordId;

     @Column(name = "spanish_word_id")
     Long spanishWordId;
}
