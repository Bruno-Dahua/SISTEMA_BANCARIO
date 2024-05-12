package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.util.Scanner;

public class ValidarId {

    public static int validarEnter(Scanner scanner){

        int valor = 0;
        boolean valido = false;
        
        do {
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                valido = true;
            } else {
                System.out.println("Formato invalido. Por favor, intentelo nuevamente: .");
            }
        } while (!valido);
        return valor;
    }
}
