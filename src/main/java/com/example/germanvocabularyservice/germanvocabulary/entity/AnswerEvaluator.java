package com.example.germanvocabularyservice.germanvocabulary.entity;

import java.util.ArrayList;
import java.util.List;

public class AnswerEvaluator {
    private final List<Long> correctAnswers = new ArrayList<>();
    private int score;
    private boolean isAnswerValid;

    public boolean isAnswerValid() {
        return isAnswerValid;
    }

    public void setAnswerValid(boolean answerValid) {
        isAnswerValid = answerValid;
    }

    public List<Long> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Long id) {
        correctAnswers.add(id);
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score += 1;
    }
}
