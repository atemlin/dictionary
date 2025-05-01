package com.lobito.dictionary.services;

import com.lobito.dictionary.domain.SlovenianWord;
import com.lobito.dictionary.repositories.SlovenianWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SlovenianWordServiceImpl implements SlovenianWordService {

    @Autowired
    SlovenianWordRepository siRepository;

    @Override
    public Optional<SlovenianWord> findSlovenianWordById(Long id) {
        return siRepository.findById(id);
    }

    @Override
    public Optional<SlovenianWord> findSlovenianWord(String word) {
        return siRepository.findWordByWord(word);
    }

    @Override
    public List<SlovenianWord> getAllSlovenianWords() {
        List<SlovenianWord> siWords = new ArrayList<>();

        siRepository.findAll().forEach(siWords::add);

        return siWords;
    }

    @Override
    public Optional<List<SlovenianWord>> findSlovenianWordsByWordStartsWithOrderByWord(String word) {

        return siRepository.findWordsByWordStartsWithOrderByWord(word);
    }

    @Override
    public SlovenianWord addNewSlovenianWord(String newSlovenianWord) {
        SlovenianWord siDictionary = new SlovenianWord(newSlovenianWord);
        siRepository.save(siDictionary);

        return siDictionary;
    }

    @Override
    public void deleteSlovenianWord(Long id) {
        siRepository.deleteById(id);
    }

    @Override
    public long getTotalNumberOfWords() {
        return siRepository.count();
    }


}
