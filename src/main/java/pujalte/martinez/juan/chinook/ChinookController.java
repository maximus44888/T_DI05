package pujalte.martinez.juan.chinook;

import javafx.application.Platform;
import javafx.fxml.FXML;

import java.util.Map;

public class ChinookController {

    @FXML
    protected void onArtist() {
        try {
            Utils.viewReport(
                    getClass().getResourceAsStream("Artist_tracks_per_album.jrxml"),
                    "jdbc:sqlite:chinook.db",
                    Map.of("ArtistId", 1),
                    false
            );
        } catch (final Exception e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
    }

    @FXML
    protected void onClients() {
        try {
            Utils.viewReport(
                    getClass().getResourceAsStream("Clients.jrxml"),
                    "jdbc:sqlite:chinook.db",
                    null,
                    false
            );
        } catch (final Exception e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
    }

    @FXML
    protected void onClose() {
        Platform.exit();
        System.exit(0);
    }
}
