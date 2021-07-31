package com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada;

import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.UUID;

public class UsuarioAutenticadoFirebaseEntradaDTO {
    private String uuid;

    public UsuarioAutenticadoFirebaseEntradaDTO(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
