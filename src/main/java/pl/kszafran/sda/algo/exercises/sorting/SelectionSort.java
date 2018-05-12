package pl.kszafran.sda.algo.exercises.sorting;

public class SelectionSort extends Swap implements IntSortingAlgorithm {
    @Override
    public void sort(int[] array) {
        for (int offset = 0; offset < array.length - 1; offset++) {
            int min = offset;
            for (int i = offset; i < array.length; i++) {
                if (array[i] < array[min]) {
                    min = i;
                }
            }
            swap(array, offset, min);
        }
    }

    @Override
    void swap(int[] array, int i, int j) {
        super.swap(array, i, j);
    }
}



