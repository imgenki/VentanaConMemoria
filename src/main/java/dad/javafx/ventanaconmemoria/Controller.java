package dad.javafx.ventanaconmemoria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Controller implements Initializable {

	private ColorModel model = new ColorModel();

	@FXML
	private VBox view;

	@FXML
	private Slider redSlider;

	@FXML
	private Slider greenSlider;

	@FXML
	private Slider blueSlider;

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		redSlider.valueProperty().bindBidirectional(model.redProperty());
		blueSlider.valueProperty().bindBidirectional(model.blueProperty());
		greenSlider.valueProperty().bindBidirectional(model.greenProperty());

		model.colorProperty().addListener((o, ov, nv) -> {
			view.setStyle("-fx-background-color: rgb(" + nv.getRed() * 256 + "," + nv.getGreen() * 256 + ", "
					+ nv.getBlue() * 256 + ");");
		});
	}

	public VBox getView() {
		return view;
	}

	public ColorModel getModel() {
		return model;
	}

}
