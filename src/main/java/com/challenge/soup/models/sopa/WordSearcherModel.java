package com.challenge.soup.models.sopa;


public class WordSearcherModel {
    private char[][] alphabetSoup;
    private Boolean presente;

    public WordSearcherModel(char[][] alphabetSoup) {
        this.alphabetSoup = alphabetSoup;
    }

    public char[][] getAlphabetSoup() {
        return alphabetSoup;
    }

    public void setAlphabetSoup(char[][] alphabetSoup) {
        this.alphabetSoup = alphabetSoup;
    }

    public boolean isPresent(String palabra) {
        
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
