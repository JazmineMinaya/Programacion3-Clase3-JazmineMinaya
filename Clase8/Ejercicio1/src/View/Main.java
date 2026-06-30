package View;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Principal.fxml"));

        Scene scene = new Scene(loader.load(), 400, 400);

        // scene.getStylesheets().add(getClass().getResource("/styles/estilos.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Conversor de Monedas");
        stage.show();
    }
}
