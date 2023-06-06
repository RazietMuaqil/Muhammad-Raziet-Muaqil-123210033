package Model;
import java.sql.*;
import javax.swing.JOptionPane;

public class AlMaulModel extends Connector implements InterfaceModel{

    @Override
    public int TotalHarga(int price, int duration) {
        int total=0;
        try{
            total=price*duration;
            return total;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            return total;
        }
    }
    
    @Override
    public String[][] Read() {
        String data[][]=new String[50][7];
        try{
            int total=0;
            String query="SELECT * from renter";
            stt=con.createStatement();
            ResultSet rs=stt.executeQuery(query);
            while(rs.next()){
                data[total][0]=rs.getString("name");
                data[total][1]=rs.getString("id");
                data[total][2]=rs.getString("contact");
                data[total][3]=rs.getString("duration");
                data[total][4]=rs.getString("bill");
                data[total][5]=rs.getString("status");
                data[total][6]=rs.getString("room");
                total++;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            return data;
        }
    }

    @Override
    public String[][] ReadRoom() {
        String data[][]=new String[50][4];
        try{
            int total=0;
            String query="SELECT * from rooms";
            stt=con.createStatement();
            ResultSet rs=stt.executeQuery(query);
            while(rs.next()){
                data[total][0]=rs.getString("name");
                data[total][1]=rs.getString("size");
                data[total][2]=rs.getString("price");
                data[total][3]=rs.getString("status");
                total++;
            }
            stt.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            return data;
        }
    }

    @Override
    public void Update(String id, String name, String room) {
       try{
            String query=" UPDATE renter SET status='Paid' WHERE id='"+id+"' ";
            stt=con.createStatement();
            stt.executeUpdate(query);
            stt.close();
            JOptionPane.showMessageDialog(null, "Update Berhasil");
            //Setelah update status dibayar maka kamar menjadi terisi
            String query2=" UPDATE rooms SET status='"+name+"' WHERE name='"+room+"' ";
            stt=con.createStatement();
            stt.executeUpdate(query2);
            stt.close();
            JOptionPane.showMessageDialog(null, "Room "+room+" Terisi oleh "+name);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void Delete(String id, String name, String room) {
        try{
            String query=" DELETE FROM renter WHERE id='"+id+"' ";
            stt=con.createStatement();
            stt.executeUpdate(query);
            stt.close();
            JOptionPane.showMessageDialog(null, "Hapus Berhasil");
            //Setelah delete data maka kamar menjadi kosong
            String query2=" UPDATE rooms SET status='empty' WHERE name='"+room+"' ";
            stt=con.createStatement();
            stt.executeUpdate(query2);
            stt.close();
            JOptionPane.showMessageDialog(null, name+" Check Out, Room "+room+" now empty");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
        public void Insert(String name, String id, String contact, int duration, int bill, String room) {
        try{
            String query = " INSERT INTO renter VALUES "
                    + " ('"+name+"','"+id+"','"+contact+"','"+duration+"','"+bill+"','NotPaid','"+room+"') ";
            stt=con.createStatement();
            stt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Tambah Berhasil");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void Edit(String name, String id, String contact) {
        try{
            String query=" UPDATE renter SET name='"+name+"', contact='"+contact+"' WHERE id='"+id+"' ";
            stt=con.createStatement();
            stt.executeUpdate(query);
            stt.close();
            JOptionPane.showMessageDialog(null, "Edit Berhasil");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
