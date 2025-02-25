package pujalte.martinez.juan.chinook;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Map;

public class ChinookController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        try {
            Utils.viewReport(
                    getClass().getResourceAsStream("Clients.jrxml"),
                    "jdbc:sqlite:chinook.db",
                    null,
                    false
            );
            Utils.viewReport(
                    getClass().getResourceAsStream("Artist_tracks_per_album.jrxml"),
                    "jdbc:sqlite:chinook.db",
                    Map.of("ArtistId", 1),
                    false
            );
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
