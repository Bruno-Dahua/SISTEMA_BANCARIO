package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.util.Scanner;

import ar.edu.utn.frbb.tup.MODELOS.TipoCuenta;

public class ValidarTipoCuenta {

    public static TipoCuenta validarTipoCuenta(Scanner scanner){

        String tipoCuentaStr = scanner.nextLine().toUpperCase();

        while (!tipoCuentaStr.equals("CA") && !tipoCuentaStr.equals("CC")) {
            System.out.println("Tipo de cuenta invalio. Por favor, intentelo nuevamente: ");
            tipoCuentaStr=scanner.nextLine().toUpperCase();
        }
        
        TipoCuenta tipoCuenta = TipoCuenta.fromString(tipoCuentaStr);
        return tipoCuenta;
    }
}
