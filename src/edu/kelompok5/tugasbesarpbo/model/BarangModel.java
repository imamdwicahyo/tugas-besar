/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.model;

import edu.kelompok5.tugasbesarpbo.database.EasyShopDatabase;
import edu.kelompok5.tugasbesarpbo.entity.Barang;
import edu.kelompok5.tugasbesarpbo.eror.BarangException;
import edu.kelompok5.tugasbesarpbo.event.BarangListener;
import edu.kelompok5.tugasbesarpbo.service.BarangDao;
import java.sql.SQLException;

/**
 *
 * @author IDC
 */
public class BarangModel {
    
    private String kode;
    private String nama_barang;
    private int stok;
    private int harga_jual;
    private int harga_beli; 
    
    private BarangListener listener;

    public BarangListener getListener() {
        return listener;
    }

    public void setListener(BarangListener listener) {
        this.listener = listener;
    }    

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
        fireOnChange();
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
        fireOnChange();
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
        fireOnChange();
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
        fireOnChange();
    }

    public int getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(int harga_beli) {
        this.harga_beli = harga_beli;
        fireOnChange();
    }
    
    protected void fireOnChange(){
        if (listener!=null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Barang barang){
        if (listener!=null) {
            listener.onInsert(barang);
        }
    }
    
    protected void fireOnUpdate(Barang barang){
        if (listener!=null) {
            listener.onUpdate(barang);
        }
    }
    
    protected void fireOnDelete(){
        if (listener!=null) {
            listener.onDelete();
        }
    }
    
    public void insertBarang() throws SQLException,BarangException{
        BarangDao dao = EasyShopDatabase.getbarangDao();
        Barang barang = new Barang();
        barang.setKode(kode);
        barang.setNama_barang(nama_barang);
        barang.setStok(stok);
        barang.setHarga_jual(harga_jual);
        barang.setHarga_beli(harga_beli);
        
        dao.insertBarang(barang);
        fireOnInsert(barang);
    }
    
    public void updateBarang() throws SQLException,BarangException{
        BarangDao dao = EasyShopDatabase.getbarangDao();
        Barang barang = new Barang();
        barang.setKode(kode);
        barang.setNama_barang(nama_barang);
        barang.setStok(stok);
        barang.setHarga_jual(harga_jual);
        barang.setHarga_beli(harga_beli);
        
        dao.updateBarang(barang);
        fireOnUpdate(barang);
    }
    
    public void deleteBarang() throws SQLException,BarangException{
        BarangDao dao = EasyShopDatabase.getbarangDao();
        dao.daleteBarang(kode);
        fireOnDelete();
    }
    
    public void resetBarang(){
        setKode("");
        setNama_barang("");
        setStok(0);
        setHarga_jual(0);
        setHarga_beli(0);
    }
    
}
