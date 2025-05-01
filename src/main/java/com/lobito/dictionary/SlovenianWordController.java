package com.lobito.dictionary.controllers;

import com.lobito.dictionary.domain.SlovenianWord;
import com.lobito.dictionary.services.SlovenianWordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class SlovenianWordController {

    //@Autowired
    private final SlovenianWordService siWordService;

    @GetMapping(value="/helloSlovenian")
    ResponseEntity<String> hello() {
        long totalWords = siWordService.getTotalNumberOfWords();
        return ResponseEntity.ok("Welcome to Slovenian Dictionary Service! Total words: " + totalWords);
    }

    @GetMapping("/slovenianWords")
    public List<SlovenianWord> getAllSlovenianWords() {
        return siWordService.getAllSlovenianWords();
    }

    @GetMapping("/slovenianWords/{word}")
    public List<SlovenianWord> getAllSlovenianWords(@PathVariable(value = "word") String word) {
        return siWordService.findSlovenianWordsByWordStartsWithOrderByWord(word).orElse(List.of());
    }

    @PostMapping(value ="/slovenianWords")
    public ResponseEntity<?> addSlovenianWord(@RequestBody String newSlovenianWord) {
        Optional<SlovenianWord> response = siWordService.findSlovenianWord(newSlovenianWord);

        if (response.isPresent() ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("The word " + "\"" + response.get().getWord() + "\"" + " already exists!");
        }

        SlovenianWord savedWord = siWordService.addNewSlovenianWord(newSlovenianWord);
        return ResponseEntity.ok(savedWord);
    }

    @DeleteMapping("/slovenianWords/{id}")
    public ResponseEntity<?> deleteSlovenianWord(@PathVariable(value = "id") Long id) {
        Optional<SlovenianWord> wordToBeDeleted = siWordService.findSlovenianWordById(id);

        if (wordToBeDeleted.isEmpty() ) {
            return ResponseEntity.badRequest()
                    .body("The word does not exist!");
        }

        siWordService.deleteSlovenianWord(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("The word " + "\"" + wordToBeDeleted.get().getWord() + "\"" + " was deleted!");
    }
}
