package com.mycompany.bioparque;
 
/**
 *
 * @author Usuario
 */
public class Reptil extends Animal {
 
    private String tipoEscamas;
 
    public Reptil(String codigo, String nombre, int edad, double peso, String sexo,
                  EstadoSalud estadoSalud, EstadoInventario estadoInventario, String habitat,
                  String tipoEscamas) {
 
        super(codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, habitat);
 
        if (tipoEscamas == null || tipoEscamas.isBlank()) {
            throw new IllegalArgumentException("El tipo de escamas es obligatorio y no puede estar vacio.");
        }
 
        this.tipoEscamas = tipoEscamas;
    }
 
    public String getTipoEscamas() {
        return tipoEscamas;
    }
 

    public void actualizarTipoEscamas(String nuevoTipoEscamas) {
        if (nuevoTipoEscamas == null || nuevoTipoEscamas.isBlank()) {
            throw new IllegalArgumentException("El tipo de escamas no puede estar vacio.");
        }
        this.tipoEscamas = nuevoTipoEscamas;
    }
 

    public void mostrarInfoReptil() {
        mostrarInformacion();
        System.out.println("Tipo de escamas: " + tipoEscamas);
    }
}