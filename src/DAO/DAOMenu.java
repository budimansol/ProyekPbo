/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOMenu;
import Model.Menu;
import Helper.KoneksiDB;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Budiman
 */
public class DAOMenu implements IDAOMenu{

    
  
    
    public DAOMenu(){
        con = KoneksiDB.getConnection();
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> lsmkn = null;
        try {
            lsmkn =new ArrayList<Menu>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next()){
                Menu mkn = new Menu();
                mkn.setId(rs.getInt("id"));
                mkn.setNama_Menu(rs.getString("nama_menu"));
                mkn.setHarga(rs.getInt("harga"));
                mkn.setStok(rs.getString("stok"));
                mkn.setKeterangan(rs.getString("keterangan"));
                lsmkn.add(mkn);
            }
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
        return lsmkn;
    }
    
    @Override
    public boolean insert(Menu b) {
        boolean result=true;
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strinsert);
            statement.setInt(1, b.getId());
            statement.setString(2, b.getNama_Menu());
            statement.setInt(3, b.getHarga());
            statement.setString(4, b.getStok());
            statement.setString(5, b.getKeterangan());
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("GAGAL INPUT");
            result=false;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("GAGAL INPUT");
                result=false;
            }
        }
        return result;
    }
    
    @Override
    public void update(Menu b) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strupdate);
            statement.setString(1, b.getNama_Menu());
            statement.setInt(2, b.getHarga());
            statement.setString(3, b.getStok());
            statement.setString(4, b.getKeterangan());
            statement.setInt(5, b.getId());
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("GAGAL UPDATE");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("GAGAL UPDATE");
            }
        }
    }
    
    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strdelete);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("GAGAL DELETE");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("GAGAL DELETE");
            }
        }
    }
    
    @Override
    public List<Menu> getAllByName(String nama_menu) {
        List<Menu> lsmkn = null;
        try {
            lsmkn =new ArrayList<Menu>();
            PreparedStatement st = con.prepareStatement(strsearch);
            st.setString(1, "%" + nama_menu + "%" );
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Menu mkn = new Menu();
                mkn.setId(rs.getInt("id"));
                mkn.setNama_Menu(rs.getString("nama_menu"));
                mkn.setHarga(rs.getInt("harga"));
                mkn.setStok(rs.getString("stok"));
                mkn.setKeterangan(rs.getString("keterangan"));
                lsmkn.add(mkn);
            }
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
        return lsmkn;
    }
    
    Connection con;
    
    //SQLQuery
    String strRead = "select * from tabelmakanan order by id asc;";
    String strinsert = "insert into tabelmakanan (id, nama_menu, harga, stok, keterangan) values (?, ?, ?, ?, ?);";   
    String strupdate = "update tabelmakanan set nama_menu=?, harga=?, stok=?, keterangan=? where id=?;";   
    String strdelete = "delete from tabelmakanan where id=?;";
    String strsearch = "select * from tabelmakanan where nama_menu like ?;";

    

    
}
