package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ProgramMain extends Application {

	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.initStyle(StageStyle.UNDECORATED);
		Parent root = FXMLLoader.load(getClass().getResource("/application/Menu.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		setStage(primaryStage);
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		ProgramMain.stage = stage;
	}

}
