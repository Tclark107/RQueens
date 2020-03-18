//------------------------------------------------------------------------------------------------------------------
// RQueens.java
// A recursive solution to the n-Queens problem.
// Tristan Clark
//------------------------------------------------------------------------------------------------------------------

// imports

class RQueens{

    /*implements the recursive algorithm we have been describing. If the string argument mode has the value
    "verbose", then findSolutions() will print out solutions as it finds them by calling the function
    printBoard(). If mode has any other value, findSolutions() will print nothing. The int returned by
    findSolutions() is the number of solutions to n-queens that have queens placed on rows 1 to (i − 1),
    as represented by the current state of array B[][]. A top level call to findSolutions() that does not
    print solutions would be findSolutions(B, 1, ""). High level pseudo-code for this function is given
    below.
        1. if i > n (a queen was placed on row n, and hence a solution was found)
        2.      if we are in verbose mode
        3.          printBoard([][] B);
        4.      return 1
        5. else
        6.      for each square on row i
        7.          if that square is safe
        8.              place a queen on that square
        9.              recur on row (i + 1), then add the returned value to an accumulating sum
        10.             remove the queen from that square
        11. return the accumulated sum*/
    static int findSolutions(int[][] B, int i, String mode){
        return i;
    }

    /*prints out a solution to n-queens in the format described*/
    static void printBoard(int[][] B){
        System.out.print("(");
        for(int i = 1; i < B.length - 1; ++i){
           System.out.print(B[i][0] + ", ");
        }
        System.out.println(B[B.length -1][0] + ")");
    }

    /*n increments B[i][j] from its initial value of 0 to 1, and sets B[i][0] to j, thus indicating
    the existence of a queen on square (i,j). It will also decrement B[k][l] for every square (k, l) under attack
    from the new queen at (i,j), where i < k ≤ n and 1 ≤ l ≤ n*/
    static void placeQueen(int[][] B,int j, int i){

    }

    /*decrements B[i][j] from 1 to 0, resets B[i][0] from j to 0, and increments B[k][l]
    for every square (k, l) no longer under attack from the now absent queen at (i,j), where i < k ≤ n and
    1 ≤ l ≤ n*/
    static void removeQueen(int[][] B,int j, int i){

    }

    static void printErr(){
        System.err.println("Usage: Queens [-v] number");
        System.err.println("Option: -v  verbose output, print all solutions");
        System.exit(0);
    }

    /*read the command line arguments, then determine the value of n,
    and what mode (normal or verbose) to run in. It will initialize an int array of size (n + 1) × (n + 1) to all
    zeros, call function findSolutions() on this array in the correct mode, then print out the number of
    solutions to n-queens that were found*/
    public static void main(String args[]){
        int n = 4;
        int[][] B = new int[n+1][n+1];
        printBoard(B);
    }
}