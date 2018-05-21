/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos_database_project2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.table.*;
/**
 *
 * @author VipinRajan
 */
public class Controller {
    private View view;
    private Model model;
    public static boolean loggedin=false;
    
public Controller() {
    
}
 
public Controller(final View view, final Model model) {
        this.view = view;
        this.model = model;
        view.btnSignupActionListener(new DatabaseListener() {
            public void actionPerformed(ActionEvent e){
                view.errUserSignup.setVisible(false);
                view.errPassSignup.setVisible(false);
                String user = view.txtUserSignup.getText();
                char[] pass = view.getpwdUserSignup1();
                char[] pass1 = view.getpwdUserSignup2();
                String depassword="";
                String depassword1="";
                for(char decrypt : pass) {
                    depassword = depassword.concat(""+decrypt);
                }
                for(char decrypt : pass1) {
                    depassword1 = depassword1.concat(""+decrypt);
                }
                if(depassword.equals(depassword1)&&!model.isDuplicate(user)) {
                model.Signup(user,depassword);
                view.errPassSignup.setVisible(false);
                view.errUserSignup.setVisible(false);
                view.btnSignup.setText("Signup Up Sucessfully!");
                view.btnSignup.setEnabled(false);
                }
                else if(!depassword.equals(depassword1)) {
                    view.errPassSignup.setVisible(true);
                }
                else if(model.isDuplicate(user)) {
                    view.errUserSignup.setVisible(true);
                }
            }
        });
        view.btnLoginActionListener(new DatabaseListener() {
            public void actionPerformed(ActionEvent e){
                view.errUserLogin.setVisible(false);
                view.errPassLogin.setVisible(false);
                String username = view.gettxtUserLogin();
                char[] pass = view.getpwdUserLogin();
                String depassword="";
                for(char decrypt : pass) {
                    depassword = depassword.concat(""+decrypt);
                }
                model.Login(username,depassword);
                if(Model.username.equals(username)&&Model.password.equals(depassword)) {
                    loggedin = true;
                    view.lblCreateAccount.setVisible(false);
                    view.lblPassSignup1.setVisible(false);
                    view.lblPassSignup2.setVisible(false);
                    view.lblUserSignup.setVisible(false);
                    view.lblLogin.setVisible(false);
                    view.lblPassLogin.setVisible(false);
                    view.lblUserLogin.setVisible(false);
                    view.pwdUserLogin.setVisible(false);
                    view.pwdUserSignup1.setVisible(false);
                    view.pwdUserSignup2.setVisible(false);
                    view.txtUserLogin.setVisible(false);
                    view.txtUserSignup.setVisible(false);
                    view.btnLogin.setVisible(false);
                    view.btnSignup.setVisible(false);
                    view.setVisible(false);
                    view.frame.setVisible(true);
                }
                else if(model.username.equals(username)&&!model.password.equals(depassword)) {
                    view.errPassSignup.setVisible(false);
                    view.errUserSignup.setVisible(false);
                    view.errPassLogin.setVisible(true);
                }
                else if(!model.username.equals(username)) {
                    view.errPassSignup.setVisible(false);
                    view.errUserSignup.setVisible(false);                    
                    view.errUserLogin.setVisible(true);
                }
            }
        });
            view.btnViewVideosActionListener(new DatabaseListener() {
            public void actionPerformed(ActionEvent e){
                model.data(Model.username);
                view.lblVideoTitle.setVisible(false);
                view.txtVideoTitle.setVisible(false);
                view.lblURL.setVisible(false);
                view.txtURL.setVisible(false);
                view.lblDesc.setVisible(false);
                view.txtDesc.setVisible(false);
                view.btnSubmitVideos.setVisible(false);
                View.lblError.setVisible(false);
                View.database.setVisible(true);
                view.jsp.setVisible(true);
            }
        });
            view.btnAddVideosActionListener(new DatabaseListener() {
            public void actionPerformed(ActionEvent e){
                view.jsp.setVisible(false);
                view.database.setVisible(true);
                view.lblVideoTitle.setVisible(true);
                view.txtVideoTitle.setVisible(true);
                view.lblURL.setVisible(true);
                view.txtURL.setVisible(true);
                view.lblDesc.setVisible(true);
                view.txtDesc.setVisible(true);
                view.btnSubmitVideos.setVisible(true);
                view.lblError.setVisible(false);
                                
            }
        });
            view.btnSubmitVideosActionListener(new DatabaseListener() {
            public void actionPerformed(ActionEvent e){
                view.lblError.setVisible(false);
                String title = view.txtVideoTitle.getText();
                String URL = view.txtURL.getText();
                String Desc = view.txtDesc.getText();
                model.addVideos(title,URL,Desc);                                
            }
        });
            
}
public void setTableData(String title, String url, String Desc) {    
    View.datamodel1.addRow(new Object[]{title,url,Desc});
    View.database.setVisible(true);
}
public void removeAll() {
    for(int i=View.datamodel1.getRowCount()-1;i>=0;i--) {
    View.datamodel1.removeRow(i);
    }
}
public void ErrorMessage(boolean b) {
    if(!b) {
    View.lblError.setText("Info Saved Successfully");
    View.lblError.setVisible(true);
    }
    else if(b) {
      View.lblError.setText("Error! The video was not saved into the database!");
      View.lblError.setVisible(true);  
    }
}

class DatabaseListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        
    }
  }
}
