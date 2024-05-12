package ar.edu.utn.frbb.tup.GESTOR;

import java.util.*;

import ar.edu.utn.frbb.tup.MODELOS.Cuenta;

public class GestorCuentas {
    
    private static List<Cuenta> cuentas = new ArrayList<>();

    public GestorCuentas(){

    }

    public static List<Cuenta> getCuentas(){
        return cuentas;
    }
}
