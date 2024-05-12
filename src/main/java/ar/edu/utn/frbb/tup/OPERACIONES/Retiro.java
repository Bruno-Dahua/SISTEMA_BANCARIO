package ar.edu.utn.frbb.tup.OPERACIONES;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.CASOS.OperacionesCaso;
import ar.edu.utn.frbb.tup.GESTOR.*;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.VALIDACIONES.*;

public class Retiro extends OperacionesCaso{

    public static void retirar(Scanner scanner){

        List<Cuenta> cuentas = GestorCuentas.getCuentas();
        List<Cliente> clientes = GestorClientes.getClientes();
        List<Movimiento> movimientos = GestorMovimientos.getMovimientos();

        if (cuentas.isEmpty()) {
            clearScreen();
            System.out.println("No es posible realizar la operacion.");
            esperarEnter();
            return;
        }else{
            clearScreen();
            System.out.println("Ingrese DNI para acceder a la cuenta: ");
            long dni = ValidarDni.ingresarDNI(scanner);
            Cuenta cuentaRetirar = null;
            boolean seguir_dni = false;
            boolean seguir_id = false;

            for(Cuenta cuenta : cuentas){
                if (cuenta.getDniAsociado() == dni) {
                    cuentaRetirar = cuenta;
                    seguir_dni = true;
                }
            }

            System.out.println("Ingrese ID para acceder a la cuenta: ");
            int id = ValidarId.validarEnter(scanner);

            for(Cuenta cuenta : cuentas){
                if (cuenta.getId() == id) {
                    cuentaRetirar = cuenta;
                    seguir_id = true;
                }
            }

            if (seguir_dni == true && seguir_id == true && cuentaRetirar.getSaldo()>0) {
                Cliente clienteRetirar = null;
                for(Cliente cliente : clientes){
                    if (cliente.getId() == id && cliente.getDni()==dni) {
                        clienteRetirar = cliente;
                    }
                }

                System.out.println("Ingrese el dinero que desea retirar: ");
                double dinero = ValidarDouble.validarDouble(scanner);

                if (dinero<cuentaRetirar.getSaldo()) {
                    cuentaRetirar.setSaldo(cuentaRetirar.getSaldo() - dinero);
                    clearScreen();
                    System.out.println("La operacion se realizo con exito...");
                    System.out.println("Se retiro $ " + dinero + " a " + clienteRetirar.getNombre() + " " + clienteRetirar.getApellido());
                    System.out.println("De la cuenta " + cuentaRetirar.getId() + " asociada al titular DNI " + cuentaRetirar.getDniAsociado());
                    esperarEnter();

                    Movimiento movimiento = new Movimiento(dni, "Retiro", dinero, cuentaRetirar.getSaldo(), LocalDateTime.now(), '-');
                    movimientos.add(movimiento);
                    
                }else{
                    clearScreen();
                    System.out.println("No hay fondos suficientes.");
                    esperarEnter();
                }
                
            }else{
                clearScreen();
                System.out.println("No es posible acceder a la cuenta.");
                esperarEnter();
                return;
            }
        }
    }
}
