package com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects;

public class Cargo {

    private String cargo;

    public Cargo(String cargo) {
        if (esValido(cargo))
            this.cargo = cargo;
        else this.cargo = "invalido";
    }

    public boolean esValido(String cargo){
        if (cargo.length() > 4 && cargo.length() <= 40)
            return true;
        else return false;
    }

    public String getCargo() {
        return cargo;
    }
}
