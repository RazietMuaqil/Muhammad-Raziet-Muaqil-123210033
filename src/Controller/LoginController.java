package Controller;
import View.AdminPageView;
import View.LoginPageView;
import View.RenterDataView;
import View.RoomListView;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class LoginController {
    LoginPageView login;
    
    public LoginController(LoginPageView login) {
        this.login = login;
        
        login.getBlogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                   if(login.getFusername().equals("admin") && login.getFpassword().equals("admin")){
                       new AdminPageView();
                       login.dispose();
                   }else if(login.getFusername().equals("user1") && login.getFpassword().equals("renter")){
                       new RoomListView();
                       login.dispose();
                   }else{
                       JOptionPane.showMessageDialog(null, "Username atau Password Salah");
                   }
               }catch (Exception e1){
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
    }
}
