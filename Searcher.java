//*********************************************************************************************
// CLASS: Searcher
//
// CSE205 Object Oriented Programming and Data Structures, semester and year
// Project Number: project 3
//
// AUTHOR: Nicholas Rabine, nrabine, nrabine@asu.edu
// AUTHOR2: Grant Kelsay, gkelsay, gkelsay@asu.edu
//*********************************************************************************************

package proj3;
import java.util.ArrayList;
/**
 * Searcher is a helper function that implements one public class method int search(ArrayList<Student> pList, String pKey)
 * which searches the Roster for a student with the specified last name stored in pKey. Since the roster is sorted into
 * ascending order by last name, it uses a binary search algorithm to return the index of the student, or return a -1 if it
 * failed to identify a match.
 */
public class Searcher {

    /**
     * A binary search algorithm to find a student from the given pKey.
     *
     * @param pList The list of students in which we will be performing our 
     * binary search on.
     * 
     * @param pKey The student in which we are trying to find within our
     *  ArrayList.
     */
    public static int search(ArrayList<Student> pList, String pKey) {
        int pLow = 0;
        int pHigh = pList.size() - 1;
        while (pLow <= pHigh) {
            int middle = (pLow + pHigh) / 2;
            int comp = pKey.compareTo(pList.get(middle).getLastName());
            if (comp == 0) {
                    return middle;
            } else if (comp < 0) {
                    pHigh = middle - 1;
            } else {
                    pLow = middle + 1;
            }
        }
        return -1; // if nothing is found return -1
    }
}
