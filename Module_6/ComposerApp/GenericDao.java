/*
 *  REFERENCES
 * 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
 * Comprehensive Version (12th ed.). Pearson Education, Inc.
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_6.ComposerApp;

import java.util.List;

// Interface definition for Dao Objects
public interface GenericDao<E, K> {
    List<E> findAll();

    E findBy(K key);

    void insert(E entity);
}
