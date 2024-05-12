package ar.edu.utn.frbb.tup.CASOS;

import java.util.Scanner;

import ar.edu.utn.frbb.tup.MenuInput;
import ar.edu.utn.frbb.tup.OPERACIONES.Deposito;
import ar.edu.utn.frbb.tup.OPERACIONES.Retiro;
import ar.edu.utn.frbb.tup.OPERACIONES.Saldo;
import ar.edu.utn.frbb.tup.OPERACIONES.Transferencia;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarOpcionNumerica;

public class OperacionesCaso extends MenuInput{
    
    public static void operacionesCaso(Scanner scanner){
        boolean exit_operaciones=false;
        int opcion_operaciones;
        while (exit_operaciones == false) {
            clearScreen();
            System.out.println("------ OPERACIONES ------");
            System.out.println("1. Retirar");
            System.out.println("2. Depositar");
            System.out.println("3. Transferir");
            System.out.println("4. Saldo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            opcion_operaciones=ValidarOpcionNumerica.ingresarOpcion(scanner);

            switch (opcion_operaciones) {
                case 1:
                    Retiro.retirar(scanner);
                    break;
                case 2:
                    Deposito.depositar(scanner);
                    break;
                case 3:
                    Transferencia.transferir(scanner);
                    break;
                case 4:
                    Saldo.consultarSaldo(scanner);
                    break;
                case 5: 
                    exit_operaciones=true;
                    break;
                default:
                    System.out.println("Opcion incorrecta. Por favor, intentelo nuevamente: ");
                    break;
            }
        }
        clearScreen();
    }
}

