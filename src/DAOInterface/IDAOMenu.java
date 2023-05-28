/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Menu;
import java.util.List;

/**
 *
 * @author Budiman
 */
public interface IDAOMenu {
    
    //read data
    public List<Menu> getAll();
    //insert
    public boolean insert(Menu b);
    //update
    public void update(Menu b);
    //delete
    public void delete(int id);
    //cari data
    public List<Menu> getAllByName(String nama_menu);
    
}
