import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        int stopIndex = arr.length - 1;
        int lastSwap;

        while (stopIndex > 0){
            lastSwap = 0;
            for (int i = 0; i < stopIndex; i++){
                if (comparator.compare(arr[i], arr[i+1]) > 0){
                    swapIndexes(arr, i, i+1);
                    lastSwap = i;
                }
            }
            stopIndex = lastSwap;
        }
    }


    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        int maxIndex;
        for (int n = arr.length-1; n > 0; n--){
            maxIndex = 0;

            for (int i = 1; i <= n; i++){
                if (comparator.compare(arr[i], arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }

            swapIndexes(arr, n, maxIndex);
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        int i;
        for (int n = 1; n < arr.length; n++){
            i = n;

            while (i > 0 && comparator.compare(arr[i-1], arr[i]) > 0){
                swapIndexes(arr, i, i-1);
                i--;
            }
        }
    }


    private static <T> void swapIndexes(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}