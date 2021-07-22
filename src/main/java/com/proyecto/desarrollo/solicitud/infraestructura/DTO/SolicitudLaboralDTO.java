package com.proyecto.desarrollo.solicitud.infraestructura.DTO;

public class SolicitudLaboralDTO {

    private String uuid;
    private String tituloOferta;
    private String cargoOferta;
    private String estatus;
    private String nombreEmpresa;
    private String nombreEmpleado;

    public SolicitudLaboralDTO(String uuid, String tituloOferta, String cargoOferta, String estatus, String nombreEmpresa, String nombreEmpleado) {
        this.uuid = uuid;
        this.tituloOferta = tituloOferta;
        this.cargoOferta = cargoOferta;
        this.estatus = estatus;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTituloOferta() {
        return tituloOferta;
    }

    public String getCargoOferta() {
        return cargoOferta;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
