package calculator.ui;

import calculator.domain.Calculus;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 * Luokka vastaa graafisesta käyttöliittymästä.
 */
public class UserInterface extends Application {

    static boolean limit = false;
    static boolean dotLimit = false;
    static boolean negLimit = false;
    static boolean trigLimit = false;
    ArrayList<Button> buttons = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        Calculus calculator = new Calculus();

        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(450, 450);

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
        Button powButton = new Button("^");
        buttons.add(powButton);
        Button rootButton = new Button("root");
        buttons.add(rootButton);
        Button equalButton = new Button("=");
        buttons.add(equalButton);
        Button cButton = new Button("C");
        buttons.add(cButton);
        Button historyButton = new Button("History");
        buttons.add(historyButton);
        Button backButton = new Button("Back");
        buttons.add(backButton);
        Button eraseButton = new Button("<-");
        buttons.add(eraseButton);
        Button ansButton = new Button("ans");
        buttons.add(ansButton);
        Button dotButton = new Button(" . ");
        buttons.add(dotButton);
        Button negButton = new Button("neg");
        buttons.add(negButton);
        Button delButton = new Button("Delete");
        buttons.add(delButton);
        Button sinButton = new Button("sin");
        buttons.add(sinButton);
        Button cosButton = new Button("cos");
        buttons.add(cosButton);
        Button tanButton = new Button("tan");
        buttons.add(tanButton);

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
        grid.add(powButton, 5, 1);
        grid.add(rootButton, 5, 2);
        grid.add(equalButton, 4, 0);
        grid.add(cButton, 1, 0);
        grid.add(eraseButton, 3, 0);
        grid.add(ansButton, 2, 0);
        grid.add(dotButton, 3, 4);
        grid.add(negButton, 1, 4);
        grid.add(sinButton, 5, 3);
        grid.add(cosButton, 5, 4);
        grid.add(tanButton, 5, 5);

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
        powButton.setOnAction(e -> addStringIntoScreen(" ^ ", screen));
        rootButton.setOnAction(e -> addStringIntoScreen(" root ", screen));
        sinButton.setOnAction(e -> addTrigonometricIntoScreen("sin", screen));
        cosButton.setOnAction(e -> addTrigonometricIntoScreen("cos", screen));
        tanButton.setOnAction(e -> addTrigonometricIntoScreen("tan", screen));
        cButton.setOnAction(e -> {
            screen.setText("");
            limit = false;
            dotLimit = false;
            negLimit = false;
            trigLimit = false;
        });
        equalButton.setOnAction(e -> {
            try {
                if (!trigLimit) {
                    screen.setText(calculator.calculate(screen.getText()));
                } else {
                    screen.setText(calculator.calculateTrigonometric(screen.getText()));
                }
            } catch (Exception ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            limit = false;
            dotLimit = false;
            trigLimit = false;
        });
        ansButton.setOnAction(e -> {
            addNumberIntoScreen(calculator.getLast(), screen);
        });
        eraseButton.setOnAction(e -> removeLast(screen));
        dotButton.setOnAction(e -> addDot(screen));
        negButton.setOnAction(e -> negative(screen));

        FlowPane history = new FlowPane();
        history.getChildren().add(historyButton);
        mainLayout.setTop(top);
        mainLayout.setCenter(grid);
        mainLayout.setBottom(history);
        history.setPadding(new Insets(20, 20, 20, 20));

        Scene mainScene = new Scene(mainLayout);

        BorderPane historyLayout = new BorderPane();
        historyLayout.setPrefSize(450, 450);
        Label historyLabel = new Label();
        historyLabel.setScaleX(2);
        historyLabel.setScaleY(2);
        StackPane historyCenter = new StackPane();
        historyLayout.setCenter(historyCenter);
        historyCenter.getChildren().add(historyLabel);
        BorderPane bottom = new BorderPane();
        bottom.setLeft(backButton);
        bottom.setRight(delButton);
        bottom.setPadding(new Insets(20, 20, 20, 20));
        historyLayout.setBottom(bottom);

        Scene historyScene = new Scene(historyLayout);

        historyButton.setOnAction(e -> {
            stage.setScene(historyScene);
            try {
                historyLabel.setText(calculator.getLastItemsFromHistory());
            } catch (Exception ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        backButton.setOnAction(e -> stage.setScene(mainScene));
        delButton.setOnAction(e -> {
            historyLabel.setText("");
            try {
                calculator.deleteHistory();
            } catch (Exception ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        stage.setScene(mainScene);
        stage.setTitle("Calculator");
        stage.show();
    }

    private Label addNumberIntoScreen(String s, Label label) {
        if (label.getText().equals("error")) {
            label.setText("");
        }
        String l = label.getText();
        String lastChar = "";
        if (l.length() >= 2) {
            lastChar = String.valueOf(l.charAt(l.length() - 1));
        }
        if (lastChar.equals(")")) {
            label.setText(l.substring(0, l.length() - 1) + s + ")");
        } else {
            label.setText(label.getText() + s);
        }
        negLimit = true;
        return label;
    }

    private Label addTrigonometricIntoScreen(String s, Label label) {
        if (!limit) {
            if (s.equals("sin")) {
                label.setText("sin()");
            }
            if (s.equals("cos")) {
                label.setText("cos()");
            }
            if (s.equals("tan")) {
                label.setText("tan()");
            }
            limit = true;
            trigLimit = true;
        }

        return label;
    }

    private Label addStringIntoScreen(String s, Label label) {
        if (label.getText().equals("error")) {
            label.setText("");
        }
        if (!label.getText().equals("") && !limit) {
            label.setText(label.getText() + s);
            limit = true;
            negLimit = false;
            dotLimit = false;
        }
        return label;
    }

    private Label addDot(Label label) {
        if (label.getText().equals("error")) {
            label.setText("");
        }
        if (!dotLimit) {
            String l = label.getText();
            String lastChar = "";
            if (l.length() >= 2) {
                lastChar = String.valueOf(l.charAt(l.length() - 1));
            }
            if (lastChar.equals(")")) {
                label.setText(l.substring(0, l.length() - 1) + "." + ")");
            } else {
                label.setText(label.getText() + ".");
            }
            dotLimit = true;
        }

        return label;
    }

    private Label negative(Label label) {
        if (label.getText().equals("error")) {
            label.setText("");
        }
        if ((!negLimit || label.getText().equals("")) && !dotLimit) {
            String l = label.getText();
            String lastChar = "";
            if (l.length() >= 2) {
                lastChar = String.valueOf(l.charAt(l.length() - 1));
            }
            if (lastChar.equals(")")) {
                label.setText(l.substring(0, l.length() - 1) + "-" + ")");
            } else {
                label.setText(label.getText() + "-");
            }
            negLimit = true;
        }

        return label;
    }

    private Label removeLast(Label label) {
        if (label.getText().equals("error")) {
            label.setText("");
        }
        String s = label.getText();
        if (s.length() == 0) {
            return label;
        }

        String last = String.valueOf(s.charAt(s.length() - 1));

        if (last.equals(")")) {
            String secondLast = String.valueOf(s.charAt(s.length() - 2));
            if (secondLast.equals("(")) {
                label.setText("");
                limit = false;
                trigLimit = false;
            } else {
                if (secondLast.equals(".")) {
                    dotLimit = false;
                }
                label.setText(s.substring(0, s.length() - 2) + ")");
            }

        } else if (last.equals(" ")) {
            label.setText(s.substring(0, s.length() - 3));
            limit = false;
        } else {
            if (last.equals(".")) {
                dotLimit = false;
            }
            if (last.equals("-")) {
                negLimit = false;
            }
            label.setText(s.substring(0, s.length() - 1));
        }

        return label;
    }

}
