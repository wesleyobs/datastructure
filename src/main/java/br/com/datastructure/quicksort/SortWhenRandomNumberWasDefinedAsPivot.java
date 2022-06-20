package br.com.datastructure.quicksort;

import java.util.Arrays;
import java.util.Random;

public class SortWhenRandomNumberWasDefinedAsPivot {
    private static final int ARRAY_SIZE = 10;
    private static final int RANDOM_NUMBER = 10;

    public static void main(String[] args) {
        final int array[] = buildArray();
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static int[] buildArray() {
        final Random random = new Random();
        int[] array = new int[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(RANDOM_NUMBER);
        }
        return array;
    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        final int indexPivot = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        final int pivot = array[indexPivot];
        swap(array, indexPivot, highIndex);

        int leftIndex = partition(array, lowIndex, highIndex, pivot);

        quickSort(array, lowIndex, leftIndex - 1);
        quickSort(array, leftIndex + 1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
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

    private static void swap(int[] array, int leftIndex, int rightIndex) {
        final int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
