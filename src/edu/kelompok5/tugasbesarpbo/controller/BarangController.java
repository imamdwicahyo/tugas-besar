 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.controller;

import edu.kelompok5.tugasbesarpbo.model.BarangModel;
import edu.kelompok5.tugasbesarpbo.view.MainViewShop;
import java.awt.Panel;
import javax.swing.JOptionPane;

/**
 *
 * @author IDC
 */
public class BarangController {
    
    private BarangModel model;

    public void setModel(BarangModel model) {
        this.model = model;
    }
    
    public void resetBarang(MainViewShop view){
        model.resetBarang();
    }
    
    public void insertBarang(MainViewShop view){
        String kode = view.getjAddKode().getText();
        String nama = view.getjAddNama().getText();
        int stok = Integer.parseInt(view.getjAddStok().getText());
        int harga_jual = Integer.parseInt(view.getjAddHJual().getText());
        int harga_beli = Integer.parseInt(view.getjAddHBeli().getText());
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (kode.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode tidak boleh kosong");
        } else if (kode.length()>13){
            JOptionPane.showMessageDialog(view, "Kode tidak boleh melebiki 13 karakter");
        } else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh melebihi 255 karekter");
        } else {
            model.setKode(kode);
            model.setNama_barang(nama);
            model.setStok(stok);
            model.setHarga_jual(harga_jual);
            model.setHarga_beli(harga_beli);
            try {
                model.insertBarang();
                JOptionPane.showMessageDialog(view, "Data barang berhasil ditambahkan");
                model.resetBarang();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, "Terjadi eror \n Eror Code "+throwable.getMessage());
            }
        }
    }
    
    public void updateBarang(MainViewShop view){
        /**if (view.getjTableBarang().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih data yang akan di ubah");
            return;
        }*/
        
        String kode = view.getjUpdateKode().getText();
        String nama = view.getjUpdateNama().getText();
        int stok = Integer.parseInt(view.getjUpdateStok().getText());
        int harga_jual = Integer.parseInt(view.getjUpdateHJual().getText());
        int harga_beli = Integer.parseInt(view.getjUpdateHBeli().getText());
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (kode.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode tidak boleh kosong");
        } else if (kode.length()>13){
            JOptionPane.showMessageDialog(view, "Kode tidak boleh melebiki 13 karakter");
        } else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh melebihi 255 karekter");
        } else {
            model.setKode(kode);
            model.setNama_barang(nama);
            model.setStok(stok);
            model.setHarga_jual(harga_jual);
            model.setHarga_beli(harga_beli);
            try {
                model.updateBarang();
                JOptionPane.showMessageDialog(view, "Data barang berhasil diubah");
                model.resetBarang();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, "Terjadi eror \n Eror Code "+throwable.getMessage());
            }
        }
    }
    
    public void deleteBarang(MainViewShop view){
        /**if (view.getjTableBarang().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih data yang akan dihapus");
            return;
        }*/
        
        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus data ini?")==JOptionPane.OK_OPTION) {
            String kode = view.getjDeleteKode().getText();
            model.setKode(kode);
            
            try {
                model.deleteBarang();
                JOptionPane.showMessageDialog(view, "Data berhasil dihapus");
                model.resetBarang();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, "Terjadi eror \n Eror Code "+throwable.getMessage());
            }
        }
        
    }
    
}
