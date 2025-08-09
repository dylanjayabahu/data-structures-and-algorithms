public class Passing {
    public static void main(String[] args) {
        int count = 0;
        helper(count); //doesnt actually increment x by 1
        System.out.println(count); // still 0
    }

    public static void helper(int x) {
        x = x + 1; //the function recieves a copy of the value in x, then does its work in the stack
        //this is destroyed/given back to the computer when the function call ends
    }

    //^ if we wanted to update count, we would set a return value for helper and then do count = helper(count)

    // if we pass in an object, we are passing in the reference variable. Lets say we take in an object
    public static void objectHelper(Container x){
        // we cannot change x like this:
        // x = new Container(x.getItem() + 1); 

        // instead, we would say have to modify the original x
        x.setItem(x.getItem() + 1);

        //this works because, even though java is a pass by value language, it passes the value of the reference to x
    }


    //pass by value = the method takes in the value of what was passed; 
        // changing its value changes the local variable but not the og variable
        // b/c they reference 2 diff locations in memory

    //pass by reference = method takes in the reference of what was passed (like the pointer if we were in c)
        // changing its value changes both the local and og variable 
        // b/c they both reference the same location in memory

    //java is a pass by value language
}

class Container {
    private int item;

    public Container(int item) {
        this.item = item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getItem() {
        return item;
    }
}