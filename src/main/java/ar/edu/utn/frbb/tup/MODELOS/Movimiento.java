package ar.edu.utn.frbb.tup.MODELOS;

import java.time.LocalDateTime;

public class Movimiento {
    private long dni;
    private String tipoMovimiento;
    private LocalDateTime fechaMovimiento;
    private char tipoEntradaSalida;

    public Movimiento(long dni, String tipoMovimiento, LocalDateTime fechaMovimiento, char tipoEntradaSalida){
        this.dni = dni;
        this.tipoMovimiento = tipoMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.tipoEntradaSalida = tipoEntradaSalida;
    }

    public long getDni(){
        return dni;
    }

    public String getTipoMovimiento(){
        return tipoMovimiento;
    }

    public LocalDateTime getFechaMovimiento(){
        return fechaMovimiento;
    }

    public char getTipoEntradaSalida(){
        return tipoEntradaSalida;
    }
}
