package br.com.datastructure.quicksort;

public abstract class QuickSort {

    public abstract void sort(int[] array, int lowIndex, int highIndex);

    protected int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftIndex = lowIndex;
        int rightIndex = highIndex;

        while (leftIndex < rightIndex) {
            while (array[leftIndex] <= pivot && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (array[rightIndex] >= pivot && rightIndex > leftIndex) {
                rightIndex--;
            }
            swap(array, leftIndex, rightIndex);
        }
        swap(array, leftIndex, highIndex);
        return leftIndex;
    }

    protected void swap(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
