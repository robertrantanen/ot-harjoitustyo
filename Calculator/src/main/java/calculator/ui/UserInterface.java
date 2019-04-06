package calculator.ui;

import calculator.domain.Calculus;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UserInterface extends Application {

    static boolean limit = false;
    ArrayList<Button> buttons = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        Calculus calculator = new Calculus();

        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(400, 400);

        Label screen = new Label("");

        screen.setScaleX(2);
        screen.setScaleY(2);

        StackPane top = new StackPane();
        top.getChildren().add(screen);
        top.setPrefHeight(100);

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Button button1 = new Button("1");
        buttons.add(button1);
        Button button2 = new Button("2");
        buttons.add(button2);
        Button button3 = new Button("3");
        buttons.add(button3);
        Button button4 = new Button("4");
        buttons.add(button4);
        Button button5 = new Button("5");
        buttons.add(button5);
        Button button6 = new Button("6");
        buttons.add(button6);
        Button button7 = new Button("7");
        buttons.add(button7);
        Button button8 = new Button("8");
        buttons.add(button8);
        Button button9 = new Button("9");
        buttons.add(button9);
        Button button0 = new Button("0");
        buttons.add(button0);
        Button plusButton = new Button("+");
        buttons.add(plusButton);
        Button minusButton = new Button("-");
        buttons.add(minusButton);
        Button multiButton = new Button("*");
        buttons.add(multiButton);
        Button divButton = new Button("/");
        buttons.add(divButton);
        Button equalButton = new Button("=");
        buttons.add(equalButton);
        Button cButton = new Button("C");
        buttons.add(cButton);
        Button historyButton = new Button("History");
        buttons.add(historyButton);
        Button backButton = new Button("Back");
        buttons.add(backButton);
        
        for (Button button : buttons) {
            button.setScaleX(1.5);
            button.setScaleY(1.5);
        }

        grid.add(button7, 1, 1);
        grid.add(button8, 2, 1);
        grid.add(button9, 3, 1);
        grid.add(button4, 1, 2);
        grid.add(button5, 2, 2);
        grid.add(button6, 3, 2);
        grid.add(button1, 1, 3);
        grid.add(button2, 2, 3);
        grid.add(button3, 3, 3);
        grid.add(button0, 2, 4);
        grid.add(plusButton, 4, 1);
        grid.add(minusButton, 4, 2);
        grid.add(multiButton, 4, 3);
        grid.add(divButton, 4, 4);
        grid.add(equalButton, 4, 0);
        grid.add(cButton, 0, 0);

        button1.setOnAction(e -> addNumberIntoScreen("1", screen));
        button2.setOnAction(e -> addNumberIntoScreen("2", screen));
        button3.setOnAction(e -> addNumberIntoScreen("3", screen));
        button4.setOnAction(e -> addNumberIntoScreen("4", screen));
        button5.setOnAction(e -> addNumberIntoScreen("5", screen));
        button6.setOnAction(e -> addNumberIntoScreen("6", screen));
        button7.setOnAction(e -> addNumberIntoScreen("7", screen));
        button8.setOnAction(e -> addNumberIntoScreen("8", screen));
        button9.setOnAction(e -> addNumberIntoScreen("9", screen));
        button0.setOnAction(e -> addNumberIntoScreen("0", screen));
        plusButton.setOnAction(e -> addStringIntoScreen(" + ", screen));
        minusButton.setOnAction(e -> addStringIntoScreen(" - ", screen));
        multiButton.setOnAction(e -> addStringIntoScreen(" * ", screen));
        divButton.setOnAction(e -> addStringIntoScreen(" / ", screen));
        cButton.setOnAction(e -> {
            screen.setText("");
            limit = false;
        });
        equalButton.setOnAction(e -> {
            screen.setText(calculator.calculate(screen.getText()));
            limit = false;
        });

        FlowPane history = new FlowPane();
        history.getChildren().add(historyButton);
        mainLayout.setTop(top);
        mainLayout.setCenter(grid);
        mainLayout.setBottom(history);
        history.setPadding(new Insets(20, 20, 20, 20));

        Scene mainScene = new Scene(mainLayout);

        BorderPane historyLayout = new BorderPane();
        historyLayout.setPrefSize(400, 400);
        Label historyLabel = new Label();
        historyLabel.setScaleX(2);
        historyLabel.setScaleY(2);
        StackPane historyCenter = new StackPane();
        historyLayout.setCenter(historyCenter);
        historyCenter.getChildren().add(historyLabel);
        FlowPane back = new FlowPane();
        back.getChildren().add(backButton);
        back.setPadding(new Insets(20, 20, 20, 20));
        historyLayout.setBottom(back);

        Scene historyScene = new Scene(historyLayout);

        historyButton.setOnAction(e -> {
            stage.setScene(historyScene);
            historyLabel.setText(calculator.getLastItemsFromHistoryList());
                });
        backButton.setOnAction(e -> stage.setScene(mainScene));

        stage.setScene(mainScene);
        stage.setTitle("Calculator");
        stage.show();
    }

    public Label addNumberIntoScreen(String s, Label label) {
        if (label.getText().equals("error")) {
            label.setText("");
        }
        label.setText(label.getText() + s);
        return label;
    }

    public Label addStringIntoScreen(String s, Label label) {
        if (label.getText().equals("error")) {
            label.setText("");
        }
        if (!label.getText().equals("") && !limit) {
            label.setText(label.getText() + s);
            limit = true;
        }
        return label;
    }

}
