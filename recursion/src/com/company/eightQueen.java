package com.company;

/**
 * Created by zsu00 on 5/15/2017.
 */
public class eightQueen {
    private int solutionCount;
    private Board b;

    //constructs 8 queen class
    public eightQueen(Board b){
        this.b = b;
        solutionCount = 0;
    }

    public void explore(int col) {
            if (col > b.size()){
                b.print();
                System.out.println();
                solutionCount ++;
            }else {
                for (int row = 1; row <= b.size(); row++)
                    if (b.safe(row, col)) {
                        b.place(row, col);
                        explore(col + 1);
                        b.remove(row, col);
                    }
            }
    }

    public int getSolutionCount(){
        return solutionCount;
    }

}
