package br.com.datastructure.quicksort.integrate;

import br.com.datastructure.quicksort.QuickSort;
import br.com.datastructure.quicksort.SortWhenLastElementWasDefinedAsPivot;
import br.com.datastructure.quicksort.SortWhenRandomNumberWasDefinedAsPivot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class CheckPerformanceBetweenRandomAndPreDefinedPivotTest {
    private static final int ARRAY_SIZE = 1000000;
    private static final int RANDOM_NUMBER = 1000000;

    private final int array[];
    private final QuickSort sortWhenLastElementWasDefinedAsPivot;
    private final QuickSort sortWhenRandomNumberWasDefinedAsPivot;

    public CheckPerformanceBetweenRandomAndPreDefinedPivotTest() {
        this.array = new int[ARRAY_SIZE];
        this.sortWhenLastElementWasDefinedAsPivot = new SortWhenLastElementWasDefinedAsPivot();
        this.sortWhenRandomNumberWasDefinedAsPivot = new SortWhenRandomNumberWasDefinedAsPivot();
    }

    @Before
    public void init() {
        final Random random = new Random();
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(RANDOM_NUMBER);
        }
    }

    @Test
    public void testPerformanceAlgorithm() {
        int[] arrayForSortWhenLastElementWasDefinedAsPivot = this.array.clone();
        long begin = System.currentTimeMillis();
        this.sortWhenLastElementWasDefinedAsPivot.sort(arrayForSortWhenLastElementWasDefinedAsPivot, 0, this.array.length - 1);

        System.out.println(String.format("SortWhenLastElementWasDefinedAsPivot %sms", System.currentTimeMillis() - begin));

        int[] arrayForSortWhenRandomNumberWasDefinedAsPivot= this.array.clone();
        begin = System.currentTimeMillis();
        this.sortWhenRandomNumberWasDefinedAsPivot.sort(arrayForSortWhenRandomNumberWasDefinedAsPivot, 0, this.array.length - 1);

        System.out.println(String.format("SortWhenRandomNumberWasDefinedAsPivot %sms", System.currentTimeMillis() - begin));
        Assert.assertArrayEquals(arrayForSortWhenLastElementWasDefinedAsPivot, arrayForSortWhenRandomNumberWasDefinedAsPivot);
    }

}
