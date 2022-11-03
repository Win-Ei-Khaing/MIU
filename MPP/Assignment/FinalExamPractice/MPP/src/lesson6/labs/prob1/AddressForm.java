package lesson6.labs.prob1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddressForm extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Address Form");

		GridPane  addressFormPane= new GridPane();
		
		HBox hbRow1=new HBox();
		hbRow1.paddingProperty().set(new Insets(25,25,25,40));
		addressFormPane.add(hbRow1,0,0);
		
		VBox vbName= new VBox();
		Label nameLabel = new Label("Name");
		vbName.getChildren().add(nameLabel);

        TextField nameField = new TextField();
        vbName.getChildren().add(nameField);
		
        hbRow1.getChildren().add(vbName);
        
        VBox vbStreet= new VBox();
        vbStreet.paddingProperty().set(new Insets(0,0,0,40));
		Label streetLabel = new Label("Street");
		vbStreet.getChildren().add(streetLabel);
        
        TextField streetField = new TextField();
        vbStreet.getChildren().add(streetField);
        hbRow1.getChildren().add(vbStreet);
		
        VBox vbCity= new VBox();
        vbCity.paddingProperty().set(new Insets(0,0,0,40));
		Label cityLabel = new Label("City");
		vbCity.getChildren().add(cityLabel);
        
        TextField cityField = new TextField();
        vbCity.getChildren().add(cityField);
        hbRow1.getChildren().add(vbCity);

		HBox hbRow2=new HBox();
		hbRow2.paddingProperty().set(new Insets(0,25,25,130));
		addressFormPane.add(hbRow2,0,1);
		
		VBox vbState= new VBox();
		Label stateLabel = new Label("State");
		vbState.getChildren().add(stateLabel);
        
        TextField stateField = new TextField();
        vbState.getChildren().add(stateField);
        hbRow2.getChildren().add(vbState);
		
		VBox vbZip= new VBox();
		vbZip.paddingProperty().set(new Insets(0,0,0,40));
		Label zipLabel = new Label("Zip");
		vbZip.getChildren().add(zipLabel);
        
        TextField zipField = new TextField();
        vbZip.getChildren().add(zipField);
        hbRow2.getChildren().add(vbZip);
        
        HBox hbRow3=new HBox();
        hbRow3.paddingProperty().set(new Insets(0,25,25,270));
        addressFormPane.add(hbRow3,0,3);
		
		Button submitButton = new Button("Submit");
		hbRow3.getChildren().add(submitButton);
		
		submitButton.setOnAction(evt -> {
			String n = System.getProperty("line.separator");
			String output = nameField.getText() + n + streetField.getText() + n + cityField.getText() + ", " + stateField.getText() + " "
					+ zipField.getText();  
			
			System.out.println(output);
        });
		
		Scene scene = new Scene(addressFormPane, 610, 200);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

}
