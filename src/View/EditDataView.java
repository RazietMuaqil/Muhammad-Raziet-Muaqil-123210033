package View;

import Model.AlMaulModel;
import java.awt.event.*;
import javax.swing.*;

public class EditDataView extends JFrame{
    JFrame window = new JFrame("Edit Data");
   
    JLabel lName = new JLabel("Name ");
    JTextField tfName = new JTextField();
    JLabel lid = new JLabel("id ");
    JTextField tfid = new JTextField();
    JLabel lContact= new JLabel("Contact ");
    JTextField tfContact = new JTextField();
    
    JButton btnEdit = new JButton("Edit");
    JButton btnLogout = new JButton("Logout");

    AlMaulModel model = new AlMaulModel();
    
    public EditDataView(String id, String name, String contact) {
        window.setLayout(null);
        window.setSize(550,200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        window.add(lName);
        window.add(tfName);
        window.add(lid);
        window.add(tfid);
        window.add(lContact);
        window.add(tfContact);
        window.add(btnEdit);
        window.add(btnLogout);
        
        //LABEL
        lName.setBounds(5, 30, 120, 20);
        lid.setBounds(5, 55, 120, 20);
        lContact.setBounds(5,80,120,20);

        //TEXTFIELD
        tfName.setBounds(110, 35, 120, 20);
        tfid.setBounds(110, 60, 120, 20);
        tfid.disable();
        tfContact.setBounds(110, 85, 120, 20);


        //BUTTON PANEL
        btnEdit.setBounds(250, 35, 90, 20);
        btnLogout.setBounds(250, 65, 90, 20);
        
        tfName.setText(name);
        tfid.setText(id);
        tfContact.setText(contact);
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.Edit(tfName.getText(), id, tfContact.getText());
                window.dispose();
                new AdminPageView();
            }
        });
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPageView().setVisible(true);
                window.dispose();
            }
        });
    }
    
}
