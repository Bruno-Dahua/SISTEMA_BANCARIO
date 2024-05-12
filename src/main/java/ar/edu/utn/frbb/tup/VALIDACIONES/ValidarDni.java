package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.util.Scanner;

public class ValidarDni {

    public static long ingresarDNI(Scanner scanner) {

        long dni;
        
        do {
            if (scanner.hasNextLong()) {
                dni = scanner.nextLong();
                scanner.nextLine(); // Consumir el salto de línea después de nextLong()
                if (String.valueOf(dni).length() == 8) {
                    return dni; // Retorna el DNI si tiene exactamente 8 dígitos
                } else {
                    System.out.println("Formato de DNI inválido. Por favor, inténtelo nuevamente: ");
                }
            } else {
                System.out.println("Formato de DNI inválido. Por favor, inténtelo nuevamente: ");
                scanner.nextLine(); // Consumir la entrada inválida
            }
        } while (true);
    }
}
