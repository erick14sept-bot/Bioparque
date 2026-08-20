package com.mycompany.bioparque;
 
/**
 *
 * @author Usuario
 */
public class Mamifero extends Animal implements Alimentable {
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

    @Override
    public String emitirSonido() {
        return "Emite un sonido gutural propio de su especie (rugido, gruñido o bramido segun el caso).";
    }

    @Override
    public String obtenerTipoAlimentacion() {
        return "Se alimenta segun su especie, complementando su dieta con cuidado de su pelaje tipo "
                + tipoPelaje + ".";
    }

    @Override
    public String describirCuidados() {
        return "Requiere cepillado o mantenimiento de su pelaje tipo " + tipoPelaje
                + " y control veterinario periodico.";
    }

    @Override
    public double calcularRacionDiaria() {
        // Aproximacion: un mamifero consume alrededor del 3% de su peso corporal al dia.
        return getPeso() * 0.03;
    }
}