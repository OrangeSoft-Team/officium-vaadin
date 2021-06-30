package com.proyecto.desarrollo.backend.entidades.empresas.aplicacion;

import com.proyecto.desarrollo.backend.entidades.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacion;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralGridVaadin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EmpresasMapper {

    private int cont;
    private ConsultarEmpresasParaCreacion[] empresasCreacion;

    /*Metodo utilizado para Parsear un Json y obtener un array de ofertasLaboralesGridVaadin*/
    public ConsultarEmpresasParaCreacion[] jsonToEmpresasCreacion(String contenido) throws ParseException {
        cont = 0;
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(contenido);
        JSONArray empresas = (JSONArray) obj;
        empresasCreacion = new ConsultarEmpresasParaCreacion[empresas.size()];
        empresas.forEach(empre -> parsearEmpresas((JSONObject) empre));
        return this.empresasCreacion;
    }

    private void parsearEmpresas(JSONObject empre) {
        this.empresasCreacion[cont] = new ConsultarEmpresasParaCreacion((String) empre.get("UUIDEmpresa"),(String) empre.get("NombreEmpresa"));
        this.cont++;
    }
}
