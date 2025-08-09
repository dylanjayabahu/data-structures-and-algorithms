//refamiliarize with java syntax
import java.util.Scanner;

public class Hello{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create Scanner object
        System.out.print("Enter your name: ");
        String name = input.nextLine(); // Read user input
        System.out.println("Hello, " + name + "!");
        // System.out.println(String.format("Hello, %s!", name)); //<- can be done this way as well
        // System.out.printf("Hello, %s!\n", name); // or like this

        System.out.print("Enter size of triangle: ");
        int n = Integer.parseInt(input.nextLine());
        triangle(n);
        input.close();
    }


    private static void triangle(int n){
        for (int i = 1; i <= n; i++){
            for (int j =0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
            
        }
    }
}

// compile with javac MyCode.java
// run with java MyCode