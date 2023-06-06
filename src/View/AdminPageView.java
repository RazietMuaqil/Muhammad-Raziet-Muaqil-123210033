package View;

import Model.AlMaulModel;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AdminPageView extends JFrame{
    JFrame window = new JFrame("Renter Data");
    Object columnName []={"nama","id","contact","duration","bill","status","room"};
    
    String data[][] = new String [100][4];
    DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    JTable tabel = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(tabel);
    
    JButton blogout = new JButton("Logout");
    
    AlMaulModel model = new AlMaulModel();
    
    public AdminPageView() {
        window.setLayout(null);
        window.setSize(550,600);
       
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.add(scrollPane);
        window.add(blogout);
        window.add(tabel);
        
        scrollPane.setBounds(20, 35, 500, 300);
        scrollPane.setViewportView(tabel);
        blogout.setBounds(20, 350, 100,50);
        
        
        showData();
        
        blogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPageView().setVisible(true);
                window.dispose();
            }
        });
        
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row=tabel.getSelectedRow();
                int col=tabel.getSelectedColumn();
                String id=tabel.getValueAt(row, 1).toString();
                String name=tabel.getValueAt(row, 0).toString();
                String contact=tabel.getValueAt(row, 2).toString();
                String status=tabel.getValueAt(row, 5).toString();
                String room=tabel.getValueAt(row, 6).toString();
                if(status.equals("Paid")){
                    int input=JOptionPane.showConfirmDialog(null, "Edit Data?", "EDIT", JOptionPane.YES_NO_OPTION);
                    if(input==0){
                        window.dispose();
                        new EditDataView(id, name, contact);
                    }else{
                        int input2=JOptionPane.showConfirmDialog(null, "Hapus Data?", "HAPUS", JOptionPane.YES_NO_OPTION);
                        if(input2==0){
                            model.Delete(id, name, room);
                            String data2[][]=model.Read();
                            tabel.setModel(new JTable(data2, columnName).getModel());
                        }
                    }
                }else{
                    int input=JOptionPane.showConfirmDialog(null, "Update menjadi Dibayar ?", "UPDATE", JOptionPane.YES_NO_OPTION);
                    if(input==0){
                        model.Update(id,name,room);
                        String data2[][]=model.Read();
                        tabel.setModel(new JTable(data2, columnName).getModel());
                    }else{
                        
                    }
                }
            }
        });
        
    }
    
    private void showData(){
        String data[][]=model.Read();
        tabel.setModel(new JTable(data, columnName).getModel());
    }
    
}
