import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void validarEstudiante(String nombre, int edad, double indice) throws Exception {
        if (nombre == null) {
            throw new Exception("\nEl nombre no puede estar vacío");
        }
        if (edad < 18 || edad > 100) {
            throw new Exception("\nLa edad debe ser mayor o igual a 18 años");
        }
        if (indice < 0.0 || indice > 4.0) {
            throw new Exception("\nEl índice debe estar entre 0 y 4");
        }
    }

    public static void registrarDatosEstudiante() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Indice: ");
        double indiceAcademico = scanner.nextDouble();
        scanner.nextLine();

        try {
            validarEstudiante(nombre, edad, indiceAcademico);

            System.out.println("\nEstudiante registrado correctamente");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("\nProceso finalizado");
        }
    }

    public static void main(String[] args) {
        registrarDatosEstudiante();
    }
}