package ar.edu.utn.frbb.tup;

import java.util.*;

import ar.edu.utn.frbb.tup.CASOS.ClientesCaso;
import ar.edu.utn.frbb.tup.CASOS.CuentasCaso;
import ar.edu.utn.frbb.tup.CASOS.MovimientosCaso;
import ar.edu.utn.frbb.tup.CASOS.OperacionesCaso;
import ar.edu.utn.frbb.tup.VALIDACIONES.*;


public class MenuInput extends BaseInput{

    public static void mostrarMenu() {

        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean exit=false;

        while (!exit) {

            System.out.println("------ BANCO ------");
            System.out.println("1. Clientes");
            System.out.println("2. Cuentas");
            System.out.println("3. Operaciones");
            System.out.println("4. Movimientos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            opcion = ValidarOpcionNumerica.ingresarOpcion(scanner);

            switch (opcion) {
                case 1:
                    ClientesCaso.caso_clientes(scanner);
                    break;

                case 2:
                    CuentasCaso.caso_cuentas(scanner);
                    break;

                case 3:
                    OperacionesCaso.operacionesCaso(scanner);
                    break;

                case 4:
                    MovimientosCaso.mostrarMovimientos(scanner);
                    break;

                case 5: 
                    exit=true;
                    break;

                default:
                    System.out.println("Opcion invalida. Por favor, intentelo nuevamente: ");
                    break;
            } 
        }

        scanner.close(); // Cierro el scanner al finalizar
    }
}




