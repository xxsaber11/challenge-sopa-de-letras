package com.challenge.soup.servicesImpl;

import com.challenge.soup.servicesImpl.services.WordSearcherService;

public class WordSearcherServiceImpl implements WordSearcherService {

    private final char[][] alphabetSoup;

    public WordSearcherServiceImpl(char[][] alphabetSoup) {
        this.alphabetSoup = alphabetSoup;
    }

    @Override
    public boolean isPresent(final String palabra) {
        int filas = alphabetSoup.length;
        int columnas = alphabetSoup[0].length;
        int longitud = palabra.length();
        char primero = palabra.charAt(0);

        boolean[][] usado = new boolean[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (alphabetSoup[i][j] == primero) {
                    usado[i][j] = true;
                    if (estaPresenteDesde(palabra, i, j, 1, usado)) {
                        return true;
                    }
                    usado[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean estaPresenteDesde(String palabra, int fila, int columna, int indice, boolean[][] usado) {
        if (indice == palabra.length()) {
            return true;
        }

        char letra = palabra.charAt(indice);

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int nuevaFila = fila + dx[k];
            int nuevaColumna = columna + dy[k];

            if (esValido(nuevaFila, nuevaColumna, usado) && alphabetSoup[nuevaFila][nuevaColumna] == letra) {
                usado[nuevaFila][nuevaColumna] = true;
                if (estaPresenteDesde(palabra, nuevaFila, nuevaColumna, indice + 1, usado)) {
                    return true;
                }
                usado[nuevaFila][nuevaColumna] = false;
            }
        }

        return false;
    }

    private boolean esValido(int fila, int columna, boolean[][] usado) {
        return fila >= 0 && fila < usado.length && columna >= 0 && columna < usado[0].length && !usado[fila][columna];
    }
}