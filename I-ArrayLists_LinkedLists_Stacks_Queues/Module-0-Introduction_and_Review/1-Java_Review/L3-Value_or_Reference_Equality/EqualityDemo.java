public class EqualityDemo {
    public static void main(String[] args){
        //reference equality = sees if two things are the exact same thing in memory 
            //uses ==
            //for primitives no diff between value/reference equality
        //value equality = seeing if two objects are equal in terms of the value they have; based on user's design/use case
            //uses .equals()


        //primitive types (int, float, double, long, char etc.) do not extend the Object class
        int one1 = 1;
        int one2 = 1;
        int two1 = 2;
        int two2 = 2;

        System.out.println(one1 == one2); // => true
        System.out.println(two1 == two2); // => true
        System.out.println(one1 == two1); // => false
        System.out.println(one1 == 1);    // => true
        System.out.println(two1 == 2);    // => true


        //String literals vs Strings
            // string literal = stores this in a special area of memory called the String Pool
                //If another string literal "hello" is used elsewhere, it will refer to the same object in memory to save space.
            // string object = like an actual object in the heap (even if another string/string literal with the same value exists)
        
        String literal = "This is a string."; 
        String object = new String("This is a string.");
        String unequal = "Nope.";


        // Using == On Value Equal Strings
        System.out.println(literal == object);                           // => false
        System.out.println(literal == "This is a string.");              // => true
        System.out.println("This is a string." == "This is a string.");  // => true
        System.out.println(object == "This is a string.");               // => false
        System.out.println(object == new String("This is a string."));   // => false

        // Using .equals() On Value Equal Strings
        System.out.println(literal.equals(object));                      // => true
        System.out.println(object.equals(literal));                      // => true
        System.out.println(literal.equals("This is a string."));         // => true
        System.out.println(object.equals("This is a string."));          // => true
        System.out.println("This is a string.".equals("This is a string."));               // => true
        System.out.println("This is a string.".equals(new String("This is a string.")));   // => true

        // Using == and .equals() on Unequal Strings
        System.out.println(literal == unequal);          // => false
        System.out.println(object == unequal);           // => false
        System.out.println(literal.equals(unequal));     // => false
        System.out.println(object.equals(unequal));      // => false

        //essentially, string literals can be compared for value with other string literals with ==
        //string objects must be compared with other objects/literals with .equals()
    }
}
