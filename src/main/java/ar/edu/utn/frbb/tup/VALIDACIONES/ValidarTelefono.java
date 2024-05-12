package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.util.Scanner;

public class ValidarTelefono {

    public static long ingresarTelefono(Scanner scanner) {
        long telefono;
        do {
            String telefonoStr = scanner.nextLine();
            // Quitamos todos los caracteres no numéricos del número ingresado
            String numeroLimpio = telefonoStr.replaceAll("[^0-9]", "");
            // Verificamos si el número limpio tiene 9 o 10 dígitos (por ejemplo)
            if (numeroLimpio.length() == 9 || numeroLimpio.length() == 10) {
                try {
                    telefono = Long.parseLong(numeroLimpio);
                    return telefono; // Retornamos el número si es válido
                } catch (NumberFormatException e) {
                    System.out.println("Número telefónico inválido. Inténtelo nuevamente.");
                }
            } else {
                System.out.println("Formato invalido. Por favor, intentelo nuevamente: ");
            }
        } while (true);
    }
}

