import java.lang.*; // Double.
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CelsiusConverter extends Application {
	Label messageLbl = new Label("Farenheit: ");

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		// Celsius input field
		TextField celsiusFld = new TextField();
		// // Set field width
		celsiusFld.setPrefColumnCount(10);

		// Allow only numerics
		// https://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
		celsiusFld.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					celsiusFld.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		
		// Convert button
		Button convertBtn = new Button("_Convert");
		convertBtn.setDefaultButton(true);
		convertBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				Double f = (Double.valueOf(celsiusFld.getText()) * 9/5) + 32.0;
				printMessage("Farenheit: " + f.toString() + " Degrees");
			}
		});
			
		// GridPane root = new GridPane();
		// root.setHgap(10);
		// root.setVgap(10);
		
		// root.addRow(0, new Label("Celsius"), celsiusFld);
		// root.addRow(2, messageLbl);
		// root.addRow(3, convertBtn);
		// root.setMinSize(300, 100);

		// Create a HBox
		HBox labelFieldButtonBox = new HBox();
		// Add the children to the HBox
		labelFieldButtonBox.getChildren().addAll(new Label("Celsius"), celsiusFld, convertBtn);
		// Set the spacing between children to 10px
		labelFieldButtonBox.setSpacing(10);

		
		// Create the VBox
		VBox root = new VBox();
		// Add the children to the VBox
		root.getChildren().addAll(labelFieldButtonBox, messageLbl);
		
		// Set the vertical spacing between children to 15px
		root.setSpacing(15);
		root.setMinSize(300, 100);

		/* 
		 * Set the padding of the VBox
		 * Set the border-style of the VBox
		 * Set the border-width of the VBox
		 * Set the border-insets of the VBox
		 * Set the border-radius of the VBox
		 * Set the border-color of the VBox
		*/
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Celsius to Farenheit Converter");
		stage.show();
	}

	// Helper
	
	public void printMessage(String message) {
		messageLbl.setText(message);
	}
}