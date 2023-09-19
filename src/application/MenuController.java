package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MenuController implements Initializable {

	@FXML
	private ImageView exitImageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		actionToLeave();

	}

	private void actionToLeave() {
		exitImageView.setSmooth(true);
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), exitImageView);
		scaleTransition.setToX(0.8);
		scaleTransition.setToY(0.8);

		exitImageView.setOnMousePressed(event -> {
			scaleTransition.playFromStart();
		});

		exitImageView.setOnMouseReleased(event -> {
			scaleTransition.setToX(1.0);
			scaleTransition.setToY(1.0);
			scaleTransition.playFromStart();
			scaleTransition.setOnFinished(EventHandler -> Platform.exit());
		});
	}

}
