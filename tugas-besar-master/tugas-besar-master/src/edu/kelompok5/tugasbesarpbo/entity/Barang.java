/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.entity;

import java.util.Objects;

/**
 *
 * @author IDC
 */
public class Barang {
    
    private String kode;
    private String nama_barang;
    private Integer stok;
    private Integer harga_jual;
    private Integer harga_beli;
    
    public Barang(){
        
    }

    public Barang(String kode, String nama_barang, Integer stok, Integer harga_jual, Integer harga_beli) {
        this.kode = kode;
        this.nama_barang = nama_barang;
        this.stok = stok;
        this.harga_jual = harga_jual;
        this.harga_beli = harga_beli;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Integer getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(Integer harga_jual) {
        this.harga_jual = harga_jual;
    }

    public Integer getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(Integer harga_beli) {
        this.harga_beli = harga_beli;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.kode);
        hash = 37 * hash + Objects.hashCode(this.nama_barang);
        hash = 37 * hash + Objects.hashCode(this.stok);
        hash = 37 * hash + Objects.hashCode(this.harga_jual);
        hash = 37 * hash + Objects.hashCode(this.harga_beli);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Barang other = (Barang) obj;
        if (!Objects.equals(this.nama_barang, other.nama_barang)) {
            return false;
        }
        if (!Objects.equals(this.kode, other.kode)) {
            return false;
        }
        if (!Objects.equals(this.stok, other.stok)) {
            return false;
        }
        if (!Objects.equals(this.harga_jual, other.harga_jual)) {
            return false;
        }
        if (!Objects.equals(this.harga_beli, other.harga_beli)) {
            return false;
        }
        return true;
    }
    
    
    
}
