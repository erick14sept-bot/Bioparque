package com.mycompany.bioparque;
 
/**
 *
 * @author Usuario
 */
public class Reptil extends Animal implements Alimentable {
 
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

    @Override
    public String emitirSonido() {
        return "Emite siseos o sonidos guturales; la mayoria de reptiles no vocaliza con fuerza.";
    }

    @Override
    public String obtenerTipoAlimentacion() {
        return "Se alimenta de forma esporadica debido a su metabolismo ectotermico "
                + "(depende de la temperatura del ambiente).";
    }

    @Override
    public String describirCuidados() {
        return "Requiere control de temperatura y humedad del habitat, ademas de revision "
                + "periodica de sus escamas tipo " + tipoEscamas + ".";
    }

    @Override
    public double calcularRacionDiaria() {
        return getPeso() * 0.02;
    }
}