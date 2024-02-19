package com.challenge.soup.models.sopa;


public class WordSearcherModel {
    private char[][] alphabetSoup;
    private Boolean presente;

    public WordSearcherModel(char[][] alphabetSoup, Boolean presente) {
        this.alphabetSoup = alphabetSoup;
        this.presente = presente;
    }

    public char[][] getAlphabetSoup() {
        return alphabetSoup;
    }

    public void setAlphabetSoup(char[][] alphabetSoup) {
        this.alphabetSoup = alphabetSoup;
    }

    public boolean isPresent() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
