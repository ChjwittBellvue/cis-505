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

package Module_10.GradeBookApp;

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

}
