package ar.edu.utn.frbb.tup.CASOS;

import java.util.*;

import ar.edu.utn.frbb.tup.MenuInput;
import ar.edu.utn.frbb.tup.GESTOR.*;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.VALIDACIONES.*;

public class MovimientosCaso extends MenuInput{

    public static void mostrarMovimientos(Scanner scanner){

        List<Cuenta> cuentas = GestorCuentas.getCuentas();
        List<Cliente> clientes = GestorClientes.getClientes();

        if (cuentas.isEmpty()) {
            clearScreen();
            System.out.println("No es posible mostrar los movimientos.");
            esperarEnter();
            return;
        }else{
            clearScreen();
            System.out.println("Ingrese DNI para acceder a la cuenta: ");
            long dni = ValidarDni.ingresarDNI(scanner);
            boolean seguir_dni = false;
            boolean seguir_id = false;
            Cuenta cuentaMostrar = null;

            for(Cuenta cuenta : cuentas){
                if (cuenta.getDniAsociado() == dni) {
                    seguir_dni = true;
                    cuentaMostrar = cuenta;
                }
            }

            System.out.println("Ingrese ID para acceder a la cuenta: ");
            int id = ValidarId.validarEnter(scanner);

            for(Cuenta cuenta : cuentas){
                if (cuenta.getId() == id) {
                    seguir_id = true;
                }
            }

            if (seguir_id == true && seguir_dni == true) {
                Cliente clienteMostrar = null;
                for(Cliente cliente : clientes){
                    if (dni == cliente.getDni()) {
                        clienteMostrar = cliente;
                    }
                }
                clearScreen();
                System.out.println("------ Movimientos ------");
                System.out.println("DNI: " + clienteMostrar.getDni());
                System.out.println("Titular: " + clienteMostrar.getNombre() + " " + clienteMostrar.getApellido());
                mostrarMovimiento(dni, cuentaMostrar);
                esperarEnter();
                clearScreen();    
            }
        }
    }

    public static void mostrarMovimiento(long dni, Cuenta cuenta){

        List<Movimiento> movimientos = GestorMovimientos.getMovimientos();

        for(Movimiento movimiento : movimientos){
            if (dni == movimiento.getDni()) {
                System.out.println("-----------------------------------");
                System.out.println("Tipo de movimiento: " + movimiento.getTipoMovimiento());
                System.out.println("Fecha: " + movimiento.getFechaMovimiento());
                System.out.println(movimiento.getTipoEntradaSalida() + " $ " + movimiento.getMonto());
                System.out.println("Saldo: $ " + movimiento.getSaldo());
            }    
        }

        System.out.println("-----------------------------------");
        System.out.println("Saldo actual: $ " + cuenta.getSaldo());
        System.out.println("-----------------------------------");
    }
}
