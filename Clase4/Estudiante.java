package Clase4;

public class Estudiante {
    private String nombre;
    private int edad;
    private String matricula;

    public Estudiante() {
        setNombre("");
        setEdad(0);
        setMatricula("");
    }

    public Estudiante(String nombre, int edad, String matricula) {
        setNombre(nombre);
        setEdad(edad);
        setMatricula(matricula);
    }

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getMatricula() {
        return matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
