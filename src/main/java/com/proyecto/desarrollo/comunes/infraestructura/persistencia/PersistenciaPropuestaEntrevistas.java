package com.proyecto.desarrollo.comunes.infraestructura.persistencia;

public interface PersistenciaPropuestaEntrevistas {

    public String consultaPropuestaEntrevista(String uuidSolicitud);

    public Boolean proponerEntrevista(String uuid);

    public boolean cancelarEntrevista(String uuid);
}
