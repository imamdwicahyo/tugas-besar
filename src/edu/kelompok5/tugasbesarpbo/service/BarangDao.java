/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.service;

import edu.kelompok5.tugasbesarpbo.entity.Barang;
import edu.kelompok5.tugasbesarpbo.eror.BarangException;
import edu.kelompok5.tugasbesarpbo.view.MainViewShop;
import java.util.List;

/**
 *
 * @author IDC
 */
public interface BarangDao {
    
    public void insertBarang(Barang barang) throws BarangException;
    public void updateBarang(Barang barang) throws BarangException;
    public void daleteBarang(String kode) throws BarangException;
    public Barang getBarang(String kode) throws BarangException;
    public Barang getCari(String cari) throws BarangException;
    public List<Barang> selectAllBarang() throws BarangException;
    public List<Barang> selectCariBarang(String nama) throws BarangException;
    
    
}
