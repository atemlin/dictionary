package com.lobito.dictionary.services;

import com.lobito.dictionary.domain.SlovenianSpanishDictionary;
import com.lobito.dictionary.domain.SlovenianSpanishWordId;
import com.lobito.dictionary.repositories.SlovenianSpanishDictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SlovenianSpanishDictionaryServiceImpl implements SlovenianSpanishDictionaryService {

    private final SlovenianSpanishDictionaryRepository repo;

    @Override
    public List<SlovenianSpanishDictionary> getAllSlovenianSpanishWords() {
        List<SlovenianSpanishDictionary> words = new ArrayList<>();

        repo.findAll().forEach(words::add);
        return words;
    }

    @Override
    public Optional<Integer> getMaxWordGroupId() {
        return repo.getMaxWordGroupId();//.orElse(0);
    }

    @Override
    public SlovenianSpanishDictionary slovenianSpanishWord(SlovenianSpanishDictionary entry) {
        return repo.save(entry);
    }

    @Override
    public Optional<SlovenianSpanishDictionary> findSlovenianSpanishEntryById(SlovenianSpanishWordId entryId) {
        return repo.findSlovenianSpanishEntryById(entryId);
    }



}
