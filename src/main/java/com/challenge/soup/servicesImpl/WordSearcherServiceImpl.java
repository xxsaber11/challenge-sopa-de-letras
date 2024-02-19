package com.challenge.soup.servicesImpl;

import com.challenge.soup.servicesImpl.services.WordSearcherService;

public class WordSearcherServiceImpl implements WordSearcherService {

    private final char[][] alphabetSoup;

    public WordSearcherServiceImpl(char[][] alphabetSoup) {
        this.alphabetSoup = alphabetSoup;
    }

    @Override
    public boolean isPresent(final String word) {
        int rows = alphabetSoup.length;
        int cols = alphabetSoup[0].length;
        int len = word.length();

        // Búsqueda horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - len + 1; j++) {
                if (isPresentHorizontal(word, i, j) || isPresentHorizontalBackwards(word, i, j + len - 1)) {
                    return true;
                }
            }
        }

        // Búsqueda vertical
        for (int i = 0; i < rows - len + 1; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPresentVertical(word, i, j) || isPresentVerticalBackwards(word, i + len - 1, j)) {
                    return true;
                }
            }
        }

        // Búsqueda parcial
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPresentPartial(word, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isPresentHorizontal(String word, int row, int col) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (alphabetSoup[row][col + i] != word.charAt(i))
                return false;
        }
        return true;
    }

    private boolean isPresentHorizontalBackwards(String word, int row, int col) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (col - i < 0 || alphabetSoup[row][col - i] != word.charAt(i))
                return false;
        }
        return true;
    }

    private boolean isPresentVertical(String word, int row, int col) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (row + i >= alphabetSoup.length || alphabetSoup[row + i][col] != word.charAt(i))
                return false;
        }
        return true;
    }

    private boolean isPresentVerticalBackwards(String word, int row, int col) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (row - i < 0 || alphabetSoup[row - i][col] != word.charAt(i))
                return false;
        }
        return true;
    }

    private boolean isPresentPartial(String word, int row, int col) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (alphabetSoup[row][col] == word.charAt(i)) {
                // Buscar el resto de la palabra en las cuatro direcciones
                if (isPresentHorizontal(word.substring(i + 1), row, col + 1) ||
                    isPresentHorizontalBackwards(word.substring(0, i), row, col - 1) ||
                    isPresentVertical(word.substring(i + 1), row + 1, col) ||
                    isPresentVerticalBackwards(word.substring(0, i), row - 1, col)) {
                    return true;
                }
            }
        }
        return false;
    }
}
