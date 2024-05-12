package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidarFecha {

    public static LocalDate ingresarFecha(Scanner scanner) {
        LocalDate fechaNacimiento;
        do {
            String fechaStr = scanner.nextLine();
            try {
                fechaNacimiento = LocalDate.parse(fechaStr);
                return fechaNacimiento; // Retorna la fecha si es válida
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, inténtelo nuevamente: ");
            }
        } while (true);
    }
}
