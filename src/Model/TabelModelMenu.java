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
public class TabelModelMenu extends AbstractTableModel {
    
    
    
    public TabelModelMenu(List<Menu> lsmkn){
        this.lsmkn = lsmkn;
    }
    
    @Override
    public int getRowCount() {
        return this.lsmkn.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama Makanan";
            case 2:
                return "Harga";
            case 3:
                return "Stok";
            case 4:
                return "Keterangan";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lsmkn.get(rowIndex).getId();
            case 1:
                return lsmkn.get(rowIndex).getNama_Menu();
            case 2:
                return lsmkn.get(rowIndex).getHarga();
            case 3:
                return lsmkn.get(rowIndex).getStok();
            case 4:
                return lsmkn.get(rowIndex).getKeterangan();
            default:
                return null;
        }
    }
    
    List<Menu> lsmkn;
}
