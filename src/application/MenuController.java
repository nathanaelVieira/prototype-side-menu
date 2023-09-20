package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MenuController implements Initializable {

	private double x, y = 0;

	@FXML
	private ImageView exitImageView;

	@FXML
	private AnchorPane stageAnchorPane;

	@FXML
	private AnchorPane stageLate;

	@FXML
	ImageView exitImageView1;

	@FXML
	ImageView exitImageView11;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		actionToLeave();
		moveScreen();

		stageAnchorPane.setStyle("""
				-fx-border-color: black;
				-fx-border-width: 1.5px;
				-fx-border-style: solid;
				-fx-border-radius: 3px;
				-fx-background-color: white;
				""");

		stageLate.setStyle("""
				-fx-border-color: black;
				-fx-border-width: 1.5px;
				-fx-border-style: solid;
				-fx-border-radius: 3px;
				-fx-background-color: white;
				""");

	}

	private void moveScreen() {
		stageAnchorPane.setOnMousePressed(event -> {
			x = event.getSceneX();
			y = event.getSceneY();
		});

		stageAnchorPane.setOnMouseDragged(event -> {
			ProgramMain.getStage().setX(event.getScreenX() - x);
			ProgramMain.getStage().setY(event.getScreenY() - y);
		});
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
