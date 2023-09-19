package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MenuController implements Initializable {

	@FXML
	private AnchorPane TopBar;

	@FXML
	private ImageView exitImageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		exitImageView.setOnMouseClicked(event -> {
			Platform.exit();
		});

	}

}
