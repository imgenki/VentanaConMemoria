package dad.javafx.ventanaconmemoria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private Controller controller;
	private Config config = new Config();

	public void init() {
		config.cargarFichero();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new Controller();
		controller.getModel().redProperty().bindBidirectional(config.redProperty());
		controller.getModel().greenProperty().bindBidirectional(config.greenProperty());
		controller.getModel().blueProperty().bindBidirectional(config.blueProperty());

		// Bindeo y set de la localizacion de la ventana en la pantalla
		primaryStage.setX(config.getLocationX());
		primaryStage.setY(config.getLocationY());

		config.locationXProperty().bind(primaryStage.xProperty());
		config.locationYProperty().bind(primaryStage.yProperty());

		// Creacion de la escena de la ventana y bindeo de su tama�o
		Scene scene = new Scene(controller.getView(), config.getWidth(), config.getHeight());

		config.heightProperty().bind(scene.heightProperty());
		config.widthProperty().bind(scene.widthProperty());

		primaryStage.setTitle("Ventana con Memoria");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void stop() {

		config.guardarFichero();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
