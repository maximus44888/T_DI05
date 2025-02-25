package pujalte.martinez.juan.chinook;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;

public class ChinookController {

    @FXML
    protected Button close;

    @FXML
    protected void onArtist() throws IOException {
        final var fxmlLoader = new FXMLLoader(getClass().getResource("artist-view.fxml"));
        final var scene = new Scene(fxmlLoader.load());
        final var stage = new Stage();
        stage.setTitle("Selección de artista");
        stage.setScene(scene);
        stage.initOwner(close.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();
    }

    @FXML
    protected void onClients() {
        try {
            Utils.viewReport(
                    getClass().getResourceAsStream("Clients.jrxml"),
                    Utils.connection.get(),
                    null,
                    false
            );
        } catch (final JRException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
    }

    @FXML
    protected void onClose() {
        close.getScene().getWindow().hide();
        Platform.exit();
        System.exit(0);
    }
}
