package ar.edu.utn.frbb.tup.MODELOS;

public class Cuenta {
    private int id;
    private double saldo;
    private TipoCuenta tipoCuenta;
    private long dniAsociado;

    // Constructor
    public Cuenta(int id, long dniAsociado, double saldo, TipoCuenta tipoCuenta) {
        this.id = id;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.dniAsociado = dniAsociado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public long getDniAsociado() {
        return dniAsociado;
    }

    public void setDniAsociado(long dniAsociado) {
        this.dniAsociado = dniAsociado;
    }

}
