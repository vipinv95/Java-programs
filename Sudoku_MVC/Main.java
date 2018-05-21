/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.IOException;

/**
 *
 * @author VipinRajan
 */
public class Main {
    public static void main(String[] args) throws IOException {
        View sudoku = new View();
        Model model = new Model();
        Controller controller = new Controller(sudoku,model);       
        sudoku.setVisible(true);
    }
}
