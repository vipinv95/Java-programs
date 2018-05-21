/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos_database_project2;

import java.awt.Dimension;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 *
 * @author VipinRajan
 */
public class Main {
    static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    static int x1 = (int) ((screen.getWidth() - screen.getWidth()) /2);
    static int y1 = (int) ((screen.getHeight() - screen.getHeight()) /2);
    public static int fx,fy;
    public static void main(String[] args) throws IOException {
        View login_page = new View();
        fx=login_page.getSize().width;
        fy=login_page.getSize().height;
        login_page.setLocation(x1+fx,y1+(fy/2));
        
        Model model = new Model();
        Controller controller = new Controller(login_page,model);
        model.LoadDriver();
        model.Connection();
        login_page.setVisible(true);
    }    
}
