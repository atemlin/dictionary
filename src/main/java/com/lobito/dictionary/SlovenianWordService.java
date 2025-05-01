package com.lobito.dictionary.services;


import com.lobito.dictionary.domain.SlovenianWord;

import java.util.List;
import java.util.Optional;

public interface SlovenianWordService {

    Optional<SlovenianWord> findSlovenianWordById(Long id);

    Optional<SlovenianWord> findSlovenianWord(String word);

    List<SlovenianWord> getAllSlovenianWords();

    Optional<List<SlovenianWord>> findSlovenianWordsByWordStartsWithOrderByWord(String word);

    SlovenianWord addNewSlovenianWord(String newSlovenianWord);

    void deleteSlovenianWord(Long id);

    long getTotalNumberOfWords();

}
