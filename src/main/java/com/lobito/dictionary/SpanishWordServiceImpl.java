package com.lobito.dictionary.services;

import com.lobito.dictionary.domain.SpanishWord;
import com.lobito.dictionary.repositories.SpanishWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SpanishWordServiceImpl implements SpanishWordService {

    //@Autowired
    private final SpanishWordRepository esRepository;

    @Override
    public Optional<SpanishWord> findSpanishWordById(Long id) {
        return esRepository.findById(id);
    }

    @Override
    public Optional<SpanishWord> findSpanishWord(String word) {
        return esRepository.findWordByWord(word);
    }

    @Override
    public List<SpanishWord> getAllSpanishWords() {
        List<SpanishWord> esWords = new ArrayList<>();

        esRepository.findAll().forEach(esWords::add);

        return esWords;
    }

    @Override
    public Optional<List<SpanishWord>> findSpanishWordsByWordStartsWithOrderByWord(String word) {

        return esRepository.findWordsByWordStartsWithOrderByWord(word);
    }

    @Override
    public SpanishWord addNewSpanishWord(String newSpanishWord) {
        SpanishWord siDictionary = new SpanishWord(newSpanishWord);
        esRepository.save(siDictionary);

        return siDictionary;
    }

    @Override
    public void deleteSpanishWord(Long id) {
        esRepository.deleteById(id);
    }

    @Override
    public long getTotalNumberOfWords() {
        return esRepository.count();
    }
}
