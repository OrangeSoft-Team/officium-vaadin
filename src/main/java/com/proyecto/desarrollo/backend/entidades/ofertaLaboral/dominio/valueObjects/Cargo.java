package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects;

public class Cargo {

    private String cargo;

    public Cargo(String cargo) {
        if (esValido(cargo))
            this.cargo = cargo;
        else this.cargo = "Cargo Invalido";
    }

    public boolean esValido(String cargo){
        if (cargo.length() > 4 && cargo.length() <= 40)
            return true;
        else return false;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}
