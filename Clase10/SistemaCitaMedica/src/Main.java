import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader (
            getClass().getResource("/view/registro_cita.fxml")
        );

        Scene scene = new Scene(loader.load());

        stage.setTitle("Sistema de Registro de Paquetes");
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(675);
        stage.show();
    }
}
