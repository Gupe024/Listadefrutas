package com.example.listfrutasapp;

public class Fruta {
    String nombre;
    int imagen;

    public Fruta(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }
}
