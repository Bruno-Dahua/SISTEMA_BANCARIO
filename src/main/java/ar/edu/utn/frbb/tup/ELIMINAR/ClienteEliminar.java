package ar.edu.utn.frbb.tup.ELIMINAR;

import java.util.List;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.CASOS.ClientesCaso;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.MOSTRAR.ClienteMostrar;
import ar.edu.utn.frbb.tup.VALIDACIONES.*;

public class ClienteEliminar extends ClientesCaso{
    
    public static void clienteEliminarPorDni(List<Cliente> clientes, Scanner scanner){

        if (clientes.size()==0) {
            System.out.println("No es posible eliminar un cliente.");
            esperarEnter();
            return;
        }else{
            System.out.println("Ingrese el DNI del cliente que desea eliminar: ");
            long dni=ValidarDni.ingresarDNI(scanner);
            Cliente clienteAEliminar = null;
            
            for (Cliente cliente : clientes) {
                if (cliente.getDni() == dni) {
                    clienteAEliminar = cliente;
                    break;
                }
            }

            if (clienteAEliminar == null) {
                System.out.println("No se encontró ningún cliente con el DNI proporcionado.");
                esperarEnter();
                return;
            }

            ClienteMostrar.mostrarDatosCliente(clienteAEliminar);
            System.out.println("¿Esta seguro que desea eliminarlo? S/N");
            TipoRespuesta respuesta = ValidarTipoRespuesta.validarTipoRespuesta(scanner);
            
            if (respuesta==TipoRespuesta.SI) {
                clearScreen();
                clientes.remove(clienteAEliminar);
                System.out.println("Cliente eliminado correctamente.");
                esperarEnter();
                clearScreen();
            }else{
                clearScreen();
                System.out.print("El cliente no se ha eliminado.");
                esperarEnter();
                clearScreen();
            }
        }
    }
}
