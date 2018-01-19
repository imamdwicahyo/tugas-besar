/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.model;

import edu.kelompok5.tugasbesarpbo.entity.Barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IDC
 */
public class TabelBarangModel extends AbstractTableModel{
    
    private List<Barang> list = new ArrayList<Barang>();

    public void setList(List<Barang> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public boolean add(Barang e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
        }
    }

    public Barang get(int i) {
        return list.get(i);
    }

    public Barang set(int i, Barang e) {
        try {
            return list.set(i, e);
        } finally {
            fireTableRowsUpdated(i, i);
        }
    }

    public Barang remove(int i) {
        try {
            return list.remove(i);
        } finally {
            fireTableRowsDeleted(i, i);
        }
    }

    
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0 : return "KODE";
            case 1 : return "NAMA_BARANG";
            case 2 : return "STOK";
            case 3 : return "HARGA_JUAL";
            case 4 : return "HARGA_BELI";
            default: return null;
        }
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getKode();
            case 1 : return list.get(rowIndex).getNama_barang();
            case 2 : return list.get(rowIndex).getStok();
            case 3 : return list.get(rowIndex).getHarga_jual();
            case 4 : return list.get(rowIndex).getHarga_beli();
            default: return null;
        }
    }
    
}
