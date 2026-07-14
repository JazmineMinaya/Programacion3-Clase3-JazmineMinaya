package model;

public class Medico {
    private String nombreMedico;

    public Medico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public String toString() {
        return nombreMedico;
    }
}
