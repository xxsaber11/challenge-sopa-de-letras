package com.challenge.soup.sorting;

import org.junit.Test;
import com.challenge.soup.models.jugadores.JugadorModel;
import com.challenge.soup.servicesImpl.SortingServiceImpl;

import java.util.ArrayList;
import java.util.List;

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
        List<JugadorModel> jugadores = new ArrayList<JugadorModel>();
        jugadores.add(p1);
        jugadores.add(p2);
        jugadores.add(p3);
        jugadores.add(p4);
        jugadores.add(p5);

        List<JugadorModel> jugadoresResult = SortingServiceImpl.ordenarPorPuntuacionYNombre(jugadores);

        JugadorModel p1Sort = new JugadorModel("Pablo", 150);
        JugadorModel p2Sort = new JugadorModel("Alejandro", 100);
        JugadorModel p3Sort = new JugadorModel("Matias", 100);
        JugadorModel p4Sort = new JugadorModel("Junior", 75);
        JugadorModel p5Sort = new JugadorModel("Enzo", 50);
        List<JugadorModel> jugadoresSort = new ArrayList<JugadorModel>();
        jugadoresSort.add(p1Sort);
        jugadoresSort.add(p2Sort);
        jugadoresSort.add(p3Sort);
        jugadoresSort.add(p4Sort);
        jugadoresSort.add(p5Sort);


        assertEquals(jugadoresSort.size(), jugadoresResult.size());
        assertEquals(jugadoresSort.get(0).getNombre(), jugadoresResult.get(0).getNombre());
        assertEquals(jugadoresSort.get(1).getNombre(), jugadoresResult.get(1).getNombre());
        assertEquals(jugadoresSort.get(2).getNombre(), jugadoresResult.get(2).getNombre());
        assertEquals(jugadoresSort.get(3).getNombre(), jugadoresResult.get(3).getNombre());
        assertEquals(jugadoresSort.get(4).getNombre(), jugadoresResult.get(4).getNombre());

        jugadores = new ArrayList<JugadorModel>();
        jugadoresResult = SortingServiceImpl.ordenarPorPuntuacionYNombre(jugadores);
        assertTrue(jugadoresResult.isEmpty());

        jugadores = new ArrayList<JugadorModel>();
        jugadores.add(p1);
        jugadoresResult = SortingServiceImpl.ordenarPorPuntuacionYNombre(jugadores);
        assertEquals(1, jugadoresResult.size());
        assertEquals(p1.getNombre(), jugadoresResult.get(0).getNombre());
    }

    @Test
    public void sort1Vacio() {
        List<JugadorModel> jugadores = new ArrayList<JugadorModel>();
        List<JugadorModel> jugadoresResult = SortingServiceImpl.ordenarPorPuntuacionYNombre(jugadores);
        assertTrue(jugadoresResult.isEmpty());
    }

    @Test
    public void sort1Unico() {
        JugadorModel p1 = new JugadorModel("Matias", 100);
        List<JugadorModel> jugadores = new ArrayList<JugadorModel>();
        jugadores.add(p1);
        List<JugadorModel> jugadoresResult = SortingServiceImpl.ordenarPorPuntuacionYNombre(jugadores);
        assertEquals(1, jugadoresResult.size());
        assertEquals(p1.getNombre(), jugadoresResult.get(0).getNombre());
    }

    @Test
    public void sort2Completo() {

        JugadorModel p1 = new JugadorModel("Matias", 100, 3);
        JugadorModel p2 = new JugadorModel("Alejandro", 100, 4);
        JugadorModel p3 = new JugadorModel("Enzo", 75, 5);
        JugadorModel p4 = new JugadorModel("Junior", 75, 30);
        JugadorModel p5 = new JugadorModel("Pablo", 150, 0);
        List<JugadorModel> jugadores = new ArrayList<JugadorModel>();
        jugadores.add(p1);
        jugadores.add(p2);
        jugadores.add(p3);
        jugadores.add(p4);
        jugadores.add(p5);

        List<JugadorModel> jugadoresResult = SortingServiceImpl.ordenarPorPuntuacionPerdidasYNombre(jugadores);

        JugadorModel p1Sort = new JugadorModel("Pablo", 150, 0);
        JugadorModel p2Sort = new JugadorModel("Matias", 100, 3);
        JugadorModel p3Sort = new JugadorModel("Alejandro", 100, 4);
        JugadorModel p4Sort = new JugadorModel("Enzo", 75, 5);
        JugadorModel p5Sort = new JugadorModel("Junior", 75, 30);

        List<JugadorModel> jugadoresSort = new ArrayList<JugadorModel>();
        jugadoresSort.add(p1Sort);
        jugadoresSort.add(p2Sort);
        jugadoresSort.add(p3Sort);
        jugadoresSort.add(p4Sort);
        jugadoresSort.add(p5Sort);


        assertEquals(jugadoresSort.size(), jugadoresResult.size());
        assertEquals(jugadoresSort.get(0).getNombre(), jugadoresResult.get(0).getNombre());
        assertEquals(jugadoresSort.get(1).getNombre(), jugadoresResult.get(1).getNombre());
        assertEquals(jugadoresSort.get(2).getNombre(), jugadoresResult.get(2).getNombre());
        assertEquals(jugadoresSort.get(3).getNombre(), jugadoresResult.get(3).getNombre());
        assertEquals(jugadoresSort.get(4).getNombre(), jugadoresResult.get(4).getNombre());
    }

    @Test
    public void sort2Vacio() {
        List<JugadorModel> jugadores = new ArrayList<JugadorModel>();
        List<JugadorModel> jugadoresResult = SortingServiceImpl.ordenarPorPuntuacionPerdidasYNombre(jugadores);
        assertTrue(jugadoresResult.isEmpty());
    }

    @Test
    public void sort2Unico() {
        JugadorModel p1 = new JugadorModel("Matias", 100);
        List<JugadorModel> jugadores = new ArrayList<JugadorModel>();
        jugadores.add(p1);
        List<JugadorModel> jugadoresResult = SortingServiceImpl.ordenarPorPuntuacionPerdidasYNombre(jugadores);
        assertEquals(1, jugadoresResult.size());
        assertEquals(p1.getNombre(), jugadoresResult.get(0).getNombre());
    }


}
