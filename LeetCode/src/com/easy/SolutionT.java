package com.easy;

import java.util.*;

class SolutionT {
	
	public static void main(String[] args) {
		System.out.println(isValidSudoku(new char[][] {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}}));
	}

    public static boolean isValidSudoku(char[][] board) {
        
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> col = new HashSet<Integer>();
        HashSet<Integer> cell = new HashSet<Integer>();
        
        for(int i=0; i<board.length; i++) {
        
             for(int j=0; j<board[i].length; j++) {
                   
                 if(board[i][j] != '.') {
                    int temp = Character.getNumericValue(board[i][j]);
                    int tempR = temp*10 + i;
                    int tempC = (temp*10 + j)*-1;
                    int tempCell = temp*100 + (i/3)*10 + (j/3);
                    if(temp<1 || temp >9 || row.contains(tempR) || col.contains(tempC) || cell.contains(tempCell)){
                        return false;
                    }else {
                    	row.add(tempR);
                    	col.add(tempC);
                    	cell.add(tempCell);
                    }    
                     
                 }
                 
            }
        }
        return true;
        
        
    }
}
