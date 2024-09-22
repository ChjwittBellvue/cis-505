/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_6.ComposerApp;

public class Composer {
    // Attributes
    private Integer id;
    private String name;
    private String genre;

    // Constructors
    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    } // end default constructor

    public Composer(Integer id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    } // end full constructor

    // Accessors
    public Integer getId() {
        return id;
    } // end getId

    public String getName() {
        return name;
    } // end getName

    public String getGenre() {
        return genre;
    } // end getGenre

    /**
     * Overridden toString method displays transaction information with each
     * attribute on its own line
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Id: " + id + System.lineSeparator());
        sb.append("  Name: " + name + System.lineSeparator());
        sb.append("  Genre: " + genre + System.lineSeparator());
        return sb.toString();
    } // end toString

}
