//*********************************************************************************************
// CLASS: Sorter
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
 * Sorter is a helper function that implements the quicksort algorithm.
 */
public class Sorter {

    /**
     * Calls the quicksort method to sort the ArrayList
     * 
     * @param pList The name list of students we are sorting.
     */
    public static void sort(ArrayList<Student> pList) {
            quickSort(pList, 0, pList.size() - 1); //call quicksort
    }

    /**
     * Takes last element as pivot, places
     * the pivot element at its correct position in sorted
   	 * ArrayList, and puts all smaller to left of pivot and 
   	 * all bigger elements to right of pivot.
     * 
     * @param pList The name list of students we are sorting.
     * 
     * @param pFromIdx an Int that is used to find the left index.
     * 
     * @param pToIdx an Int that is used to find the right index.
     */
    private static int partition(ArrayList<Student> pList, int pFromIdx,
                    int pToIdx) {

            Student pivot = pList.get(pFromIdx); //pivot

            int leftIndex = pFromIdx - 1; //smaller element
            int rightIndex = pToIdx + 1; //larger element

            while (leftIndex < rightIndex) {
                    leftIndex++; //increase smaller index
                    while (pList.get(leftIndex).compareTo(pivot) < 0) {
                            leftIndex++; //increase smaller index
                    }
                    rightIndex--; //decrease larger index
                    while (pList.get(rightIndex).compareTo(pivot) > 0) {
                            rightIndex--; //decrease larger index
                    }
                    if (leftIndex < rightIndex) {
                            swap(pList, leftIndex, rightIndex); //call swap
                    }
            }
            return rightIndex;
    }
    
    /**
     * A recursive function that calls upon itself until all of the
     * elements in the pList of students are sorted.
     * 
     * @param pList The name list of students we are sorting.
     * 
     * @param pFromIdx an Int that is used to find the left index.
     * 
     * @param pToIdx an Int that is used to find the right index.
     */
    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        if (pFromIdx >= pToIdx)
                return;
        
        int partitionIndex = partition(pList, pFromIdx, pToIdx);
        
        // Separately sort elements before
        // partition and after partition
        quickSort(pList, pFromIdx, partitionIndex);
        quickSort(pList, partitionIndex + 1, pToIdx);
    }

    /**
     * A helper function to swap two elements.
     * 
     * @param pList The name list of students we are sorting.
     * 
     * @param pIdx1 the left index.
     * 
     * @param pIdx2 the right index.
     */
    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2) {
            Student temp = pList.get(pIdx1);
            pList.set(pIdx1, pList.get(pIdx2));
            pList.set(pIdx2, temp);
    }

}
