package com.easy;

import java.util.*;

class SolutionSodoku {
    public void solveSudoku(char[][] board) {
        
        HashSet<Integer>[] row =  new HashSet<Integer>[board.length];
        HashSet<Integer>[] col =  new HashSet<Integer>[board.length];
        HashSet<Integer>[] block =  new HashSet<Integer>[board.length];
        
        for(int i=0;i<board.length;i++) {
            row[i] = new HashSet<Integer>();
            col[i] = new HashSet<Integer>();
            block[i] = new HashSet<Integer>();
        }
        
        for(int i=0;i<board.length;i++) {
          for(int j=0;j<board.length;j++) {
              row[i].add(board[i][j])
              col[j].add(board[i][j])
              block[(i*(board.length-1)+j/3].add(board[i][j])
                     
                     
                     
          
        }
 }
}