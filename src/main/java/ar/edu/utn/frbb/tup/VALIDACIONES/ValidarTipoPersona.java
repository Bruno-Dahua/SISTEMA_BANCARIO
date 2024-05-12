package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.util.Scanner;

import ar.edu.utn.frbb.tup.MODELOS.TipoPersona;

public class ValidarTipoPersona {

    public static TipoPersona validarTipoPersona(Scanner scanner){

        String tipoPersonaStr = scanner.nextLine().toUpperCase();

        while (!tipoPersonaStr.equals("F") && !tipoPersonaStr.equals("J")) {
            System.out.println("Tipo de persona invalio. Por favor, intentelo nuevamente: ");
            tipoPersonaStr=scanner.nextLine().toUpperCase();
        }
        
        TipoPersona tipoPersona = TipoPersona.fromString(tipoPersonaStr);
        return tipoPersona;
    }
}
