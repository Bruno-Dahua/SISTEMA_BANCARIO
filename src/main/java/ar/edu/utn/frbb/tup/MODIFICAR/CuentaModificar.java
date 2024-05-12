package ar.edu.utn.frbb.tup.MODIFICAR;

import java.util.*;

import ar.edu.utn.frbb.tup.CASOS.CuentasCaso;
import ar.edu.utn.frbb.tup.GESTOR.GestorClientes;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.MOSTRAR.CuentaMostrar;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDni;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDouble;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarTipoCuenta;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarTipoRespuesta;

public class CuentaModificar extends CuentasCaso{

    public static void cuentaModificarPorDni(List<Cuenta> cuentas, Scanner scanner){

        List<Cliente> clientes = GestorClientes.getClientes();

        if (cuentas.isEmpty()) {
            System.out.println("No es posible modificar una cuenta");
            esperarEnter();
            return;
        }else if (cuentas != null) {
            System.out.println("Ingrese el DNI del titular de la cuenta que desea modificar: ");
            long dni = ValidarDni.ingresarDNI(scanner);
            Cuenta cuentaEncontrada = null;
            Cliente clienteParaMostrar = null;

            for(Cuenta cuenta : cuentas){
                if (cuenta.getDniAsociado() == dni) {
                    cuentaEncontrada = cuenta;
                    break;
                }
            }

            for(Cliente cliente : clientes){
                if (cliente.getDni() == dni) {
                    clienteParaMostrar = cliente;
                }
            }

            if (cuentaEncontrada == null) {
                System.out.println("No se encontró ninguna cuenta con el DNI proporcionado.");
                esperarEnter();
                return;
            }else{
                CuentaMostrar.mostrarDatosCuenta(cuentaEncontrada, clienteParaMostrar);
                System.out.println("¿Esta seguro que desea modificarla? S/N");
                TipoRespuesta respuesta = ValidarTipoRespuesta.validarTipoRespuesta(scanner);
                
                if (respuesta==TipoRespuesta.SI) {
                    clearScreen();

                    System.out.println("------ Modificación de la Cuenta ------");
                    
                    System.out.println("Ingrese nuevo DNI del titular: ");
                    long dninuevo = ValidarDni.ingresarDNI(scanner);
                    boolean seguir = true;
                    
                    for(Cliente cliente : clientes){
                        if (cliente.getDni() == dninuevo) {
                            seguir = true;
                        }
                    }

                    if (seguir == true) {
                        cuentaEncontrada.setDniAsociado(dni);

                        System.out.println("Ingrese nuevo saldo: ");
                        double saldo = ValidarDouble.validarDouble(scanner);
                        cuentaEncontrada.setSaldo(saldo);

                        System.out.println("Ingrese nuevo tipo de cuenta Caja de Ahorro (CA) o Cuenta Corriente (CC): ");
                        TipoCuenta tipoCuenta = ValidarTipoCuenta.validarTipoCuenta(scanner);
                        cuentaEncontrada.setTipoCuenta(tipoCuenta);

                        clearScreen();
                        System.out.println("La cuenta fue modificada correctamente.");
                        esperarEnter();
                    }else{
                        clearScreen();
                        System.out.println("No se puede asociar la cuenta al cliente con DNI: " + dni);
                        esperarEnter();
                    }
                }

            }
        }
    }
}
