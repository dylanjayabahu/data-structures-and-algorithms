import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        ArrayList<T> result = new ArrayList<>();
        traverseTree(root, result, 0);
        return result;
    }

    

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        ArrayList<T> result = new ArrayList<>();
        traverseTree(root, result, 1);
        return result;
    }



    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        ArrayList<T> result = new ArrayList<>();
        traverseTree(root, result, 2);
        return result;
    }


    private void traverseTree(TreeNode<T> current, ArrayList<T> result, int mode){
        if (current != null){

            if (mode == 0){
                result.add(current.getData());
                traverseTree(current.getLeft(), result, mode);
                traverseTree(current.getRight(), result, mode);
            }
            else if (mode == 1){
                traverseTree(current.getLeft(), result, mode);
                result.add(current.getData());
                traverseTree(current.getRight(), result, mode);
            }
            else{
                traverseTree(current.getLeft(), result, mode);
                traverseTree(current.getRight(), result, mode);
                result.add(current.getData());
            }

        }
    }
}