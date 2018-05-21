/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos_database_project2;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author VipinRajan
 */
public class Model {    
    Controller controller = new Controller();
    Connection conn;
    public static String username = "";
    public static String password = "";
    public static String title = "";
    public static String URL = "";
    public static String Desc = "";

    public Model() {
        
    }
    public void LoadDriver() {
    try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {

        }
    }
    public void Connection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logins", "student", "");
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Signup(String user, String password) {
        try {
        conn.createStatement().executeUpdate("INSERT INTO logininfo (username,password) VALUES ('"+user+"','"+password+"');");    
       }
       catch(SQLException e) {

       }
    }
    public boolean isDuplicate(String user) {
        try {
           ResultSet dup = conn.createStatement().executeQuery("SELECT * FROM logininfo WHERE username = '"+user+"';");
            while(dup.next()) {
                username = dup.getString(1);
            }
            if(username.length()>(0)) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public void data(String user) {
        try {
        controller.removeAll();            
        ResultSet videos = conn.createStatement().executeQuery("SELECT * FROM videos WHERE user = '"+user+"'");
            while (videos.next()) {
                title = videos.getString(2);
                URL = videos.getString(3);
                Desc = videos.getString(4);
                controller.setTableData(title,URL,Desc);

            }
        }
        catch (SQLException e) {
            System.out.println("Does not work");
        }
    }
    public void Login(String user, String pass) {
        try {
        ResultSet login = conn.createStatement().executeQuery("SELECT * FROM logininfo WHERE username = '"+user+"';");
            while (login.next()) {
                username = login.getString(1);
                password = login.getString(2);                
            }
        }
        catch (SQLException e) {
            
        }
    }
    public void addVideos(String title, String URL, String Desc) {
       try {
        conn.createStatement().executeUpdate("INSERT INTO videos (user,Video_Title,URL,Description) VALUES ('"+username+"','"+title+"','"+URL+"','"+Desc+"');");    
       controller.ErrorMessage(false);
       }
       catch(SQLException e) {
           controller.ErrorMessage(true);
       }
    }
}
