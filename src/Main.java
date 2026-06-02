import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void validarEstudiante(String nombre, int edad, double indice) throws EstudianteInvalidoException {
        if (nombre == null) {
            throw new EstudianteInvalidoException("\nEl nombre no puede estar vacío");
        }
        if (edad < 18 || edad > 100) {
            throw new EstudianteInvalidoException("\nLa edad debe ser mayor o igual a 18 años");
        }
        if (indice < 0.0 || indice > 4.0) {
            throw new EstudianteInvalidoException("\nEl índice debe estar entre 0 y 4");
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
        catch (EstudianteInvalidoException e) {
            System.out.println("\n" + e.getMessage());
        }
        finally {
            System.out.println("\nProceso finalizado");
        }
    }

    public static void main(String[] args) {
        registrarDatosEstudiante();
    }
}