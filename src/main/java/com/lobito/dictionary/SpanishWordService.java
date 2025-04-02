package com.lobito.dictionary.services;

import com.lobito.dictionary.domain.SpanishWord;
import java.util.List;
import java.util.Optional;

public interface SpanishWordService {

    Optional<SpanishWord> findSpanishWordById(Long id);

    Optional<SpanishWord> findSpanishWord(String word);

    List<SpanishWord> getAllSpanishWords();

    Optional<List<SpanishWord>> findSpanishWordsByWordStartsWithOrderByWord(String word);

    SpanishWord addNewSpanishWord(String newSpanishWord);

    void deleteSpanishWord(Long id);

    long getTotalNumberOfWords();

}
