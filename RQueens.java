//------------------------------------------------------------------------------------------------------------------
// RQueens.java
// A recursive solution to the n-Queens problem.
// Not meant for numbers bigger than 16, it will be too slow.
// Tristan Clark
//------------------------------------------------------------------------------------------------------------------

class RQueens{

    // findSolutions(B,i,mode)
    /* implements the recursive algorithm we have been describing. If the string argument mode has the value
    "verbose", then findSolutions() will print out solutions as it finds them by calling the function
    printBoard(). If mode has any other value, findSolutions() will print nothing. The int returned by
    findSolutions() is the number of solutions to n-queens that have queens placed on rows 1 to (i − 1),
    as represented by the current state of array B[][]. */
    static int findSolutions(int[][] B, int i, String mode){
        int sum = 0;
        if(i == B.length) {
            if(mode == "-v") printBoard(B);
            return 1;
        } else {
            for(int j = 1; j < B.length; ++j) {
                if(B[i][j] == 0) {
                    placeQueen(B, j, i);
                    sum += findSolutions(B, i+1, mode);
                    removeQueen(B, j, i);
                }
            }
        }
        return sum;
    }

    // printWholeBoard(B)
    // function that allows me to see the whole board
    // runs at ^2 time so is used for testing smaller numbers and not for functionality
    static void printWholeBoard(int[][] B) {
        for(int i = 1; i <= B.length - 1; ++i){
            System.out.print("(");
            for(int j = 1; j < B.length - 1; ++j){
                System.out.print(B[i][j] + ",");
            }
            System.out.println(B[i][B.length-1] + ")");
        }
    }

    // printBoard(B)
    // prints out a solution to n-queens if the user uses the -v option
    static void printBoard(int[][] B){
        System.out.print("(");
        for(int i = 1; i < B.length - 1; ++i){
           System.out.print(B[i][0] + ", ");
        }
        System.out.println(B[B.length -1][0] + ")");
    }

    // placeQueen(B,j,i)
    /* n increments B[i][j] from its initial value of 0 to 1, and sets B[i][0] to j, thus indicating
    the existence of a queen on square (i,j). It will also decrement B[k][l] for every square (k, l) under attack
    from the new queen at (i,j), where i < k ≤ n and 1 ≤ l ≤ n*/
    static void placeQueen(int[][] B,int j, int i){
        B[i][j]++;
        B[i][0] = j;
        for(int k=i+1; k < B.length; ++k){
            for(int l = 1;l < B.length; ++l){
                if(l==j || Math.abs(l-j) == Math.abs(k-i)) B[k][l]--;
            }
        }
    }

    // removeQueen(B,j,i)
    /* decrements B[i][j] from 1 to 0, resets B[i][0] from j to 0, and increments B[k][l]
    for every square (k, l) no longer under attack from the now absent queen at (i,j), where i < k ≤ n and
    1 ≤ l ≤ n*/
    static void removeQueen(int[][] B,int j, int i){
        B[i][j]--;
        B[i][0] = 0;
        for(int k=i+1; k < B.length; ++k){
            for(int l = 1;l < B.length; ++l){
                if(l==j || Math.abs(l-j) == Math.abs(k-i)) B[k][l]++;
            }
        }
    }

    // printErr()
    // prints the error message and exits if incorrect input is given
    static void printErr(){
        System.err.println("Usage: RQueens [-v] number");
        System.err.println("Option: -v  verbose output, print all solutions");
        System.exit(0);
    }

    public static void main(String args[]){

        // variables
        int n, sol, arglen = args.length;
        int[][] B;

        // if length of input is 2, check for "-v" and an integer, then print the solution as its solved
        if(arglen == 2) {
            if(!args[0].startsWith("-v")){
                printErr();
            }
            try{
                n = Integer.parseInt(args[1]);
                B = new int[n+1][n+1];
                sol = findSolutions(B, 1, "-v");
                System.out.println(n + "-Queens has " + sol + " solutions");
            } catch(NumberFormatException e1) {
                printErr();
            }

        // if length of input is 1, check for integer and solve.
        } else if(arglen == 1) {
            try{
                n = Integer.parseInt(args[0]);
                B = new int[n+1][n+1];
                sol = findSolutions(B, 1, "");
                System.out.println(n + "-Queens has " + sol + " solutions");
            } catch (NumberFormatException e2) {
                printErr();
            }
        
        // otherwise call the error message and exit
        } else {
            printErr();
        }
    }
}