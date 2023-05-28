/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Pesanan;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Budiman
 */
public interface IDAOPesanan {
    //read
    public List<Pesanan> getAll();
    //insert
    public void insert(Pesanan b);
    //update
    public void update(Pesanan b);
    //delete
    public void delete(int id);
    //cari
    public List<Pesanan> getAllByName(String nama);
    
    public void isiComboBoxMenu (JComboBox<String> combobox);
}
