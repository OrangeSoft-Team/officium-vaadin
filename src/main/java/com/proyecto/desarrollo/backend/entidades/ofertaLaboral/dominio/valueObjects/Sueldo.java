package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sueldo {
    private float sueldo;

    public Sueldo(float sueldo){
        if (esValido(sueldo))
            this.sueldo = dosDecimales(sueldo);
        else this.sueldo = -1;
    }

    public boolean esValido(float sueldo){
        if (sueldo > 0 && sueldo <= 1000000)
            return true;
        return false;
    }

    public static float dosDecimales(float numero){
        BigDecimal bigDecimal = new BigDecimal(Float.toString(numero));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }

    public float getSueldo() {
        return sueldo;
    }
}
