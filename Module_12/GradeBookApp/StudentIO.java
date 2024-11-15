/*
 *  REFERENCES
 * 
 * Pankaj (2022, October 24). Java SimpleDateFormat - Java Date Format. Retrieved September 14, 2024, 
 * from https://www.digitalocean.com/community/tutorials/java-simpledateformat-java-date-format
 * 
 * (2020, October 26). Next() does't allow "white space" and nextLine() skips "sodaType" all together. StackOverflow. 
 * Retrieved November 15, 2024, from 
 * https://stackoverflow.com/questions/64543656/next-doest-allow-white-space-and-nextline-skips-sodatype-all-together
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_12.GradeBookApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentIO {
    // Set up file
    final private static String FILE_NAME = "grades.csv";
    private static File file = new File(FILE_NAME);

    /**
     * Method to insert Students to the grades file
     * 
     * @param student
     * @throws IOException
     */
    public static void insert(Student student) throws IOException {
        PrintWriter output = null;

        if (file.exists()) { // If the file exists, append to it
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        } else { // If the does not exist, create it and write to it with future operations
            output = new PrintWriter(FILE_NAME);
            // Add header
            output.println("firstName,lastName,course,grade");
        }

        // Write student to file
        output.println(student.getFirstName() + ","
                + student.getLastName() + ","
                + student.getCourse() + ","
                + student.getGrade());

        // Close the writer session
        output.close();
    } // end bulkInsert

    // Method to find all Students in the file
    public static ArrayList<Student> findAll() throws IOException {
        ArrayList<Student> students = new ArrayList<>();

        if (file.exists()) {
            Scanner input = new Scanner(file);
            input.useDelimiter("\r?\n");

            // Skip header
            input.next();

            // Continue creating Student objects while there are objects in the file
            while (input.hasNext()) {

                // Assign sets of 4 input to their proper Student values
                String studentCsvString = input.next();
                String[] studentArgs = studentCsvString.split(",");

                // Add the student to the list
                students.add(new Student(studentArgs[0], studentArgs[1], studentArgs[2], studentArgs[3]));
            }

            input.close();
        } else { // If there is no file, return an empty list
            return students;
        }

        // Return the list of Students
        return students;
    } // end findAll
}
