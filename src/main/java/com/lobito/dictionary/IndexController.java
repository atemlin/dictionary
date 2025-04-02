package com.lobito.dictionary.controllers;

import com.lobito.dictionary.services.SlovenianWordService;
import com.lobito.dictionary.services.SpanishWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class IndexController {

    private final SlovenianWordService siService;
    private final SpanishWordService esService;

    @GetMapping(value={"/","/hello"})
    ResponseEntity<String> hello() {
        long totalWords = 0; //esWordService.getTotalNumberOfWords();
        return ResponseEntity.ok("Welcome to Slovenian-Spanish Dictionary Service!\n"
                + "Total slovenian words: " + siService.getTotalNumberOfWords() + "! \n"
                + " Total spanish words: " + esService.getTotalNumberOfWords() + "! \n");
    }

}
