/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Budiman
 */
public class Menu {

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nama
     */
    public String getNama_Menu() {
        return nama_menu;
    }

    /**
     * @param nama_menu the nama to set
     */
    public void setNama_Menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    /**
     * @return the harga
     */
    public Integer getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    /**
     * @return the stok
     */
    public String getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(String stok) {
        this.stok = stok;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    private Integer id;
    private String nama_menu;
    private Integer harga;
    private String stok;
    private String keterangan;
    
    
}
