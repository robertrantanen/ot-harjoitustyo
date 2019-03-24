package calculator.ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class UserInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane layout = new BorderPane();
        layout.setPrefSize(400, 400);

        Label screen = new Label("screen");

        screen.setScaleX(2);
        screen.setScaleY(2);

        StackPane top = new StackPane();
        top.getChildren().add(screen);
        top.setPrefHeight(100);

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button button0 = new Button("0");

        grid.add(button7, 0, 0);
        grid.add(button8, 1, 0);
        grid.add(button9, 2, 0);
        grid.add(button4, 0, 1);
        grid.add(button5, 1, 1);
        grid.add(button6, 2, 1);
        grid.add(button1, 0, 2);
        grid.add(button2, 1, 2);
        grid.add(button3, 2, 2);
        grid.add(button0, 1, 3);

        layout.setTop(top);
        layout.setCenter(grid);

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

}
