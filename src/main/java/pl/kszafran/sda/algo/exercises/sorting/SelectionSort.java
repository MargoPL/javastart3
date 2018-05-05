package pl.kszafran.sda.algo.exercises.sorting;

public class SelectionSort extends Swap implements IntSortingAlgorithm {

    @Override
    void swap(int i, int j, int[] array) {
        super.swap(i, j, array);
    }

    @Override
    public void sort(int[] array) {

//        repeat (numOfElements - 1) times
//
//        set the first unsorted element as the minimum
//
//        for each of the unsorted elements
//
//        if element < currentMinimum
//
//        set element as new minimum
//
//        swap minimum with first unsorted position

        int numOfElements = array.length;
        for (int min : array) {
        }

    }
}
