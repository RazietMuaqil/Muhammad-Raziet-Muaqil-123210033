package Model;

public interface InterfaceModel {
    int TotalHarga(int price, int duration);
    String[][] Read();
    String[][] ReadRoom();
    void Insert(String name, String id, String contact, int duration, int bill, String room);
    void Update(String id, String name, String room);
    void Edit(String name, String id, String contact);
    void Delete(String id, String name, String room);
    
}
