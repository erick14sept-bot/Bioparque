package com.mycompany.bioparque;
 
import java.util.ArrayList;
import java.util.Scanner;
 
/**
 *
 * @author Usuario
 */
public class GestionarAnimal {
 
    private final Scanner lector;
    private final ArrayList<Animal> animales = new ArrayList<>();

    public GestionarAnimal(Scanner lector) {
        this.lector = lector;

        registrar(new Mamifero(
                "M001", "Leon", 5, 190, "Macho",
                EstadoSalud.SANO, EstadoInventario.DISPONIBLE, "Sabana", "Corto"
        ));
 
        registrar(new Ave(
                "A001", "Aguila real", 7, 4.5, "Hembra",
                EstadoSalud.SANO, EstadoInventario.DISPONIBLE, "Montana", 2.2, true
        ));
 
        registrar(new Reptil(
                "R001", "Tortuga", 10, 35, "Hembra",
                EstadoSalud.SANO, EstadoInventario.DISPONIBLE, "Zona tropical", "Duras"
        ));
    }
 
 
    public boolean existeCodigo(String codigo) {
        for (Animal animal : animales) {
            if (animal.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }
 
    public void registrar(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("El animal a registrar no puede ser nulo.");
        }
        if (existeCodigo(animal.getCodigo())) {
            throw new IllegalArgumentException("Ya existe un animal registrado con el codigo " + animal.getCodigo() + ".");
        }
        animales.add(animal);
    }

    public Animal buscar(String codigo) {
        for (Animal animal : animales) {
            if (animal.getCodigo().equalsIgnoreCase(codigo)) {
                return animal;
            }
        }
        return null;
    }
 

    public ArrayList<Animal> listarTodos() {
        return animales;
    }

    public void eliminar(String codigo) {
        Animal animal = buscar(codigo);
        if (animal == null) {
            throw new IllegalArgumentException("No existe un animal con el codigo " + codigo + ".");
        }
        animales.remove(animal);
    }

    private String categoriaDe(Animal animal) {
        if (animal instanceof Mamifero) {
            return "Mamifero";
        } else if (animal instanceof Ave) {
            return "Ave";
        } else if (animal instanceof Reptil) {
            return "Reptil";
        }
        return "Desconocida";
    }
 

    private void mostrarAnimal(Animal animal) {
        System.out.println("Categoria: " + categoriaDe(animal));
 
        if (animal instanceof Mamifero) {
            Mamifero mamifero = (Mamifero) animal;
            mamifero.mostrarInfoMamifero();
 
        } else if (animal instanceof Ave) {
            Ave ave = (Ave) animal;
            ave.mostrarInfoAve();
 
        } else if (animal instanceof Reptil) {
            Reptil reptil = (Reptil) animal;
            reptil.mostrarInfoReptil();
 
        } else {
            animal.mostrarInformacion();
        }
    }
 

    public void registrarDesdeConsola() {
        try {
            System.out.print("Ingrese el codigo: ");
            String codigo = lector.nextLine().trim();
 
            if (codigo.isBlank()) {
                System.out.println("Error: el codigo no puede estar vacio.");
                return;
            }
            if (existeCodigo(codigo)) {
                System.out.println("Error: ya existe un animal registrado con el codigo " + codigo + ". Ingrese uno diferente.");
                return;
            }
 
            System.out.print("Ingrese el nombre: ");
            String nombre = lector.nextLine();
 
            System.out.print("Ingrese la edad: ");
            int edad = Integer.parseInt(lector.nextLine());
 
            System.out.print("Ingrese el peso: ");
            double peso = Double.parseDouble(lector.nextLine());
 
            System.out.print("Ingrese el sexo: ");
            String sexo = lector.nextLine();
 
            System.out.print("Ingrese el habitat: ");
            String habitat = lector.nextLine();
 
            System.out.print("Ingrese la categoria (1-Mamifero, 2-Ave, 3-Reptil): ");
            int categoria = Integer.parseInt(lector.nextLine());
 
            Animal nuevoAnimal;
 
            if (categoria == 1) {
                System.out.print("Ingrese el tipo de pelaje: ");
                String tipoPelaje = lector.nextLine();
 
                nuevoAnimal = new Mamifero(codigo, nombre, edad, peso, sexo,
                        EstadoSalud.SANO, EstadoInventario.DISPONIBLE, habitat, tipoPelaje);
 
            } else if (categoria == 2) {
                System.out.print("Ingrese la envergadura: ");
                double envergadura = Double.parseDouble(lector.nextLine());
 
                System.out.print("¿Puede volar? (true/false): ");
                boolean puedeVolar = Boolean.parseBoolean(lector.nextLine());
 
                nuevoAnimal = new Ave(codigo, nombre, edad, peso, sexo,
                        EstadoSalud.SANO, EstadoInventario.DISPONIBLE, habitat, envergadura, puedeVolar);
 
            } else if (categoria == 3) {
                System.out.print("Ingrese el tipo de escamas: ");
                String tipoEscamas = lector.nextLine();
 
                nuevoAnimal = new Reptil(codigo, nombre, edad, peso, sexo,
                        EstadoSalud.SANO, EstadoInventario.DISPONIBLE, habitat, tipoEscamas);
 
            } else {
                System.out.println("Categoria no valida. Debe ser 1, 2 o 3.");
                return;
            }
 
            registrar(nuevoAnimal);
            System.out.println("Animal registrado correctamente.");
 
        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese un valor numerico valido. (" + e.getMessage() + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar el animal: " + e.getMessage());
        }
    }
 
    public void listar() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }
 
        System.out.println("\n===== LISTADO DE ANIMALES =====");
 
        for (Animal animal : animales) {
            mostrarAnimal(animal);
            System.out.println("------------------------");
        }
    }
 
    public void buscarDesdeConsola() {
        System.out.print("Ingrese el codigo del animal: ");
        String codigo = lector.nextLine();
 
        Animal animal = buscar(codigo);
 
        if (animal == null) {
            System.out.println("No se encontro el animal.");
            return;
        }
 
        System.out.println("\n===== ANIMAL ENCONTRADO =====");
        mostrarAnimal(animal);
    }
 

    public void actualizarDesdeConsola() {
        System.out.print("Ingrese el codigo del animal a actualizar: ");
        String codigo = lector.nextLine();
 
        Animal animal = buscar(codigo);
        if (animal == null) {
            System.out.println("No se encontro un animal con el codigo " + codigo + ".");
            return;
        }
 
        System.out.println("\n===== ACTUALIZAR ANIMAL: " + animal.getNombre() + " =====");
        System.out.println("1. Actualizar peso");
        System.out.println("2. Trasladar habitat");
        System.out.println("3. Poner en observacion (cuarentena)");
        System.out.println("4. Retirar del inventario");
        System.out.println("5. Habilitar (disponible)");
        System.out.println("6. Actualizar estado de salud");
        System.out.println("0. Cancelar");
        System.out.print("Seleccione una opcion: ");
 
        try {
            int opcion = Integer.parseInt(lector.nextLine());
 
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo peso: ");
                    double nuevoPeso = Double.parseDouble(lector.nextLine());
                    animal.actualizarPeso(nuevoPeso);
                    System.out.println("Peso actualizado correctamente.");
                    break;
 
                case 2:
                    System.out.print("Ingrese el nuevo habitat: ");
                    String nuevoHabitat = lector.nextLine();
                    animal.trasladarHabitat(nuevoHabitat);
                    System.out.println("Habitat actualizado correctamente.");
                    break;
 
                case 3:
                    animal.ponerEnObservacion();
                    System.out.println("Animal puesto en observacion.");
                    break;
 
                case 4:
                    animal.retirar();
                    System.out.println("Animal retirado del inventario activo.");
                    break;
 
                case 5:
                    animal.habilitar();
                    System.out.println("Animal habilitado como disponible.");
                    break;
 
                case 6:
                    System.out.print("Ingrese el nuevo estado de salud (SANO, EN_TRATAMIENTO, ENFERMO, RECUPERACION): ");
                    String estadoTexto = lector.nextLine();
                    EstadoSalud nuevoEstado = EstadoSalud.valueOf(estadoTexto.trim().toUpperCase());
                    animal.actualizarEstadoSalud(nuevoEstado);
                    System.out.println("Estado de salud actualizado correctamente.");
                    break;
 
                case 0:
                    System.out.println("Actualizacion cancelada.");
                    break;
 
                default:
                    System.out.println("Opcion fuera de rango.");
            }
 
        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese un valor numerico valido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al actualizar el animal: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Operacion no permitida: " + e.getMessage());
        }
    }

    public void eliminarDesdeConsola() {
        System.out.print("Ingrese el codigo del animal a eliminar: ");
        String codigo = lector.nextLine();
 
        Animal animal = buscar(codigo);
        if (animal == null) {
            System.out.println("No se encontro un animal con el codigo " + codigo + ".");
            return;
        }
 
        System.out.println("Va a eliminar a: " + animal.getNombre() + " (" + categoriaDe(animal) + ")");
        System.out.print("¿Confirma la eliminacion? (si/no): ");
        String confirmacion = lector.nextLine();
 
        if (!confirmacion.trim().equalsIgnoreCase("si")) {
            System.out.println("Eliminacion cancelada.");
            return;
        }
 
        try {
            eliminar(codigo);
            System.out.println("Animal eliminado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al eliminar el animal: " + e.getMessage());
        }
    }
}