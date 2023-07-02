package com.lobito.dictionary.boostrap;

import com.lobito.dictionary.domain.SlovenianDictionary;
import com.lobito.dictionary.repositories.SlovenianDictionaryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    SlovenianDictionaryRepository sloRepo;

    public Bootstrap(SlovenianDictionaryRepository sloRepo) {
        this.sloRepo = sloRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("********** Started in BT **********");

        System.out.println("*** Slovenian section");
        //SlovenianDictionary sloDictionary = new SlovenianDictionary();
        //sloDictionary.setWord("ena");
        sloRepo.save(new SlovenianDictionary("ena"));
        sloRepo.save(new SlovenianDictionary("dve"));

    }
}