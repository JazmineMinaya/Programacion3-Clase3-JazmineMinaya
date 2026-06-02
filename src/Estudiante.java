public class Estudiante {
    private String nombre;
    private int edad;
    private double indiceAcademico;

    public Estudiante() {
        setNombre("");
        setEdad(0);
        setIndiceAcademico(0);
    }

    public Estudiante(String nombre, int edad, double indiceAcademico) {
        setNombre(nombre);
        setEdad(edad);
        setIndiceAcademico(indiceAcademico);
    }

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public double getIndiceAcademico() {
        return indiceAcademico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setIndiceAcademico(double indiceAcademico) {
        this.indiceAcademico = indiceAcademico;
    }
}