package ar.edu.utn.frbb.tup.MODELOS;

import java.time.LocalDateTime;

public class Movimiento {
    private long dni;
    private String tipoMovimiento;
    private double monto;
    private double saldo;
    private LocalDateTime fechaMovimiento;
    private char tipoEntradaSalida;

    //Constructors
    public Movimiento(long dni, String tipoMovimiento, double monto, double saldo, LocalDateTime fechaMovimiento, char tipoEntradaSalida){
        this.dni = dni;
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.saldo = saldo;
        this.fechaMovimiento = fechaMovimiento;
        this.tipoEntradaSalida = tipoEntradaSalida;
    }

    //Getters y Setters 
    public long getDni(){
        return dni;
    }

    public String getTipoMovimiento(){
        return tipoMovimiento;
    }

    public double getMonto(){
        return monto;
    }

    public double getSaldo(){
        return saldo;
    }
    
    public LocalDateTime getFechaMovimiento(){
        return fechaMovimiento;
    }

    public char getTipoEntradaSalida(){
        return tipoEntradaSalida;
    }
}
