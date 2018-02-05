/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.event;

import edu.kelompok5.tugasbesarpbo.entity.Barang;
import edu.kelompok5.tugasbesarpbo.model.BarangModel;

/**
 *
 * @author IDC
 */
public interface BarangListener {
    
    public void onChange(BarangModel model);
    public void onInsert(Barang barang);
    public void onUpdate(Barang barang);
    public void onDelete();
    
    
}
