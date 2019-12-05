package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imgButtonHome;

    @FXML
    void initialize() {
        assert imgButtonHome != null : "fx:id=\"imgButtonHome\" was not injected: check your FXML file 'app.fxml'.";

    }
}
