import java.util.ArrayList;
import java.util.Arrays;

public class IncreasingSubseq {
    static int numIncreasingSubseqs(int[] seq){
        //recursive structure:
        //num up to i = sum[num up to j for j up to i-1, and seq[j] < seq[i]]
        //base case: num up to index 0 is 1. 
        
        //can be done with dp to avoid inifficient recursive calls and avoid memoization
        int[] dp = new int[seq.length]; //dp[i] is the number of increasing subseqs ending at i

        dp[0] = 1;

        for (int i = 1; i < seq.length; i++){
            int current = seq[i];
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (current > seq[j]){ //strictly increasing, so dont use >=
                    dp[i] += dp[j];
                }
            }
        }

        //sum all values in dp to find total incresing subseq ending at any index
        int total = 0;
        for (int count: dp){
            total += count;
        }
        return total;
    }

    static int printAndCountIncreasingSubseqs(int[] seq){
        ArrayList<ArrayList<ArrayList<Integer>>> out = new ArrayList<>();

        for (int i = 0; i < seq.length; i++){

            ArrayList<ArrayList<Integer>> currentList = new ArrayList<>();

            ArrayList<Integer> single = new ArrayList<>(Arrays.asList(seq[i]));
            currentList.add(single);


            for (int j = 0; j < i; j++){
                if (seq[i] > seq[j]){
                    for (ArrayList<Integer> subseq: out.get(j)){
                        ArrayList<Integer> newSubseq = new ArrayList<>(subseq);
                        newSubseq.add(seq[i]);
                        currentList.add(newSubseq);
                    }
                }
            }

            out.add(currentList);
        }

        int count = 0;
        for (ArrayList<ArrayList<Integer>> group : out) {
            for (ArrayList<Integer> subseq : group) {
                System.out.println(subseq);
                count++;
            }
        }


        return count;
    }   

    public static void main(String[] argc){
        int[] seq = new int[]{1,7,3,5,2,8,1025,-1,-5,4};
        int num1 = numIncreasingSubseqs(seq);
        int num2 = printAndCountIncreasingSubseqs(seq);
        
        assert (num1 == num2);
        System.out.println(num1);

    }
}

