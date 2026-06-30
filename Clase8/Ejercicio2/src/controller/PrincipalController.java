package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;

public class PrincipalController {
    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<String> cmbBebida;

    @FXML
    public void initialize() {
        cmbBebida.getItems().addAll("Café americano - RD$100", "Cappuccino - RD$150", "Chocolate caliente - RD$130", "Jugo natural - RD$120");
    }

    @FXML
    private TextField cantidad;

    @FXML
    private CheckBox postre;

    @FXML
    private Button btnCalcular;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label resumenCompra;

    @FXML
    private Label mensajeSoporte;
}
