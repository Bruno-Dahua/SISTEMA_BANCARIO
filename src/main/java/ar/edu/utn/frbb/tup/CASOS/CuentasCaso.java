package ar.edu.utn.frbb.tup.CASOS;

import java.util.*;

import ar.edu.utn.frbb.tup.MenuInput;
import ar.edu.utn.frbb.tup.ELIMINAR.*;
import ar.edu.utn.frbb.tup.GESTOR.*;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.MODIFICAR.*;
import ar.edu.utn.frbb.tup.MOSTRAR.*;
import ar.edu.utn.frbb.tup.VALIDACIONES.*;
import ar.edu.utn.frbb.tup.INGRESAR.*;

public class CuentasCaso extends MenuInput{

    public static void caso_cuentas(Scanner scanner){

        List<Cuenta> cuentas = GestorCuentas.getCuentas();
        boolean exit_cuenta = false;
        int opcion_cuenta;

        while (exit_cuenta==false) {

            clearScreen();
            System.out.println("------ CUENTAS ------");
            System.out.println("1. Ingresar Cuenta");
            System.out.println("2. Modificar Cuenta");
            System.out.println("3. Eliminar Cuenta");
            System.out.println("4. Mostrar Cuenta");
            System.out.println("5. Menu Principal");
            System.out.print("Seleccione una opción (1-5): ");

            opcion_cuenta = ValidarOpcionNumerica.ingresarOpcion(scanner);

            switch (opcion_cuenta) {
                case 1:
                    CuentaIngresar.ingresarCuenta(cuentas, scanner);
                    break;

                case 2:
                    CuentaModificar.cuentaModificarPorDni(cuentas, scanner);
                    break;

                case 3:
                    CuentaEliminar.cuentaEliminarPorDni(cuentas, scanner);
                    break;

                case 4:
                    CuentaMostrar.mostrarCuentaPorDNI(cuentas, scanner);
                    break;

                case 5: 
                    exit_cuenta = true;
                    break;

                default:
                    System.out.println("Opcion incorrecta. Por favor, intentelo nuevamente: ");
                    break;
            }
        }

        clearScreen();
    }
}
