package com.challenge.soup.servicesImpl;

public class RepeatedCharactersServiceImpl {

    public Boolean isValid(String cadena) {
        int[] frequency = new int[256];

        cadena.chars().parallel().forEach(c -> frequency[c]++);

        int count = -1;
        boolean valid = true;

        for (int f : frequency) {
            if (f == 0) continue;
            if (count == -1) {
                count = f; // Inicializar el contador con la frecuencia del primer caracter encontrado
            } else if (f != count && (f != count + 1 && f != count - 1)) {
                valid = false;
                break;
            }
        }

        return valid;
    }
}
