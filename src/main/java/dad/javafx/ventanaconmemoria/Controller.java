package dad.javafx.ventanaconmemoria;

import java.io.IOException;
import java.net.URL;
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
	
	// view
	
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
		model.redProperty().bindBidirectional(redSlider.valueProperty());
		model.greenProperty().bindBidirectional(greenSlider.valueProperty());
		model.blueProperty().bindBidirectional(blueSlider.valueProperty());
		
		model.redProperty().addListener(e -> onRedPropertyChange(e));
		model.greenProperty().addListener(e -> onGreenPropertyChange(e));
		model.blueProperty().addListener(e -> onBluePropertyChange(e));
	}
	
	public VBox getView() {
		return view;
	}
	
	private void onRedPropertyChange(Observable e) {
		Color color = Color.rgb(model.redProperty().intValue(), model.greenProperty().intValue(), model.blueProperty().intValue());
		view.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	private void onGreenPropertyChange(Observable e) {
		Color color = Color.rgb(model.redProperty().intValue(), model.greenProperty().intValue(), model.blueProperty().intValue());
		view.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	private void onBluePropertyChange(Observable e) {
		Color color = Color.rgb(model.redProperty().intValue(), model.greenProperty().intValue(), model.blueProperty().intValue());
		view.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}

}
