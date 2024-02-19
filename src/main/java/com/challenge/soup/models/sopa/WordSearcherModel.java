package com.challenge.soup.models.sopa;


public class WordSearcherModel {
    private char[][] alphabetSoup;

    public WordSearcherModel(char[][] alphabetSoup) {
        this.alphabetSoup = alphabetSoup;
    }

    public String isPresent(String word) {
        word = word.toUpperCase();
        return word;
    }
    
    public char[][] getAlphabetSoup() {
        return alphabetSoup;
    }

    public void setAlphabetSoup(char[][] alphabetSoup) {
        this.alphabetSoup = alphabetSoup;
    }
}
