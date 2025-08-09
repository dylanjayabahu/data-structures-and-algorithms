public class EqualityDemoObjects {
    public static void main(String[] args){
        //Null Checking - done with ==
            //.equals on a Null object will throw a NullPointerException (NPE)

        String nullObject = null;
        String normalObject = "normal";

        //right way to check if object is null
        System.out.println(nullObject == null);   // => true
        System.out.println(normalObject == null); // => false

        // The String class checks if argument is null, so it will throw NPE.  
        // If a .equals() method doesn't check for a null argument, it will crash and throw a NPE.
        // Here, we are comparing the value stored in normalObject to the values null, and nullObject
        System.out.println(normalObject.equals(null)); // => false
        System.out.println(normalObject.equals(nullObject)); // => false

        
        // However, here we invoking the .equals() method on a null object stored in nullOject
        // This will cause a NPE to be thrown, regardless of the parameter in the .equals() method
        // nullObject.equals(normalObject);  // causes NullPointerException
        // nullObject.equals(null); // causes NullPointerException



        //Wrapper Objects
        //similar to how strings and string literals operate, we can do the same with primitive types
        //each primitive type has a wrapper object class (e.g. Integer for int)
        //the wrapper object behave like strings objects do vs string literals
        Integer primitive = 1;
        Integer object = Integer.valueOf(1);
        Integer unequal = 2;

        // Using == On Value Equal Integers
        System.out.println(primitive == object);        // => false
        System.out.println(primitive == 1);             // => true
        System.out.println(object == 1);                // => true
        System.out.println(object == Integer.valueOf(1));   // => false

        // Using .equals() On Value Equal Integers
        System.out.println(primitive.equals(object));                 // => true
        System.out.println(object.equals(primitive));                 // => true
        System.out.println(primitive.equals(1));                      // => true
        System.out.println(object.equals(1));                         // => true
        System.out.println((Integer.valueOf(1)).equals(1));               // => true
        System.out.println((Integer.valueOf(1)).equals(Integer.valueOf(1)));  // => true

        // Using == and .equals() on Unequal Integers
        System.out.println(primitive == unequal);        // => false
        System.out.println(object == unequal);           // => false
        System.out.println(primitive.equals(unequal));   // => false
        System.out.println(object.equals(unequal));      // => false

        // If run, the following do not work since 1 is considered a primitive without autoboxing
        // 1.equals(primitive);  // causes Error
        // 1.equals(1);          // causes Error


        //note that Integer() is depracated; instead use Integer.valeuOf(), as used in the code above




        // e.g. if many people have the name "Monkey" in a system, and we want to remove that one of the ppl named monkey
        // we want to compare by reference, not value

        // if we eant to see the records of all the ppl named "Monkey", we would want to compare by value
    }
}