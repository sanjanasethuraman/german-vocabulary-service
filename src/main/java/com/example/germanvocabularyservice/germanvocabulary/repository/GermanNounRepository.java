package com.example.germanvocabularyservice.germanvocabulary.repository;

import com.example.germanvocabularyservice.germanvocabulary.entity.GermanWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GermanNounRepository extends JpaRepository<GermanWord, Long> {

    @Query(value = "SELECT * FROM german_vocabulary ORDER BY RAND() LIMIT 1", nativeQuery = true)
    GermanWord getRandomWordFromDatabase();
}
