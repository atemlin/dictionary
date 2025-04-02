package com.lobito.dictionary.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface DictionaryRepository<T, ID> extends CrudRepository<T, ID> {

    Optional<T> findWordByWord(final String word);

    Optional<List<T>> findWordsByWordStartsWithOrderByWord (final String word);
}
