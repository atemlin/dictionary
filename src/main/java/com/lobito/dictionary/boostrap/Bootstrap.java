package com.lobito.dictionary.boostrap;

import com.lobito.dictionary.domain.SlovenianWord;
import com.lobito.dictionary.repositories.SlovenianWordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    SlovenianWordRepository slovenianRepo;

    public Bootstrap(SlovenianWordRepository sloRepo) {
        this.slovenianRepo = sloRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("********** Started in BT **********");

        System.out.println("*** Slovenian section");
        //SlovenianDictionary sloDictionary = new SlovenianDictionary();
        //sloDictionary.setWord("ena");
        slovenianRepo.save(new SlovenianWord("ena"));
        slovenianRepo.save(new SlovenianWord("dve"));

    }
}