package com.mycompany.bioparque;
 
/**
 *
 * @author Usuario
 */
public class Ave extends Animal {
    private double envergadura;
    private boolean puedeVolar;
 
    public Ave(String codigo, String nombre, int edad, double peso, String sexo,
               EstadoSalud estadoSalud, EstadoInventario estadoInventario, String habitat,
               double envergadura, boolean puedeVolar) {
 
        super(codigo, nombre, edad, peso, sexo, estadoSalud, estadoInventario, habitat);
 
        if (envergadura <= 0) {
            throw new IllegalArgumentException("La envergadura es obligatoria y debe ser mayor que cero.");
        }
 
        this.envergadura = envergadura;
        this.puedeVolar = puedeVolar;
    }
 
    public double getEnvergadura() {
        return envergadura;
    }
 
    public boolean isPuedeVolar() {
        return puedeVolar;
    }
 

    public void actualizarEnvergadura(double nuevaEnvergadura) {
        if (nuevaEnvergadura <= 0) {
            throw new IllegalArgumentException("La envergadura debe ser mayor que cero.");
        }
        this.envergadura = nuevaEnvergadura;
    }
 

    public void registrarCapacidadVuelo(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }
 

    public void mostrarInfoAve() {
        mostrarInformacion();
        System.out.println("Envergadura: " + envergadura + " m");
        System.out.println("Puede volar: " + (puedeVolar ? "Si" : "No"));
    }
}