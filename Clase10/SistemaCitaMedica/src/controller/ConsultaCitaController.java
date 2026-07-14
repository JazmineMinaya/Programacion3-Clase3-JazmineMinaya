package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Cita;
import model.Medico;
import model.Especialidad;
import utils.ArchivoUtil;

public class ConsultaCitaController {
    @FXML
    private TableView<Cita> tablaCitas;

    @FXML
    private TableColumn<Cita, String> colCodigo;

    @FXML
    private TableColumn<Cita, String> colPaciente;

    @FXML
    private TableColumn<Cita, String> colMedico;

    @FXML
    private TableColumn<Cita, String> colEspecialidad;

    @FXML
    private TableColumn<Cita, String> colFecha;

    @FXML
    private TableColumn<Cita, String> colHora;

    @FXML
    private TableColumn<Cita, String> colEstado;

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(
            new PropertyValueFactory<>("codigo")
        );
        colPaciente.setCellValueFactory(
            new PropertyValueFactory<>("paciente")
        );
        colMedico.setCellValueFactory(
            new PropertyValueFactory<>("medico")
        );
        colEspecialidad.setCellValueFactory(
            new PropertyValueFactory<>("especialidad")
        );
        colFecha.setCellValueFactory(
            new PropertyValueFactory<>("fecha")
        );
        colHora.setCellValueFactory(
            new PropertyValueFactory<>("hora")
        );
        colFecha.setCellValueFactory(
            new PropertyValueFactory<>("fecha")
        );

        cargarArchivo();
    }

    @FXML
    public void guardarCitaArchivo(){
        Cita citaSeleccionada = tablaCitas.getSelectionModel().getSelectedItem();

        if (citaSeleccionada != null) {
            ArchivoUtil.guardarCita(citaSeleccionada);
            
            mostrarAlerta(Alert.AlertType.INFORMATION, "Exito", "Las citas se han guardado en el archiov");
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Atención", "Seleccione una cita de la tabla");
        }
    }

    @FXML
    public void cargarArchivo(){
        ObservableList<Cita> lista = FXCollections.observableArrayList(
            ArchivoUtil.leerListaCitas()
        );

        tablaCitas.setItems(lista);

        if (lista.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Archivo Vacio", "No hay registros de citas en el archivo");
        } 
        else {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Exito", "Las citas han sido cargadas correctamente");
        }
    }

    @FXML
    public void cancelarCita(){
        
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
