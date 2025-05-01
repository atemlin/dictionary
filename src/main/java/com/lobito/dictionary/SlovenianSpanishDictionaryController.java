package com.lobito.dictionary.controllers;

import com.lobito.dictionary.domain.SlovenianSpanishDictionary;
import com.lobito.dictionary.domain.SlovenianSpanishWordId;
import com.lobito.dictionary.dtos.SlovenianSpanishWordDTO;
import com.lobito.dictionary.services.SlovenianSpanishDictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class SlovenianSpanishDictionaryController {

    private SlovenianSpanishDictionaryService sloSpaDictService;

    @GetMapping("/slovenianSpanishDictionary")
    public List<SlovenianSpanishDictionary> getAllSlovenianSpanishDictionary() {

        return sloSpaDictService.getAllSlovenianSpanishWords();
    }

    @PostMapping("/slovenianSpanishDictionary")
    public ResponseEntity<?> addslovenianSpanishWord(@RequestBody SlovenianSpanishWordDTO slovenianSpanishWordDTO) {
        //Optional<Long> slovenianWordId = sloSpaDictService.findSlovenianWordById(slovenianSpanishWordDTO.slovenianWordId());
        //Optional<Long> SpanishWordId = sloSpaDictService.findSpanishWordById(slovenianSpanishWordDTO.spanishWordId());

        Optional<Integer> maxWordGroupName = sloSpaDictService.getMaxWordGroupId();

        System.out.println("Max: " + maxWordGroupName.orElse(0));
/*
        if (slovenianWordId.isPresent() && SpanishWordId.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("The entry data " + "\"" + slovenianWordId.get() + " - " + SpanishWordId.get() +
                          "\"" + " already exists!");
        }*/

        var slovenianSpanishWord = new SlovenianSpanishDictionary();
        var slovenianSpanishWordKey = new SlovenianSpanishWordId();
        slovenianSpanishWordKey.setSlovenianWordId(slovenianSpanishWordDTO.slovenianWordId());
        slovenianSpanishWordKey.setSpanishWordId(slovenianSpanishWordDTO.spanishWordId());
        slovenianSpanishWord.setId(slovenianSpanishWordKey);

        var savedSlovenianSpanishWord = sloSpaDictService.slovenianSpanishWord(slovenianSpanishWord);
        return ResponseEntity.ok(savedSlovenianSpanishWord);
    }

}
