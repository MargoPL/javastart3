package pl.kszafran.sda.algo.exercises.sorting;

class Swap {

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
