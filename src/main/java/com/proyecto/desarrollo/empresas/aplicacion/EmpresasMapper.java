package com.proyecto.desarrollo.empresas.aplicacion;

import com.proyecto.desarrollo.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacionDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EmpresasMapper {

    private int cont;
    private ConsultarEmpresasParaCreacionDTO[] empresasCreacion;

    /*Metodo utilizado para Parsear un Json y obtener un array de ofertasLaboralesGridVaadin*/
    public ConsultarEmpresasParaCreacionDTO[] jsonToEmpresasCreacion(String contenido) throws ParseException {
        cont = 0;
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(contenido);
        JSONArray empresas = (JSONArray) obj;
        empresasCreacion = new ConsultarEmpresasParaCreacionDTO[empresas.size()];
        empresas.forEach(empre -> parsearEmpresas((JSONObject) empre));
        return this.empresasCreacion;
    }

    private void parsearEmpresas(JSONObject empre) {
        this.empresasCreacion[cont] = new ConsultarEmpresasParaCreacionDTO((String) empre.get("uuidEmpresa"),(String) empre.get("nombreEmpresa"));
        this.cont++;
    }
}
