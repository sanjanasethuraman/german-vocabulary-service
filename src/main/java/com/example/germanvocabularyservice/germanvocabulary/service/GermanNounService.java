package com.example.germanvocabularyservice.germanvocabulary.service;

import com.example.germanvocabularyservice.germanvocabulary.entity.AnswerEvaluator;
import com.example.germanvocabularyservice.germanvocabulary.entity.GermanWord;
import com.example.germanvocabularyservice.germanvocabulary.repository.GermanNounRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class GermanNounService {
    private GermanNounRepository germanNounRepository;

    private HashSet<Long> questionSet = new HashSet<>();
    private GermanWord fetchedWord;
    private AnswerEvaluator answerEvaluator = new AnswerEvaluator();

    GermanNounService(GermanNounRepository repository) {
        this.germanNounRepository = repository;
    }

    public GermanWord getRandomWordFromDatabase() {
        try {
            fetchedWord = germanNounRepository.getRandomWordFromDatabase();
            GermanWord outgoingData = new GermanWord("", "", "", "", fetchedWord.getWortOhneArtikel(), fetchedWord.getEnglishTranslation());
            if (!questionSet.contains(fetchedWord.getId())) return outgoingData;
            questionSet.add(fetchedWord.getId());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public AnswerEvaluator checkValidityOfAnswer(GermanWord word) {
        if (fetchedWord.equals(word)) {
            answerEvaluator.setScore();
            answerEvaluator.setCorrectAnswers(fetchedWord.getId());
            answerEvaluator.setAnswerValid(fetchedWord.equals(word));
            return answerEvaluator;
        }

        return null;
    }
}
