package dad.javafx.ventanaconmemoria;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;

public class ColorModel {
	private DoubleProperty red;
	private DoubleProperty green;
	private DoubleProperty blue;
	private ReadOnlyObjectWrapper<Color> color;

	public ColorModel() {
		red = new SimpleDoubleProperty();
		green = new SimpleDoubleProperty();
		blue = new SimpleDoubleProperty();
		color = new ReadOnlyObjectWrapper<Color>();
		color.bind(Bindings.createObjectBinding(() -> {
			return new Color(getRed() / 256.0, getGreen() / 256.0, getBlue() / 256.0, 1f);
		}, red, green, blue));
	}

	public final DoubleProperty redProperty() {
		return this.red;
	}

	public final double getRed() {
		return this.redProperty().get();
	}

	public final void setRed(final double red) {
		this.redProperty().set(red);
	}

	public final DoubleProperty greenProperty() {
		return this.green;
	}

	public final double getGreen() {
		return this.greenProperty().get();
	}

	public final void setGreen(final double green) {
		this.greenProperty().set(green);
	}

	public final DoubleProperty blueProperty() {
		return this.blue;
	}

	public final double getBlue() {
		return this.blueProperty().get();
	}

	public final void setBlue(final double blue) {
		this.blueProperty().set(blue);
	}

	public final javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.paint.Color> colorProperty() {
		return this.color.getReadOnlyProperty();
	}

	public final Color getColor() {
		return this.colorProperty().get();
	}

}
