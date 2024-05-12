package ar.edu.utn.frbb.tup.MODIFICAR;

import java.time.LocalDate;
import java.util.*;

import ar.edu.utn.frbb.tup.CASOS.ClientesCaso;
import ar.edu.utn.frbb.tup.MODELOS.*;
import ar.edu.utn.frbb.tup.MOSTRAR.ClienteMostrar;
import ar.edu.utn.frbb.tup.VALIDACIONES.*;

public class ClientesModificar extends ClientesCaso{
    
    public static void clienteModificarPorDni(List<Cliente> clientes, Scanner scanner){

        if (clientes.size()==0) {
            System.out.println("No es posible modificar un cliente.");
            esperarEnter();
            return;
        }else{
            System.out.println("Ingrese DNI del cliente que desea modificar: ");
            long dni = ValidarDni.ingresarDNI(scanner);
            Cliente clienteAModificar = null;
            
            for (Cliente cliente : clientes) {
                if (cliente.getDni() == dni) {
                    clienteAModificar = cliente;
                    break;
                }
            }
            if (clienteAModificar==null) {
                System.out.println("No se encontró ningún cliente con el DNI proporcionado.");
                esperarEnter();
                return;
            }

            ClienteMostrar.mostrarDatosCliente(clienteAModificar);
            System.out.println("¿Esta seguro que desea modificarlo? S/N");
            TipoRespuesta respuesta = ValidarTipoRespuesta.validarTipoRespuesta(scanner);
            
            if (respuesta==TipoRespuesta.SI) {
                clearScreen();

                System.out.println("------ Modificación de Cliente ------");

                System.out.print("Ingrese el nuevo nombre del cliente: ");
                String nuevoNombre = ValidarString.ingresarNombre(scanner);
                clienteAModificar.setNombre(nuevoNombre);

                System.out.print("Ingrese el nuevo apellido del cliente: ");
                String nuevoApellido = ValidarString.ingresarNombre(scanner);
                clienteAModificar.setApellido(nuevoApellido);

                System.out.print("Ingrese el nuevo DNI del cliente: ");
                long nuevoDNI = ValidarDni.ingresarDNI(scanner);
                clienteAModificar.setDni(nuevoDNI);

                System.out.print("Ingrese la nueva fecha de nacimiento del cliente (YYYY-MM-DD): ");
                LocalDate nuevaFechaNacimiento = ValidarFecha.ingresarFecha(scanner);
                clienteAModificar.setFechaNacimiento(nuevaFechaNacimiento);

                System.out.print("Ingrese el nuevo teléfono del cliente: ");
                long nuevoTelefono = ValidarTelefono.ingresarTelefono(scanner);
                clienteAModificar.setTelefono(nuevoTelefono);

                System.out.print("Ingrese la nueva dirección del cliente: ");
                String nuevaDireccion = scanner.nextLine();
                clienteAModificar.setDireccion(nuevaDireccion);

                System.out.print("Ingrese el nuevo tipo de persona del cliente Fisica (F) o Juridica (J): ");
                TipoPersona nuevoTipoPersona = ValidarTipoPersona.validarTipoPersona(scanner);
                clienteAModificar.setTipoPersona(nuevoTipoPersona);

                clearScreen();
                System.out.println("Cliente modificado correctamente.");
                esperarEnter();
            }
        }
    }
}

