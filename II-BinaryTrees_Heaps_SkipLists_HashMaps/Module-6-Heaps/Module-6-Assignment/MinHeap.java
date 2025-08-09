import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        if (data == null){
            throw new IllegalArgumentException("Cannot add null data.");
        }

        //last element is at index size 
        //add at index size+1
        if (size+1 >= backingArray.length){
            resize();
        }
        backingArray[size+1] = data;


        int childIndex = size+1;
        int parentIndex = getParentIndex(childIndex);
        while (parentIndex > 0 && backingArray[childIndex].compareTo(backingArray[parentIndex]) < 0){
            swap(childIndex, parentIndex);

            childIndex = parentIndex;
            parentIndex = getParentIndex(childIndex);
        }
        
        size++;
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        if (size <= 0){
            throw new NoSuchElementException("Cannot remove from empty heap.");
        }


        T min = backingArray[1];

        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;

        int parentIndex = 1;
        int leftChildIndex = getLeftChildIndex(parentIndex);
        int rightChildIndex = leftChildIndex+1;
        int minChildIndex;

        //repeat while we still have children
        while(leftChildIndex <= size){
            //guaranteed to have a left child
            //may or may not have a right child 

            //if we have a right child and its bigger than the left child, minchild is the right child
            if (rightChildIndex <= size && backingArray[rightChildIndex].compareTo(backingArray[leftChildIndex]) < 0){
                minChildIndex = rightChildIndex;
            }
            else{
                minChildIndex = leftChildIndex;
            }

            //if the parent is bigger than the minchild, swap
            if (backingArray[parentIndex].compareTo(backingArray[minChildIndex]) > 0){
                swap(parentIndex, minChildIndex);
            }
            else{
                break; //break if the order is not violated
            }

            parentIndex = minChildIndex;
            leftChildIndex = getLeftChildIndex(parentIndex);
            rightChildIndex = leftChildIndex+1;
        }

        return min;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    private int getParentIndex(int childIndex){
        return childIndex/2;
    }

    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex;
    }

    private void swap(int index1, int index2){
        T temp = backingArray[index1];
        backingArray[index1] = backingArray[index2];
        backingArray[index2] = temp;
    }

    private void resize(){
        T[] newBackingArray = (T[]) new Comparable[backingArray.length * 2];


        for (int i = 1; i <= size; i++) {
            newBackingArray[i] = backingArray[i];
        }

        backingArray = newBackingArray;
    }
}