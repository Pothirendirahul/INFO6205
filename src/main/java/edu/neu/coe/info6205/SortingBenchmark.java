package edu.neu.coe.info6205;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.function.Supplier;

public class SortingBenchmark {

    public static void main(String[] args) {
        // Initialize the InsertionSort algorithm
        InsertionSort sortingAlgorithm = new InsertionSort();

        // Set up the benchmark timer for the sorting tests
        Benchmark_Timer<Integer[]> sortingTimer = new Benchmark_Timer<>("Sorting Performance",
                null,
                arrayToSort -> sortingAlgorithm.sort(arrayToSort, 0, arrayToSort.length),
                null);

        // Loop through array sizes, doubling each time, starting from 450 to under 20,000
        for (int arraySize = 450; arraySize < 20000; arraySize *= 2) {
            // Test with randomly ordered arrays
            measureSortingPerformance("Randomly Ordered", arraySize, sortingTimer, true, false);

            // Test with ordered arrays
            measureSortingPerformance("Ordered", arraySize, sortingTimer, false, true);

            // Test with partially ordered arrays
            measureSortingPerformance("Partially Ordered", arraySize, sortingTimer, false, true, true);

            // Test with reverse ordered arrays
            measureSortingPerformance("Reverse Ordered", arraySize, sortingTimer, false, false, true);
        }
    }

    private static void measureSortingPerformance(String condition, int arraySize, Benchmark_Timer<Integer[]> sortingTimer,
                                                  boolean isRandom, boolean isSorted, boolean... isPartiallySorted) {
        Supplier<Integer[]> arraySupplier = () -> {
            Integer[] array = new Integer[arraySize];
            Random rand = new Random();

            if (isRandom) {
                for (int start = 0; start < arraySize; start++) {
                    array[start] = rand.nextInt(arraySize);
                }
            } else {
                for (int start = 0; start < arraySize; start++) {
                    array[start] = isSorted ? start : arraySize - start; // Ordered or reverse ordered
                }
                if (isSorted) Arrays.sort(array);
                if (isPartiallySorted.length > 0 && isPartiallySorted[0]) {
                    for (int start = 0; start < arraySize / 2; start++) {
                        array[rand.nextInt(arraySize)] = rand.nextInt(arraySize * 100);
                    }
                }
                if (!isSorted) Arrays.sort(array, Collections.reverseOrder());
            }

            return array;
        };

        double time = sortingTimer.runFromSupplier(arraySupplier, 10);
        System.out.printf("Array Size: %d, Condition: %s, Time Taken: %.2f%n", arraySize, condition, time);
    }
}
