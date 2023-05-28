/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPesanan;
import DAOInterface.IDAOPesanan;
import Model.Pesanan;
import Model.TabelModelPesanan;
import View.FormPesanan;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Budiman
 */
public class ControllerPesanan {
    
    public ControllerPesanan (FormPesanan framePesanan){
        this.framePesanan = framePesanan;
        iPesanan = new DAOPesanan();
        iPesanan.getAll();
        iPesanan.isiComboBoxMenu(framePesanan.getIsiPesanan());
    }
    
    public void isiTabel(){
        lsPsn = iPesanan.getAll();
        TabelModelPesanan tabelPsn = new TabelModelPesanan(lsPsn);
        framePesanan.gettabelPesanan().setModel(tabelPsn);
    }
    
    public void insert(){
        Pesanan b = new Pesanan();
        b.setIdPesanan(Integer.parseInt(framePesanan.gettxtIDPesanan().getText()));
        b.setTanggal(framePesanan.gettxtTglPesanan().getText());
        b.setNamaPesanan(framePesanan.gettxtNamaPesanan().getText());        
        b.setIsiPesanan(framePesanan.getIsiPesanan().getSelectedItem().toString());
        b.setQty(Integer.parseInt(framePesanan.gettxtQty().getValue().toString()));
        b.setTotal(Integer.parseInt(framePesanan.gettxtTotal().getText()));      
        iPesanan.insert(b);
        JOptionPane.showMessageDialog(null, "INPUT BERHASIL");
    }
    
    public void reset(){
        if(!framePesanan.gettxtIDPesanan().isEnabled())
            framePesanan.gettxtIDPesanan().setEnabled(true);
        framePesanan.gettxtIDPesanan().setText("");
        if(!framePesanan.gettxtTglPesanan().isEnabled())
            framePesanan.gettxtTglPesanan().setEnabled(true);
        framePesanan.gettxtTglPesanan().setText("");
        framePesanan.gettxtNamaPesanan().setText("");
        framePesanan.getIsiPesanan().setSelectedItem("");
        framePesanan.gettxtQty().setValue(1);
        framePesanan.gettxtTotal().setText("");
    }
    
    public void isiField(int row){
        framePesanan.gettxtIDPesanan().setEnabled(false);
        framePesanan.gettxtTglPesanan().setEnabled(false);
        framePesanan.gettxtIDPesanan().setText(lsPsn.get(row).getIdPesanan().toString());
        framePesanan.gettxtTglPesanan().setText(lsPsn.get(row).getTanggal());
        framePesanan.gettxtNamaPesanan().setText(lsPsn.get(row).getNamaPesanan());
        framePesanan.getIsiPesanan().setSelectedItem(lsPsn.get(row).getIsiPesanan());
        framePesanan.gettxtQty().setValue(lsPsn.get(row).getQty());
        framePesanan.gettxtTotal().setText(lsPsn.get(row).getTotal().toString());
        
    }
    
    public void update(){
        Pesanan b = new Pesanan();
        b.setTanggal(framePesanan.gettxtTglPesanan().getText());
        b.setNamaPesanan(framePesanan.gettxtNamaPesanan().getText());        
        b.setIsiPesanan(framePesanan.getIsiPesanan().getSelectedItem().toString());
        b.setQty(Integer.parseInt(framePesanan.gettxtQty().getValue().toString()));
        b.setTotal(Integer.parseInt(framePesanan.gettxtTotal().getText()));      
        b.setIdPesanan(Integer.parseInt(framePesanan.gettxtIDPesanan().getText()));
        iPesanan.update(b);
        JOptionPane.showMessageDialog(null, "UPDATE BERHASIL");
    }
    
    public void delete(){
        iPesanan.delete(Integer.parseInt(framePesanan.gettxtIDPesanan().getText()));
        JOptionPane.showMessageDialog(null, "DELETE BERHASIL");
    }
    
    public void cari(){
        lsPsn = iPesanan.getAllByName(framePesanan.gettxtCari().getText());
        TabelModelPesanan tabelpsn = new TabelModelPesanan(lsPsn);
        framePesanan.gettabelPesanan().setModel(tabelpsn);
    }
    
    
    
    FormPesanan framePesanan;
    IDAOPesanan iPesanan;
    List<Pesanan> lsPsn;
}
