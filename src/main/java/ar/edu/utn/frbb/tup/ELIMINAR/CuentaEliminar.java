package ar.edu.utn.frbb.tup.ELIMINAR;

import java.util.*;

import ar.edu.utn.frbb.tup.CASOS.CuentasCaso;
import ar.edu.utn.frbb.tup.GESTOR.GestorClientes;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.MOSTRAR.CuentaMostrar;
import ar.edu.utn.frbb.tup.VALIDACIONES.*;

public class CuentaEliminar extends CuentasCaso{

    public static void cuentaEliminarPorDni(List<Cuenta> cuentas, Scanner scanner){

        List<Cliente> clientes = GestorClientes.getClientes();
        
        if(cuentas.isEmpty()){
            System.out.println("No es posible eliminar una cuenta.");
            esperarEnter();
            return;
        }else{
            System.out.println("Ingrese el DNI del titular de la cuenta que desea eliminar: ");
            long dni = ValidarDni.ingresarDNI(scanner);
            Cuenta cuentaAEliminar = null;
            Cliente clienteParaMostrar = null;

            for(Cuenta cuenta : cuentas){
                if (cuenta.getDniAsociado() == dni) {
                    cuentaAEliminar = cuenta;
                }
            }

            for(Cliente cliente : clientes){
                if (cliente.getDni() == dni) {
                    clienteParaMostrar = cliente;
                }
            }

            if (cuentaAEliminar==null) {
                System.out.println("No es posible eliminar una cuenta.");
                esperarEnter();
                return;
            }else{
                CuentaMostrar.mostrarDatosCuenta(cuentaAEliminar, clienteParaMostrar);
                System.out.println("¿Esta seguro que desea eliminarla? S/N");
                TipoRespuesta respuesta = ValidarTipoRespuesta.validarTipoRespuesta(scanner);
                if (respuesta==TipoRespuesta.SI) {
                    clearScreen();
                    cuentas.remove(cuentaAEliminar);
                    System.out.println("La cuenta fue eliminada correctamente.");
                    esperarEnter();
                    clearScreen();
                }else{
                    clearScreen();
                    System.out.println("La cuenta no se ha eliminado.");
                    esperarEnter();
                    clearScreen();
                }
            }
        }
    }
}
