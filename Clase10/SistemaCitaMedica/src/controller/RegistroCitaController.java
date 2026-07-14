package controller;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import java.util.ArrayList;

import model.Cita;
import model.Medico;
import model.Especialidad;
import utils.ArchivoUtil;
import utils.Navegacion;

public class RegistroCitaController {
    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtTelefono;

    @FXML
    private ComboBox<Medico> cmbMedico;

    @FXML
    private ComboBox<Especialidad> cmbEspecialidad;

    @FXML
    private DatePicker fechaCita;

    @FXML
    private TextField txtHora;

    @FXML
    private TextArea txtMotivoConsulta;

    @FXML
    private ComboBox<String> cmbEstado;

    @FXML
   public void initialize() {
        Especialidad neurologia = new Especialidad("Neurología");
        Especialidad nutricion = new Especialidad("Nutrición");

        cmbEspecialidad.getItems().addAll(neurologia, nutricion);

        Medico primerMedico = new Medico("Melody Santos");
        Medico segundoMedico = new Medico("Oliver Peralta");

        cmbMedico.getItems().addAll(primerMedico, segundoMedico);

        cmbEstado.getItems().addAll("Programada", "Atendida", "Cancelada");
    }

    @FXML
    public void abrirConsultaCita() {
        ConsultaCitaController controller = Navegacion.abrirVentana(
            "/view/consulta_cita.fxml",
            "Consulta de Citas");
    }

    @FXML
    public void salir() {
        Platform.exit();
    }

    @FXML
    public void registrarCita() {
        if (txtCodigo.getText().isEmpty() || txtNombre.getText().isEmpty() ||
            txtCedula.getText().isEmpty() || txtTelefono.getText().isEmpty() ||
            txtHora.getText().isEmpty() || cmbMedico.getValue() == null || 
            fechaCita.getValue() == null) {
            
            mostrarAlerta(Alert.AlertType.WARNING, "Error", "Todos los campos deben estar llenos");
            return; 
        }

        try {
            ArrayList<Cita> citas = ArchivoUtil.leerListaCitas();
            
            for (Cita cita : citas) {
                
                if (cita.getCodigo().equalsIgnoreCase(txtCodigo.getText().trim())) {
                    throw new exception.CitaDuplicadaException("El código ya existe");
                }

                String cedula = txtCedula.getText().trim();

                for (int i = 0; i < cedula.length(); i++) {
                    if (!Character.isDigit(cedula.charAt(i))) {
                        mostrarAlerta(Alert.AlertType.WARNING, "Error", "La cédula debe contener numeros");
                        return;
                    }
                }

                String telefono = txtTelefono.getText().trim();

                for (int i = 0; i < telefono.length(); i++) {
                    if (!Character.isDigit(telefono.charAt(i))) {
                        mostrarAlerta(Alert.AlertType.WARNING, "Error", "El teefono debe contener numeros");
                        return;
                    }
                }

                if (cita.getNombreMedico().equals(cmbMedico.getValue().toString()) && 
                    cita.getFecha().equals(fechaCita.getValue().toString()) && 
                    cita.getHora().equalsIgnoreCase(txtHora.getText().trim())) {
                    throw new exception.CitaDuplicadaException("El médico posee una cita a esa fecha y hora");
                }
            }

            ArchivoUtil.guardarCita(crearCita());
            
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Cita guardada correctamente");
            limpiarFormulario();

        } catch (exception.CitaDuplicadaException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Conflicto de Cita", e.getMessage());
        }
    }

    @FXML
    public void limpiarFormulario() {
        txtCodigo.clear();
        txtNombre.clear();
        txtCedula.clear();
        txtTelefono.clear();
        txtHora.clear();
        txtMotivoConsulta.clear();

        cmbMedico.setValue(null);
        cmbEspecialidad.setValue(null);
        fechaCita.setValue(null);
        cmbEstado.setValue(null);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private Cita crearCita() {
        Medico medico = cmbMedico.getValue();
        String medicoSeleccionado = medico.toString();

        Especialidad especialidad = cmbEspecialidad.getValue();
        String especialidadSeleccionado = especialidad.toString();

        String fechaSeleccionada;

        if (fechaCita.getValue() != null) {
            fechaSeleccionada = fechaCita.getValue().toString();
        } else {
            fechaSeleccionada = "";
        }

        return new Cita(
            txtCodigo.getText(),
            txtNombre.getText(),
            txtCedula.getText(),
            txtTelefono.getText(),
            medicoSeleccionado,
            especialidadSeleccionado,
            fechaSeleccionada,
            txtHora.getText(),
            cmbEstado.getValue(), 
            txtMotivoConsulta.getText()
        );
    }
}
