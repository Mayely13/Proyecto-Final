import java.util.ArrayList;
import java.util.Scanner;

// Clase Estudiante
class Estudiante {
    private String nombre;
    private int edad;

    // Constructor
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Método para mostrar información del estudiante
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
}

// Clase GestionBaseDatos que maneja la lógica de estudiantes
public class GestionBaseDatos {
    private ArrayList<Estudiante> estudiantes;

    // Constructor
    public GestionBaseDatos() {
        estudiantes = new ArrayList<>();
    }

    // Agregar estudiante
    public void agregarEstudiante(String nombre, int edad) {
        Estudiante estudiante = new Estudiante(nombre, edad);
        estudiantes.add(estudiante);
        System.out.println("Estudiante agregado: " + nombre);
    }

    // Mostrar todos los estudiantes
    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("\nEstudiantes registrados:");
            for (Estudiante e : estudiantes) {
                e.mostrarInfo();
            }
        }
    }

    // Eliminar un estudiante por nombre
    public void eliminarEstudiante(String nombre) {
        boolean encontrado = false;
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                estudiantes.remove(e);
                System.out.println("Estudiante eliminado: " + nombre);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Estudiante no encontrado: " + nombre);
        }
    }

    // Menú principal para interactuar con el sistema
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese edad del estudiante: ");
                    int edad = scanner.nextInt();
                    agregarEstudiante(nombre, edad);
                    break;
                case 2:
                    mostrarEstudiantes();
                    break;
                case 3:
                    System.out.print("Ingrese nombre del estudiante a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    eliminarEstudiante(nombreEliminar);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    public static void main(String[] args) {
        GestionBaseDatos gestion = new GestionBaseDatos();
        gestion.menu();  // Iniciar el menú de opciones
    }
}
