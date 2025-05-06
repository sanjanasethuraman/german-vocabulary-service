package com.example.germanvocabularyservice.germanvocabulary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "german_vocabulary")
public class GermanWord {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long Id;

    @Column(name = "singular_nominativ")
    private String singularNominativ;

    @Column(name = "singular_akkusativ")
    private String singularAkkusativ;

    @Column(name = "plural_nominativ")
    private String pluralNominativ;

    @Column(name = "plural_akkusativ")
    private String pluralAkkusativ;

    @Column(name = "wort_ohne_artikel")
    private String wortOhneArtikel;

    public GermanWord() {

    }

    public GermanWord(String singularNominativ, String singularAkkusativ, String pluralNominativ, String pluralAkkusativ, String wortOhneArtikel, String englishTranslation) {
        this.singularNominativ = singularNominativ;
        this.singularAkkusativ = singularAkkusativ;
        this.pluralNominativ = pluralNominativ;
        this.pluralAkkusativ = pluralAkkusativ;
        this.wortOhneArtikel = wortOhneArtikel;
        this.englishTranslation = englishTranslation;
    }

    @Column(name = "english_translation")
    private String englishTranslation;

    @Override
    public boolean equals(Object obj) {
        GermanWord receivedObject = (GermanWord) obj;

        if (!this.singularNominativ.equalsIgnoreCase(receivedObject.singularNominativ)) return false;
        if (!this.singularAkkusativ.equalsIgnoreCase(receivedObject.singularAkkusativ)) return false;
        if (!this.pluralNominativ.equalsIgnoreCase(receivedObject.pluralNominativ)) return false;
        return this.pluralAkkusativ.equalsIgnoreCase(receivedObject.pluralAkkusativ);
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getSingularNominativ() {
        return singularNominativ;
    }

    public void setSingularNominativ(String singularNominativ) {
        this.singularNominativ = singularNominativ;
    }

    public String getSingularAkkusativ() {
        return singularAkkusativ;
    }

    public void setSingularAkkusativ(String singularAkkusativ) {
        this.singularAkkusativ = singularAkkusativ;
    }

    public String getPluralNominativ() {
        return pluralNominativ;
    }

    public void setPluralNominativ(String pluralNominativ) {
        this.pluralNominativ = pluralNominativ;
    }

    public String getPluralAkkusativ() {
        return pluralAkkusativ;
    }

    public void setPluralAkkusativ(String pluralAkkusativ) {
        this.pluralAkkusativ = pluralAkkusativ;
    }

    public String getWortOhneArtikel() {
        return wortOhneArtikel;
    }

    public void setWortOhneArtikel(String wortOhneArtikel) {
        this.wortOhneArtikel = wortOhneArtikel;
    }

    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        this.englishTranslation = englishTranslation;
    }
}
