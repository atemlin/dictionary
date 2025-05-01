package com.lobito.dictionary.repositories;

import com.lobito.dictionary.domain.SlovenianWord;
import org.springframework.stereotype.Repository;


@Repository
public interface SlovenianWordRepository extends DictionaryRepository<SlovenianWord, Long> {

}
