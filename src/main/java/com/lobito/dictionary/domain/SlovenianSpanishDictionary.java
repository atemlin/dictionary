package com.lobito.dictionary.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;


@Getter @Setter
@NoArgsConstructor //@AllArgsConstructor
@Entity
@Table(name = "slovenian_spanish_dictionary")
public class SlovenianSpanishDictionary implements Serializable {

    @EmbeddedId
    private SlovenianSpanishWordId id;

    @ManyToOne
    @MapsId("slovenianWordId")
    @JoinColumn(name="slovenian_word_id")
    private SlovenianWord slovenianWord;

    @ManyToOne
    @MapsId("spanishWordId")
    @JoinColumn(name="spanish_word_id")
    private SpanishWord spanishWord;

    //@Column(nullable = true)
    private Integer wordGroupId;

    @Column(columnDefinition = "varchar(4)")
    private Gender slovenianGender;

    @Column(columnDefinition = "varchar(4)")
    private Gender spanishGender;

    //@Column(nullable = true)
    private Integer categoryId;

}
