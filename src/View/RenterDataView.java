package View;

import Model.AlMaulModel;
import java.awt.event.*;
import javax.swing.*;

public class RenterDataView extends JFrame{
    JFrame window = new JFrame("Renter Data");
   
    JLabel lName = new JLabel("Name ");
    JTextField tfName = new JTextField();
    JLabel lid = new JLabel("id ");
    JTextField tfid = new JTextField();
    JLabel lContact= new JLabel("Contact ");
    JTextField tfContact = new JTextField();
    JLabel lRentTime = new JLabel("RentTime ");
    JTextField tfRentTime = new JTextField();
    
    JButton btnAddPanel = new JButton("Submit");
    JButton btnLogout = new JButton("Logout");

    AlMaulModel model = new AlMaulModel();
    
    public RenterDataView(String room, int price) {
        window.setLayout(null);
        window.setSize(550,200);
        // window.setDefaultCloseOperation(3);
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
        window.add(lRentTime);
        window.add(tfRentTime);
        window.add(btnAddPanel);
        window.add(btnLogout);
        
        //LABEL
        lName.setBounds(5, 30, 120, 20);
        lid.setBounds(5, 55, 120, 20);
        lContact.setBounds(5,80,120,20);
        lRentTime.setBounds(5,110,120,20);

//TEXTFIELD
        tfName.setBounds(110, 35, 120, 20);
        tfid.setBounds(110, 60, 120, 20);
        tfContact.setBounds(110, 85, 120, 20);
        tfRentTime.setBounds(110, 115, 120, 20);


//BUTTON PANEL
        btnAddPanel.setBounds(250, 35, 90, 20);
        btnLogout.setBounds(250, 65, 90, 20);
        
        btnAddPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(getTfName().isBlank() || getTfid().isBlank() ||
                        getTfContact().isBlank() || getTfRentTime().isBlank()){
                        throw new IllegalAccessException("Lengkapi Data !");
                    }
                    int durasi=Integer.parseInt(getTfRentTime());
                    int total=model.TotalHarga(price, durasi);
                    model.Insert(getTfName(), getTfid(), getTfContact(), durasi, total, room);
                    tfName.setText("");tfid.setText("");tfContact.setText("");tfRentTime.setText("");
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
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

    public String getTfName() {
        return tfName.getText();
    }

    public String getTfid() {
        return tfid.getText();
    }

    public String getTfContact() {
        return tfContact.getText();
    }

    public String getTfRentTime() {
        return tfRentTime.getText();
    }

}

