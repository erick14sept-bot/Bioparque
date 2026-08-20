package com.mycompany.bioparque;
 
/**
 *
 * @author Usuario
 */
public abstract class Animal {
 
    
    private final String codigo;       
    private String nombre;             
    private final int edad;            
    private double peso;                
    private String sexo;               
    private EstadoSalud estadoSalud;   
    private EstadoInventario estadoInventario; 
    private String habitat;            
 
    public Animal(String codigo, String nombre, int edad, double peso, String sexo, EstadoSalud estadoSalud, EstadoInventario estadoInventario, String habitat) {
 

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El codigo es obligatorio y no puede estar vacio.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio y no puede estar vacio.");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad es obligatoria y no puede ser negativa.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso es obligatorio y debe ser mayor que cero.");
        }
        if (sexo == null || sexo.isBlank()) {
            throw new IllegalArgumentException("El sexo es obligatorio y no puede estar vacio.");
        }
        if (estadoSalud == null) {
            throw new IllegalArgumentException("El estado de salud es obligatorio.");
        }
        if (estadoInventario == null) {
            throw new IllegalArgumentException("El estado de inventario es obligatorio.");
        }
        if (habitat == null || habitat.isBlank()) {
            throw new IllegalArgumentException("El habitat es obligatorio y no puede estar vacio.");
        }
 
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.estadoSalud = estadoSalud;
        this.estadoInventario = estadoInventario;
        this.habitat = habitat;
    }

    public void actualizarPeso(double nuevoPeso) {
        if (nuevoPeso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }
        this.peso = nuevoPeso;
    }
 

    public void trasladarHabitat(String nuevoHabitat) {
        if (nuevoHabitat == null || nuevoHabitat.isBlank()) {
            throw new IllegalArgumentException("El nuevo habitat no puede estar vacio.");
        }
        this.habitat = nuevoHabitat;
    }

    public void ponerEnObservacion() {
        this.estadoInventario = EstadoInventario.EN_CUARENTENA;
        this.estadoSalud = EstadoSalud.EN_TRATAMIENTO;
    }
 

    public void retirar() {
        if (this.estadoInventario == EstadoInventario.NO_DISPONIBLE) {
            throw new IllegalStateException("El animal ya se encuentra retirado.");
        }
        this.estadoInventario = EstadoInventario.NO_DISPONIBLE;
    }
 

    public void habilitar() {
        this.estadoInventario = EstadoInventario.DISPONIBLE;
    }
 

    public void actualizarEstadoSalud(EstadoSalud nuevoEstado) {
        if (nuevoEstado == null) {
            throw new IllegalArgumentException("El estado de salud no puede ser nulo.");
        }
        this.estadoSalud = nuevoEstado;
    }
 

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public double getPeso() {
        return peso;
    }
 
    public String getSexo() {
        return sexo;
    }
 
    public EstadoSalud getEstadoSalud() {
        return estadoSalud;
    }
 
    public EstadoInventario getEstadoInventario() {
        return estadoInventario;
    }
 
    public String getHabitat() {
        return habitat;
    }
 
    public void mostrarInformacion() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Sexo: " + sexo);
        System.out.println("Estado de salud: " + estadoSalud);
        System.out.println("Estado de inventario: " + estadoInventario);
        System.out.println("Habitat: " + habitat);
    }

    public abstract String emitirSonido();

    public abstract String obtenerTipoAlimentacion();

    public abstract String describirCuidados();
}