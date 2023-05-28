/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Budiman
 */
public class TabelModelPesanan extends AbstractTableModel{

    public TabelModelPesanan(List<Pesanan> lsPsn){
        this.lsPsn = lsPsn;
    }
    
    @Override
    public int getRowCount() {
        return this.lsPsn.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "ID Pesanan";
            case 1:
                return "Tanggal Pesanan";
            case 2:
                return "Nama Pesanan";
            case 3:
                return "Isi Pesanan";
            case 4:
                return "Qty";
            case 5:
                return "Total";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lsPsn.get(rowIndex).getIdPesanan();
            case 1:
                return lsPsn.get(rowIndex).getTanggal();
            case 2:
                return lsPsn.get(rowIndex).getNamaPesanan();
            case 3:
                return lsPsn.get(rowIndex).getIsiPesanan();
            case 4:
                return lsPsn.get(rowIndex).getQty();
            case 5:
                return lsPsn.get(rowIndex).getTotal();
            default:
                return null;
        }
    }
    
    List <Pesanan> lsPsn;
}
