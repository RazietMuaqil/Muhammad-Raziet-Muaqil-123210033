package View;

import Controller.LoginController;
import java.awt.event.*;
import javax.swing.*;

public class LoginPageView extends JFrame{
 
    JLabel ltitle = new JLabel("Login");
    
    JLabel lusername = new JLabel("Username");
    JTextField fusername = new JTextField();
    
    JLabel lpassword = new JLabel("Password");
    JPasswordField fpassword = new JPasswordField();
    
    JButton blogin = new JButton("Login");
    
    LoginController controller=new LoginController(this);
    public LoginPageView(){
        setSize(800, 600);
        setTitle("Login Page");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(ltitle);
        add(lusername);
        add(lpassword);
        add(fusername);
        add(fpassword);
        add(blogin);
        
        ltitle.setBounds(365, 50, 75, 50);
        
        lusername.setBounds(275, 120, 100, 30);
        fusername.setBounds(275, 150, 250, 30);
        
        lpassword.setBounds(275, 180, 100, 30);
        fpassword.setBounds(275, 210, 250, 30);
        
        blogin.setBounds(350, 260, 100, 30);
        
    }

    public JButton getBlogin() {
        return blogin;
    }

    public String getFusername() {
        return fusername.getText();
    }

    public String getFpassword() {
        return String.valueOf(fpassword.getPassword());
    }

    
    
    
}
