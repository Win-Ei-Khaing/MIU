package lesson6.labs.prob2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StringUtility extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("String Utility");

		GridPane stringUtilityPane = new GridPane();
		stringUtilityPane.setPadding(new Insets(25));
		stringUtilityPane.setHgap(20);

		VBox vbLeft = new VBox();
		vbLeft.setSpacing(20);
		stringUtilityPane.add(vbLeft, 0, 0);

		Button countLettersButton = new Button("Count Letters");
		countLettersButton.setMinWidth(150);

		vbLeft.getChildren().add(countLettersButton);

		Button reverseLettersButton = new Button("Reverse Letters");
		reverseLettersButton.setMinWidth(150);
		vbLeft.getChildren().add(reverseLettersButton);

		Button removeDuplicatesButton = new Button("Remove Duplicates");
		removeDuplicatesButton.setMinWidth(150);
		vbLeft.getChildren().add(removeDuplicatesButton);

		VBox vbRight = new VBox();
		vbRight.paddingProperty().set(new Insets(12, 0, 0, 0));
		stringUtilityPane.add(vbRight, 1, 0);

		Label inputLabel = new Label("Input");
		vbRight.getChildren().add(inputLabel);

		TextField inputField = new TextField();
		vbRight.getChildren().add(inputField);

		Label outputLabel = new Label("Output");
		vbRight.getChildren().add(outputLabel);

		TextField outputField = new TextField();
		vbRight.getChildren().add(outputField);

		countLettersButton.setOnAction(evt -> {
			String output = Integer.toString(inputField.getText().length());

			System.out.println(output);
		});

		reverseLettersButton.setOnAction(evt -> {
			char[] inputCharArray = inputField.getText().toCharArray();
			for (int i = 0; i < inputCharArray.length / 2; i++) {
				char temp = inputCharArray[i];
				inputCharArray[i] = inputCharArray[inputCharArray.length - i
						- 1];
				inputCharArray[inputCharArray.length - i - 1] = temp;
			}
			outputField.setText(String.valueOf(inputCharArray));
		});

		removeDuplicatesButton.setOnAction(evt -> {
			char[] inputCharArray = inputField.getText().toCharArray();
			for (int i = 0; i < inputCharArray.length; i++) {
				for (int j = i+1; j < inputCharArray.length; j++) {
					if(inputCharArray[i]==inputCharArray[j]){
						inputCharArray[j]='\0';
					}
				}
			}
			outputField.setText(String.valueOf(inputCharArray));
		});

		Scene scene = new Scene(stringUtilityPane, 370, 170);
		primaryStage.setScene(scene);

		primaryStage.show();
	}
}
