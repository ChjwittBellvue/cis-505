/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_6.ComposerApp;

import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao {
    private List<Composer> composers = new ArrayList<Composer>();

    /**
     * Constructor creates a list of five composers
     */
    public MemComposerDao() {
        Composer composer1 = new Composer(1, "Bach", "Classical");
        Composer composer2 = new Composer(2, "Tchaikovsky", "Classical");
        Composer composer3 = new Composer(3, "Chris Thile", "Folk");
        Composer composer4 = new Composer(4, "Patrick Stump", "Rock");
        Composer composer5 = new Composer(5, "Garth Brooks", "Country");

        this.composers.add(composer1);
        this.composers.add(composer2);
        this.composers.add(composer3);
        this.composers.add(composer4);
        this.composers.add(composer5);
    } // end constructor

    /**
     * Returns the full list of composers in this object
     */
    @Override
    public List<Composer> findAll() {
        return this.composers;
    } // end findAll

    /**
     * Finds and returns a composer by id
     */
    @Override
    public Composer findBy(Integer key) {
        // Loop through each composer
        for (Composer composer : composers) {
            // Find the composer with the desired key and return it
            if (composer.getId().equals(key)) {
                return composer;
            }
        }
        // If no composer is found, return a null object
        System.out.println("  No composer found with that ID." + System.lineSeparator());
        return null;
    } // end findBy

    /**
     * Inserts a new composer into the composers list
     */
    @Override
    public void insert(Composer entity) {
        composers.add(entity);
    }

}
