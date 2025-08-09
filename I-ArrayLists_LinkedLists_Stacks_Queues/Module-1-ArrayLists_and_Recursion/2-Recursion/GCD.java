public class GCD {    
    public static void main(String[] args){
        System.out.println(gcd(20, 20)); // 20
        System.out.println(gcd(186, 14)); // 2
    }

    static int gcd(int x, int y){
        //ensure x > y
        if (x < y){
            int temp = x;
            x=y;
            y=temp;
        }

        //base case
        if (y==0){
            return x;
        }

        //recursive case 
        return gcd(y, x%y);
    }
}

