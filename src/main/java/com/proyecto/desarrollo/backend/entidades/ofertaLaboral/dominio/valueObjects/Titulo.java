package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects;

public class Titulo {

    private String titulo;

    public Titulo(String titulo){
        if (esValido(titulo)){
            this.titulo = titulo;
        }
        else this.titulo = "Titulo Invalido";
    }

    /*Funcion que verifica la validez del titulo (mayor o igual a 4 caracteres y menor o igual a 80)*/
    public boolean esValido(String titulo){
        if (titulo.length() >= 4 && titulo.length() <= 80 )
            return true;
        return false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
