package ar.edu.utn.frbb.tup.INGRESAR;

import java.util.List;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.CASOS.CuentasCaso;
import ar.edu.utn.frbb.tup.GESTOR.GestorClientes;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.VALIDACIONES.*;

public class CuentaIngresar extends CuentasCaso{
    
    public static void ingresarCuenta(List<Cuenta> cuentas, Scanner scanner){

        List<Cliente> clientes = GestorClientes.getClientes();

        if (clientes.isEmpty()) {
            System.out.println("No es posible crear la cuenta.");
            esperarEnter();
            return;
        }else{
            System.out.println("------ Ingreso de Cuenta ------");

            System.out.println("Ingrese el DNI del dueño de la cuenta: ");
            long dni = ValidarDni.ingresarDNI(scanner);

            // Buscar el cliente por su DNI
            Cliente clienteAsociado = null;
            for (Cliente cliente : clientes) {
                if (cliente.getDni() == dni) {
                    clienteAsociado = cliente;
                    break;
                }
            }

            if (clienteAsociado != null) {
                int id;
                if (cuentas.isEmpty()) {
                    id = 1; 
                    
                } else {
                    id = cuentas.get(cuentas.size() - 1).getId() + 1;
                }

                double saldo = 0;

                System.out.print("Ingrese el tipo de cuenta Caja de Ahorro (CA) o Cuenta Corriente (CC): ");
                TipoCuenta tipoCuenta = ValidarTipoCuenta.validarTipoCuenta(scanner);

                // Crear la cuenta con el cliente asociado y devolverla
                Cuenta cuenta = new Cuenta(id, dni, saldo, tipoCuenta);

                clearScreen();
                System.out.println("Cuenta ingresada correctamente.");
                esperarEnter();

                cuentas.add(cuenta);
                
            } else {
                clearScreen();
                System.out.println("No se encontró un cliente asociado con el DNI proporcionado.");
                esperarEnter();
                return;
            }
        }
    }
}
