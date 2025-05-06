package com.example.germanvocabularyservice.germanvocabulary.repository;

import com.example.germanvocabularyservice.germanvocabulary.entity.GermanWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelToDatabaseRepository extends JpaRepository<GermanWord, Long> {


}
