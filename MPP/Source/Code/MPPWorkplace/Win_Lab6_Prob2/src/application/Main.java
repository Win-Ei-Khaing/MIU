package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;

/**
 * 
 * @author wineikhaing
 *
 */

public class Main extends Application {
	TextField txtInput = new TextField();
	@FXML
	TextField txtOutput = new TextField();
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gridpane = new GridPane();
			Button btnCount = new Button("Count Letters");
			btnCount.setMaxWidth(140);
			btnCount.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println(txtInput.getText().length());
					String lenStr = txtInput.getText().length() + "";
					txtOutput.setText(lenStr);
				}
			});		
			gridpane.add(btnCount, 1, 0);

			Button btnReverse = new Button("Reverse Letters");
			btnReverse.setMaxWidth(140);
			btnReverse.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String reversedStr="";
					String input = txtInput.getText();
					for(int i = input.length()-1; i >= 0; i--) {
						reversedStr += input.charAt(i);
					}
					System.out.println(reversedStr);
					txtOutput.setText(reversedStr);
				}
			});		
			gridpane.add(btnReverse, 1, 2);

			Button btnRemove = new Button("Remove Duplicates");
			btnRemove.setMaxWidth(140);
			btnRemove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String input = txtInput.getText();
					List<Character> chars = new ArrayList<>();
					for (char ch : input.toCharArray()) {
						chars.add(ch);
					}

					String clearStr="";

					for(Character c : chars) {
						//System.out.println(clearStr+"____"+clearStr.indexOf(c) + "__finding "+c);
						if(clearStr.indexOf(c) < 0)
							clearStr+= c;
					}
					System.out.println(clearStr);
					txtOutput.setText(clearStr);
				}
			});		
			gridpane.add(btnRemove, 1, 4);

			gridpane.add(txtInput, 2, 1);
			gridpane.add(txtOutput, 2, 3);

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
