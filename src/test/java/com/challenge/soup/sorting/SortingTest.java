package com.challenge.soup.sorting;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.soup.models.jugadores.JugadorModel;
import com.challenge.soup.servicesImpl.SortingServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortingTest {

    @Test
    public void sort1Completo() {
        JugadorModel p1 = new JugadorModel("Matias", 100);
        JugadorModel p2 = new JugadorModel("Alejandro", 100);
        JugadorModel p3 = new JugadorModel("Enzo", 50);
        JugadorModel p4 = new JugadorModel("Junior", 75);
        JugadorModel p5 = new JugadorModel("Pablo", 150);
        List<JugadorModel> Jugadores = new ArrayList<JugadorModel>();
        Jugadores.add(p1);
        Jugadores.add(p2);
        Jugadores.add(p3);
        Jugadores.add(p4);
        Jugadores.add(p5);

        Map<String, Object> resultado = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        resultado = SortingServiceImpl.ordenarPorPuntuacionYNombre(Jugadores);
        List<JugadorModel> JugadoresResult = objectMapper.convertValue(resultado.get("response"), new TypeReference<List<JugadorModel>>() {});


        JugadorModel p1Sort = new JugadorModel("Pablo", 150);
        JugadorModel p2Sort = new JugadorModel("Alejandro", 100);
        JugadorModel p3Sort = new JugadorModel("Matias", 100);
        JugadorModel p4Sort = new JugadorModel("Junior", 75);
        JugadorModel p5Sort = new JugadorModel("Enzo", 50);
        List<JugadorModel> JugadoresSort = new ArrayList<JugadorModel>();
        JugadoresSort.add(p1Sort);
        JugadoresSort.add(p2Sort);
        JugadoresSort.add(p3Sort);
        JugadoresSort.add(p4Sort);
        JugadoresSort.add(p5Sort);


        assertEquals(JugadoresSort.size(), JugadoresResult.size());
        assertEquals(JugadoresSort.get(0).getNombre(), JugadoresResult.get(0).getNombre());
        assertEquals(JugadoresSort.get(1).getNombre(), JugadoresResult.get(1).getNombre());
        assertEquals(JugadoresSort.get(2).getNombre(), JugadoresResult.get(2).getNombre());
        assertEquals(JugadoresSort.get(3).getNombre(), JugadoresResult.get(3).getNombre());
        assertEquals(JugadoresSort.get(4).getNombre(), JugadoresResult.get(4).getNombre());

        Jugadores = new ArrayList<JugadorModel>();
        Map<String, Object> resultado2 = new HashMap<>();
        resultado2 = SortingServiceImpl.ordenarPorPuntuacionYNombre(Jugadores);
        JugadoresResult = objectMapper.convertValue(resultado2.get("response"), new TypeReference<List<JugadorModel>>() {});
        assertTrue(JugadoresResult.isEmpty());

        Jugadores = new ArrayList<JugadorModel>();
        Jugadores.add(p1);

        Map<String, Object> resultado3 = new HashMap<>();
        resultado3 = SortingServiceImpl.ordenarPorPuntuacionYNombre(Jugadores);
        JugadoresResult = objectMapper.convertValue(resultado3.get("response"), new TypeReference<List<JugadorModel>>() {});

        assertEquals(1, JugadoresResult.size());
        assertEquals(p1.getNombre(), JugadoresResult.get(0).getNombre());
    }

    @Test
    public void sort1Vacio() {
       List<JugadorModel> jugadores = new ArrayList<>();
       Map<String, Object> resultado = SortingServiceImpl.ordenarPorPuntuacionYNombre(jugadores);
       ObjectMapper objectMapper = new ObjectMapper();
       List<JugadorModel> jugadoresResult = objectMapper.convertValue(resultado.get("response"),
               new TypeReference<List<JugadorModel>>() {});

       assertTrue(jugadoresResult.isEmpty());
    }

    @Test
    public void sort1Unico() {
        JugadorModel p1 = new JugadorModel("Matias", 100);
        List<JugadorModel> Jugadores = new ArrayList<JugadorModel>();
        Jugadores.add(p1);        
        
        Map<String, Object> resultado = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        resultado = SortingServiceImpl.ordenarPorPuntuacionYNombre(Jugadores);
        List<JugadorModel> JugadoresResult = objectMapper.convertValue(resultado.get("response"), new TypeReference<List<JugadorModel>>() {});

        assertEquals(1, JugadoresResult.size());
        assertEquals(p1.getNombre(), JugadoresResult.get(0).getNombre());
    }

    @Test
    public void sort2Completo() {

        JugadorModel p1 = new JugadorModel("Matias", 100, 3);
        JugadorModel p2 = new JugadorModel("Alejandro", 100, 4);
        JugadorModel p3 = new JugadorModel("Enzo", 75, 5);
        JugadorModel p4 = new JugadorModel("Junior", 75, 30);
        JugadorModel p5 = new JugadorModel("Pablo", 150, 0);
        List<JugadorModel> Jugadores = new ArrayList<JugadorModel>();
        Jugadores.add(p1);
        Jugadores.add(p2);
        Jugadores.add(p3);
        Jugadores.add(p4);
        Jugadores.add(p5);
        Map<String, Object> resultado = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        resultado = SortingServiceImpl.ordenarPorPuntuacionPerdidasYNombre(Jugadores);
        List<JugadorModel> JugadoresResult = objectMapper.convertValue(resultado.get("response"), new TypeReference<List<JugadorModel>>() {});


        JugadorModel p1Sort = new JugadorModel("Pablo", 150, 0);
        JugadorModel p2Sort = new JugadorModel("Matias", 100, 3);
        JugadorModel p3Sort = new JugadorModel("Alejandro", 100, 4);
        JugadorModel p4Sort = new JugadorModel("Enzo", 75, 5);
        JugadorModel p5Sort = new JugadorModel("Junior", 75, 30);

        List<JugadorModel> JugadoresSort = new ArrayList<JugadorModel>();
        JugadoresSort.add(p1Sort);
        JugadoresSort.add(p2Sort);
        JugadoresSort.add(p3Sort);
        JugadoresSort.add(p4Sort);
        JugadoresSort.add(p5Sort);


        assertEquals(JugadoresSort.size(), JugadoresResult.size());
        assertEquals(JugadoresSort.get(0).getNombre(), JugadoresResult.get(0).getNombre());
        assertEquals(JugadoresSort.get(1).getNombre(), JugadoresResult.get(1).getNombre());
        assertEquals(JugadoresSort.get(2).getNombre(), JugadoresResult.get(2).getNombre());
        assertEquals(JugadoresSort.get(3).getNombre(), JugadoresResult.get(3).getNombre());
        assertEquals(JugadoresSort.get(4).getNombre(), JugadoresResult.get(4).getNombre());
    }

    @Test
    public void sort2Vacio() {
        List<JugadorModel> Jugadores = new ArrayList<JugadorModel>();        
        Map<String, Object> resultado = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        resultado = SortingServiceImpl.ordenarPorPuntuacionPerdidasYNombre(Jugadores);
        List<JugadorModel> JugadoresResult = objectMapper.convertValue(resultado.get("response"), new TypeReference<List<JugadorModel>>() {});

        assertTrue(JugadoresResult.isEmpty());
    }

    @Test
    public void sort2Unico() {
        JugadorModel p1 = new JugadorModel("Matias", 100);
        List<JugadorModel> Jugadores = new ArrayList<JugadorModel>();
        Jugadores.add(p1);
        
        Map<String, Object> resultado = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        resultado = SortingServiceImpl.ordenarPorPuntuacionPerdidasYNombre(Jugadores);
        List<JugadorModel> JugadoresResult = objectMapper.convertValue(resultado.get("response"), new TypeReference<List<JugadorModel>>() {});

        assertEquals(1, JugadoresResult.size());
        assertEquals(p1.getNombre(), JugadoresResult.get(0).getNombre());
    }


}
