package pujalte.martinez.juan.chinook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.Map;

public class ArtistController {

    @FXML
    protected Button generateReport;
    @FXML
    protected ListView<Artist> listView;

    @FXML
    private void initialize() {
        generateReport.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNull());
        listView.setItems(getAllArtists());
    }

    private ObservableList<Artist> getAllArtists() {
        final var artists = FXCollections.<Artist>observableArrayList();
        try (final var connection = Utils.connection.get()) {
            final var resultSet = connection.createStatement().executeQuery("SELECT ArtistId, Name FROM artists");
            while (resultSet.next()) {
                artists.add(new Artist(resultSet.getInt("ArtistId"), resultSet.getString("Name")));
            }
        } catch (final Exception e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        return artists;
    }

    public void onArtistTrack() {
        final var artist = listView.getSelectionModel().getSelectedItem();
        if (artist == null) return;
        try {
            Utils.viewReport(
                    getClass().getResourceAsStream("Artist_tracks_per_album.jrxml"),
                    Utils.connection.get(),
                    Map.of("ArtistId", artist.id),
                    false
            );
        } catch (final Exception e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
    }

    public record Artist(int id, String name) {
    }
}
