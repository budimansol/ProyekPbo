/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOPesanan;
import Helper.KoneksiDB;
import Model.Pesanan;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Budiman
 */
public class DAOPesanan implements IDAOPesanan {

    public DAOPesanan(){
        con = KoneksiDB.getConnection();
    }
    
    @Override
    public List<Pesanan> getAll() {
        List <Pesanan> lsPsn = null;
        try {
            lsPsn = new ArrayList<Pesanan>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next()){
                Pesanan psn = new Pesanan();
                psn.setIdPesanan(rs.getInt("id_pesanan"));
                psn.setTanggal(rs.getString("tgl_pesanan"));
                psn.setNamaPesanan(rs.getString("nama"));
                psn.setIsiPesanan(rs.getString("item"));
                psn.setQty(rs.getInt("qty"));
                psn.setTotal(rs.getInt("total"));
                lsPsn.add(psn);
            }
        } catch (SQLException e) {
                System.out.println("error" + e);
        }
        return lsPsn;
    }
    
    @Override
    public void insert(Pesanan b){
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, b.getIdPesanan());
            statement.setString(2, b.getTanggal());
            statement.setString(3, b.getNamaPesanan());
            statement.setString(4,b.getIsiPesanan());
            statement.setInt(5, b.getQty());
            statement.setInt(6, b.getTotal());
            statement.execute();
        } catch (SQLException e){
            System.out.println("GAGAL INPUT");
        } finally {
            try{
                statement.close();
            } catch (SQLException e) {
                System.out.println("GAGAL INPUT");
            }
        }
    }
    
    @Override
    public void update(Pesanan b) {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, b.getTanggal());
            statement.setString(2, b.getNamaPesanan());
            statement.setString(3,b.getIsiPesanan());
            statement.setInt(4, b.getQty());
            statement.setInt(5, b.getTotal());
            statement.setInt(6, b.getIdPesanan());
            statement.execute();
        } catch (SQLException e){
            System.out.println("GAGAL UPDATE");
        } finally {
            try{
                statement.close();
            } catch (SQLException e) {
                System.out.println("GAGAL UPDATE");
            }
        }
    }
    
    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strDelete);
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
    public List<Pesanan> getAllByName(String nama) {
        List<Pesanan> lsPsn = null;
        try {
            lsPsn =new ArrayList<Pesanan>();
            PreparedStatement st = con.prepareStatement(strsearch);
            st.setString(1, "%" + nama + "%" );
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Pesanan psn = new Pesanan();
                psn.setIdPesanan(rs.getInt("id_pesanan"));
                psn.setTanggal(rs.getString("tgl_pesanan"));
                psn.setNamaPesanan(rs.getString("nama"));
                psn.setIsiPesanan(rs.getString("item"));
                psn.setQty(rs.getInt("qty"));
                psn.setTotal(rs.getInt("total"));
                lsPsn.add(psn);
            }
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
        return lsPsn;
    }
    
    @Override
    public void isiComboBoxMenu(JComboBox<String> combobox) {
        try{
            PreparedStatement st = con.prepareStatement(strComboMenu);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String ComboBoxMenu = rs.getString("nama_menu");
                combobox.addItem(ComboBoxMenu);
            }
        } catch(SQLException e) {
            System.out.println("tidak ada data");
        }
    }
    

    Connection con;
    
    //sqlquery
    String strRead = "select * from tabelpesanan;";
    //insert
    String strInsert = "insert into tabelpesanan (id_pesanan,tgl_pesanan, nama, item, qty, total) values (?,?,?,?,?,?);";
    //update
    String strUpdate = "update tabelpesanan set tgl_pesanan=?, nama=?, item=?, qty=?, total=? where id_pesanan=?;";
    //delete
    String strDelete = "delete from tabelpesanan where id_pesanan=?;";
    //cari
    String strsearch = "select * from tabelpesanan where nama like ?;";

    String strComboMenu = "select nama_menu from tabelmakanan where stok='Ada';";
    
}
