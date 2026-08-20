package com.mycompany.bioparque;
 
/**
 *
 * @author Usuario
 */
public class Ave extends Animal implements Alimentable {
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

    @Override
    public String emitirSonido() {
        return "Emite un canto o trino caracteristico de su especie.";
    }

    @Override
    public String obtenerTipoAlimentacion() {
        return puedeVolar
                ? "Busca su alimento en vuelo (semillas, insectos o presas pequenas)."
                : "Obtiene su alimento desde el suelo o el agua, ya que no puede volar.";
    }

    @Override
    public String describirCuidados() {
        return "Requiere un espacio acorde a su envergadura de " + envergadura
                + " m y revision periodica de su plumaje y capacidad de vuelo.";
    }

    @Override
    public double calcularRacionDiaria() {
        return getPeso() * 0.10;
    }
}