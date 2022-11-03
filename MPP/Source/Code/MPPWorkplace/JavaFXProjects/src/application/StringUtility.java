package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StringUtility extends Application{
	TextField txtName = new TextField();
	TextField txtStreet = new TextField();
	TextField txtCity = new TextField();
	TextField txtState = new TextField();
	TextField txtZip = new TextField();

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gridpane = new GridPane();

			gridpane.add(new Label("Name"), 1, 0); 
			gridpane.add(new Label("Street"), 3, 0); 
			gridpane.add(new Label("City"), 5, 0); 

			gridpane.add(txtName, 1, 1); 
			gridpane.add(txtStreet, 3, 1); 
			gridpane.add(txtCity, 5, 1);

			gridpane.add(new Label("State"), 2, 2); 
			gridpane.add(new Label("Zip"), 4, 2); 

			gridpane.add(txtState, 2, 3); 
			gridpane.add(txtZip, 4, 3); 

			Button btnSubmit = new Button("Submit");
			btnSubmit.setMaxWidth(120);
			btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if(txtName.getText().length() != 0 && 
							txtStreet.getText().length() != 0 && 
							txtCity.getText().length() != 0 && 
							txtState.getText().length() != 0 && 
							txtZip.getText().length() != 0)
						System.out.printf("%s\n%s\n%s, %s %s", txtName.getText(), 
								txtStreet.getText(), txtCity.getText(), txtState.getText(), 
								txtZip.getText());
				}
			});			gridpane.add(btnSubmit, 3, 4);

			Scene scene2 = new Scene(new StackPane(gridpane), 640, 480);

			primaryStage.setScene(scene2);
			primaryStage.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent t) {
					System.exit(0);
				}
			});
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
