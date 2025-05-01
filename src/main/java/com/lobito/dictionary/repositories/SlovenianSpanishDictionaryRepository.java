package com.lobito.dictionary.repositories;

import com.lobito.dictionary.domain.SlovenianSpanishDictionary;
import com.lobito.dictionary.domain.SlovenianSpanishWordId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SlovenianSpanishDictionaryRepository extends CrudRepository<SlovenianSpanishDictionary,
                                                                            SlovenianSpanishWordId> {

    @Query(value = "SELECT MAX(wordGroupId) FROM SlovenianSpanishDictionary")
    Optional<Integer> getMaxWordGroupId();

    Optional<SlovenianSpanishDictionary>findSlovenianSpanishEntryById(SlovenianSpanishWordId entryId);

}
