package com.lobito.dictionary.services;

import com.lobito.dictionary.domain.SlovenianSpanishDictionary;
import com.lobito.dictionary.domain.SlovenianSpanishWordId;

import java.util.List;
import java.util.Optional;

public interface SlovenianSpanishDictionaryService {

    List<SlovenianSpanishDictionary> getAllSlovenianSpanishWords();

    Optional<Integer> getMaxWordGroupId();

    SlovenianSpanishDictionary slovenianSpanishWord(SlovenianSpanishDictionary entry) ;

    Optional<SlovenianSpanishDictionary> findSlovenianSpanishEntryById(SlovenianSpanishWordId entryId);

}
