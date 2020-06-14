package grupo3pf;

import java.time.*;
import entidades.*;
import modelos.*;
import java.util.*;

public class Grupo3PF {

    static enum DiaSemana {LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO};
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
        AfiliadoData ad = new AfiliadoData();
        
        // Crear afiliado
        Afiliado afiliado1 = ad.altaAfiliado(new Afiliado(14623275, "Diego", true));
        Afiliado afiliado2 = ad.altaAfiliado(new Afiliado(39245136, "Diego2", true));
        
        // Obtener afiliado
        System.out.println(ad.obtenerAfiliado(afiliado1.getId()).toString());
        
        // Obtener todos los afiliados
        for (Afiliado a : ad.obtenerAfiliados()){
            System.out.println(a.toString());
        }
        
        // Eliminar afiliado
        ad.bajaAfiliado(afiliado1.getId());
        
        // Modificar afiliado
        ad.actualizarAfiliado(afiliado1.getId(), afiliado2);
        
        // Resultado final:
        for (Afiliado a : ad.obtenerAfiliados()){
            System.out.println(a.toString());
        }
    }
    
}
