package com.challenge.soup.servicesImpl;

import com.challenge.soup.servicesImpl.services.WordSearcherService;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WordSearcherServiceImpl implements WordSearcherService {

    @Override
    public boolean isPresent(final String word, char[][] alphabetSoup) {
        String upperCaseWord = word.toUpperCase();
    
        // Búsqueda de palabras en las filas de la sopa de letras
        boolean foundInRows = Arrays.stream(alphabetSoup)
                .parallel()
                .anyMatch(row -> isWordPresentInRow(upperCaseWord, row));
    
        if (foundInRows) {
            return true;
        }
    
        // Búsqueda de palabras en las columnas de la sopa de letras
        boolean foundInColumns = IntStream.range(0, alphabetSoup[0].length)
                .parallel() 
                .anyMatch(col -> isWordPresentInColumn(upperCaseWord, alphabetSoup, col));
    
        return foundInColumns;
    }

    private boolean isWordPresentInRow(String word, char[] row) {
        int wordLen = word.length();
        int cols = row.length;
        for (int i = 0; i <= cols - wordLen; i++) {
            if (word.equals(new String(row, i, wordLen)) || word.equals(new String(reverseArray(row), i, wordLen))) {
                return true;
            }
        }
        return false;
    }

    private boolean isWordPresentInColumn(String word, char[][] alphabetSoup, int col) {
        int wordLen = word.length();
        int rows = alphabetSoup.length;
        char[] column = new char[rows];
        for (int i = 0; i < rows; i++) {
            column[i] = alphabetSoup[i][col];
        }
        for (int i = 0; i <= rows - wordLen; i++) {
            if (word.equals(new String(column, i, wordLen)) || word.equals(new String(reverseArray(column), i, wordLen))) {
                return true;
            }
        }
        return false;
    }

    private char[] reverseArray(char[] array) {
        char[] reversedArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }
}
