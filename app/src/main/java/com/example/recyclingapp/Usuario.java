package com.example.recyclingapp;

public class Usuario {

    String email;
    int puntos;


    public Usuario(String email, int puntos) {
        this.email = email;
        this.puntos= puntos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getEmail() {
        return email;
    }

    public int getPuntos() {
        return puntos;
    }
}
