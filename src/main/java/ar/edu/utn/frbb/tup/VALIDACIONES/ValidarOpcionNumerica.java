package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.util.Scanner;

public class ValidarOpcionNumerica {
    
    public static int ingresarOpcion(Scanner scanner) {
        int opcion = 0;
        boolean valido = false;
        do {
            if (scanner.hasNextInt()) {
                opcion=scanner.nextInt();
                valido=true;
            }
            else{
                System.out.println("Opcion invalida. Por favor, intentelo nuevamente: ");
                scanner.nextLine();
            }
        } while (!valido);
        return opcion;
    }
}
