package br.com.datastructure.quicksort;

public class SortWhenLastElementWasDefinedAsPivot extends QuickSort {
    @Override
    public void sort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        final int pivot = array[highIndex];

        int leftIndex = partition(array, lowIndex, highIndex, pivot);

        sort(array, lowIndex, leftIndex - 1);
        sort(array, leftIndex + 1, highIndex);
    }
}
