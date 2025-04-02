package com.lobito.dictionary.repositories;

import com.lobito.dictionary.domain.SpanishWord;
import org.springframework.stereotype.Repository;

@Repository
public interface SpanishWordRepository extends DictionaryRepository<SpanishWord, Long>  {

}
