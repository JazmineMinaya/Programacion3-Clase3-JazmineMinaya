package Clase4;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       
    }

    public static void mostrarMenu() {
        System.out.println("\n===========================");
        System.out.println("    ARCHIVAR ESTUDIANTE");
        System.out.println("===========================");
        System.out.println("\n1. Agregar estudiante");
        System.out.println("2. Mostrar estudiantes");
        System.out.println("3. Salir");
    }

    public static void agregarEstudiante() {
        System.out.println("AGREGAR ESTUDIANTE:\n");

        System.out.print("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la matricula: ");
        String matricula = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, edad, matricula);

        try {
            FileWriter archivoEstudiante = new FileWriter("archivoEstudiante.txt", true);

            archivoEstudiante.write("Nombre: " + estudiante.getNombre() + "\n");
            archivoEstudiante.write("Edad: " + estudiante.getEdad() + "\n");
            archivoEstudiante.write("Matricula: " + estudiante.getMatricula() + "\n");

            archivoEstudiante.close();

            System.out.println("\nEl estudiante ha sido agregado exitosamente al archivo.");
        }
        catch(Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
