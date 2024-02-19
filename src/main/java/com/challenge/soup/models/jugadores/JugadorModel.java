package com.challenge.soup.models.jugadores;

import java.util.UUID;

public class JugadorModel {
    private String id;
    private String nombre;
    private int puntuacion;
    private int perdidas;

    public JugadorModel(String nombre, int puntuacion) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public JugadorModel(String nombre, int puntuacion, int perdidas) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.perdidas = perdidas;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }
}