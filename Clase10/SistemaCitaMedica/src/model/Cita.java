package model;

public class Cita {
    private String codigo;
    private String nombrePaciente;
    private String cedula;
    private String telefono;
    private String nombreMedico;
    private String especialidadMedico;
    private String fecha;
    private String hora;
    private String motivoConsulta;
    private String estado;

    public Cita(String codigo, String nombrePaciente, String cedula, String telefono, String nombreMedico, 
                String especialidadMedico, String fecha, String hora, String motivoConsulta, String estado) {
        
        this.codigo = codigo;
        this.nombrePaciente = nombrePaciente;
        this.cedula = cedula;
        this.telefono = telefono;
        this.nombreMedico = nombreMedico;
        this.especialidadMedico = especialidadMedico;
        this.fecha = fecha;
        this.hora = hora;
        this.motivoConsulta = motivoConsulta;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNombrePaciente() {
        return nombrePaciente;
    }
    public String getCedula() {
        return cedula;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getNombreMedico() {
        return nombreMedico;
    }
    public String getEspecialidadMedico() {
        return especialidadMedico;
    }
    public String getFecha() {
        return fecha;
    }
    public String getHora() {
        return hora;
    }
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    public String getEstado() {
        return estado;
    }

    public String toString() {
        return codigo + ";" + nombrePaciente + ";" + cedula + ";" + telefono + ";" + nombreMedico + ";" +
               especialidadMedico + ";" + fecha + ";" + hora + ";" + motivoConsulta + ";" + estado;
    }
}
