/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_11.GradeBookApp;

public class Student {
    // Attributes
    private String firstName;
    private String lastName;
    private String course;
    private String grade;

    // Constructors
    public Student() {
    } // end default constructor

    public Student(String firstName, String lastName, String course, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grade = grade;
    } // end full parameter constructor

    // Accessors and Mutators
    public String getFirstName() {
        return firstName;
    } // end getFirstName

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } // end setFirstName

    public String getLastName() {
        return lastName;
    } // end getLastName

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // end setLastName

    public String getCourse() {
        return course;
    } // end getCourse

    public void setCourse(String course) {
        this.course = course;
    } // end setCourse

    public String getGrade() {
        return grade;
    } // end getGrade

    public void setGrade(String grade) {
        this.grade = grade;
    } // end setGrade

    /**
     * Overridden toString method
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Student: " + firstName + " " + lastName + System.lineSeparator());
        sb.append("  Course: " + course + System.lineSeparator());
        sb.append("  Grade: " + grade + System.lineSeparator());

        return sb.toString();
    } // end toString

}
