package ar.edu.utn.frbb.tup.OPERACIONES;

import java.util.List;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.CASOS.OperacionesCaso;
import ar.edu.utn.frbb.tup.GESTOR.GestorClientes;
import ar.edu.utn.frbb.tup.GESTOR.GestorCuentas;
import ar.edu.utn.frbb.tup.MODELOS.Cliente;
import ar.edu.utn.frbb.tup.MODELOS.Cuenta;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDni;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDouble;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarId;

public class Transferencia extends OperacionesCaso{
    public static void transferir(Scanner scanner) {
    List<Cuenta> cuentas = GestorCuentas.getCuentas();
    List<Cliente> clientes = GestorClientes.getClientes();

    if (cuentas.isEmpty()) {
        clearScreen();
        System.out.println("No es posible realizar la operación.");
        esperarEnter();
        return;
    } else {
        clearScreen();
        System.out.println("Ingrese DNI para acceder a su cuenta: ");
        long dniOrigen = ValidarDni.ingresarDNI(scanner);
        Cuenta cuentaOrigen = null;
        boolean seguirDniOrigen = false;
        boolean seguirIdOrigen = false;

        for (Cuenta cuenta : cuentas) {
            if (cuenta.getDniAsociado() == dniOrigen) {
                cuentaOrigen = cuenta;
                seguirDniOrigen = true;
            }
        }

        System.out.println("Ingrese ID para acceder a su cuenta: ");
        int idOrigen = ValidarId.validarEnter(scanner);

        for (Cuenta cuenta : cuentas) {
            if (cuenta.getId() == idOrigen) {
                seguirIdOrigen = true;
            }
        }

        if (seguirDniOrigen && seguirIdOrigen && cuentaOrigen.getSaldo()>0) {
            clearScreen();
            System.out.println("Ingrese DNI del destinatario: ");
            long dniDestinatario = ValidarDni.ingresarDNI(scanner);
            Cliente clienteDestinatario = null;
            Cuenta cuentaDestinatario = null;
            boolean seguirDniDestinatario = false;

            for (Cliente cliente : clientes) {
                if (cliente.getDni() == dniDestinatario) {
                    clienteDestinatario = cliente;
                    seguirDniDestinatario = true;
                }
            }

            if (seguirDniDestinatario) {
                System.out.println("Ingrese el dinero que desea transferir: ");
                double dinero = ValidarDouble.validarDouble(scanner);
                if (dinero > cuentaOrigen.getSaldo()) {
                    clearScreen();
                    System.out.println("No hay fondos suficientes en la cuenta.");
                    esperarEnter();
                } else {
                    for (Cuenta cuenta : cuentas) {
                        if (cuenta.getDniAsociado() == dniDestinatario) {
                            cuentaDestinatario = cuenta;
                            break;
                        }
                    }

                    cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - dinero);
                    cuentaDestinatario.setSaldo(cuentaDestinatario.getSaldo() + dinero);

                    clearScreen();
                    System.out.println("La operación se realizó con éxito...");
                    System.out.println("Se transfirió $ " + dinero + " a " + clienteDestinatario.getNombre() + " " + clienteDestinatario.getApellido());
                    System.out.println("Desde la cuenta " + cuentaOrigen.getId() + " asociada al titular DNI " + cuentaOrigen.getDniAsociado());
                    System.out.println("Hacia la cuenta " + cuentaDestinatario.getId() + " asociada al titular DNI " + cuentaDestinatario.getDniAsociado());
                    esperarEnter();
                }
            } else {
                clearScreen();
                System.out.println("El destinatario no tiene una cuenta asociada a ese DNI.");
                esperarEnter();
            }
        } else {
            clearScreen();
            System.out.println("No es posible acceder a la cuenta.");
            esperarEnter();
            return;
        }
    }
}

}
