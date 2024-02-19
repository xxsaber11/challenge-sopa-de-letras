package com.challenge.soup.sorting;

import org.junit.Test;

import com.challenge.soup.models.JugadorModel;

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
        List<JugadorModel> JugadorModeles = new ArrayList<JugadorModel>();
        JugadorModeles.add(p1);
        JugadorModeles.add(p2);
        JugadorModeles.add(p3);
        JugadorModeles.add(p4);
        JugadorModeles.add(p5);

        List<JugadorModel> JugadorModelesResult = Sorting.ordenarPorPuntuacionYNombre(JugadorModeles);

        JugadorModel p1Sort = new JugadorModel("Pablo", 150);
        JugadorModel p2Sort = new JugadorModel("Alejandro", 100);
        JugadorModel p3Sort = new JugadorModel("Matias", 100);
        JugadorModel p4Sort = new JugadorModel("Junior", 75);
        JugadorModel p5Sort = new JugadorModel("Enzo", 50);
        List<JugadorModel> JugadorModelesSort = new ArrayList<JugadorModel>();
        JugadorModelesSort.add(p1Sort);
        JugadorModelesSort.add(p2Sort);
        JugadorModelesSort.add(p3Sort);
        JugadorModelesSort.add(p4Sort);
        JugadorModelesSort.add(p5Sort);


        assertEquals(JugadorModelesSort.size(), JugadorModelesResult.size());
        assertEquals(JugadorModelesSort.get(0).getNombre(), JugadorModelesResult.get(0).getNombre());
        assertEquals(JugadorModelesSort.get(1).getNombre(), JugadorModelesResult.get(1).getNombre());
        assertEquals(JugadorModelesSort.get(2).getNombre(), JugadorModelesResult.get(2).getNombre());
        assertEquals(JugadorModelesSort.get(3).getNombre(), JugadorModelesResult.get(3).getNombre());
        assertEquals(JugadorModelesSort.get(4).getNombre(), JugadorModelesResult.get(4).getNombre());

        JugadorModeles = new ArrayList<JugadorModel>();
        JugadorModelesResult = Sorting.ordenarPorPuntuacionYNombre(JugadorModeles);
        assertTrue(JugadorModelesResult.isEmpty());

        JugadorModeles = new ArrayList<JugadorModel>();
        JugadorModeles.add(p1);
        JugadorModelesResult = Sorting.ordenarPorPuntuacionYNombre(JugadorModeles);
        assertEquals(1, JugadorModelesResult.size());
        assertEquals(p1.getNombre(), JugadorModelesResult.get(0).getNombre());
    }

    @Test
    public void sort1Vacio() {
        List<JugadorModel> JugadorModeles = new ArrayList<JugadorModel>();
        List<JugadorModel> JugadorModelesResult = Sorting.ordenarPorPuntuacionYNombre(JugadorModeles);
        assertTrue(JugadorModelesResult.isEmpty());
    }

    @Test
    public void sort1Unico() {
        JugadorModel p1 = new JugadorModel("Matias", 100);
        List<JugadorModel> JugadorModeles = new ArrayList<JugadorModel>();
        JugadorModeles.add(p1);
        List<JugadorModel> JugadorModelesResult = Sorting.ordenarPorPuntuacionYNombre(JugadorModeles);
        assertEquals(1, JugadorModelesResult.size());
        assertEquals(p1.getNombre(), JugadorModelesResult.get(0).getNombre());
    }

    @Test
    public void sort2Completo() {

        JugadorModel p1 = new JugadorModel("Matias", 100, 3);
        JugadorModel p2 = new JugadorModel("Alejandro", 100, 4);
        JugadorModel p3 = new JugadorModel("Enzo", 75, 5);
        JugadorModel p4 = new JugadorModel("Junior", 75, 30);
        JugadorModel p5 = new JugadorModel("Pablo", 150, 0);
        List<JugadorModel> JugadorModeles = new ArrayList<JugadorModel>();
        JugadorModeles.add(p1);
        JugadorModeles.add(p2);
        JugadorModeles.add(p3);
        JugadorModeles.add(p4);
        JugadorModeles.add(p5);

        List<JugadorModel> JugadorModelesResult = Sorting.ordenarPorPuntuacionPerdidasYNombre(JugadorModeles);

        JugadorModel p1Sort = new JugadorModel("Pablo", 150, 0);
        JugadorModel p2Sort = new JugadorModel("Matias", 100, 3);
        JugadorModel p3Sort = new JugadorModel("Alejandro", 100, 4);
        JugadorModel p4Sort = new JugadorModel("Enzo", 75, 5);
        JugadorModel p5Sort = new JugadorModel("Junior", 75, 30);

        List<JugadorModel> JugadorModelesSort = new ArrayList<JugadorModel>();
        JugadorModelesSort.add(p1Sort);
        JugadorModelesSort.add(p2Sort);
        JugadorModelesSort.add(p3Sort);
        JugadorModelesSort.add(p4Sort);
        JugadorModelesSort.add(p5Sort);


        assertEquals(JugadorModelesSort.size(), JugadorModelesResult.size());
        assertEquals(JugadorModelesSort.get(0).getNombre(), JugadorModelesResult.get(0).getNombre());
        assertEquals(JugadorModelesSort.get(1).getNombre(), JugadorModelesResult.get(1).getNombre());
        assertEquals(JugadorModelesSort.get(2).getNombre(), JugadorModelesResult.get(2).getNombre());
        assertEquals(JugadorModelesSort.get(3).getNombre(), JugadorModelesResult.get(3).getNombre());
        assertEquals(JugadorModelesSort.get(4).getNombre(), JugadorModelesResult.get(4).getNombre());
    }

    @Test
    public void sort2Vacio() {
        List<JugadorModel> JugadorModeles = new ArrayList<JugadorModel>();
        List<JugadorModel> JugadorModelesResult = Sorting.ordenarPorPuntuacionPerdidasYNombre(JugadorModeles);
        assertTrue(JugadorModelesResult.isEmpty());
    }

    @Test
    public void sort2Unico() {
        JugadorModel p1 = new JugadorModel("Matias", 100);
        List<JugadorModel> JugadorModeles = new ArrayList<JugadorModel>();
        JugadorModeles.add(p1);
        List<JugadorModel> JugadorModelesResult = Sorting.ordenarPorPuntuacionPerdidasYNombre(JugadorModeles);
        assertEquals(1, JugadorModelesResult.size());
        assertEquals(p1.getNombre(), JugadorModelesResult.get(0).getNombre());
    }


}
