package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;

public class PrincipalController {
    private final double PRECIO_POSTRE = 75;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtCliente;

    @FXML
    private ComboBox<String> cmbBebida;

    @FXML
    public void initialize() {
        cmbBebida.getItems().addAll("Café americano - RD$100", "Cappuccino - RD$150", "Chocolate caliente - RD$130", "Jugo natural - RD$120");
    }

    @FXML
    private TextField txtCantidad;

    @FXML
    private CheckBox chkPostre;

    @FXML
    private Button btnCalcular;

    @FXML
    private Button btnLimpiar;

    @FXML
    public void calcular() {
        String cliente = txtCliente.getText();
        String cantidad = txtCantidad.getText();
        String bebidaSeleccionada = cmbBebida.getValue();

        int cantidadNumero;
        int precioBebida = 0;
        String nombreBebida = "";

        if(cliente.isEmpty()) {
            lblMensajeSoporte.setText("Debe ingresar un cliente...");
            return;
        }

        if (cantidad.isEmpty()) {
            lblMensajeSoporte.setText("Debe ingresar una cantidad...");
            return;
        }

        try {
            cantidadNumero = Integer.parseInt(cantidad);
            
            if (cantidadNumero <= 0) {
                lblMensajeSoporte.setText("La cantidad debe ser mayor que cero");
                return;
            }
        }
        catch (NumberFormatException e) {
            lblMensajeSoporte.setText("La cantidad debe ser un valor numérico");
            return;
        }

        if (bebidaSeleccionada == null) {
            lblMensajeSoporte.setText("Debe seleccionar una bebida...");
            return;
        }

        if (bebidaSeleccionada.contains("Café americano")) {
            precioBebida = 100;
            nombreBebida = "Café americano";
        } else if (bebidaSeleccionada.contains("Cappuccino")) {
            precioBebida = 150;
            nombreBebida = "Cappuccino";
        } else if (bebidaSeleccionada.contains("Chocolate caliente")) {
            precioBebida = 130;
            nombreBebida = "Chocolate caliente";
        } else if (bebidaSeleccionada.contains("Jugo natural")) {
            precioBebida = 120;
            nombreBebida = "Jugo natural";
        }

        int subtotal = precioBebida * cantidadNumero;
        int total = subtotal;
        boolean postre = false;

        if (chkPostre.isSelected()) {
            total += PRECIO_POSTRE;
            postre = true;
        }

        lblMensajeSoporte.setText("Compra realizada exitosamente...");
        
        lblResumenCompra.setText(String.format("Resumen:\n" + "Cliente: %s\n" + "Producto: %s\n" + "Cantidad: %s\n" + "Subtotal: RD$ %,.2f\n" +
            "Postre: %s\n" + "Total: RD$ %,.2f", cliente, nombreBebida, cantidadNumero, subtotal, postre, total));

    }

    @FXML
    public void limpiar() {
        txtCliente.clear();
        txtCantidad.clear();

        lblResumenCompra.setText("Resumen:");
        lblMensajeSoporte.setText("Esperando datos de la compra...");
    }

    @FXML
    private Label lblResumenCompra;

    @FXML
    private Label lblMensajeSoporte;
}
