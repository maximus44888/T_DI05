package pujalte.martinez.juan.chinook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

public class ChinookApplication extends Application {
    public static void main(final String[] args) {
        BasicConfigurator.configure();
        launch();
    }

    @Override
    public void start(final Stage stage) throws IOException {
        final var fxmlLoader = new FXMLLoader(getClass().getResource("chinook-view.fxml"));
        final var scene = new Scene(fxmlLoader.load());
        stage.setTitle("Chinook Report");
        stage.setScene(scene);
        stage.show();
    }
}
