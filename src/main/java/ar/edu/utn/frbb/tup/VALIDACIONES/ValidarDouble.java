package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.util.Scanner;

public class ValidarDouble {

    public static double validarDouble(Scanner scanner){

        double valor = 0.0;
        boolean valido = false;
        
        do {
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                valido = true;
            } else {
                System.out.println("Formato inválido. Por favor, intentelo nuevamente: ");
                scanner.next(); // Limpiar el buffer de entrada
            }
        } while (!valido);
        return valor;
    }
}
