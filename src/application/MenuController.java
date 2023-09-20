package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
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
	private ImageView exitImageView1;

	@FXML
	private ImageView exitImageView11;

	@FXML
	private AnchorPane pane1, pane2;

	@FXML
	private ImageView menu;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		pane1.setVisible(false);

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), pane1);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		TranslateTransition transition = new TranslateTransition(Duration.millis(500), pane2);
		transition.setByX(-600);
		transition.play();

		menu.setOnMouseClicked(event -> {
			pane1.setVisible(true);

			if (pane2.getTranslateX() == -600) {
				FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(500), pane1);
				fadeTransition.setFromValue(0);
				fadeTransition.setToValue(0.15);
				fadeTransition.play();

				TranslateTransition transition1 = new TranslateTransition(Duration.millis(500), pane2);
				transition.setByX(+600);
				transition.play();
			}

		});

		pane1.setOnMouseClicked(event -> {
			FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(500), pane1);
			fadeTransition.setFromValue(0.15);
			fadeTransition.setToValue(0);
			fadeTransition.play();

			fadeTransition.setOnFinished(events -> {
				pane1.setVisible(false);
			});

			TranslateTransition transition1 = new TranslateTransition(Duration.millis(500), pane2);
			transition.setByX(-600);
			transition.play();
		});

		actionToLeave();
		moveScreen();
		styleInitial();
	}

	private void styleInitial() {
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

		pane2.setStyle("""
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
