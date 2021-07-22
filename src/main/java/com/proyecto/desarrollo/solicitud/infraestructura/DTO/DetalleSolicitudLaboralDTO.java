package com.proyecto.desarrollo.solicitud.infraestructura.DTO;

public class DetalleSolicitudLaboralDTO {

    private String uuid;

    private String uuidOfertaLaboral;

    private String tituloOferta;

    private String cargoOferta;

    private String estatus;

    private String uuidEmpresa;

    private String nombreEmpresa;

    private String uuidEmpleado;

    private String nombreEmpleado;

    private String comentario;


    public DetalleSolicitudLaboralDTO(String uuid, String uuidOfertaLaboral, String tituloOferta, String cargoOferta, String estatus, String uuidEmpresa, String nombreEmpresa, String uuidEmpleado, String nombreEmpleado, String comentario) {
        this.uuid = uuid;
        this.uuidOfertaLaboral = uuidOfertaLaboral;
        this.tituloOferta = tituloOferta;
        this.cargoOferta = cargoOferta;
        this.estatus = estatus;
        this.uuidEmpresa = uuidEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.uuidEmpleado = uuidEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.comentario = comentario;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUuidOfertaLaboral() {
        return uuidOfertaLaboral;
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

    public String getUuidEmpresa() {
        return uuidEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getUuidEmpleado() {
        return uuidEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getComentario() {
        return comentario;
    }
}
