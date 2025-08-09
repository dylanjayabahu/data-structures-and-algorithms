import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null){
            throw new IllegalArgumentException("Data cannot be null.");
        }

        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        
        if (size == 0){
            head = newNode;
            tail = newNode;
            size = 1;
            return;
        }

        newNode.setNext(head);
        head = newNode;
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null){
            throw new IllegalArgumentException("Data cannot be null.");
        }

        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);

        if (size == 0){
            addToFront(data);
            return;
        }

        tail.setNext(newNode);
        tail = newNode;
        size ++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (size == 0){
            throw new NoSuchElementException("Cannot remove from empty list.");
        }

        T temp = head.getData();
        head = head.getNext();
        size --;

        if (size == 0){
            tail = null;
        }

        return temp;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (size == 0){
            throw new NoSuchElementException("Cannot remove from empty list.");
        }

        if (size == 1){
            return removeFromFront();
        }

        T temp = tail.getData();

        SinglyLinkedListNode<T> current = head;
        while (current.getNext().getNext() != null){
            current = current.getNext();
        }

        current.setNext(null);
        tail = current;
        size--;
        return temp;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}