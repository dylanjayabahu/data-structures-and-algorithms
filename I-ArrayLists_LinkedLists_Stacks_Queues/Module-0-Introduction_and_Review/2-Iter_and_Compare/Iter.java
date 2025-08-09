import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Iter{
    public static void main(String[] args){
        List<String> structures = new ArrayList<>();
        structures.add("BST");
        structures.add("HashMap");
        structures.add("Graph");

        // simple for each loop that iterates through the ArrayList "structures"
        for (String structure: structures) {
            System.out.println("I love " + structure + "s!");
        }



        
        List<String> foods = new LinkedList<>();
        foods.add("pasta");
        foods.add("pizza");
        foods.add("soup");

        // this for-each loop is more efficient...
        for (String food: foods) {
            System.out.println("I love eating " + food + "!");
        }

        // ...rather than this regular for loop
        for (int i = 0; i < foods.size(); i++) {
            String food = foods.get(i); // this line requires Java to internally iterate through a portion of the linkedlist again
            System.out.println("I love eating " + food + "!");
        }
    }       
}

//object that implements Iterable iterface can be iterated with a for-each loop
//the class must override the iterator method, which returns an iterator object

//Iterator Interface:
    //handles the task of iterating through data
    //needs to overwrite the next() and hasNext() methods
        //public abstract T next(); //returns next data in iteration order
        //public abstract boolean hasNext(); //returns if there is more data
        //abstract methods have no implementation; forces subclasses to provide their own implementation
    // can also include the optional remove method
        //public void remove(); //removes the data returned by next
        //default behavior is throwing an exception unless overridden

    //typically some cursor variable to keep track of iteration progress


//Iterator vs Iterable

//Iterator: "Does the iterating" – walks through the collection manually.
    //Iterable = outer container → provides an Iterator
    //iterator interface gives more control, allowing for more custom behaviour
        //depends on both data structure and iterator
    //allows for:
        //while (iter.hasNext()) { iter.next(); }


//Iterable: "Can be iterated over" – allows use in a for-each loop
    //Iterator = inner cursor → goes through the data
    // iterable object allows us to abstract away that underlying control for more general use
        // no dependiencies except data structure
    //allows for:   
        // for (Book b : bookList) { ... }


//This iterable/iterator stuff is often build into the classes we will use, like ArrayList and LinkedList