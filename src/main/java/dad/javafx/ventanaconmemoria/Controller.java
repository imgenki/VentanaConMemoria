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
	private String rutaPerfil = System.getProperty("user.home");
	Color color;
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
		init();
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
		color = Color.rgb(model.redProperty().intValue(), model.greenProperty().intValue(), model.blueProperty().intValue());
		view.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	private void onGreenPropertyChange(Observable e) {
		color = Color.rgb(model.redProperty().intValue(), model.greenProperty().intValue(), model.blueProperty().intValue());
		view.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	private void onBluePropertyChange(Observable e) {
		color = Color.rgb(model.redProperty().intValue(), model.greenProperty().intValue(), model.blueProperty().intValue());
		view.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void init(){
		
        try (InputStream input = new FileInputStream(rutaPerfil + "ventana.config")) {

            Properties prop = new Properties();

            // Carga archivo de propiedades
            prop.load(input);

            model.redProperty().set(Double.parseDouble(prop.getProperty("background.red")));
            model.greenProperty().set(Double.parseDouble(prop.getProperty("background.green")));
            model.blueProperty().set(Double.parseDouble(prop.getProperty("background.blue")));
            view.prefWidthProperty().set((Double.parseDouble(prop.getProperty("size.width"))));
            view.prefHeightProperty().set((Double.parseDouble(prop.getProperty("size.height"))));
            view.layoutXProperty().set(Double.parseDouble(prop.getProperty("location.x")));
            view.layoutYProperty().set(Double.parseDouble(prop.getProperty("location.y")));

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.print("Archivo no cargado");
        }
	}
	
	public void stop() {
        try (OutputStream output = new FileOutputStream(rutaPerfil + "\\.VentanaConMemoria\\ventana.config")) {

            Properties prop = new Properties();

            prop.setProperty("background.red", model.redProperty().toString());
            prop.setProperty("background.green", model.greenProperty().toString());
            prop.setProperty("background.blue", model.blueProperty().toString());
            prop.setProperty("size.width", view.widthProperty().toString());
            prop.setProperty("size.height", view.heightProperty().toString());
            prop.setProperty("location.x", view.layoutXProperty().toString());
            prop.setProperty("location.y", view.layoutYProperty().toString());

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
            System.out.print("Archivo Guardado");
        }
	}

}
