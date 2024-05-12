package ar.edu.utn.frbb.tup.VALIDACIONES;

import java.util.Scanner;

public class ValidarString {
    public static String ingresarNombre(Scanner scanner) {
        String nombre;
        do {
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("Formato inválido. Por favor, inténtelo nuevamente: ");
            }else if(!nombre.matches("[a-zA-Z]+")) {
                System.out.println("Formato inválido. Por favor, inténtelo nuevamente: ");
            } 
        } while (nombre.isEmpty() || !nombre.matches("[a-zA-Z]+"));
        nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        return nombre;
    }
}