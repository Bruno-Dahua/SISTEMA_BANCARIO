package ar.edu.utn.frbb.tup.MOSTRAR;

import java.util.*;

import ar.edu.utn.frbb.tup.CASOS.CuentasCaso;
import ar.edu.utn.frbb.tup.GESTOR.GestorClientes;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDni;

public class CuentaMostrar extends CuentasCaso{

    public static void mostrarCuentaPorDNI(List<Cuenta> cuentas, Scanner scanner){

        List<Cliente> clientes = GestorClientes.getClientes();

        if (cuentas.isEmpty()) {
            System.out.println("No es posible mostrar una cuenta.");
            esperarEnter();
            return;
        }else{
            System.out.print("Ingrese el DNI del titular de la cuenta que desea mostrar: ");
            long dni = ValidarDni.ingresarDNI(scanner);
            Cuenta cuentaEncontrada = null;

            for(Cuenta cuenta : cuentas){
                if (cuenta.getDniAsociado()==dni) {
                    cuentaEncontrada=cuenta;
                    break;
                }
            }

            if (cuentaEncontrada==null) {
                System.out.println("No es posible mostrar una cuenta.");
                esperarEnter();
                return;
            }else{
                Cliente clienteEncontrado = null;

                for (Cliente cliente : clientes) {
                    if (cliente.getDni() == cuentaEncontrada.getDniAsociado()) {
                        clienteEncontrado = cliente;
                        break;
                    }
                }

                if (clienteEncontrado == null) {
                    System.out.println("No se encontró el cliente asociado a la cuenta.");
                    esperarEnter();
                    return;
                }
                
                mostrarDatosCuenta(cuentaEncontrada, clienteEncontrado);
                esperarEnter();
                clearScreen();
            }
        }
    }

    public static void mostrarDatosCuenta(Cuenta cuenta, Cliente cliente){

        System.out.println("------ Datos del Cuenta ------");
        System.out.println("ID: " + cuenta.getId());
        System.out.println("DNI asociado: " + cuenta.getDniAsociado());
        System.out.println("Titular: " + cliente.getApellido() + " " + cliente.getNombre());
        System.out.println("Saldo: " + cuenta.getSaldo());
        
        if (cuenta.getTipoCuenta()==TipoCuenta.CAJA_AHORRO) {
            System.out.println("Tipo de cuenta: CAJA DE AHORROS");
        }else{
            System.out.println("Tipo de cuenta: CUENTA CORRIENTE");
        }
    }
}
