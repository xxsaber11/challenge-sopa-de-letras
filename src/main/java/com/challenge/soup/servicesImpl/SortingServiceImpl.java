package com.challenge.soup.servicesImpl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.challenge.soup.models.jugadores.JugadorModel;
import com.challenge.soup.utils.enums.TipoErroresEnum;

public class SortingServiceImpl {

    public static List<JugadorModel>  ordenarPorPuntuacionYNombre(List<JugadorModel> jugadores) {
        Map<String, Object> resultado = new HashMap<>();
        try {
            // Ordenar por puntuación de manera descendente
            jugadores.sort(Comparator.comparingInt(JugadorModel::getPuntuacion).reversed()
                    // Luego, si las puntuaciones son iguales, ordenar por nombre de manera ascendente
                    .thenComparing(Comparator.comparing(JugadorModel::getNombre)));

            resultado.put("response", jugadores);
            resultado.put("codError", 200);
        } catch (Exception e) {
            resultado.put("response", TipoErroresEnum.ERROR_ORDENAMIENTO.getMensaje());
            resultado.put("codError", TipoErroresEnum.ERROR_ORDENAMIENTO.getCodigo());
            //return resultado;
        }

        return jugadores;
    }

    public static List<JugadorModel> ordenarPorPuntuacionPerdidasYNombre(List<JugadorModel> jugadores) {
        Map<String, Object> resultado = new HashMap<>();
        try {
            // Ordenar por puntuación de manera descendente, luego por pérdidas de manera ascendente
            jugadores.sort(Comparator.comparingInt(JugadorModel::getPuntuacion).reversed()
                    .thenComparing(Comparator.comparingInt(JugadorModel::getPerdidas))
                    // Finalmente, si las puntuaciones y pérdidas son iguales, ordenar por nombre de manera ascendente
                    .thenComparing(Comparator.comparing(JugadorModel::getNombre)));

            resultado.put("response", jugadores);
            resultado.put("codError", 200);
        } catch (Exception e) {
            resultado.put("response", TipoErroresEnum.ERROR_ORDENAMIENTO.getMensaje());
            resultado.put("codError", TipoErroresEnum.ERROR_ORDENAMIENTO.getCodigo());
            //return resultado;
        }

        return jugadores;
    }
}
