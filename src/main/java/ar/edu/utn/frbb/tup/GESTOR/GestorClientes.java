package ar.edu.utn.frbb.tup.GESTOR;

import java.util.*;

import ar.edu.utn.frbb.tup.MODELOS.Cliente;

public class GestorClientes {
    
    private static List<Cliente> clientes = new ArrayList<>();

    public GestorClientes() {
        
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}
