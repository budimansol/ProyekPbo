/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOMenu;
import DAOInterface.IDAOMenu;
import Model.Menu;
import Model.TabelModelMenu;
import View.FormMenu;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Budiman
 */
public class ControllerMenu {
    
    public ControllerMenu(FormMenu frame){
        this.frame = frame;
        iMenu = new DAOMenu();
    }
    
    public void isiTabel(){
        lsmkn = iMenu.getAll();
        TabelModelMenu tabelmkn = new TabelModelMenu(lsmkn);
        frame.getTabelData().setModel(tabelmkn);
    }
    
    public boolean insert(){
        Menu b = new Menu();
        b.setId(Integer.parseInt(frame.gettxtID().getText()));
        b.setNama_Menu(frame.gettxtNamaMenu().getText());
        b.setHarga(Integer.parseInt(frame.gettxtHargaMenu().getText()));
        b.setStok(frame.getStokMenu().getSelectedItem().toString());
        b.setKeterangan(frame.gettxtKeterangan().getText());
//        iMenu.insert(b);
        boolean res = iMenu.insert(b);
        if(res)
            JOptionPane.showMessageDialog(null, "SIMPAN DATA BERHASIL");
        else
            JOptionPane.showMessageDialog(null, "SIMPAN DATA GAGAL");
        return res;
    }
    
    public void reset(){
        if(!frame.gettxtID().isEnabled())
            frame.gettxtID().setEnabled(true);
        frame.gettxtID().setText("");
        frame.gettxtNamaMenu().setText("");
        frame.gettxtHargaMenu().setText("");
        frame.getStokMenu().setSelectedItem("Ada");
        frame.gettxtKeterangan().setText("");
    }
    
    public void isiField(int row){
        frame.gettxtID().setEnabled(false);
        frame.gettxtID().setText(lsmkn.get(row).getId().toString());
        frame.gettxtNamaMenu().setText(lsmkn.get(row).getNama_Menu());
        frame.gettxtHargaMenu().setText(lsmkn.get(row).getHarga().toString());
        frame.getStokMenu().setSelectedItem(lsmkn.get(row).getStok());
        frame.gettxtKeterangan().setText(lsmkn.get(row).getKeterangan());
    }
    
    public void update(){
        Menu b = new Menu();
        b.setNama_Menu(frame.gettxtNamaMenu().getText());
        b.setHarga(Integer.parseInt(frame.gettxtHargaMenu().getText()));
        b.setStok(frame.getStokMenu().getSelectedItem().toString());
        b.setKeterangan(frame.gettxtKeterangan().getText());
        b.setId(Integer.parseInt(frame.gettxtID().getText()));
        iMenu.update(b);
        JOptionPane.showMessageDialog(null, "UPDATE DATA BERHASIL");
    }
    
    public void delete(){
        iMenu.delete(Integer.parseInt(frame.gettxtID().getText()));
        JOptionPane.showMessageDialog(null, "DELETE DATA BERHASIL");
    }
    
    public void cari(){
        lsmkn = iMenu.getAllByName(frame.gettxtCariMenu().getText());
        TabelModelMenu tabelmkn = new TabelModelMenu(lsmkn);
        frame.getTabelData().setModel(tabelmkn);
    }
    
    FormMenu frame;
    IDAOMenu iMenu;
    List<Menu> lsmkn;
}
