package ar.edu.utn.frbb.tup.CASOS;

import java.util.List;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.MenuInput;
import ar.edu.utn.frbb.tup.ELIMINAR.ClienteEliminar;
import ar.edu.utn.frbb.tup.GESTOR.GestorClientes;
import ar.edu.utn.frbb.tup.INGRESAR.ClienteIngresar;
import ar.edu.utn.frbb.tup.MODELOS.Cliente;
import ar.edu.utn.frbb.tup.MOSTRAR.ClienteMostrar;
import ar.edu.utn.frbb.tup.VALIDACIONES.ValidarOpcionNumerica;
import ar.edu.utn.frbb.tup.MODIFICAR.ClientesModificar;

public class ClientesCaso extends MenuInput{
    
    public static void caso_clientes(Scanner scanner){
        List<Cliente> clientes = GestorClientes.getClientes();
        boolean exit_cliente=false;
        int opcion_cliente;
        while (exit_cliente==false) {
            clearScreen();
            System.out.println("------ CLIENTES ------");
            System.out.println("1. Ingresar Cliente");
            System.out.println("2. Modificar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Mostrar Cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            opcion_cliente=ValidarOpcionNumerica.ingresarOpcion(scanner);

            switch (opcion_cliente) {
                case 1:
                    clearScreen();
                    Cliente cliente = ClienteIngresar.ingresarCliente(clientes, scanner);
                    clientes.add(cliente);
                    break;
                case 2:
                    clearScreen();
                    ClientesModificar.clienteModificarPorDni(clientes, scanner);
                    break;
                case 3:
                    clearScreen();
                    ClienteEliminar.clienteEliminarPorDni(clientes, scanner);
                    break;
                case 4:
                    clearScreen();
                    ClienteMostrar.mostrarClientePorDNI(clientes, scanner);
                    break;
                case 5: 
                    exit_cliente=true;
                    break;
                default:
                    System.out.println("Opcion incorrecta. Por favor, intentelo nuevamente: ");
                    break;
            }
        }
        clearScreen();
    }
}
