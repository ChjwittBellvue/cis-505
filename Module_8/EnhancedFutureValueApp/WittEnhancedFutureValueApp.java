/*
 *  REFERENCES
 * 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
 * Comprehensive Version (12th ed.). Pearson Education, Inc.
 * 
 * Oracle (2013, September 1). Using JavaFX UI Controls - Combo Box. Retrieved September 29, 2024, from https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
 * 
 * Payne, D. (2021). CSD 405 Intermediate Java Programming. Bellevue University.
 * Modified by Witt, C. 2024
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_8.EnhancedFutureValueApp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WittEnhancedFutureValueApp extends Application {

    // Attributes
    // Text Fields
    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();

    // Text Area
    private TextArea txtResults = new TextArea();

    // Labels
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.11% as 11.1");
    private Label lblYears = new Label("Years: ");
    private Label lblFutureValueDate = new Label("");

    // Value list for combo box
    private ObservableList<Integer> options = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5);

    // Combo Box
    private ComboBox<Integer> cbYears = new ComboBox<Integer>(options);

    // Buttons
    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button("Clear");

    /**
     * Added main method for JavaFX, it wouldn't start on my machine after I
     * restarted, this was more consistent
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method to run program
     */
    @Override
    public void start(Stage primaryStage) {

        // Create Grid pane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);

        // Add labels
        gridPane.add(lblMonthlyPayment, 0, 0);
        GridPane.setHalignment(lblMonthlyPayment, HPos.LEFT);

        gridPane.add(lblInterestRate, 0, 1);
        GridPane.setHalignment(lblInterestRate, HPos.LEFT);

        lblInterestRateFormat.setTextFill(Color.RED);
        gridPane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        gridPane.add(lblYears, 0, 3);
        GridPane.setHalignment(lblYears, HPos.LEFT);

        // Add Text Boxes
        gridPane.add(txtInterestRate, 1, 1);
        GridPane.setHalignment(txtInterestRate, HPos.RIGHT);

        gridPane.add(txtMonthlyPayment, 1, 0);
        GridPane.setHalignment(txtMonthlyPayment, HPos.RIGHT);

        // Add Combo Box
        cbYears.setMinWidth(200);
        gridPane.add(cbYears, 1, 3);
        GridPane.setHalignment(cbYears, HPos.LEFT);

        // Set button commands
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

        // Set up button container and add it to the gridPane
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);
        gridPane.add(actionBtnContainer, 1, 4);

        // Add future date label to grid
        gridPane.add(lblFutureValueDate, 0, 5, 2, 1);

        // Add second container for the text area
        HBox txtBox = new HBox();
        txtBox.setPadding(new Insets(15, 0, 15, 30));
        txtBox.setSpacing(10);
        txtBox.getChildren().add(txtResults);

        // Add the textBox container to the gridPane
        gridPane.add(txtBox, 0, 6, 2, 1);
        GridPane.setHalignment(txtBox, HPos.LEFT);

        // Set the scene in the Stage and update the Title
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Witt Future Value App");
        primaryStage.sizeToScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end start

    /**
     * Clears user input from UI
     */
    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        lblFutureValueDate.setText("");
        cbYears.setValue(0);

    }

    /**
     * Returns future value results based on user input
     */
    private void calculateResults() {
        // Check that the boxes include only numbers
        try {
            // Gather values based on user input
            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
            double interestRate = Double.parseDouble(txtInterestRate.getText());
            int years = cbYears.getValue();

            // Call FinanceCalculator to get future value
            Double futureValue = FinanceCalculator.calculateFutureValue(monthlyPayment, interestRate, years);

            // Format the date for lblFutureValueDate and display it
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String todaysDate = dateFormat.format(new Date());

            lblFutureValueDate.setText("Calculation as of " + todaysDate);

            // Format the final future value and display it
            String formattedFutureValue = String.format("$%,6.2f", futureValue);
            txtResults.setText("The future value is " + formattedFutureValue);
        } catch (NumberFormatException e) { // If the user inputs something other than a number
            txtResults.setText("Please enter only numbers or decimals in the text boxes");
        }

    }

}
