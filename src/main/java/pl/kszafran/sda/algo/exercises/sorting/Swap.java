package pl.kszafran.sda.algo.exercises.sorting;

public abstract class Swap {

    void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
