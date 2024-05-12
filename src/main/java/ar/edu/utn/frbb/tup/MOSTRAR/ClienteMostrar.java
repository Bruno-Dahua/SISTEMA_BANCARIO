package ar.edu.utn.frbb.tup.MOSTRAR;

import java.util.*;

import ar.edu.utn.frbb.tup.CASOS.ClientesCaso;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDni;

public class ClienteMostrar extends ClientesCaso{

    public static void mostrarClientePorDNI(List<Cliente> clientes, Scanner scanner) {

        if (clientes.size()==0) {
            System.out.println("No es posible mostrar un cliente.");
            esperarEnter();
            return;
        }else{
            System.out.print("Ingrese el DNI del cliente que desea mostrar: ");
            long dni = ValidarDni.ingresarDNI(scanner);
            Cliente clienteEncontrado = null;

            for (Cliente cliente : clientes) {
                if (cliente.getDni() == dni) {
                    clienteEncontrado = cliente;
                    break;
                }
            }

            if (clienteEncontrado == null) {
                System.out.println("No se encontró ningún cliente con el DNI proporcionado.");
                esperarEnter();
                return;
            }else{
                mostrarDatosCliente(clienteEncontrado);
                esperarEnter();
                clearScreen();
            }
        }
    }
        
    

    public static void mostrarDatosCliente(Cliente cliente) {
        
        System.out.println("------ Datos del Cliente ------");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("DNI: " + cliente.getDni());
        System.out.println("Fecha de Nacimiento: " + cliente.getFechaNacimiento());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("Direccion: " + cliente.getDireccion());
        if (cliente.getTipoPersona()==TipoPersona.PERSONA_FISICA) {
            System.out.println("Tipo de persona: FISICA");
        } else {
            System.out.println("Tipo de persona: JURIDICA");
        }
        System.out.println("Fecha de Alta: " + cliente.getFechaAlta());
    }
}
