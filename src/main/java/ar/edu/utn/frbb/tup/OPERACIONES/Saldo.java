package ar.edu.utn.frbb.tup.OPERACIONES;

import java.util.List;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.CASOS.OperacionesCaso;
import ar.edu.utn.frbb.tup.GESTOR.*;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.VALIDACIONES.*;

public class Saldo extends OperacionesCaso{

    public static void consultarSaldo(Scanner scanner){

        List<Cuenta> cuentas = GestorCuentas.getCuentas();
        List<Cliente> clientes = GestorClientes.getClientes();

        boolean seguir = false;
        long dni;
        int id;
        Cuenta cuentaConsultar = null;

        if (cuentas.isEmpty()) {
            clearScreen();
            System.out.println("No es posible realizar la operacion.");
            esperarEnter();
            return;
        }else{
            clearScreen();
            System.out.println("Ingrese DNI para acceder a la cuenta: ");
            dni = ValidarDni.ingresarDNI(scanner);
            
            for(Cuenta cuenta : cuentas){
                if (cuenta.getDniAsociado() == dni) {
                    cuentaConsultar = cuenta;
                    seguir = true;
                    break;
                }else{
                    seguir = false;
                }
            }

            System.out.println("Ingrese ID para acceder a la cuenta: ");
            id = ValidarId.validarEnter(scanner);

            for(Cuenta cuenta : cuentas){
                if (cuenta.getId() == id) {
                    cuentaConsultar = cuenta;
                    seguir = true;
                    break;
                }
                else{
                    seguir = false;
                }
            }
        }

        if (seguir == true) {

            Cliente clienteConsultar = null;

            for(Cliente cliente : clientes){
                if (cliente.getDni() == dni && cliente.getId() == id) {
                    clienteConsultar = cliente;
                }
            }
            
            clearScreen();
            System.out.println("Titular de la cuenta: " + clienteConsultar.getNombre() + " " + clienteConsultar.getApellido());
            System.out.println("DNI: " + cuentaConsultar.getDniAsociado());
            System.out.println("Saldo: $ " + cuentaConsultar.getSaldo());
            esperarEnter();
            return;
        }else{
            System.out.println("No es posible acceder a la cuenta.");
            esperarEnter();
            return;
        }
    }
}
