package com.mycompany.bioparque;
 
/**
 *
 * @author Usuario
 */
public class Mamifero extends Animal {
    private String tipoPelaje;
 
    public Mamifero(String codigo, String nombre, int edad, double peso, String sexo,
                     EstadoSalud estadoSalud, EstadoInventario estadoInventario, String habitat,
                     String tipoPelaje) {
 
        super(codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, habitat);
 
        if (tipoPelaje == null || tipoPelaje.isBlank()) {
            throw new IllegalArgumentException("El tipo de pelaje es obligatorio y no puede estar vacio.");
        }
 
        this.tipoPelaje = tipoPelaje;
    }
 
    public String getTipoPelaje() {
        return tipoPelaje;
    }

    public void actualizarTipoPelaje(String nuevoTipoPelaje) {
        if (nuevoTipoPelaje == null || nuevoTipoPelaje.isBlank()) {
            throw new IllegalArgumentException("El tipo de pelaje no puede estar vacio.");
        }
        this.tipoPelaje = nuevoTipoPelaje;
    }
 

    public void mostrarInfoMamifero() {
        mostrarInformacion();
        System.out.println("Tipo de pelaje: " + tipoPelaje);
    }
}