package ar.edu.utn.frbb.tup.INGRESAR;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.CASOS.ClientesCaso;
import ar.edu.utn.frbb.tup.MODELOS.Cliente;
import ar.edu.utn.frbb.tup.MODELOS.TipoPersona;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarDni;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarFecha;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarString;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarTelefono;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarTipoPersona;

public class ClienteIngresar extends ClientesCaso{
    public static Cliente ingresarCliente(List<Cliente> clientes, Scanner scanner) {

        System.out.println("------ Ingreso de Cliente ------");

        int id;
        if (clientes.isEmpty()) {
            id = 1; 
        } else {
            id = clientes.get(clientes.size() - 1).getId() + 1;
        }

        System.out.print("Ingrese el nombre del cliente: ");
        scanner.nextLine();
        String nombre = ValidarString.ingresarNombre(scanner);

        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = ValidarString.ingresarNombre(scanner);

        System.out.print("Ingrese el DNI del cliente: ");
        long dni = ValidarDni.ingresarDNI(scanner);
        
        System.out.print("Ingrese la fecha de nacimiento del cliente (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = ValidarFecha.ingresarFecha(scanner);
        
        System.out.print("Ingrese el teléfono del cliente: ");
        long telefono = ValidarTelefono.ingresarTelefono(scanner);

        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el tipo de persona Fisica (F) o Juridica (J): ");
        TipoPersona tipoPersona = ValidarTipoPersona.validarTipoPersona(scanner);

        LocalDate fechaAlta = LocalDate.now();

        // Crear el cliente y devolverlo
        Cliente cliente = new Cliente(id, nombre, apellido, dni, fechaNacimiento, telefono, direccion, tipoPersona, fechaAlta);
        
        clearScreen();
        System.out.println("Cliente ingresado correctamente. ");
        esperarEnter();
        
        return cliente;

/*      Cliente cliente1 = new Cliente(1, "Bruno", "Dahua", 45889159, LocalDate.of(2005, 01, 03), 2932405452L, "Alb XV casa 13", TipoPersona.fromString("f"), LocalDate.of(2024, 05, 12));
        Cliente cliente2 = new Cliente(2, "Diana", "Juan", 18458131, LocalDate.of(1967, 12, 8), 2932613546L, "Alb XV casa 13", TipoPersona.fromString("J"), LocalDate.of(2024, 05, 12));
        clientes.add(cliente2);
        return cliente1;*/
        
    }
}