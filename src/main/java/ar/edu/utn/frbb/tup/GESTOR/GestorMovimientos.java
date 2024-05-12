package ar.edu.utn.frbb.tup.GESTOR;

import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frbb.tup.MODELOS.Movimiento;

public class GestorMovimientos {
    private static List<Movimiento> movimientos = new ArrayList<>();

    public List<Movimiento> getMovimientos(){
        return movimientos;
    }


}
