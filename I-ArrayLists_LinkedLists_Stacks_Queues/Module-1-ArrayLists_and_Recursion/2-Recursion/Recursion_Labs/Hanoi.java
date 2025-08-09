public class Hanoi {
    static String PEGS = "ABC";

    public static void main(String[] args){
        int numDisks = 3;
        printHanoiMoves(numDisks, 0, 2);
    }

   static void printHanoiMoves(int numDisks, int startPeg, int endPeg){
        //print a move as (A -> B), which means moving the top disk on peg A to peg B
        //move the first n-1 disks to an intedmediate peg
        //then move the bottom disk to the target peg
        //then move the n-1 disks on the intermdiate peg to the target peg

        if (numDisks == 0){
            return;
        }

        // int intermediatePeg = 0;
        // for (int p = 0; p < 3; p++){
        //     if (startPeg != p && endPeg != p){
        //         intermediatePeg = p;
        //     }
        // }
        int intermediatePeg = 3-startPeg-endPeg;

        printHanoiMoves(numDisks - 1, startPeg, intermediatePeg);

        System.out.println(PEGS.charAt(startPeg) + "-->" + PEGS.charAt(endPeg));

        printHanoiMoves(numDisks-1, intermediatePeg, endPeg);
        
    }

    
}
