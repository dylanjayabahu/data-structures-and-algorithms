import java.util.List;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of LSD Radix Sort.
 */
public class Sorting {

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be: out-of-place stable not adaptive
     *
     * Have a worst case running time of: O(kn) And a best case running time of:
     * O(kn)
     *
     * For this question, you are given k: the number of digits in the greatest
     * magnitude number in arr. Because of this, you do not need to make an initial
     * O(n) pass through to determine this number.
     *
     * At no point should you find yourself needing a way to exponentiate a number;
     * any such method would be non-O(1). Think about how how you can get each power
     * of BASE naturally and efficiently as the algorithm progresses through each
     * digit.
     *
     * You may use an ArrayList or LinkedList if you wish. Be sure the List
     * implementation you choose allows for stability while being as efficient as
     * possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     * @param k   The number of digits in the greatest magnitude number in arr.
     */
    public static void lsdRadixSort(int[] arr, int k) {
        LinkedList<Integer>[] buckets = new LinkedList[19];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        int place = 1;
        int digit;

        for (int iter = 1; iter <= k; iter++){
            for (int num : arr){
                digit = (num/place) % 10; //get Kth digit
                buckets[digit+9].add(num);
            }
            
            int i = 0;
            for (LinkedList<Integer> bucket : buckets){
                while (!bucket.isEmpty()){
                    arr[i] = bucket.removeFirst();
                    i++;
                }
            }

            place *= 10;
        }
    }



    /**
     * Implement bubble sort.
     *
     * It should be: in-place stable adaptive
     *
     * Have a worst case running time of: O(n^2) And a best case running time of:
     * O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator are both valid and
     * will never be null.
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
            for (int i = 0; i+1 <= stopIndex; i++){ 
                if (comparator.compare(arr[i], arr[i+1]) > 0){
                    swapIndexes(arr, i, i+1);
                    lastSwap = i;
                }
            }
            stopIndex = lastSwap;
        }
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    private static <T> void swapIndexes(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}