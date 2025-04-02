package com.lobito.dictionary.controllers;

import com.lobito.dictionary.domain.SpanishWord;
import com.lobito.dictionary.services.SpanishWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class SpanishWordController {

    private final SpanishWordService esWordService;

    @GetMapping(value= "/helloSpanish")
    ResponseEntity<String> hello() {
        long totalWords = esWordService.getTotalNumberOfWords();
        return ResponseEntity.ok("Welcome to Spanish Dictionary Service! Total words: " + totalWords);
    }

    @GetMapping("/spanishWords")
    public List<SpanishWord> getAllSpanishWords() {
        return esWordService.getAllSpanishWords();
    }

    @GetMapping("/spanishWords/{word}")
    public List<SpanishWord> getAllSpanishWords(@PathVariable(value = "word") String word) {
        return esWordService.findSpanishWordsByWordStartsWithOrderByWord(word).orElse(List.of());
    }

    @PostMapping(value ="/spanishWords")
    public ResponseEntity<?> addSpanishWord(@RequestBody String newSpanishWord) {
        Optional<SpanishWord> response = esWordService.findSpanishWord(newSpanishWord);

        if (response.isPresent() ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("The word " + "\"" + response.get().getWord() + "\"" + " already exists!");
        }

        SpanishWord savedWord = esWordService.addNewSpanishWord(newSpanishWord);
        return ResponseEntity.ok(savedWord);
    }

    @DeleteMapping("/spanishWords/{id}")
    public ResponseEntity<?> deleteSpanishWord(@PathVariable(value = "id") Long id) {
        Optional<SpanishWord> wordToBeDeleted = esWordService.findSpanishWordById(id);

        if (wordToBeDeleted.isEmpty() ) {
            return ResponseEntity.badRequest()
                    .body("The word does not exist!");
        }

        esWordService.deleteSpanishWord(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("The word " + "\"" + wordToBeDeleted.get().getWord() + "\"" + " was deleted!");
    }
}
