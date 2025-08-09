import java.util.NoSuchElementException;
import javax.script.Compilable;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

     /**
     * Returns the data from the tree matching the given parameter.
     *
     * This should be done recursively.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to search for. You may assume data is never null.
     * @return The data in the tree equal to the parameter.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T get(T data) {

        return rGet(data, root);

        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    private T rGet(T data, BSTNode<T> curr){

        if (curr == null){
            throw new NoSuchElementException("data not found.");
        }

        int cmp = data.compareTo(curr.getData());

        if (cmp > 0){
            return rGet(data, curr.getRight());
        }
        else if (cmp < 0){
            return rGet(data, curr.getLeft());
        }

        return curr.getData();
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the PREDECESSOR to
     * replace the data. You should use recursion to find and remove the
     * predecessor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove. You may assume that data is never null.
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T remove(T data) {
        BSTNode<T> dummy = new BSTNode<>(null);
        root = rRemove(data, root, dummy);

        return dummy.getData();
    }

    private BSTNode<T> rRemove(T data, BSTNode<T> curr, BSTNode<T> dummy){
        if (curr == null){
            throw new NoSuchElementException("Cannot remove; not found.");
        }

        int cmp = data.compareTo(curr.getData());

        if (cmp > 0){
            curr.setRight(rRemove(data, curr.getRight(), dummy));
        }
        else if (cmp < 0){
            curr.setLeft(rRemove(data, curr.getLeft(), dummy));
        }
        else{
            //found. /remove it.
            dummy.setData(curr.getData());
            size --;

            //0 children
            if (curr.getLeft() == null && curr.getRight() == null){
                curr = null;
            }

            //1 child
            else if (curr.getRight() == null){
                curr = curr.getLeft();
            }
            else if (curr.getLeft() == null){
                curr = curr.getRight();
            }


            //2 children
            else {
                BSTNode<T> dummy2 = new BSTNode<>(null);
                curr.setLeft(removePredecessor(curr.getLeft(), dummy2));
                curr.setData(dummy2.getData());
            }
            
            
            
        }

        return curr;

    }

    private BSTNode<T> removePredecessor(BSTNode<T> curr, BSTNode<T> dummy){
        if (curr.getRight() == null){
            dummy.setData(curr.getData());
            return curr.getLeft();
        }

       curr.setRight(removePredecessor(curr.getRight(), dummy));
       return curr;
    }


    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}