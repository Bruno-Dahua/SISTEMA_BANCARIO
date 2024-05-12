package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.util.Scanner;

import ar.edu.utn.frbb.tup.MODELOS.TipoRespuesta;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarTipoRespuesta;

public class ValidarTipoRespuesta {

    public static TipoRespuesta validarTipoRespuesta(Scanner scanner){

        String tipoRespuestaStr = scanner.nextLine().toUpperCase();

        while (!tipoRespuestaStr.equals("S") && !tipoRespuestaStr.equals("N")) {
            System.out.println("Tipo de respuesta invalio. Por favor, intentelo nuevamente: ");
            tipoRespuestaStr=scanner.nextLine().toUpperCase();
        }
        
        TipoRespuesta tipoRespuesta = TipoRespuesta.fromString(tipoRespuestaStr);
        return tipoRespuesta;
    }
}
