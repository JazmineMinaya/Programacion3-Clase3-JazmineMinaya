package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class PrincipalController {
    private final double TASA_USD = 59.00;
    private final double TASA_EUR = 64.00;

    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblMonto;

    @FXML
    private TextField txtMonto;

    @FXML
    private Label lblMonedaDestino;

    @FXML
    private ComboBox<String> cmbMonedasDestino;

    @FXML
    public void initialize() {

        cmbMonedasDestino.getItems().add("Dólar estadounidense");
        cmbMonedasDestino.getItems().add("Euro");

    }

    @FXML
    private Button btnConvertir;

    @FXML
    private Button btnLimpiar;

    @FXML
    public void convertir() {
        String monto = txtMonto.getText();
        String monedaSeleccionada = cmbMonedasDestino.getValue();

        double montoPesos;
        double resultadoConversion;
        String simboloMoneda;

        if (monto.isEmpty()) {
            lblMensaje.setText("Debe ingresar un número...");
            return;
        }

        try {
            montoPesos = Double.parseDouble(monto);
            if (montoPesos < 0) {
                lblMensaje.setText("El monto debe ser mayor o igual a 0");
                return;
            }
        } catch (NumberFormatException e) {
            lblMensaje.setText("El monto debe ser un valor numérico");
            return;
        }

        if (monedaSeleccionada == null) {
            lblMensaje.setText("Debe seleccionar una moneda destino...");
            return;
        }

        if (monedaSeleccionada.equals("Dólar estadounidense")) {
            resultadoConversion = montoPesos / TASA_USD;
            simboloMoneda = "USD";
        } 
        else {
            resultadoConversion = montoPesos / TASA_EUR;
            simboloMoneda = "EUR";
        }

        lblResultado.setText(String.format("Resultado: RD$ %,.2f equivale a %,.2f %s", montoPesos, resultadoConversion, simboloMoneda));
        lblMensaje.setText("Conversión realizada exitosamente");
    }

    @FXML
    public void limpiar() {
        txtMonto.clear();

        lblResultado.setText("Resultado:");
        lblMensaje.setText("Esperando información...");
    }

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblMensaje;
}
