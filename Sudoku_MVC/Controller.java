/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
//import static sudoku.View.ClearGrid;
//import static sudoku.View.GenerateSudoku;
//import static sudoku.View.PopulateGrid;
//import static sudoku.View.grid;

/**
 *
 * @author VipinRajan
 */
public class Controller { 
    private View view;
    private Model model;
    public Timer clock = new Timer();;
    public Controller() {
        
    }
    public Controller(final View view, final Model model) {
        this.view = view;
        this.model = model;
        
            Model.wins = Integer.parseInt(view.lblWinsno.getText());           
            view.btnGenerateActionListener(new SudokuListener() {
            public void actionPerformed(ActionEvent e){
                model.ClearGrid();
                model.GenerateSudoku();
                PopulateGrid(Model.grid);
                view.btnSubmit.setEnabled(true);
                view.btnClear.setEnabled(true);
                view.btnSolve.setEnabled(true);
                clock.cancel();
                clock = new Timer();
                clock.schedule(new UpdateUITask(), 0, 1000);
            }
        });   
            view.btnClearActionListener(new SudokuListener() {
            public void actionPerformed(ActionEvent e){
                PopulateGrid(Model.grid);
            }           
        });  
            view.btnSolveActionListener(new SudokuListener() {
            public void actionPerformed(ActionEvent e){
                model.GenerateSolution();
                PopulateGrid(Model.grid);
                clock.cancel();
                view.btnSubmit.setEnabled(false);
                view.btnClear.setEnabled(false);
                Model.solver++;
                view.lblSolverno.setText(""+Model.solver);
                view.lblSolver.setText("Solved by Solver: ".concat(view.lblSolverno.getText()));
                view.btnSolve.setEnabled(false);                
            }           
        });            
            view.btnSubmitActionListener(new SudokuListener() {
            public void actionPerformed(ActionEvent e){
        int[][] puz = new int[9][9];
        for(int i=0;i<Model.grid.length;i++) {
            for(int j=0;j<Model.grid.length;j++) {
                puz[i][j] = Model.grid[i][j];
            }
        }
        GUItoGrid();
        if(model.isValid(Model.grid)&&!model.hasEmptyCell(Model.grid)) {
            clock.cancel();
            Model.wins++;
            view.lblWinsno.setText(""+Model.wins);
            view.lblWins.setText("Wins: ".concat(view.lblWinsno.getText()));
            view.btnSubmit.setEnabled(false);
            view.btnClear.setEnabled(false);
            JOptionPane.showMessageDialog(null, "You have successfully solved the puzzle!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);           
        }
        else if(model.hasEmptyCell(Model.grid)) {
            JOptionPane.showMessageDialog(null, "The puzzle is not completed! Please fill all the empty cells!", "Puzzle not Completed!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(!model.isValid(Model.grid)) {
            JOptionPane.showMessageDialog(null, "The puzzle is not solved correctly! Please check your solution!", "Incorrect!", JOptionPane.INFORMATION_MESSAGE);
        }
        Model.grid = puz; 
            }
        });            
    }

    class UpdateUITask extends TimerTask {

        int nSeconds = 0;
        int nMinutes =nSeconds/60;
                @Override
                public void run() {
                    view.lblTimeTaken.setText("Time taken: "+nMinutes+" mins "+(nSeconds%60)+" secs");
                    nMinutes = ++nSeconds/60;
                }

    }    
    
    class SudokuListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        
    }
  }
     
    public void GUItoGrid() {
        if(!view.jTextField1.getText().equals("")) {
       Model.grid[0][0] = Integer.parseInt(view.jTextField1.getText());
        }
        if(!view.jTextField2.getText().equals("")) {
       Model.grid[0][1] = Integer.parseInt(view.jTextField2.getText());
        }
        if(!view.jTextField3.getText().equals("")) {
       Model.grid[0][2] = Integer.parseInt(view.jTextField3.getText());
        }
        if(!view.jTextField4.getText().equals("")) {
       Model.grid[0][3] = Integer.parseInt(view.jTextField4.getText());
        }
       if(!view.jTextField5.getText().equals("")) {
       Model.grid[0][4] = Integer.parseInt(view.jTextField5.getText());
       }
       if(!view.jTextField6.getText().equals("")) {
       Model.grid[0][5] = Integer.parseInt(view.jTextField6.getText());
       }
       if(!view.jTextField7.getText().equals("")) {
       Model.grid[0][6] = Integer.parseInt(view.jTextField7.getText());
       }
       if(!view.jTextField8.getText().equals("")) {
       Model.grid[0][7] = Integer.parseInt(view.jTextField8.getText());
       }
       if(!view.jTextField9.getText().equals("")) {
       Model.grid[0][8] = Integer.parseInt(view.jTextField9.getText());
       }
       if(!view.jTextField10.getText().equals("")) {
       Model.grid[1][0] = Integer.parseInt(view.jTextField10.getText());
       }
       if(!view.jTextField11.getText().equals("")) {
       Model.grid[1][1] = Integer.parseInt(view.jTextField11.getText());
       }
       if(!view.jTextField12.getText().equals("")) {
       Model.grid[1][2] = Integer.parseInt(view.jTextField12.getText());
       }
       if(!view.jTextField13.getText().equals("")) {
       Model.grid[1][3] = Integer.parseInt(view.jTextField13.getText());
       }
       if(!view.jTextField14.getText().equals("")) {
       Model.grid[1][4] = Integer.parseInt(view.jTextField14.getText());
       }
       if(!view.jTextField15.getText().equals("")) {
       Model.grid[1][5] = Integer.parseInt(view.jTextField15.getText());
       }
       if(!view.jTextField16.getText().equals("")) {
       Model.grid[1][6] = Integer.parseInt(view.jTextField16.getText());
       }
       if(!view.jTextField17.getText().equals("")) {
       Model.grid[1][7] = Integer.parseInt(view.jTextField17.getText());
       }
       if(!view.jTextField18.getText().equals("")) {
       Model.grid[1][8] = Integer.parseInt(view.jTextField18.getText());
       }
       if(!view.jTextField19.getText().equals("")) {
       Model.grid[2][0] = Integer.parseInt(view.jTextField19.getText());
       }
       if(!view.jTextField20.getText().equals("")) {
       Model.grid[2][1] = Integer.parseInt(view.jTextField20.getText());
       }
       if(!view.jTextField21.getText().equals("")) {
       Model.grid[2][2] = Integer.parseInt(view.jTextField21.getText());
       }
       if(!view.jTextField22.getText().equals("")) {
       Model.grid[2][3] = Integer.parseInt(view.jTextField22.getText());
       }
       if(!view.jTextField23.getText().equals("")) {
       Model.grid[2][4] = Integer.parseInt(view.jTextField23.getText());
       }
       if(!view.jTextField24.getText().equals("")) {
       Model.grid[2][5] = Integer.parseInt(view.jTextField24.getText());
       }
       if(!view.jTextField25.getText().equals("")) {
       Model.grid[2][6] = Integer.parseInt(view.jTextField25.getText());
       }
       if(!view.jTextField26.getText().equals("")) {
       Model.grid[2][7] = Integer.parseInt(view.jTextField26.getText());
       }
       if(!view.jTextField27.getText().equals("")) {
       Model.grid[2][8] = Integer.parseInt(view.jTextField27.getText());
       }
       if(!view.jTextField28.getText().equals("")) {
       Model.grid[3][0] = Integer.parseInt(view.jTextField28.getText());
       }
       if(!view.jTextField29.getText().equals("")) {
       Model.grid[3][1] = Integer.parseInt(view.jTextField29.getText());
       }
       if(!view.jTextField30.getText().equals("")) {
       Model.grid[3][2] = Integer.parseInt(view.jTextField30.getText());
       }
       if(!view.jTextField31.getText().equals("")) {
       Model.grid[3][3] = Integer.parseInt(view.jTextField31.getText());
       }
       if(!view.jTextField32.getText().equals("")) {
       Model.grid[3][4] = Integer.parseInt(view.jTextField32.getText());
       }
       if(!view.jTextField33.getText().equals("")) {
       Model.grid[3][5] = Integer.parseInt(view.jTextField33.getText());
       }
       if(!view.jTextField34.getText().equals("")) {
       Model.grid[3][6] = Integer.parseInt(view.jTextField34.getText());
       }
       if(!view.jTextField35.getText().equals("")) {
       Model.grid[3][7] = Integer.parseInt(view.jTextField35.getText());
       }
       if(!view.jTextField36.getText().equals("")) {
       Model.grid[3][8] = Integer.parseInt(view.jTextField36.getText());
       }
       if(!view.jTextField37.getText().equals("")) {
       Model.grid[4][0] = Integer.parseInt(view.jTextField37.getText());
       }
       if(!view.jTextField38.getText().equals("")) {
       Model.grid[4][1] = Integer.parseInt(view.jTextField38.getText());
       }
       if(!view.jTextField39.getText().equals("")) {
       Model.grid[4][2] = Integer.parseInt(view.jTextField39.getText());
       }
       if(!view.jTextField40.getText().equals("")) {
       Model.grid[4][3] = Integer.parseInt(view.jTextField40.getText());
       }
       if(!view.jTextField41.getText().equals("")) {
       Model.grid[4][4] = Integer.parseInt(view.jTextField41.getText());
       }
       if(!view.jTextField42.getText().equals("")) {
       Model.grid[4][5] = Integer.parseInt(view.jTextField42.getText());
       }
       if(!view.jTextField43.getText().equals("")) {
       Model.grid[4][6] = Integer.parseInt(view.jTextField43.getText());
       }
       if(!view.jTextField44.getText().equals("")) {
       Model.grid[4][7] = Integer.parseInt(view.jTextField44.getText());
       }
       if(!view.jTextField45.getText().equals("")) {
       Model.grid[4][8] = Integer.parseInt(view.jTextField45.getText());
       }
       if(!view.jTextField46.getText().equals("")) {
       Model.grid[5][0] = Integer.parseInt(view.jTextField46.getText());
       }
       if(!view.jTextField47.getText().equals("")) {
       Model.grid[5][1] = Integer.parseInt(view.jTextField47.getText());
       }
       if(!view.jTextField48.getText().equals("")) {
       Model.grid[5][2] = Integer.parseInt(view.jTextField48.getText());
       }
       if(!view.jTextField49.getText().equals("")) {
       Model.grid[5][3] = Integer.parseInt(view.jTextField49.getText());
       }
       if(!view.jTextField50.getText().equals("")) {
       Model.grid[5][4] = Integer.parseInt(view.jTextField50.getText());
       }
       if(!view.jTextField51.getText().equals("")) {
       Model.grid[5][5] = Integer.parseInt(view.jTextField51.getText());
       }
       if(!view.jTextField52.getText().equals("")) {
       Model.grid[5][6] = Integer.parseInt(view.jTextField52.getText());
       }
       if(!view.jTextField53.getText().equals("")) {
       Model.grid[5][7] = Integer.parseInt(view.jTextField53.getText());
       }
       if(!view.jTextField54.getText().equals("")) {
       Model.grid[5][8] = Integer.parseInt(view.jTextField54.getText());
       }
       if(!view.jTextField55.getText().equals("")) {
       Model.grid[6][0] = Integer.parseInt(view.jTextField55.getText());
       }
       if(!view.jTextField56.getText().equals("")) {
       Model.grid[6][1] = Integer.parseInt(view.jTextField56.getText());
       }
       if(!view.jTextField57.getText().equals("")) {
       Model.grid[6][2] = Integer.parseInt(view.jTextField57.getText());
       }
       if(!view.jTextField58.getText().equals("")) {
       Model.grid[6][3] = Integer.parseInt(view.jTextField58.getText());
       }
       if(!view.jTextField59.getText().equals("")) {
       Model.grid[6][4] = Integer.parseInt(view.jTextField59.getText());
       }
       if(!view.jTextField60.getText().equals("")) {
       Model.grid[6][5] = Integer.parseInt(view.jTextField60.getText());
       }
       if(!view.jTextField61.getText().equals("")) {
       Model.grid[6][6] = Integer.parseInt(view.jTextField61.getText());
       }
       if(!view.jTextField62.getText().equals("")) {
       Model.grid[6][7] = Integer.parseInt(view.jTextField62.getText());
       }
       if(!view.jTextField63.getText().equals("")) {
       Model.grid[6][8] = Integer.parseInt(view.jTextField63.getText());
       }
       if(!view.jTextField64.getText().equals("")) {
       Model.grid[7][0] = Integer.parseInt(view.jTextField64.getText());
       }
       if(!view.jTextField65.getText().equals("")) {
       Model.grid[7][1] = Integer.parseInt(view.jTextField65.getText());
       }
       if(!view.jTextField66.getText().equals("")) {
       Model.grid[7][2] = Integer.parseInt(view.jTextField66.getText());
       }
       if(!view.jTextField67.getText().equals("")) {
       Model.grid[7][3] = Integer.parseInt(view.jTextField67.getText());
       }
       if(!view.jTextField68.getText().equals("")) {
       Model.grid[7][4] = Integer.parseInt(view.jTextField68.getText());
       }
       if(!view.jTextField69.getText().equals("")) {
       Model.grid[7][5] = Integer.parseInt(view.jTextField69.getText());
       }
       if(!view.jTextField70.getText().equals("")) {
       Model.grid[7][6] = Integer.parseInt(view.jTextField70.getText());
       }
       if(!view.jTextField71.getText().equals("")) {
       Model.grid[7][7] = Integer.parseInt(view.jTextField71.getText());
       }
       if(!view.jTextField72.getText().equals("")) {
       Model.grid[7][8] = Integer.parseInt(view.jTextField72.getText());
       }
       if(!view.jTextField73.getText().equals("")) {
       Model.grid[8][0] = Integer.parseInt(view.jTextField73.getText());
       }
       if(!view.jTextField74.getText().equals("")) {
       Model.grid[8][1] = Integer.parseInt(view.jTextField74.getText());
       }
       if(!view.jTextField75.getText().equals("")) {
       Model.grid[8][2] = Integer.parseInt(view.jTextField75.getText());
       }
       if(!view.jTextField76.getText().equals("")) {
       Model.grid[8][3] = Integer.parseInt(view.jTextField76.getText());
       }
       if(!view.jTextField77.getText().equals("")) {
       Model.grid[8][4] = Integer.parseInt(view.jTextField77.getText());
       }
       if(!view.jTextField78.getText().equals("")) {
       Model.grid[8][5] = Integer.parseInt(view.jTextField78.getText());
       }
       if(!view.jTextField79.getText().equals("")) {
       Model.grid[8][6] = Integer.parseInt(view.jTextField79.getText());
       }
       if(!view.jTextField80.getText().equals("")) {
       Model.grid[8][7] = Integer.parseInt(view.jTextField80.getText());
       }
       if(!view.jTextField81.getText().equals("")) {
       Model.grid[8][8] = Integer.parseInt(view.jTextField81.getText());
       }
    }    
    
    public void PopulateGrid(int[][] grid) {
        if(grid[0][0]!=0) {
       view.jTextField1.setText(""+grid[0][0]);
       view.jTextField1.setForeground(Color.blue);
       view.jTextField1.setEditable(false);
        }
        else {
       view.jTextField1.setText("");
       view.jTextField1.setForeground(Color.black);
       view.jTextField1.setEditable(true);     
        }
        if(grid[0][1]!=0) {
       view.jTextField2.setText(""+grid[0][1]);
       view.jTextField2.setForeground(Color.blue);
       view.jTextField2.setEditable(false);
        }
        else {
       view.jTextField2.setText("");     
       view.jTextField2.setForeground(Color.black);
       view.jTextField2.setEditable(true);     
        }        
        if(grid[0][2]!=0) {
       view.jTextField3.setText(""+grid[0][2]);
       view.jTextField3.setForeground(Color.blue);
       view.jTextField3.setEditable(false);
        }
        else {
       view.jTextField3.setText("");     
       view.jTextField3.setForeground(Color.black);
       view.jTextField3.setEditable(true);     
        }        
        if(grid[0][3]!=0) {
       view.jTextField4.setText(""+grid[0][3]);
       view.jTextField4.setForeground(Color.blue);
       view.jTextField4.setEditable(false);
        } 
        else {
       view.jTextField4.setText("");     
       view.jTextField4.setForeground(Color.black);
       view.jTextField4.setEditable(true);     
        }        
        if(grid[0][4]!=0) {
       view.jTextField5.setText(""+grid[0][4]);
       view.jTextField5.setForeground(Color.blue);
       view.jTextField5.setEditable(false);
        }
        else {
       view.jTextField5.setText("");     
       view.jTextField5.setForeground(Color.black);
       view.jTextField5.setEditable(true);     
        }        
        if(grid[0][5]!=0) {
       view.jTextField6.setText(""+grid[0][5]);
       view.jTextField6.setForeground(Color.blue);
       view.jTextField6.setEditable(false);
        }
        else {
       view.jTextField6.setText("");     
       view.jTextField6.setForeground(Color.black);
       view.jTextField6.setEditable(true);     
        }        
        if(grid[0][6]!=0) {
       view.jTextField7.setText(""+grid[0][6]);
       view.jTextField7.setForeground(Color.blue);
       view.jTextField7.setEditable(false);
        }
        else {
       view.jTextField7.setText("");     
       view.jTextField7.setForeground(Color.black);
       view.jTextField7.setEditable(true);     
        }        
        if(grid[0][7]!=0) {
       view.jTextField8.setText(""+grid[0][7]);
       view.jTextField8.setForeground(Color.blue);
       view.jTextField8.setEditable(false);
        } 
        else {
       view.jTextField8.setText("");     
       view.jTextField8.setForeground(Color.black);
       view.jTextField8.setEditable(true);     
        }        
        if(grid[0][8]!=0) {
       view.jTextField9.setText(""+grid[0][8]);
       view.jTextField9.setForeground(Color.blue);
       view.jTextField9.setEditable(false);
        } 
        else {
       view.jTextField9.setText("");     
       view.jTextField9.setForeground(Color.black);
       view.jTextField9.setEditable(true);     
        }
        if(grid[1][0]!=0) {
       view.jTextField10.setText(""+grid[1][0]);
       view.jTextField10.setForeground(Color.blue);
       view.jTextField10.setEditable(false);
        }
        else {
       view.jTextField10.setText("");     
       view.jTextField10.setForeground(Color.black);
       view.jTextField10.setEditable(true);     
        }
        if(grid[1][1]!=0) {
       view.jTextField11.setText(""+grid[1][1]);
       view.jTextField11.setForeground(Color.blue);
       view.jTextField11.setEditable(false);
        }
        else {
       view.jTextField11.setText("");     
       view.jTextField11.setForeground(Color.black);
       view.jTextField11.setEditable(true);     
        }
        if(grid[1][2]!=0) {
       view.jTextField12.setText(""+grid[1][2]);
       view.jTextField12.setForeground(Color.blue);
       view.jTextField12.setEditable(false);
        }
        else {
       view.jTextField12.setText("");     
       view.jTextField12.setForeground(Color.black);
       view.jTextField12.setEditable(true);     
        }
        if(grid[1][3]!=0) {
       view.jTextField13.setText(""+grid[1][3]);
       view.jTextField13.setForeground(Color.blue);
       view.jTextField13.setEditable(false);
        }
        else {
       view.jTextField13.setText("");     
       view.jTextField13.setForeground(Color.black);
       view.jTextField13.setEditable(true);     
        }
        if(grid[1][4]!=0) {
       view.jTextField14.setText(""+grid[1][4]);
       view.jTextField14.setForeground(Color.blue);
       view.jTextField14.setEditable(false);
        }
        else {
       view.jTextField14.setText("");     
       view.jTextField14.setForeground(Color.black);
       view.jTextField14.setEditable(true);     
        }
        if(grid[1][5]!=0) {
       view.jTextField15.setText(""+grid[1][5]);
       view.jTextField15.setForeground(Color.blue);
       view.jTextField15.setEditable(false);
        }
        else {
       view.jTextField15.setText("");     
       view.jTextField15.setForeground(Color.black);
       view.jTextField15.setEditable(true);     
        }
        if(grid[1][6]!=0) {
       view.jTextField16.setText(""+grid[1][6]);
       view.jTextField16.setForeground(Color.blue);
       view.jTextField16.setEditable(false);
        }
        else {
       view.jTextField16.setText("");     
       view.jTextField16.setForeground(Color.black);
       view.jTextField16.setEditable(true);     
        }
        if(grid[1][7]!=0) {
       view.jTextField17.setText(""+grid[1][7]);
       view.jTextField17.setForeground(Color.blue);
       view.jTextField17.setEditable(false);
        }
        else {
       view.jTextField17.setText("");     
       view.jTextField17.setForeground(Color.black);
       view.jTextField17.setEditable(true);     
        }
        if(grid[1][8]!=0) {
       view.jTextField18.setText(""+grid[1][8]);
       view.jTextField18.setForeground(Color.blue);
       view.jTextField18.setEditable(false);
        }
        else {
       view.jTextField18.setText("");     
       view.jTextField18.setForeground(Color.black);
       view.jTextField18.setEditable(true);     
        }
        if(grid[2][0]!=0) {
       view.jTextField19.setText(""+grid[2][0]);
       view.jTextField19.setForeground(Color.blue);
       view.jTextField19.setEditable(false);
        }
        else {
       view.jTextField19.setText("");     
       view.jTextField19.setForeground(Color.black);
       view.jTextField19.setEditable(true);     
        }
        if(grid[2][1]!=0) {
       view.jTextField20.setText(""+grid[2][1]);
       view.jTextField20.setForeground(Color.blue);
       view.jTextField20.setEditable(false);
        }
        else {
       view.jTextField20.setText("");     
       view.jTextField20.setForeground(Color.black);
       view.jTextField20.setEditable(true);     
        }
        if(grid[2][2]!=0) {
       view.jTextField21.setText(""+grid[2][2]);
       view.jTextField21.setForeground(Color.blue);
       view.jTextField21.setEditable(false);
        }
        else {
       view.jTextField21.setText("");     
       view.jTextField21.setForeground(Color.black);
       view.jTextField21.setEditable(true);     
        }
        if(grid[2][3]!=0) {
       view.jTextField22.setText(""+grid[2][3]);
       view.jTextField22.setForeground(Color.blue);
       view.jTextField22.setEditable(false);
        }
        else {
       view.jTextField22.setText("");     
       view.jTextField22.setForeground(Color.black);
       view.jTextField22.setEditable(true);     
        }
        if(grid[2][4]!=0) {
       view.jTextField23.setText(""+grid[2][4]);
       view.jTextField23.setForeground(Color.blue);
       view.jTextField23.setEditable(false);
        }
        else {
       view.jTextField23.setText("");     
       view.jTextField23.setForeground(Color.black);
       view.jTextField23.setEditable(true);     
        }
        if(grid[2][5]!=0) {
       view.jTextField24.setText(""+grid[2][5]);
       view.jTextField24.setForeground(Color.blue);
       view.jTextField24.setEditable(false);
        }
        else {
       view.jTextField24.setText("");     
       view.jTextField24.setForeground(Color.black);
       view.jTextField24.setEditable(true);     
        }
        if(grid[2][6]!=0) {
       view.jTextField25.setText(""+grid[2][6]);
       view.jTextField25.setForeground(Color.blue);
       view.jTextField25.setEditable(false);
        }
        else {
       view.jTextField25.setText("");     
       view.jTextField25.setForeground(Color.black);
       view.jTextField25.setEditable(true);     
        }
        if(grid[2][7]!=0) {
       view.jTextField26.setText(""+grid[2][7]);
       view.jTextField26.setForeground(Color.blue);
       view.jTextField26.setEditable(false);
        }
        else {
       view.jTextField26.setText("");     
       view.jTextField26.setForeground(Color.black);
       view.jTextField26.setEditable(true);     
        }
        if(grid[2][8]!=0) {
       view.jTextField27.setText(""+grid[2][8]);
       view.jTextField27.setForeground(Color.blue);
       view.jTextField27.setEditable(false);
        }
        else {
       view.jTextField27.setText("");     
       view.jTextField27.setForeground(Color.black);
       view.jTextField27.setEditable(true);     
        }
        if(grid[3][0]!=0) {
       view.jTextField28.setText(""+grid[3][0]);
       view.jTextField28.setForeground(Color.blue);
       view.jTextField28.setEditable(false);
        }
        else {
       view.jTextField28.setText("");     
       view.jTextField28.setForeground(Color.black);
       view.jTextField28.setEditable(true);     
        }
        if(grid[3][1]!=0) {
       view.jTextField29.setText(""+grid[3][1]);
       view.jTextField29.setForeground(Color.blue);
       view.jTextField29.setEditable(false);
        }
        else {
       view.jTextField29.setText("");     
       view.jTextField29.setForeground(Color.black);
       view.jTextField29.setEditable(true);     
        }
        if(grid[3][2]!=0) {
       view.jTextField30.setText(""+grid[3][2]);
       view.jTextField30.setForeground(Color.blue);
       view.jTextField30.setEditable(false);
        }
        else {
       view.jTextField30.setText("");     
       view.jTextField30.setForeground(Color.black);
       view.jTextField30.setEditable(true);     
        }
        if(grid[3][3]!=0) {
       view.jTextField31.setText(""+grid[3][3]);
       view.jTextField31.setForeground(Color.blue);
       view.jTextField31.setEditable(false);
        }
        else {
       view.jTextField31.setText("");     
       view.jTextField31.setForeground(Color.black);
       view.jTextField31.setEditable(true);     
        }
        if(grid[3][4]!=0) {
       view.jTextField32.setText(""+grid[3][4]);
       view.jTextField32.setForeground(Color.blue);
       view.jTextField32.setEditable(false);
        }
        else {
       view.jTextField32.setText("");     
       view.jTextField32.setForeground(Color.black);
       view.jTextField32.setEditable(true);     
        }
        if(grid[3][5]!=0) {
       view.jTextField33.setText(""+grid[3][5]);
       view.jTextField33.setForeground(Color.blue);
       view.jTextField33.setEditable(false);
        }
        else {
       view.jTextField33.setText("");     
       view.jTextField33.setForeground(Color.black);
       view.jTextField33.setEditable(true);     
        }
        if(grid[3][6]!=0) {
       view.jTextField34.setText(""+grid[3][6]);
       view.jTextField34.setForeground(Color.blue);
       view.jTextField34.setEditable(false);
        }
        else {
       view.jTextField34.setText("");     
       view.jTextField34.setForeground(Color.black);
       view.jTextField34.setEditable(true);     
        }
        if(grid[3][7]!=0) {
       view.jTextField35.setText(""+grid[3][7]);
       view.jTextField35.setForeground(Color.blue);
       view.jTextField35.setEditable(false);
        }
        else {
       view.jTextField35.setText("");     
       view.jTextField35.setForeground(Color.black);
       view.jTextField35.setEditable(true);     
        }
        if(grid[3][8]!=0) {
       view.jTextField36.setText(""+grid[3][8]);
       view.jTextField36.setForeground(Color.blue);
       view.jTextField36.setEditable(false);
        }
        else {
       view.jTextField36.setText("");     
       view.jTextField36.setForeground(Color.black);
       view.jTextField36.setEditable(true);     
        }
        if(grid[4][0]!=0) {
       view.jTextField37.setText(""+grid[4][0]);
       view.jTextField37.setForeground(Color.blue);
       view.jTextField37.setEditable(false);
        }
        else {
       view.jTextField37.setText("");     
       view.jTextField37.setForeground(Color.black);
       view.jTextField37.setEditable(true);     
        }
        if(grid[4][1]!=0) {
       view.jTextField38.setText(""+grid[4][1]);
       view.jTextField38.setForeground(Color.blue);
       view.jTextField38.setEditable(false);
        }
        else {
       view.jTextField38.setText("");     
       view.jTextField38.setForeground(Color.black);
       view.jTextField38.setEditable(true);     
        }
        if(grid[4][2]!=0) {
       view.jTextField39.setText(""+grid[4][2]);
       view.jTextField39.setForeground(Color.blue);
       view.jTextField39.setEditable(false);
        }
        else {
       view.jTextField39.setText("");     
       view.jTextField39.setForeground(Color.black);
       view.jTextField39.setEditable(true);     
        }
        if(grid[4][3]!=0) {
       view.jTextField40.setText(""+grid[4][3]);
       view.jTextField40.setForeground(Color.blue);
       view.jTextField40.setEditable(false);
        }
        else {
       view.jTextField40.setText("");     
       view.jTextField40.setForeground(Color.black);
       view.jTextField40.setEditable(true);     
        }
        if(grid[4][4]!=0) {
       view.jTextField41.setText(""+grid[4][4]);
       view.jTextField41.setForeground(Color.blue);
       view.jTextField41.setEditable(false);
        }
        else {
       view.jTextField41.setText("");     
       view.jTextField41.setForeground(Color.black);
       view.jTextField41.setEditable(true);     
        }
        if(grid[4][5]!=0) {
       view.jTextField42.setText(""+grid[4][5]);
       view.jTextField42.setForeground(Color.blue);
       view.jTextField42.setEditable(false);
        }
        else {
       view.jTextField42.setText("");     
       view.jTextField42.setForeground(Color.black);
       view.jTextField42.setEditable(true);     
        }
        if(grid[4][6]!=0) {
       view.jTextField43.setText(""+grid[4][6]);
       view.jTextField43.setForeground(Color.blue);
       view.jTextField43.setEditable(false);
        }
        else {
       view.jTextField43.setText("");     
       view.jTextField43.setForeground(Color.black);
       view.jTextField43.setEditable(true);     
        }
        if(grid[4][7]!=0) {
       view.jTextField44.setText(""+grid[4][7]);
       view.jTextField44.setForeground(Color.blue);
       view.jTextField44.setEditable(false);
        }
        else {
       view.jTextField44.setText("");     
       view.jTextField44.setForeground(Color.black);
       view.jTextField44.setEditable(true);     
        }
        if(grid[4][8]!=0) {
       view.jTextField45.setText(""+grid[4][8]);
       view.jTextField45.setForeground(Color.blue);
       view.jTextField45.setEditable(false);
        }
        else {
       view.jTextField45.setText("");     
       view.jTextField45.setForeground(Color.black);
       view.jTextField45.setEditable(true);     
        }
        if(grid[5][0]!=0) {
       view.jTextField46.setText(""+grid[5][0]);
       view.jTextField46.setForeground(Color.blue);
       view.jTextField46.setEditable(false);
        }
        else {
       view.jTextField46.setText("");     
       view.jTextField46.setForeground(Color.black);
       view.jTextField46.setEditable(true);     
        }
        if(grid[5][1]!=0) {
       view.jTextField47.setText(""+grid[5][1]);
       view.jTextField47.setForeground(Color.blue);
       view.jTextField47.setEditable(false);
        }
        else {
       view.jTextField47.setText("");     
       view.jTextField47.setForeground(Color.black);
       view.jTextField47.setEditable(true);     
        }
        if(grid[5][2]!=0) {
       view.jTextField48.setText(""+grid[5][2]);
       view.jTextField48.setForeground(Color.blue);
       view.jTextField48.setEditable(false);
        }
        else {
       view.jTextField48.setText("");     
       view.jTextField48.setForeground(Color.black);
       view.jTextField48.setEditable(true);     
        }
        if(grid[5][3]!=0) {
       view.jTextField49.setText(""+grid[5][3]);
       view.jTextField49.setForeground(Color.blue);
       view.jTextField49.setEditable(false);
        }
        else {
       view.jTextField49.setText("");     
       view.jTextField49.setForeground(Color.black);
       view.jTextField49.setEditable(true);     
        }
        if(grid[5][4]!=0) {
       view.jTextField50.setText(""+grid[5][4]);
       view.jTextField50.setForeground(Color.blue);
       view.jTextField50.setEditable(false);
        }
        else {
       view.jTextField50.setText("");     
       view.jTextField50.setForeground(Color.black);
       view.jTextField50.setEditable(true);     
        }
        if(grid[5][5]!=0) {
       view.jTextField51.setText(""+grid[5][5]);
       view.jTextField51.setForeground(Color.blue);
       view.jTextField51.setEditable(false);
        }
        else {
       view.jTextField51.setText("");     
       view.jTextField51.setForeground(Color.black);
       view.jTextField51.setEditable(true);     
        }
        if(grid[5][6]!=0) {
       view.jTextField52.setText(""+grid[5][6]);
       view.jTextField52.setForeground(Color.blue);
       view.jTextField52.setEditable(false);
        }
        else {
       view.jTextField52.setText("");     
       view.jTextField52.setForeground(Color.black);
       view.jTextField52.setEditable(true);     
        }
        if(grid[5][7]!=0) {
       view.jTextField53.setText(""+grid[5][7]);
       view.jTextField53.setForeground(Color.blue);
       view.jTextField53.setEditable(false);
        }
        else {
       view.jTextField53.setText("");     
       view.jTextField53.setForeground(Color.black);
       view.jTextField53.setEditable(true);     
        }
        if(grid[5][8]!=0) {
       view.jTextField54.setText(""+grid[5][8]);
       view.jTextField54.setForeground(Color.blue);
       view.jTextField54.setEditable(false);
        }
        else {
       view.jTextField54.setText("");     
       view.jTextField54.setForeground(Color.black);
       view.jTextField54.setEditable(true);     
        }
        if(grid[6][0]!=0) {
       view.jTextField55.setText(""+grid[6][0]);
       view.jTextField55.setForeground(Color.blue);
       view.jTextField55.setEditable(false);
        }
        else {
       view.jTextField55.setText("");     
       view.jTextField55.setForeground(Color.black);
       view.jTextField55.setEditable(true);     
        }
        if(grid[6][1]!=0) {
       view.jTextField56.setText(""+grid[6][1]);
       view.jTextField56.setForeground(Color.blue);
       view.jTextField56.setEditable(false);
        }
        else {
       view.jTextField56.setText("");     
       view.jTextField56.setForeground(Color.black);
       view.jTextField56.setEditable(true);     
        }
        if(grid[6][2]!=0) {
       view.jTextField57.setText(""+grid[6][2]);
       view.jTextField57.setForeground(Color.blue);
       view.jTextField57.setEditable(false);
        }
        else {
       view.jTextField57.setText("");     
       view.jTextField57.setForeground(Color.black);
       view.jTextField57.setEditable(true);     
        }
        if(grid[6][3]!=0) {
       view.jTextField58.setText(""+grid[6][3]);
       view.jTextField58.setForeground(Color.blue);
       view.jTextField58.setEditable(false);
        }
        else {
       view.jTextField58.setText("");     
       view.jTextField58.setForeground(Color.black);
       view.jTextField58.setEditable(true);     
        }
        if(grid[6][4]!=0) {
       view.jTextField59.setText(""+grid[6][4]);
       view.jTextField59.setForeground(Color.blue);
       view.jTextField59.setEditable(false);
        }
        else {
       view.jTextField59.setText("");     
       view.jTextField59.setForeground(Color.black);
       view.jTextField59.setEditable(true);     
        }
        if(grid[6][5]!=0) {
       view.jTextField60.setText(""+grid[6][5]);
       view.jTextField60.setForeground(Color.blue);
       view.jTextField60.setEditable(false);
        }
        else {
       view.jTextField60.setText("");     
       view.jTextField60.setForeground(Color.black);
       view.jTextField60.setEditable(true);     
        }
        if(grid[6][6]!=0) {
       view.jTextField61.setText(""+grid[6][6]);
       view.jTextField61.setForeground(Color.blue);
       view.jTextField61.setEditable(false);
        }
        else {
       view.jTextField61.setText("");     
       view.jTextField61.setForeground(Color.black);
       view.jTextField61.setEditable(true);     
        }
        if(grid[6][7]!=0) {
       view.jTextField62.setText(""+grid[6][7]);
       view.jTextField62.setForeground(Color.blue);
       view.jTextField62.setEditable(false);
        }
        else {
       view.jTextField62.setText("");     
       view.jTextField62.setForeground(Color.black);
       view.jTextField62.setEditable(true);     
        }
        if(grid[6][8]!=0) {
       view.jTextField63.setText(""+grid[6][8]);
       view.jTextField63.setForeground(Color.blue);
       view.jTextField63.setEditable(false);
        }
        else {
       view.jTextField63.setText("");     
       view.jTextField63.setForeground(Color.black);
       view.jTextField63.setEditable(true);     
        }
        if(grid[7][0]!=0) {
       view.jTextField64.setText(""+grid[7][0]);
       view.jTextField64.setForeground(Color.blue);
       view.jTextField64.setEditable(false);
        }
        else {
       view.jTextField64.setText("");     
       view.jTextField64.setForeground(Color.black);
       view.jTextField64.setEditable(true);     
        }
        if(grid[7][1]!=0) {
       view.jTextField65.setText(""+grid[7][1]);
       view.jTextField65.setForeground(Color.blue);
       view.jTextField65.setEditable(false);
        }
        else {
       view.jTextField65.setText("");     
       view.jTextField65.setForeground(Color.black);
       view.jTextField65.setEditable(true);     
        }
        if(grid[7][2]!=0) {
       view.jTextField66.setText(""+grid[7][2]);
       view.jTextField66.setForeground(Color.blue);
       view.jTextField66.setEditable(false);
        }
        else {
       view.jTextField66.setText("");     
       view.jTextField66.setForeground(Color.black);
       view.jTextField66.setEditable(true);     
        }
        if(grid[7][3]!=0) {
       view.jTextField67.setText(""+grid[7][3]);
       view.jTextField67.setForeground(Color.blue);
       view.jTextField67.setEditable(false);
        }
        else {
       view.jTextField67.setText("");     
       view.jTextField67.setForeground(Color.black);
       view.jTextField67.setEditable(true);     
        }
        if(grid[7][4]!=0) {
       view.jTextField68.setText(""+grid[7][4]);
       view.jTextField68.setForeground(Color.blue);
       view.jTextField68.setEditable(false);
        }
        else {
       view.jTextField68.setText("");     
       view.jTextField68.setForeground(Color.black);
       view.jTextField68.setEditable(true);     
        }
        if(grid[7][5]!=0) {
       view.jTextField69.setText(""+grid[7][5]);
       view.jTextField69.setForeground(Color.blue);
       view.jTextField69.setEditable(false);
        }
        else {
       view.jTextField69.setText("");     
       view.jTextField69.setForeground(Color.black);
       view.jTextField69.setEditable(true);     
        }
        if(grid[7][6]!=0) {
       view.jTextField70.setText(""+grid[7][6]);
       view.jTextField70.setForeground(Color.blue);
       view.jTextField70.setEditable(false);
        }
        else {
       view.jTextField70.setText("");     
       view.jTextField70.setForeground(Color.black);
       view.jTextField70.setEditable(true);     
        }
        if(grid[7][7]!=0) {
       view.jTextField71.setText(""+grid[7][7]);
       view.jTextField71.setForeground(Color.blue);
       view.jTextField71.setEditable(false);
        }
        else {
       view.jTextField71.setText("");     
       view.jTextField71.setForeground(Color.black);
       view.jTextField71.setEditable(true);     
        }
        if(grid[7][8]!=0) {
       view.jTextField72.setText(""+grid[7][8]);
       view.jTextField72.setForeground(Color.blue);
       view.jTextField72.setEditable(false);
        }
        else {
       view.jTextField72.setText("");     
       view.jTextField72.setForeground(Color.black);
       view.jTextField72.setEditable(true);     
        }
        if(grid[8][0]!=0) {
       view.jTextField73.setText(""+grid[8][0]);
       view.jTextField73.setForeground(Color.blue);
       view.jTextField73.setEditable(false);
        }
        else {
       view.jTextField73.setText("");     
       view.jTextField73.setForeground(Color.black);
       view.jTextField73.setEditable(true);     
        }
        if(grid[8][1]!=0) {
       view.jTextField74.setText(""+grid[8][1]);
       view.jTextField74.setForeground(Color.blue);
       view.jTextField74.setEditable(false);
        }
        else {
       view.jTextField74.setText("");     
       view.jTextField74.setForeground(Color.black);
       view.jTextField74.setEditable(true);     
        }
        if(grid[8][2]!=0) {
       view.jTextField75.setText(""+grid[8][2]);
       view.jTextField75.setForeground(Color.blue);
       view.jTextField75.setEditable(false);
        }
        else {
       view.jTextField75.setText("");     
       view.jTextField75.setForeground(Color.black);
       view.jTextField75.setEditable(true);     
        }
        if(grid[8][3]!=0) {
       view.jTextField76.setText(""+grid[8][3]);
       view.jTextField76.setForeground(Color.blue);
       view.jTextField76.setEditable(false);
        }
        else {
       view.jTextField76.setText("");     
       view.jTextField76.setForeground(Color.black);
       view.jTextField76.setEditable(true);     
        }
        if(grid[8][4]!=0) {
       view.jTextField77.setText(""+grid[8][4]);
       view.jTextField77.setForeground(Color.blue);
       view.jTextField77.setEditable(false);
        }
        else {
       view.jTextField77.setText("");     
       view.jTextField77.setForeground(Color.black);
       view.jTextField77.setEditable(true);     
        }
        if(grid[8][5]!=0) {
       view.jTextField78.setText(""+grid[8][5]);
       view.jTextField78.setForeground(Color.blue);
       view.jTextField78.setEditable(false);
        }
        else {
       view.jTextField78.setText("");     
       view.jTextField78.setForeground(Color.black);
       view.jTextField78.setEditable(true);     
        }
        if(grid[8][6]!=0) {
       view.jTextField79.setText(""+grid[8][6]);
       view.jTextField79.setForeground(Color.blue);
       view.jTextField79.setEditable(false);
        }
        else {
       view.jTextField79.setText("");     
       view.jTextField79.setForeground(Color.black);
       view.jTextField79.setEditable(true);     
        }
        if(grid[8][7]!=0) {
       view.jTextField80.setText(""+grid[8][7]);
       view.jTextField80.setForeground(Color.blue);
       view.jTextField80.setEditable(false);
        }
        else {
       view.jTextField80.setText("");     
       view.jTextField80.setForeground(Color.black);
       view.jTextField80.setEditable(true);     
        }
        if(grid[8][8]!=0) {
       view.jTextField81.setText(""+grid[8][8]);
       view.jTextField81.setForeground(Color.blue);
       view.jTextField81.setEditable(false);
        }
        else {
       view.jTextField81.setText("");     
       view.jTextField81.setForeground(Color.black);
       view.jTextField81.setEditable(true);     
        }
    }    
}
