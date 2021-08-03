package com.proyecto.desarrollo.empleados.infraestructura.DTO.salida;

public class EmpleadoDetalleSalidaDTO {
    private String uuid;

    public EmpleadoDetalleSalidaDTO(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
