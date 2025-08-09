import java.util.Scanner;


public class Tiling {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); // Create Scanner object
        System.out.print("Enter n: ");
        int n = Integer.parseInt(input.nextLine());
        System.out.println("Number of tilings of for 2xn grid is: " + Integer.toString(numTilings(n)));
        input.close();
    }


    static int numTilings(int n){
        //needs to be O(n) time and O(1) space
        
        //recursive formula:
        //f(0) = 1
        //f(1) = 3
        //f(n) = 3f(n-1) + 4f(n-2)

        if (n==0){
            return 1;
        }
        if (n==1){
            return 3;
        }

        int f_n_minus_2 = 1;
        int f_n_minus_1 = 3;
        int f_n = 0;

        for(int i = 2; i <= n; i++){
            f_n = 3*f_n_minus_1 + 4*f_n_minus_2;
            f_n_minus_2 = f_n_minus_1;
            f_n_minus_1 = f_n;
        }

        return f_n;
    }

}


