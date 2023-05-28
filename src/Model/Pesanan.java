/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Budiman
 */
public class Pesanan {

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return the qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * @return the idPesanan
     */
    public Integer getIdPesanan() {
        return idPesanan;
    }

    /**
     * @param idPesanan the idPesanan to set
     */
    public void setIdPesanan(Integer idPesanan) {
        this.idPesanan = idPesanan;
    }



    /**
     * @return the namaPesanan
     */
    public String getNamaPesanan() {
        return namaPesanan;
    }

    /**
     * @param namaPesanan the namaPesanan to set
     */
    public void setNamaPesanan(String namaPesanan) {
        this.namaPesanan = namaPesanan;
    }

    /**
     * @return the isiPesanan
     */
    public String getIsiPesanan() {
        return isiPesanan;
    }

    /**
     * @param isiPesanan the isiPesanan to set
     */
    public void setIsiPesanan(String isiPesanan) {
        this.isiPesanan = isiPesanan;
    }
    private Integer idPesanan;
    private String tanggal;
    private String namaPesanan;
    private String isiPesanan;
    private Integer qty;
    private Integer total;
}
