package ar.edu.utn.frbb.tup.MODELOS;

import java.time.LocalDate;


// Clase Cliente que extiende de Persona
public class Cliente extends Persona {
    private int id;
    private TipoPersona tipoPersona;
    private LocalDate fechaAlta;

    // Constructor
    public Cliente(int id, String nombre, String apellido, long dni, LocalDate fechaNacimiento, long telefono, String direccion, TipoPersona tipoPersona, LocalDate fechaAlta) {
        super(nombre, apellido, dni, fechaNacimiento, telefono, direccion);
        this.id = id;
        this.tipoPersona = tipoPersona;
        this.fechaAlta = fechaAlta;
    }


    // Getters y Setters
    public int getId() {
        return id;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

}