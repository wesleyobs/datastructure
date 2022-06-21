package br.com.datastructure.quicksort;

import java.util.Random;

public class SortWhenRandomNumberWasDefinedAsPivot extends QuickSort {
    @Override
    public void sort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        final int indexPivot = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        final int pivot = array[indexPivot];

        this.swap(array, indexPivot, highIndex);

        int leftIndex = partition(array, lowIndex, highIndex, pivot);

        sort(array, lowIndex, leftIndex - 1);
        sort(array, leftIndex + 1, highIndex);
    }
}
