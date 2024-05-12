package ar.edu.utn.frbb.tup.OPERACIONES;

import java.util.*;

import ar.edu.utn.frbb.tup.CASOS.OperacionesCaso;
import ar.edu.utn.frbb.tup.GESTOR.GestorClientes;
import ar.edu.utn.frbb.tup.GESTOR.GestorCuentas;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDni;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDouble;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarId;

public class Deposito extends OperacionesCaso{
    public static void depositar(Scanner scanner){

        List<Cuenta> cuentas = GestorCuentas.getCuentas();
        List<Cliente> clientes = GestorClientes.getClientes();

        if (cuentas.isEmpty()) {
            clearScreen();
            System.out.println("No es posible realizar la operacion.");
            esperarEnter();
            return;
        }else{
            clearScreen();
            System.out.println("Ingrese DNI para acceder a la cuenta: ");
            long dni = ValidarDni.ingresarDNI(scanner);
            Cuenta cuentaDepositar = null;
            boolean seguir_dni = false;
            boolean seguir_id = false;

            for(Cuenta cuenta : cuentas){
                if (cuenta.getDniAsociado() == dni) {
                    cuentaDepositar = cuenta;
                    seguir_dni = true;
                }
            }

            System.out.println("Ingrese ID para acceder a la cuenta: ");
            int id = ValidarId.validarEnter(scanner);

            for(Cuenta cuenta : cuentas){
                if (cuenta.getId() == id) {
                    cuentaDepositar = cuenta;
                    seguir_id = true;
                }
            }

            if (seguir_dni == true && seguir_id == true) {
                Cliente clienteDepositar = null;
                for(Cliente cliente : clientes){
                    if (cliente.getId() == id && cliente.getDni()==dni) {
                        clienteDepositar = cliente;
                    }
                }
                System.out.println("Ingrese el dinero que desea depositar: ");
                double dinero = ValidarDouble.validarDouble(scanner);
                cuentaDepositar.setSaldo(cuentaDepositar.getSaldo() + dinero);

                clearScreen();
                System.out.println("La operacion se realizo con exito...");
                System.out.println("Se deposito $ " + dinero + " a " + clienteDepositar.getNombre() + " " + clienteDepositar.getApellido());
                System.out.println("En la cuenta " + cuentaDepositar.getId() + " asociada al titular DNI " + cuentaDepositar.getDniAsociado());
                esperarEnter();
            }else{
                System.out.println("No es posible acceder a la cuenta.");
                esperarEnter();
                return;
            }
        }

    }
}
