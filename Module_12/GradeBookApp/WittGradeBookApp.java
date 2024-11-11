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

package Module_12.GradeBookApp;

import java.io.IOException;
import java.util.ArrayList;

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
import javafx.stage.Stage;

public class WittGradeBookApp extends Application {

    // Attributes
    // Text Fields
    private TextField txtFirstName = new TextField();
    private TextField txtLastName = new TextField();
    private TextField txtCourse = new TextField();

    // Text Area
    private TextArea txtResults = new TextArea();

    // Labels
    private Label lblFirstName = new Label("First Name:");
    private Label lblLastName = new Label("Last Name:");
    private Label lblCourse = new Label("Course:");
    private Label lblGrade = new Label("Grade:");

    // Value list for combo box
    private ObservableList<String> options = FXCollections.observableArrayList("A", "B", "C", "D", "F");

    // Combo Box
    private ComboBox<String> cbGrade = new ComboBox<String>(options);

    // Buttons
    private Button btnViewGrades = new Button("View Grades");
    private Button btnSaveGrade = new Button("Save Grade");
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
        gridPane.add(lblFirstName, 0, 0);
        GridPane.setHalignment(lblFirstName, HPos.LEFT);

        gridPane.add(lblLastName, 0, 1);
        GridPane.setHalignment(lblLastName, HPos.LEFT);

        gridPane.add(lblCourse, 0, 2);
        GridPane.setHalignment(lblCourse, HPos.RIGHT);

        gridPane.add(lblGrade, 0, 3);
        GridPane.setHalignment(lblGrade, HPos.LEFT);

        // Add Text Boxes
        gridPane.add(txtFirstName, 1, 0);
        GridPane.setHalignment(txtFirstName, HPos.RIGHT);

        gridPane.add(txtLastName, 1, 1);
        GridPane.setHalignment(txtLastName, HPos.RIGHT);

        gridPane.add(txtCourse, 1, 2);
        GridPane.setHalignment(txtCourse, HPos.RIGHT);

        // Add Combo Box
        cbGrade.setMinWidth(200);
        gridPane.add(cbGrade, 1, 3);
        GridPane.setHalignment(cbGrade, HPos.LEFT);

        // Set button commands
        btnClear.setOnAction(e -> clearFormFields());
        btnViewGrades.setOnAction(e -> {
            try {
                viewGrades();
            } catch (IOException e1) {
                txtResults.setText("  Error occurred while reading grades file, unable to complete operation.");
            }
        });
        btnSaveGrade.setOnAction(e -> {
            try {
                saveGrade();
            } catch (IOException e1) {
                txtResults.setText("  Error occurred while writing to grades file, unable to complete operation.");
            }
        });

        // Set up button container and add it to the gridPane
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnViewGrades);
        actionBtnContainer.getChildren().add(btnSaveGrade);
        gridPane.add(actionBtnContainer, 1, 4);

        // Add second container for the text area
        HBox txtBox = new HBox();
        txtBox.setPadding(new Insets(15, 0, 15, 30));
        txtBox.setSpacing(10);
        txtResults.setEditable(false);
        txtBox.getChildren().add(txtResults);

        // Add the textBox container to the gridPane
        gridPane.add(txtBox, 0, 6, 2, 1);
        GridPane.setHalignment(txtBox, HPos.LEFT);

        // Set the scene in the Stage and update the Title
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Witt Grade Book App");
        primaryStage.sizeToScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end start

    /**
     * Clears user input from UI
     */
    private void clearFormFields() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtResults.setText("");
        txtCourse.setText("");
        cbGrade.setValue(null);
    }

    /**
     * Displays students in grades.csv
     * 
     * @throws IOException
     */
    private void viewGrades() throws IOException {
        // Call IO class to get students
        ArrayList<Student> students = StudentIO.findAll();

        // If there are valid students in the file
        if (!students.isEmpty()) {
            // Line to indicate everything that follows are grade objects
            txtResults.setText("  Grades: " + System.lineSeparator() + System.lineSeparator());

            // Cycle through the students and append the results
            for (Student student : students) {
                txtResults.appendText(student.toString() + System.lineSeparator());
            }
        } else { // If no student is found or the file does not exist yet
            txtResults.setText("  No grades found.");
        }
    }

    /**
     * Saves a grade to the grades file
     * 
     * @throws IOException
     */
    private void saveGrade() throws IOException {
        // Validate fields first for valid content
        if (validateFields()) {
            // If content is good, create a student object and insert it into the file,
            // trimming Strings to reduce whitespace
            Student student = new Student(txtFirstName.getText().trim(), txtLastName.getText().trim(),
                    txtCourse.getText().trim(),
                    cbGrade.getValue());
            StudentIO.insert(student);

            // Clear the form for the next addition and set a message for the user
            clearFormFields();
            txtResults.setText("  Grade added.");
        }
    }

    /**
     * Method to validate each field
     * 
     * @return boolean - valid input
     */
    private boolean validateFields() {
        // Default value to true, flip to false if something is invalid
        boolean fieldsValid = true;

        // First name validation
        // NOTE: using if statements rather than if/else so that all errors are
        // displayed at once to the results block
        if (txtFirstName.getText() == null || txtFirstName.getText().trim() == "") {
            appendErrorsToTxtResults("   Please add a valid first name.", fieldsValid);
            fieldsValid = false;
        }
        // Last name validation
        if (txtLastName.getText() == null || txtLastName.getText().trim() == "") {
            appendErrorsToTxtResults("   Please add a valid last name.", fieldsValid);
            fieldsValid = false;
        }
        // Course validation
        if (txtCourse.getText() == null || txtCourse.getText().trim() == "") {
            appendErrorsToTxtResults("   Please add a valid course.", fieldsValid);
            fieldsValid = false;
        }
        // Grade validation
        if (cbGrade.getValue() == null) {
            appendErrorsToTxtResults("   Please set a grade.", fieldsValid);
            fieldsValid = false;
        }

        // Validate there are no commas in the
        fieldsValid = verifyNoCommas(fieldsValid);

        return fieldsValid;
    }

    /**
     * Checks for commas in fields, if they are included they will break the csv
     * 
     * @param fieldsValid
     * @return boolean - valid fields
     */
    private boolean verifyNoCommas(boolean fieldsValid) {
        // Checks for commas in each text field
        if (txtFirstName.getText().contains(",") || txtLastName.getText().contains(",")
                || txtCourse.getText().contains(",")) {
            appendErrorsToTxtResults("   Commas are not allowed in text fields.", fieldsValid);
            return false;
        }
        return fieldsValid;
    }

    /**
     * Appends error messages to the results field
     * 
     * @param message      - Error message text
     * @param firstMessage - Boolean indicating if this is the first error message
     * 
     */
    private void appendErrorsToTxtResults(String message, boolean firstMessage) {
        // If this is the first error, reset the results area and indicate an error
        if (firstMessage) {
            txtResults.setText("  ERROR: " + System.lineSeparator());
            txtResults.appendText(message + System.lineSeparator());
        } else { // If this is not the first error, append the new error to the list
            txtResults.appendText(message + System.lineSeparator());
        }
    }
}
