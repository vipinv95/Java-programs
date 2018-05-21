/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author VipinRajan
 */
public class Model {
    public static int[][] grid = new int[9][9];
    public static int wins = 0;
    public static int solver = 0;
    public static int sol = 0;
    Controller controller = new Controller();
    public Model() {
        
    }
        public void ClearGrid() {
            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++) {
                    grid[i][j]=0;
                }
            }
        }
    public boolean hasEmptyCell(int[][] grid) {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(grid[i][j]==0) {
                    return true;
                }
            }
        }
        return false;
    } 
    public boolean isValid(int[][] grid) {

        for(int a=0;a<9;a++) {
            for(int b=0;b<9;b++) {
        for(int i=0;i<9;i++) {
                if(!(b==i)) {
                if(grid[a][b]==grid[a][i]) {
//                    grid[a][b]=0;
                    return false;
                }
                }
        }
        for(int j=0;j<9;j++) {
                if(!(a==j)) {
                if(grid[a][b]==grid[j][b]) {
//                    grid[a][b]=0;
                    return false;
                }    
                }
        }
        for(int k=0;k<9;k++) {
                if(!((a-(a%3)+(k%3))==a)&&(!((b-(b%3)+(k/3))==b))) {
                if(((grid[a-(a%3)+(k%3)][b-(b%3)+(k/3)])==grid[a][b])) {
//                    grid[a][b]=0;
                    return false;
                }
             }
        }
      }
    }
        return true;
    }
    
    public int[][] GenerateSudoku() {
        switch((int)(Math.random()*10)+1) {
            case 1:
                sol = 1;
                ClearGrid();
                puz1(grid);
                break;
            case 2:
                sol = 2;
                ClearGrid();
                puz2(grid);
                break;
            case 3:
                sol = 3;
                ClearGrid();
                puz3(grid);
                break;
            case 4:
                sol = 4;
                ClearGrid();
                puz4(grid);
                break;
            case 5:
                sol = 5;
                ClearGrid();
                puz5(grid);
                break;
            case 6:
                sol = 6;
                ClearGrid();
                puz6(grid);
                break;
            case 7:
                sol = 7;
                ClearGrid();
                puz7(grid);
                break; 
            case 8:
                sol = 8;
                ClearGrid();
                puz8(grid);
                break;
            case 9:
                sol = 9;
                ClearGrid();
                puz9(grid);
                break;
            case 10:
                sol = 10;
                ClearGrid();
                puz10(grid);
                break;    
        }
        return grid;
        
    }

public int[][] GenerateSolution() {
        switch(sol) {
            case 1:
                ClearGrid();
                sol1(grid);
                break;
            case 2:
                ClearGrid();
                sol2(grid);
                break;
            case 3:
                ClearGrid();
                sol3(grid);
                break;
            case 4:
                ClearGrid();
                sol4(grid);
                break;
            case 5:
                ClearGrid();
                sol5(grid);
                break;
            case 6:
                ClearGrid();
                sol6(grid);
                break;
            case 7:
                ClearGrid();
                sol7(grid);
                break; 
            case 8:
                ClearGrid();
                sol8(grid);
                break;
            case 9:
                ClearGrid();
                sol9(grid);
                break;
            case 10:
                ClearGrid();
                sol10(grid);
                break;
            default:
                break;
        }
        return grid;
        
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static int[][] puz1(int[][] puz1) {
        grid[0][0]=5;
        grid[0][1]=0;
        grid[0][2]=1;
        grid[0][3]=0;
        grid[0][4]=0;
        grid[0][5]=0;        
        grid[0][6]=0;
        grid[0][7]=7;
        grid[0][8]=0;
        
        grid[1][0]=0;
        grid[1][1]=0;
        grid[1][2]=0;
        grid[1][3]=8;
        grid[1][4]=5;
        grid[1][5]=0;        
        grid[1][6]=1;
        grid[1][7]=0;
        grid[1][8]=0;
        
        grid[2][0]=0;
        grid[2][1]=0;
        grid[2][2]=7;
        grid[2][3]=0;
        grid[2][4]=0;
        grid[2][5]=6;        
        grid[2][6]=0;
        grid[2][7]=0;
        grid[2][8]=2;
        
        grid[3][0]=0;
        grid[3][1]=0;
        grid[3][2]=0;
        grid[3][3]=0;
        grid[3][4]=3;
        grid[3][5]=2;        
        grid[3][6]=0;
        grid[3][7]=1;
        grid[3][8]=0;
                
        grid[4][0]=0;
        grid[4][1]=0;
        grid[4][2]=5;
        grid[4][3]=7;
        grid[4][4]=1;
        grid[4][5]=4;      
        grid[4][6]=3;
        grid[4][7]=0;
        grid[4][8]=0; 
                
        grid[5][0]=0;
        grid[5][1]=3;
        grid[5][2]=0;
        grid[5][3]=6;
        grid[5][4]=8;
        grid[5][5]=0;        
        grid[5][6]=0;
        grid[5][7]=0;
        grid[5][8]=0;
                
        grid[6][0]=6;
        grid[6][1]=0;
        grid[6][2]=0;
        grid[6][3]=3;
        grid[6][4]=0;
        grid[6][5]=0;        
        grid[6][6]=5;
        grid[6][7]=0;
        grid[6][8]=0; 
                
        grid[7][0]=0;
        grid[7][1]=0;
        grid[7][2]=8;
        grid[7][3]=0;
        grid[7][4]=4;
        grid[7][5]=1;        
        grid[7][6]=0;
        grid[7][7]=0;
        grid[7][8]=0;    
                
        grid[8][0]=0;
        grid[8][1]=1;
        grid[8][2]=0;
        grid[8][3]=0;
        grid[8][4]=0;
        grid[8][5]=0;        
        grid[8][6]=2;
        grid[8][7]=0;
        grid[8][8]=4;
           return grid;
    }
    public static int[][] puz2(int[][] puz2) {
        grid[0][0]=6;
        grid[0][1]=0;
        grid[0][2]=8;
        grid[0][3]=0;
        grid[0][4]=9;
        grid[0][5]=0;        
        grid[0][6]=0;
        grid[0][7]=2;
        grid[0][8]=0;
        
        grid[1][0]=0;
        grid[1][1]=0;
        grid[1][2]=0;
        grid[1][3]=2;
        grid[1][4]=0;
        grid[1][5]=3;        
        grid[1][6]=8;
        grid[1][7]=0;
        grid[1][8]=0;
        
        grid[2][0]=0;
        grid[2][1]=0;
        grid[2][2]=0;
        grid[2][3]=8;
        grid[2][4]=4;
        grid[2][5]=6;        
        grid[2][6]=0;
        grid[2][7]=5;
        grid[2][8]=0;
        
        grid[3][0]=0;
        grid[3][1]=0;
        grid[3][2]=2;
        grid[3][3]=9;
        grid[3][4]=0;
        grid[3][5]=0;        
        grid[3][6]=0;
        grid[3][7]=0;
        grid[3][8]=0;
                
        grid[4][0]=0;
        grid[4][1]=6;
        grid[4][2]=0;
        grid[4][3]=0;
        grid[4][4]=8;
        grid[4][5]=0;     
        grid[4][6]=0;
        grid[4][7]=9;
        grid[4][8]=0; 
                
        grid[5][0]=0;
        grid[5][1]=0;
        grid[5][2]=0;
        grid[5][3]=0;
        grid[5][4]=0;
        grid[5][5]=7;      
        grid[5][6]=2;
        grid[5][7]=0;
        grid[5][8]=0;
                
        grid[6][0]=0;
        grid[6][1]=8;
        grid[6][2]=0;
        grid[6][3]=3;
        grid[6][4]=7;
        grid[6][5]=9;        
        grid[6][6]=0;
        grid[6][7]=0;
        grid[6][8]=0;
               
        grid[7][0]=0;
        grid[7][1]=0;
        grid[7][2]=1;
        grid[7][3]=6;
        grid[7][4]=0;
        grid[7][5]=4;        
        grid[7][6]=0;
        grid[7][7]=0;
        grid[7][8]=0;    
               
        grid[8][0]=0;
        grid[8][1]=3;
        grid[8][2]=0;
        grid[8][3]=0;
        grid[8][4]=1;
        grid[8][5]=0;        
        grid[8][6]=9;
        grid[8][7]=0;
        grid[8][8]=6;
           return grid;
    }
    public static int[][] puz3(int[][] puz3) {
        grid[0][0]=9;
        grid[0][1]=8;
        grid[0][2]=0;
        grid[0][3]=5;
        grid[0][4]=0;
        grid[0][5]=7;        
        grid[0][6]=0;
        grid[0][7]=0;
        grid[0][8]=0;
        
        grid[1][0]=1;
        grid[1][1]=0;
        grid[1][2]=0;
        grid[1][3]=0;
        grid[1][4]=0;
        grid[1][5]=9;        
        grid[1][6]=0;
        grid[1][7]=0;
        grid[1][8]=7;
        
        grid[2][0]=0;
        grid[2][1]=0;
        grid[2][2]=6;
        grid[2][3]=0;
        grid[2][4]=0;
        grid[2][5]=1;        
        grid[2][6]=0;
        grid[2][7]=0;
        grid[2][8]=0;
        
        grid[3][0]=6;
        grid[3][1]=5;
        grid[3][2]=0;
        grid[3][3]=9;
        grid[3][4]=0;
        grid[3][5]=2;        
        grid[3][6]=0;
        grid[3][7]=0;
        grid[3][8]=0;
                
        grid[4][0]=0;
        grid[4][1]=0;
        grid[4][2]=1;
        grid[4][3]=8;
        grid[4][4]=0;
        grid[4][5]=6;     
        grid[4][6]=9;
        grid[4][7]=0;
        grid[4][8]=0; 
                
        grid[5][0]=0;
        grid[5][1]=0;
        grid[5][2]=0;
        grid[5][3]=7;
        grid[5][4]=0;
        grid[5][5]=3;      
        grid[5][6]=0;
        grid[5][7]=1;
        grid[5][8]=4;
                
        grid[6][0]=0;
        grid[6][1]=0;
        grid[6][2]=0;
        grid[6][3]=6;
        grid[6][4]=0;
        grid[6][5]=0;        
        grid[6][6]=5;
        grid[6][7]=0;
        grid[6][8]=0;
               
        grid[7][0]=5;
        grid[7][1]=0;
        grid[7][2]=0;
        grid[7][3]=2;
        grid[7][4]=0;
        grid[7][5]=0;        
        grid[7][6]=0;
        grid[7][7]=0;
        grid[7][8]=8;    
               
        grid[8][0]=0;
        grid[8][1]=0;
        grid[8][2]=0;
        grid[8][3]=1;
        grid[8][4]=0;
        grid[8][5]=5;        
        grid[8][6]=0;
        grid[8][7]=2;
        grid[8][8]=6;
           return grid;
    }
    public static int[][] puz4(int[][] puz4) {
        grid[0][0]=2;
        grid[0][1]=1;
        grid[0][2]=0;
        grid[0][3]=8;
        grid[0][4]=9;
        grid[0][5]=6;        
        grid[0][6]=0;
        grid[0][7]=7;
        grid[0][8]=0;
        
        grid[1][0]=0;
        grid[1][1]=3;
        grid[1][2]=9;
        grid[1][3]=0;
        grid[1][4]=0;
        grid[1][5]=0;        
        grid[1][6]=0;
        grid[1][7]=5;
        grid[1][8]=0;
        
        grid[2][0]=0;
        grid[2][1]=0;
        grid[2][2]=0;
        grid[2][3]=0;
        grid[2][4]=0;
        grid[2][5]=3;        
        grid[2][6]=1;
        grid[2][7]=8;
        grid[2][8]=0;
        
        grid[3][0]=0;
        grid[3][1]=0;
        grid[3][2]=0;
        grid[3][3]=0;
        grid[3][4]=0;
        grid[3][5]=8;        
        grid[3][6]=0;
        grid[3][7]=0;
        grid[3][8]=0;
                
        grid[4][0]=1;
        grid[4][1]=0;
        grid[4][2]=0;
        grid[4][3]=5;
        grid[4][4]=0;
        grid[4][5]=9;     
        grid[4][6]=0;
        grid[4][7]=0;
        grid[4][8]=3; 
                
        grid[5][0]=0;
        grid[5][1]=0;
        grid[5][2]=0;
        grid[5][3]=3;
        grid[5][4]=0;
        grid[5][5]=0;      
        grid[5][6]=0;
        grid[5][7]=0;
        grid[5][8]=0;
                
        grid[6][0]=0;
        grid[6][1]=7;
        grid[6][2]=2;
        grid[6][3]=1;
        grid[6][4]=0;
        grid[6][5]=0;        
        grid[6][6]=0;
        grid[6][7]=0;
        grid[6][8]=0;
               
        grid[7][0]=0;
        grid[7][1]=8;
        grid[7][2]=0;
        grid[7][3]=0;
        grid[7][4]=0;
        grid[7][5]=0;        
        grid[7][6]=4;
        grid[7][7]=6;
        grid[7][8]=0;    
               
        grid[8][0]=0;
        grid[8][1]=9;
        grid[8][2]=0;
        grid[8][3]=6;
        grid[8][4]=7;
        grid[8][5]=5;        
        grid[8][6]=0;
        grid[8][7]=1;
        grid[8][8]=8;
           return grid;
    }
    public static int[][] puz5(int[][] puz5) {
        grid[0][0]=5;
        grid[0][1]=0;
        grid[0][2]=9;
        grid[0][3]=0;
        grid[0][4]=0;
        grid[0][5]=8;        
        grid[0][6]=0;
        grid[0][7]=0;
        grid[0][8]=0;
        
        grid[1][0]=8;
        grid[1][1]=0;
        grid[1][2]=0;
        grid[1][3]=0;
        grid[1][4]=1;
        grid[1][5]=0;        
        grid[1][6]=0;
        grid[1][7]=2;
        grid[1][8]=3;
        
        grid[2][0]=0;
        grid[2][1]=0;
        grid[2][2]=0;
        grid[2][3]=0;
        grid[2][4]=0;
        grid[2][5]=5;        
        grid[2][6]=0;
        grid[2][7]=0;
        grid[2][8]=8;
        
        grid[3][0]=0;
        grid[3][1]=0;
        grid[3][2]=2;
        grid[3][3]=0;
        grid[3][4]=6;
        grid[3][5]=0;        
        grid[3][6]=8;
        grid[3][7]=0;
        grid[3][8]=4;
                
        grid[4][0]=3;
        grid[4][1]=0;
        grid[4][2]=0;
        grid[4][3]=4;
        grid[4][4]=0;
        grid[4][5]=9;     
        grid[4][6]=0;
        grid[4][7]=0;
        grid[4][8]=6; 
                
        grid[5][0]=6;
        grid[5][1]=0;
        grid[5][2]=4;
        grid[5][3]=0;
        grid[5][4]=2;
        grid[5][5]=0;      
        grid[5][6]=1;
        grid[5][7]=0;
        grid[5][8]=0;
                
        grid[6][0]=1;
        grid[6][1]=0;
        grid[6][2]=0;
        grid[6][3]=3;
        grid[6][4]=0;
        grid[6][5]=0;        
        grid[6][6]=0;
        grid[6][7]=0;
        grid[6][8]=0;
               
        grid[7][0]=4;
        grid[7][1]=7;
        grid[7][2]=0;
        grid[7][3]=0;
        grid[7][4]=9;
        grid[7][5]=0;        
        grid[7][6]=0;
        grid[7][7]=0;
        grid[7][8]=2;    
               
        grid[8][0]=0;
        grid[8][1]=0;
        grid[8][2]=0;
        grid[8][3]=6;
        grid[8][4]=0;
        grid[8][5]=0;        
        grid[8][6]=3;
        grid[8][7]=0;
        grid[8][8]=5;
           return grid;
    }
    public static int[][] puz6(int[][] puz6) {
        grid[0][0]=6;
        grid[0][1]=3;
        grid[0][2]=4;
        grid[0][3]=2;
        grid[0][4]=0;
        grid[0][5]=0;        
        grid[0][6]=0;
        grid[0][7]=9;
        grid[0][8]=0;
        
        grid[1][0]=0;
        grid[1][1]=9;
        grid[1][2]=7;
        grid[1][3]=6;
        grid[1][4]=3;
        grid[1][5]=0;        
        grid[1][6]=0;
        grid[1][7]=2;
        grid[1][8]=1;
        
        grid[2][0]=2;
        grid[2][1]=1;
        grid[2][2]=8;
        grid[2][3]=0;
        grid[2][4]=0;
        grid[2][5]=4;        
        grid[2][6]=0;
        grid[2][7]=0;
        grid[2][8]=0;
        
        grid[3][0]=0;
        grid[3][1]=0;
        grid[3][2]=0;
        grid[3][3]=0;
        grid[3][4]=0;
        grid[3][5]=0;        
        grid[3][6]=0;
        grid[3][7]=0;
        grid[3][8]=0;
                
        grid[4][0]=0;
        grid[4][1]=0;
        grid[4][2]=0;
        grid[4][3]=0;
        grid[4][4]=0;
        grid[4][5]=0;     
        grid[4][6]=0;
        grid[4][7]=0;
        grid[4][8]=0; 
                
        grid[5][0]=0;
        grid[5][1]=0;
        grid[5][2]=0;
        grid[5][3]=0;
        grid[5][4]=0;
        grid[5][5]=0;      
        grid[5][6]=0;
        grid[5][7]=0;
        grid[5][8]=0;
                
        grid[6][0]=0;
        grid[6][1]=0;
        grid[6][2]=0;
        grid[6][3]=1;
        grid[6][4]=0;
        grid[6][5]=0;        
        grid[6][6]=7;
        grid[6][7]=8;
        grid[6][8]=9;
               
        grid[7][0]=7;
        grid[7][1]=6;
        grid[7][2]=0;
        grid[7][3]=0;
        grid[7][4]=2;
        grid[7][5]=9;        
        grid[7][6]=3;
        grid[7][7]=1;
        grid[7][8]=0;    
               
        grid[8][0]=0;
        grid[8][1]=8;
        grid[8][2]=0;
        grid[8][3]=0;
        grid[8][4]=0;
        grid[8][5]=3;        
        grid[8][6]=6;
        grid[8][7]=5;
        grid[8][8]=2;
           return grid;
    }
    public static int[][] puz7(int[][] puz7) {
        grid[0][0]=8;
        grid[0][1]=0;
        grid[0][2]=3;
        grid[0][3]=2;
        grid[0][4]=4;
        grid[0][5]=5;        
        grid[0][6]=0;
        grid[0][7]=0;
        grid[0][8]=0;
        
        grid[1][0]=4;
        grid[1][1]=2;
        grid[1][2]=6;
        grid[1][3]=9;
        grid[1][4]=0;
        grid[1][5]=0;        
        grid[1][6]=0;
        grid[1][7]=3;
        grid[1][8]=0;
        
        grid[2][0]=0;
        grid[2][1]=0;
        grid[2][2]=0;
        grid[2][3]=0;
        grid[2][4]=0;
        grid[2][5]=3;        
        grid[2][6]=2;
        grid[2][7]=0;
        grid[2][8]=0;
        
        grid[3][0]=0;
        grid[3][1]=3;
        grid[3][2]=0;
        grid[3][3]=0;
        grid[3][4]=0;
        grid[3][5]=0;        
        grid[3][6]=0;
        grid[3][7]=0;
        grid[3][8]=0;
                
        grid[4][0]=0;
        grid[4][1]=9;
        grid[4][2]=0;
        grid[4][3]=0;
        grid[4][4]=2;
        grid[4][5]=0;     
        grid[4][6]=0;
        grid[4][7]=5;
        grid[4][8]=0; 
                
        grid[5][0]=0;
        grid[5][1]=0;
        grid[5][2]=0;
        grid[5][3]=0;
        grid[5][4]=0;
        grid[5][5]=0;      
        grid[5][6]=0;
        grid[5][7]=2;
        grid[5][8]=0;
                
        grid[6][0]=0;
        grid[6][1]=0;
        grid[6][2]=5;
        grid[6][3]=8;
        grid[6][4]=0;
        grid[6][5]=0;        
        grid[6][6]=0;
        grid[6][7]=0;
        grid[6][8]=0;
               
        grid[7][0]=0;
        grid[7][1]=6;
        grid[7][2]=0;
        grid[7][3]=0;
        grid[7][4]=0;
        grid[7][5]=4;        
        grid[7][6]=1;
        grid[7][7]=8;
        grid[7][8]=2;    
               
        grid[8][0]=0;
        grid[8][1]=0;
        grid[8][2]=0;
        grid[8][3]=7;
        grid[8][4]=1;
        grid[8][5]=2;        
        grid[8][6]=5;
        grid[8][7]=0;
        grid[8][8]=6;
           return grid;
    }
    public static int[][] puz8(int[][] puz8) {
        grid[0][0]=3;
        grid[0][1]=0;
        grid[0][2]=8;
        grid[0][3]=2;
        grid[0][4]=5;
        grid[0][5]=0;        
        grid[0][6]=1;
        grid[0][7]=0;
        grid[0][8]=0;
        
        grid[1][0]=5;
        grid[1][1]=6;
        grid[1][2]=0;
        grid[1][3]=0;
        grid[1][4]=7;
        grid[1][5]=1;        
        grid[1][6]=3;
        grid[1][7]=0;
        grid[1][8]=4;
        
        grid[2][0]=1;
        grid[2][1]=0;
        grid[2][2]=0;
        grid[2][3]=0;
        grid[2][4]=0;
        grid[2][5]=3;        
        grid[2][6]=0;
        grid[2][7]=0;
        grid[2][8]=0;
        
        grid[3][0]=0;
        grid[3][1]=0;
        grid[3][2]=0;
        grid[3][3]=0;
        grid[3][4]=0;
        grid[3][5]=0;        
        grid[3][6]=6;
        grid[3][7]=0;
        grid[3][8]=0;
                
        grid[4][0]=0;
        grid[4][1]=0;
        grid[4][2]=0;
        grid[4][3]=0;
        grid[4][4]=3;
        grid[4][5]=0;     
        grid[4][6]=0;
        grid[4][7]=0;
        grid[4][8]=0; 
                
        grid[5][0]=0;
        grid[5][1]=0;
        grid[5][2]=1;
        grid[5][3]=0;
        grid[5][4]=0;
        grid[5][5]=0;      
        grid[5][6]=0;
        grid[5][7]=0;
        grid[5][8]=0;
                
        grid[6][0]=0;
        grid[6][1]=0;
        grid[6][2]=0;
        grid[6][3]=7;
        grid[6][4]=0;
        grid[6][5]=0;        
        grid[6][6]=0;
        grid[6][7]=0;
        grid[6][8]=2;
               
        grid[7][0]=6;
        grid[7][1]=0;
        grid[7][2]=7;
        grid[7][3]=5;
        grid[7][4]=4;
        grid[7][5]=0;        
        grid[7][6]=0;
        grid[7][7]=3;
        grid[7][8]=1;    
               
        grid[8][0]=0;
        grid[8][1]=0;
        grid[8][2]=5;
        grid[8][3]=0;
        grid[8][4]=6;
        grid[8][5]=2;        
        grid[8][6]=4;
        grid[8][7]=0;
        grid[8][8]=7;
           return grid;
    }
    public static int[][] puz9(int[][] puz9) {
        grid[0][0]=4;
        grid[0][1]=0;
        grid[0][2]=0;
        grid[0][3]=2;
        grid[0][4]=0;
        grid[0][5]=5;        
        grid[0][6]=0;
        grid[0][7]=9;
        grid[0][8]=0;
        
        grid[1][0]=0;
        grid[1][1]=0;
        grid[1][2]=0;
        grid[1][3]=0;
        grid[1][4]=1;
        grid[1][5]=6;        
        grid[1][6]=0;
        grid[1][7]=0;
        grid[1][8]=5;
        
        grid[2][0]=6;
        grid[2][1]=0;
        grid[2][2]=5;
        grid[2][3]=7;
        grid[2][4]=0;
        grid[2][5]=0;        
        grid[2][6]=0;
        grid[2][7]=0;
        grid[2][8]=0;
        
        grid[3][0]=0;
        grid[3][1]=0;
        grid[3][2]=3;
        grid[3][3]=0;
        grid[3][4]=2;
        grid[3][5]=0;        
        grid[3][6]=0;
        grid[3][7]=0;
        grid[3][8]=8;
                
        grid[4][0]=2;
        grid[4][1]=6;
        grid[4][2]=0;
        grid[4][3]=0;
        grid[4][4]=0;
        grid[4][5]=0;     
        grid[4][6]=0;
        grid[4][7]=7;
        grid[4][8]=1; 
                
        grid[5][0]=5;
        grid[5][1]=0;
        grid[5][2]=0;
        grid[5][3]=0;
        grid[5][4]=9;
        grid[5][5]=0;      
        grid[5][6]=6;
        grid[5][7]=0;
        grid[5][8]=0;
                
        grid[6][0]=0;
        grid[6][1]=0;
        grid[6][2]=0;
        grid[6][3]=0;
        grid[6][4]=0;
        grid[6][5]=1;        
        grid[6][6]=3;
        grid[6][7]=0;
        grid[6][8]=9;
               
        grid[7][0]=8;
        grid[7][1]=0;
        grid[7][2]=0;
        grid[7][3]=9;
        grid[7][4]=6;
        grid[7][5]=0;        
        grid[7][6]=0;
        grid[7][7]=0;
        grid[7][8]=0;    
               
        grid[8][0]=0;
        grid[8][1]=1;
        grid[8][2]=0;
        grid[8][3]=5;
        grid[8][4]=0;
        grid[8][5]=3;        
        grid[8][6]=0;
        grid[8][7]=0;
        grid[8][8]=4;
           return grid;
    }
    public static int[][] puz10(int[][] puz10) {
        grid[0][0]=9;
        grid[0][1]=0;
        grid[0][2]=0;
        grid[0][3]=1;
        grid[0][4]=8;
        grid[0][5]=0;        
        grid[0][6]=4;
        grid[0][7]=3;
        grid[0][8]=0;
        
        grid[1][0]=0;
        grid[1][1]=2;
        grid[1][2]=0;
        grid[1][3]=0;
        grid[1][4]=9;
        grid[1][5]=0;        
        grid[1][6]=6;
        grid[1][7]=0;
        grid[1][8]=0;
        
        grid[2][0]=0;
        grid[2][1]=6;
        grid[2][2]=0;
        grid[2][3]=0;
        grid[2][4]=0;
        grid[2][5]=0;        
        grid[2][6]=0;
        grid[2][7]=0;
        grid[2][8]=5;
        
        grid[3][0]=0;
        grid[3][1]=0;
        grid[3][2]=0;
        grid[3][3]=9;
        grid[3][4]=0;
        grid[3][5]=8;        
        grid[3][6]=5;
        grid[3][7]=1;
        grid[3][8]=0;
                
        grid[4][0]=0;
        grid[4][1]=0;
        grid[4][2]=5;
        grid[4][3]=0;
        grid[4][4]=0;
        grid[4][5]=0;     
        grid[4][6]=2;
        grid[4][7]=0;
        grid[4][8]=0; 
                
        grid[5][0]=0;
        grid[5][1]=3;
        grid[5][2]=8;
        grid[5][3]=4;
        grid[5][4]=0;
        grid[5][5]=2;      
        grid[5][6]=0;
        grid[5][7]=0;
        grid[5][8]=0;
                
        grid[6][0]=3;
        grid[6][1]=0;
        grid[6][2]=0;
        grid[6][3]=0;
        grid[6][4]=0;
        grid[6][5]=0;        
        grid[6][6]=0;
        grid[6][7]=5;
        grid[6][8]=0;
               
        grid[7][0]=0;
        grid[7][1]=0;
        grid[7][2]=4;
        grid[7][3]=0;
        grid[7][4]=3;
        grid[7][5]=0;        
        grid[7][6]=0;
        grid[7][7]=9;
        grid[7][8]=0;    
               
        grid[8][0]=0;
        grid[8][1]=7;
        grid[8][2]=9;
        grid[8][3]=0;
        grid[8][4]=4;
        grid[8][5]=1;        
        grid[8][6]=0;
        grid[8][7]=0;
        grid[8][8]=6;
           return grid;
    }   
    
    
    
    
    
    
    public static int[][] sol1(int[][] puz1) {
        grid[0][0]=5;
        grid[0][1]=6;
        grid[0][2]=1;
        grid[0][3]=4;
        grid[0][4]=2;
        grid[0][5]=3;        
        grid[0][6]=8;
        grid[0][7]=7;
        grid[0][8]=9;
        
        grid[1][0]=2;
        grid[1][1]=4;
        grid[1][2]=9;
        grid[1][3]=8;
        grid[1][4]=5;
        grid[1][5]=7;        
        grid[1][6]=1;
        grid[1][7]=6;
        grid[1][8]=3;
        
        grid[2][0]=3;
        grid[2][1]=8;
        grid[2][2]=7;
        grid[2][3]=1;
        grid[2][4]=9;
        grid[2][5]=6;        
        grid[2][6]=4;
        grid[2][7]=5;
        grid[2][8]=2;
        
        grid[3][0]=4;
        grid[3][1]=7;
        grid[3][2]=6;
        grid[3][3]=5;
        grid[3][4]=3;
        grid[3][5]=2;        
        grid[3][6]=9;
        grid[3][7]=1;
        grid[3][8]=8;
                
        grid[4][0]=8;
        grid[4][1]=9;
        grid[4][2]=5;
        grid[4][3]=7;
        grid[4][4]=1;
        grid[4][5]=4;      
        grid[4][6]=3;
        grid[4][7]=2;
        grid[4][8]=6; 
                
        grid[5][0]=1;
        grid[5][1]=3;
        grid[5][2]=2;
        grid[5][3]=6;
        grid[5][4]=8;
        grid[5][5]=9;        
        grid[5][6]=7;
        grid[5][7]=4;
        grid[5][8]=5;
                
        grid[6][0]=6;
        grid[6][1]=2;
        grid[6][2]=4;
        grid[6][3]=3;
        grid[6][4]=7;
        grid[6][5]=8;        
        grid[6][6]=5;
        grid[6][7]=9;
        grid[6][8]=1; 
                
        grid[7][0]=9;
        grid[7][1]=5;
        grid[7][2]=8;
        grid[7][3]=2;
        grid[7][4]=4;
        grid[7][5]=1;        
        grid[7][6]=6;
        grid[7][7]=3;
        grid[7][8]=7;    
                
        grid[8][0]=7;
        grid[8][1]=1;
        grid[8][2]=3;
        grid[8][3]=9;
        grid[8][4]=6;
        grid[8][5]=5;        
        grid[8][6]=2;
        grid[8][7]=8;
        grid[8][8]=4;
           return grid;
    }
    public static int[][] sol2(int[][] puz2) {
        grid[0][0]=6;
        grid[0][1]=5;
        grid[0][2]=8;
        grid[0][3]=7;
        grid[0][4]=9;
        grid[0][5]=1;        
        grid[0][6]=3;
        grid[0][7]=2;
        grid[0][8]=4;
        
        grid[1][0]=1;
        grid[1][1]=4;
        grid[1][2]=9;
        grid[1][3]=2;
        grid[1][4]=5;
        grid[1][5]=3;        
        grid[1][6]=8;
        grid[1][7]=6;
        grid[1][8]=7;
        
        grid[2][0]=3;
        grid[2][1]=2;
        grid[2][2]=7;
        grid[2][3]=8;
        grid[2][4]=4;
        grid[2][5]=6;        
        grid[2][6]=1;
        grid[2][7]=5;
        grid[2][8]=9;
        
        grid[3][0]=7;
        grid[3][1]=1;
        grid[3][2]=2;
        grid[3][3]=9;
        grid[3][4]=3;
        grid[3][5]=5;        
        grid[3][6]=6;
        grid[3][7]=4;
        grid[3][8]=8;
                
        grid[4][0]=4;
        grid[4][1]=6;
        grid[4][2]=3;
        grid[4][3]=1;
        grid[4][4]=8;
        grid[4][5]=2;     
        grid[4][6]=7;
        grid[4][7]=9;
        grid[4][8]=5; 
                
        grid[5][0]=8;
        grid[5][1]=9;
        grid[5][2]=5;
        grid[5][3]=4;
        grid[5][4]=6;
        grid[5][5]=7;      
        grid[5][6]=2;
        grid[5][7]=3;
        grid[5][8]=1;
                
        grid[6][0]=5;
        grid[6][1]=8;
        grid[6][2]=6;
        grid[6][3]=3;
        grid[6][4]=7;
        grid[6][5]=9;        
        grid[6][6]=4;
        grid[6][7]=1;
        grid[6][8]=2;
               
        grid[7][0]=9;
        grid[7][1]=7;
        grid[7][2]=1;
        grid[7][3]=6;
        grid[7][4]=2;
        grid[7][5]=4;        
        grid[7][6]=5;
        grid[7][7]=8;
        grid[7][8]=3;    
               
        grid[8][0]=2;
        grid[8][1]=3;
        grid[8][2]=4;
        grid[8][3]=5;
        grid[8][4]=1;
        grid[8][5]=8;        
        grid[8][6]=9;
        grid[8][7]=7;
        grid[8][8]=6;
           return grid;
    }
    public static int[][] sol3(int[][] puz3) {
        grid[0][0]=9;
        grid[0][1]=8;
        grid[0][2]=2;
        grid[0][3]=5;
        grid[0][4]=6;
        grid[0][5]=7;        
        grid[0][6]=3;
        grid[0][7]=4;
        grid[0][8]=1;
        
        grid[1][0]=1;
        grid[1][1]=3;
        grid[1][2]=5;
        grid[1][3]=4;
        grid[1][4]=8;
        grid[1][5]=9;        
        grid[1][6]=2;
        grid[1][7]=6;
        grid[1][8]=7;
        
        grid[2][0]=7;
        grid[2][1]=4;
        grid[2][2]=6;
        grid[2][3]=3;
        grid[2][4]=2;
        grid[2][5]=1;        
        grid[2][6]=5;
        grid[2][7]=8;
        grid[2][8]=9;
        
        grid[3][0]=6;
        grid[3][1]=5;
        grid[3][2]=4;
        grid[3][3]=9;
        grid[3][4]=1;
        grid[3][5]=2;        
        grid[3][6]=8;
        grid[3][7]=7;
        grid[3][8]=3;
                
        grid[4][0]=3;
        grid[4][1]=7;
        grid[4][2]=1;
        grid[4][3]=8;
        grid[4][4]=4;
        grid[4][5]=6;     
        grid[4][6]=9;
        grid[4][7]=5;
        grid[4][8]=2; 
                
        grid[5][0]=8;
        grid[5][1]=2;
        grid[5][2]=9;
        grid[5][3]=7;
        grid[5][4]=5;
        grid[5][5]=3;      
        grid[5][6]=6;
        grid[5][7]=1;
        grid[5][8]=4;
                
        grid[6][0]=2;
        grid[6][1]=1;
        grid[6][2]=3;
        grid[6][3]=6;
        grid[6][4]=7;
        grid[6][5]=8;        
        grid[6][6]=4;
        grid[6][7]=9;
        grid[6][8]=5;
               
        grid[7][0]=5;
        grid[7][1]=6;
        grid[7][2]=7;
        grid[7][3]=2;
        grid[7][4]=9;
        grid[7][5]=4;        
        grid[7][6]=1;
        grid[7][7]=3;
        grid[7][8]=8;    
               
        grid[8][0]=4;
        grid[8][1]=9;
        grid[8][2]=8;
        grid[8][3]=1;
        grid[8][4]=3;
        grid[8][5]=5;        
        grid[8][6]=7;
        grid[8][7]=2;
        grid[8][8]=6;
           return grid;
    }
    public static int[][] sol4(int[][] puz4) {
        grid[0][0]=2;
        grid[0][1]=1;
        grid[0][2]=5;
        grid[0][3]=8;
        grid[0][4]=9;
        grid[0][5]=6;        
        grid[0][6]=3;
        grid[0][7]=7;
        grid[0][8]=4;
        
        grid[1][0]=8;
        grid[1][1]=3;
        grid[1][2]=9;
        grid[1][3]=4;
        grid[1][4]=1;
        grid[1][5]=7;        
        grid[1][6]=6;
        grid[1][7]=5;
        grid[1][8]=2;
        
        grid[2][0]=7;
        grid[2][1]=4;
        grid[2][2]=6;
        grid[2][3]=2;
        grid[2][4]=5;
        grid[2][5]=3;        
        grid[2][6]=1;
        grid[2][7]=8;
        grid[2][8]=9;
        
        grid[3][0]=4;
        grid[3][1]=2;
        grid[3][2]=3;
        grid[3][3]=7;
        grid[3][4]=6;
        grid[3][5]=8;        
        grid[3][6]=5;
        grid[3][7]=9;
        grid[3][8]=1;
                
        grid[4][0]=1;
        grid[4][1]=6;
        grid[4][2]=7;
        grid[4][3]=5;
        grid[4][4]=2;
        grid[4][5]=9;     
        grid[4][6]=8;
        grid[4][7]=4;
        grid[4][8]=3; 
                
        grid[5][0]=9;
        grid[5][1]=5;
        grid[5][2]=8;
        grid[5][3]=3;
        grid[5][4]=4;
        grid[5][5]=1;      
        grid[5][6]=7;
        grid[5][7]=2;
        grid[5][8]=6;
                
        grid[6][0]=6;
        grid[6][1]=7;
        grid[6][2]=2;
        grid[6][3]=1;
        grid[6][4]=8;
        grid[6][5]=4;        
        grid[6][6]=9;
        grid[6][7]=3;
        grid[6][8]=5;
               
        grid[7][0]=5;
        grid[7][1]=8;
        grid[7][2]=1;
        grid[7][3]=9;
        grid[7][4]=3;
        grid[7][5]=2;        
        grid[7][6]=4;
        grid[7][7]=6;
        grid[7][8]=7;    
               
        grid[8][0]=3;
        grid[8][1]=9;
        grid[8][2]=4;
        grid[8][3]=6;
        grid[8][4]=7;
        grid[8][5]=5;        
        grid[8][6]=2;
        grid[8][7]=1;
        grid[8][8]=8;
           return grid;
    }
    public static int[][] sol5(int[][] puz5) {
        grid[0][0]=5;
        grid[0][1]=3;
        grid[0][2]=9;
        grid[0][3]=2;
        grid[0][4]=4;
        grid[0][5]=8;        
        grid[0][6]=7;
        grid[0][7]=6;
        grid[0][8]=1;
        
        grid[1][0]=8;
        grid[1][1]=4;
        grid[1][2]=7;
        grid[1][3]=9;
        grid[1][4]=1;
        grid[1][5]=6;        
        grid[1][6]=5;
        grid[1][7]=2;
        grid[1][8]=3;
        
        grid[2][0]=2;
        grid[2][1]=1;
        grid[2][2]=6;
        grid[2][3]=7;
        grid[2][4]=3;
        grid[2][5]=5;        
        grid[2][6]=4;
        grid[2][7]=9;
        grid[2][8]=8;
        
        grid[3][0]=7;
        grid[3][1]=9;
        grid[3][2]=2;
        grid[3][3]=1;
        grid[3][4]=6;
        grid[3][5]=3;        
        grid[3][6]=8;
        grid[3][7]=5;
        grid[3][8]=4;
                
        grid[4][0]=3;
        grid[4][1]=8;
        grid[4][2]=1;
        grid[4][3]=4;
        grid[4][4]=5;
        grid[4][5]=9;     
        grid[4][6]=2;
        grid[4][7]=7;
        grid[4][8]=6; 
                
        grid[5][0]=6;
        grid[5][1]=5;
        grid[5][2]=4;
        grid[5][3]=8;
        grid[5][4]=2;
        grid[5][5]=7;      
        grid[5][6]=1;
        grid[5][7]=3;
        grid[5][8]=9;
                
        grid[6][0]=1;
        grid[6][1]=6;
        grid[6][2]=5;
        grid[6][3]=3;
        grid[6][4]=8;
        grid[6][5]=2;        
        grid[6][6]=9;
        grid[6][7]=4;
        grid[6][8]=7;
               
        grid[7][0]=4;
        grid[7][1]=7;
        grid[7][2]=3;
        grid[7][3]=5;
        grid[7][4]=9;
        grid[7][5]=1;        
        grid[7][6]=6;
        grid[7][7]=8;
        grid[7][8]=2;    
               
        grid[8][0]=9;
        grid[8][1]=2;
        grid[8][2]=8;
        grid[8][3]=6;
        grid[8][4]=7;
        grid[8][5]=4;        
        grid[8][6]=3;
        grid[8][7]=1;
        grid[8][8]=5;
           return grid;
    }
    public static int[][] sol6(int[][] puz6) {
        grid[0][0]=6;
        grid[0][1]=3;
        grid[0][2]=4;
        grid[0][3]=2;
        grid[0][4]=1;
        grid[0][5]=5;        
        grid[0][6]=8;
        grid[0][7]=9;
        grid[0][8]=7;
        
        grid[1][0]=5;
        grid[1][1]=9;
        grid[1][2]=7;
        grid[1][3]=6;
        grid[1][4]=3;
        grid[1][5]=8;        
        grid[1][6]=4;
        grid[1][7]=2;
        grid[1][8]=1;
        
        grid[2][0]=2;
        grid[2][1]=1;
        grid[2][2]=8;
        grid[2][3]=7;
        grid[2][4]=9;
        grid[2][5]=4;        
        grid[2][6]=5;
        grid[2][7]=3;
        grid[2][8]=6;
        
        grid[3][0]=4;
        grid[3][1]=2;
        grid[3][2]=3;
        grid[3][3]=5;
        grid[3][4]=6;
        grid[3][5]=1;        
        grid[3][6]=9;
        grid[3][7]=7;
        grid[3][8]=8;
                
        grid[4][0]=8;
        grid[4][1]=5;
        grid[4][2]=1;
        grid[4][3]=9;
        grid[4][4]=4;
        grid[4][5]=7;     
        grid[4][6]=2;
        grid[4][7]=6;
        grid[4][8]=3; 
                
        grid[5][0]=9;
        grid[5][1]=7;
        grid[5][2]=6;
        grid[5][3]=3;
        grid[5][4]=8;
        grid[5][5]=2;      
        grid[5][6]=1;
        grid[5][7]=4;
        grid[5][8]=5;
                
        grid[6][0]=3;
        grid[6][1]=4;
        grid[6][2]=2;
        grid[6][3]=1;
        grid[6][4]=5;
        grid[6][5]=6;        
        grid[6][6]=7;
        grid[6][7]=8;
        grid[6][8]=9;
               
        grid[7][0]=7;
        grid[7][1]=6;
        grid[7][2]=5;
        grid[7][3]=8;
        grid[7][4]=2;
        grid[7][5]=9;        
        grid[7][6]=3;
        grid[7][7]=1;
        grid[7][8]=4;    
               
        grid[8][0]=1;
        grid[8][1]=8;
        grid[8][2]=9;
        grid[8][3]=4;
        grid[8][4]=7;
        grid[8][5]=3;        
        grid[8][6]=6;
        grid[8][7]=5;
        grid[8][8]=2;
           return grid;
    }
    public static int[][] sol7(int[][] puz7) {
        grid[0][0]=8;
        grid[0][1]=7;
        grid[0][2]=3;
        grid[0][3]=2;
        grid[0][4]=4;
        grid[0][5]=5;        
        grid[0][6]=6;
        grid[0][7]=1;
        grid[0][8]=9;
        
        grid[1][0]=4;
        grid[1][1]=2;
        grid[1][2]=6;
        grid[1][3]=9;
        grid[1][4]=7;
        grid[1][5]=1;        
        grid[1][6]=8;
        grid[1][7]=3;
        grid[1][8]=5;
        
        grid[2][0]=1;
        grid[2][1]=5;
        grid[2][2]=9;
        grid[2][3]=6;
        grid[2][4]=8;
        grid[2][5]=3;        
        grid[2][6]=2;
        grid[2][7]=4;
        grid[2][8]=7;
        
        grid[3][0]=5;
        grid[3][1]=3;
        grid[3][2]=2;
        grid[3][3]=1;
        grid[3][4]=9;
        grid[3][5]=8;        
        grid[3][6]=4;
        grid[3][7]=6;
        grid[3][8]=8;
                
        grid[4][0]=6;
        grid[4][1]=9;
        grid[4][2]=1;
        grid[4][3]=4;
        grid[4][4]=2;
        grid[4][5]=8;     
        grid[4][6]=7;
        grid[4][7]=5;
        grid[4][8]=3; 
                
        grid[5][0]=7;
        grid[5][1]=4;
        grid[5][2]=8;
        grid[5][3]=3;
        grid[5][4]=5;
        grid[5][5]=6;      
        grid[5][6]=9;
        grid[5][7]=2;
        grid[5][8]=1;
                
        grid[6][0]=2;
        grid[6][1]=1;
        grid[6][2]=5;
        grid[6][3]=8;
        grid[6][4]=6;
        grid[6][5]=9;        
        grid[6][6]=3;
        grid[6][7]=7;
        grid[6][8]=4;
               
        grid[7][0]=9;
        grid[7][1]=6;
        grid[7][2]=7;
        grid[7][3]=5;
        grid[7][4]=3;
        grid[7][5]=4;        
        grid[7][6]=1;
        grid[7][7]=8;
        grid[7][8]=2;    
               
        grid[8][0]=3;
        grid[8][1]=8;
        grid[8][2]=4;
        grid[8][3]=7;
        grid[8][4]=1;
        grid[8][5]=2;        
        grid[8][6]=5;
        grid[8][7]=9;
        grid[8][8]=6;
           return grid;
    }
    public static int[][] sol8(int[][] puz8) {
        grid[0][0]=3;
        grid[0][1]=7;
        grid[0][2]=8;
        grid[0][3]=2;
        grid[0][4]=5;
        grid[0][5]=4;        
        grid[0][6]=1;
        grid[0][7]=9;
        grid[0][8]=6;
        
        grid[1][0]=5;
        grid[1][1]=6;
        grid[1][2]=9;
        grid[1][3]=8;
        grid[1][4]=7;
        grid[1][5]=1;        
        grid[1][6]=3;
        grid[1][7]=2;
        grid[1][8]=4;
        
        grid[2][0]=1;
        grid[2][1]=4;
        grid[2][2]=2;
        grid[2][3]=6;
        grid[2][4]=9;
        grid[2][5]=3;        
        grid[2][6]=7;
        grid[2][7]=5;
        grid[2][8]=8;
        
        grid[3][0]=4;
        grid[3][1]=8;
        grid[3][2]=3;
        grid[3][3]=1;
        grid[3][4]=2;
        grid[3][5]=5;        
        grid[3][6]=6;
        grid[3][7]=7;
        grid[3][8]=9;
                
        grid[4][0]=2;
        grid[4][1]=9;
        grid[4][2]=6;
        grid[4][3]=4;
        grid[4][4]=3;
        grid[4][5]=7;     
        grid[4][6]=8;
        grid[4][7]=1;
        grid[4][8]=5; 
                
        grid[5][0]=7;
        grid[5][1]=5;
        grid[5][2]=1;
        grid[5][3]=9;
        grid[5][4]=8;
        grid[5][5]=6;      
        grid[5][6]=2;
        grid[5][7]=4;
        grid[5][8]=3;
                
        grid[6][0]=8;
        grid[6][1]=3;
        grid[6][2]=4;
        grid[6][3]=7;
        grid[6][4]=1;
        grid[6][5]=9;        
        grid[6][6]=5;
        grid[6][7]=6;
        grid[6][8]=2;
               
        grid[7][0]=6;
        grid[7][1]=2;
        grid[7][2]=7;
        grid[7][3]=5;
        grid[7][4]=4;
        grid[7][5]=8;        
        grid[7][6]=9;
        grid[7][7]=3;
        grid[7][8]=1;    
               
        grid[8][0]=9;
        grid[8][1]=1;
        grid[8][2]=5;
        grid[8][3]=3;
        grid[8][4]=6;
        grid[8][5]=2;        
        grid[8][6]=4;
        grid[8][7]=8;
        grid[8][8]=7;
           return grid;
    }
    public static int[][] sol9(int[][] puz9) {
        grid[0][0]=4;
        grid[0][1]=7;
        grid[0][2]=1;
        grid[0][3]=2;
        grid[0][4]=3;
        grid[0][5]=5;        
        grid[0][6]=8;
        grid[0][7]=9;
        grid[0][8]=6;
        
        grid[1][0]=3;
        grid[1][1]=9;
        grid[1][2]=8;
        grid[1][3]=4;
        grid[1][4]=1;
        grid[1][5]=6;        
        grid[1][6]=7;
        grid[1][7]=2;
        grid[1][8]=5;
        
        grid[2][0]=6;
        grid[2][1]=2;
        grid[2][2]=5;
        grid[2][3]=7;
        grid[2][4]=8;
        grid[2][5]=9;        
        grid[2][6]=1;
        grid[2][7]=4;
        grid[2][8]=3;
        
        grid[3][0]=1;
        grid[3][1]=4;
        grid[3][2]=3;
        grid[3][3]=6;
        grid[3][4]=2;
        grid[3][5]=7;        
        grid[3][6]=9;
        grid[3][7]=5;
        grid[3][8]=8;
                
        grid[4][0]=2;
        grid[4][1]=6;
        grid[4][2]=9;
        grid[4][3]=3;
        grid[4][4]=5;
        grid[4][5]=8;     
        grid[4][6]=4;
        grid[4][7]=7;
        grid[4][8]=1; 
                
        grid[5][0]=5;
        grid[5][1]=8;
        grid[5][2]=7;
        grid[5][3]=1;
        grid[5][4]=9;
        grid[5][5]=4;      
        grid[5][6]=6;
        grid[5][7]=3;
        grid[5][8]=2;
                
        grid[6][0]=7;
        grid[6][1]=5;
        grid[6][2]=2;
        grid[6][3]=8;
        grid[6][4]=4;
        grid[6][5]=1;        
        grid[6][6]=3;
        grid[6][7]=6;
        grid[6][8]=9;
               
        grid[7][0]=8;
        grid[7][1]=3;
        grid[7][2]=4;
        grid[7][3]=9;
        grid[7][4]=6;
        grid[7][5]=2;        
        grid[7][6]=5;
        grid[7][7]=1;
        grid[7][8]=7;    
               
        grid[8][0]=9;
        grid[8][1]=1;
        grid[8][2]=6;
        grid[8][3]=5;
        grid[8][4]=7;
        grid[8][5]=3;        
        grid[8][6]=2;
        grid[8][7]=8;
        grid[8][8]=4;
           return grid;
    }
    public static int[][] sol10(int[][] puz10) {
        grid[0][0]=9;
        grid[0][1]=5;
        grid[0][2]=7;
        grid[0][3]=1;
        grid[0][4]=8;
        grid[0][5]=6;        
        grid[0][6]=4;
        grid[0][7]=3;
        grid[0][8]=2;
        
        grid[1][0]=4;
        grid[1][1]=2;
        grid[1][2]=3;
        grid[1][3]=5;
        grid[1][4]=9;
        grid[1][5]=7;        
        grid[1][6]=6;
        grid[1][7]=8;
        grid[1][8]=1;
        
        grid[2][0]=8;
        grid[2][1]=6;
        grid[2][2]=1;
        grid[2][3]=3;
        grid[2][4]=2;
        grid[2][5]=4;        
        grid[2][6]=9;
        grid[2][7]=7;
        grid[2][8]=5;
        
        grid[3][0]=7;
        grid[3][1]=4;
        grid[3][2]=2;
        grid[3][3]=9;
        grid[3][4]=6;
        grid[3][5]=8;        
        grid[3][6]=5;
        grid[3][7]=1;
        grid[3][8]=3;
                
        grid[4][0]=6;
        grid[4][1]=9;
        grid[4][2]=5;
        grid[4][3]=7;
        grid[4][4]=1;
        grid[4][5]=3;     
        grid[4][6]=2;
        grid[4][7]=4;
        grid[4][8]=8; 
                
        grid[5][0]=1;
        grid[5][1]=3;
        grid[5][2]=8;
        grid[5][3]=4;
        grid[5][4]=5;
        grid[5][5]=2;      
        grid[5][6]=7;
        grid[5][7]=6;
        grid[5][8]=9;
                
        grid[6][0]=3;
        grid[6][1]=1;
        grid[6][2]=6;
        grid[6][3]=2;
        grid[6][4]=7;
        grid[6][5]=9;        
        grid[6][6]=8;
        grid[6][7]=5;
        grid[6][8]=4;
               
        grid[7][0]=2;
        grid[7][1]=8;
        grid[7][2]=4;
        grid[7][3]=6;
        grid[7][4]=3;
        grid[7][5]=5;        
        grid[7][6]=1;
        grid[7][7]=9;
        grid[7][8]=7;    
               
        grid[8][0]=5;
        grid[8][1]=7;
        grid[8][2]=9;
        grid[8][3]=8;
        grid[8][4]=4;
        grid[8][5]=1;        
        grid[8][6]=3;
        grid[8][7]=2;
        grid[8][8]=6;
           return grid;
    }    
}
