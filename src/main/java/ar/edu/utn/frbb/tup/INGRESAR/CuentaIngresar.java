package ar.edu.utn.frbb.tup.INGRESAR;

import java.util.List;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.CASOS.CuentasCaso;
import ar.edu.utn.frbb.tup.GESTOR.GestorClientes;
import ar.edu.utn.frbb.tup.MODELOS.Cuenta;
import ar.edu.utn.frbb.tup.MODELOS.TipoCuenta;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDni;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarTipoCuenta;
import ar.edu.utn.frbb.tup.MODELOS.Cliente;

public class CuentaIngresar extends CuentasCaso{
    
    public static Cuenta ingresarCuenta(List<Cuenta> cuentas, Scanner scanner){
        List<Cliente> clientes = GestorClientes.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("No es posible crear la cuenta.");
            esperarEnter();
            return null;
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
                // Generar el ID de la cuenta
                int id;
                if (cuentas.isEmpty()) {
                    id = 1; // Si la lista está vacía, el nuevo cliente tendrá ID 1
                } else {
                    // Obtener el ID más alto y sumarle 1 para obtener el nuevo ID
                    id = cuentas.get(cuentas.size() - 1).getId() + 1;
                }

                double saldo = 0;

                System.out.print("Ingrese el tipo de cuenta Caja de Ahorro (CA) o Cuenta Corriente (CC): ");
                TipoCuenta tipoCuenta = ValidarTipoCuenta.validarTipoCuenta(scanner);

                // Crear la cuenta con el cliente asociado
                Cuenta cuenta = new Cuenta(id, dni, saldo, tipoCuenta);

                clearScreen();
                System.out.println("Cuenta ingresada correctamente.");
                esperarEnter();

                return cuenta;
            } else {
                clearScreen();
                System.out.println("No se encontró un cliente asociado con el DNI proporcionado.");
                esperarEnter();
                return null;
            }
        }
    }
}
