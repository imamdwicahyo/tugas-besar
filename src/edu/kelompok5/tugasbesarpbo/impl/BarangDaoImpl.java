/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.impl;

import edu.kelompok5.tugasbesarpbo.entity.Barang;
import edu.kelompok5.tugasbesarpbo.eror.BarangException;
import edu.kelompok5.tugasbesarpbo.service.BarangDao;
import edu.kelompok5.tugasbesarpbo.view.MainViewShop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IDC
 */
public class BarangDaoImpl implements BarangDao{
    
    private Connection connection;
    private final String insertBarang = "INSERT INTO BARANG (KODE,NAMA_BARANG,STOK,HARGA_JUAL,HARGA_BELI) VALUES (?,?,?,?,?)";
    private final String updateBarang = "UPDATE BARANG SET KODE=?,NAMA_BARANG=?,STOK=?,HARGA_JUAL=?,HARGA_BELI=? WHERE KODE=?";
    private final String deleteBarang = "DELETE FROM BARANG WHERE KODE=?";
    private final String getByKode = "SELECT * FROM BARANG WHERE KODE=?";
    private final String selectAll = "SELECT * FROM BARANG";
    private final String cariBarang = "SELECT * FROM BARANG WHERE NAMA_BARANG=?";
    private final String pencarian = "SELECT * FROM BARANG WHERE NAMA_BARANG LIKE '?%'";

    
    public BarangDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public BarangDaoImpl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     

    @Override
    public void insertBarang(Barang barang) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(insertBarang);
            statement.setString(1, barang.getKode());
            statement.setString(2, barang.getNama_barang());
            statement.setInt(3, barang.getStok());
            statement.setInt(4, barang.getHarga_jual());
            statement.setInt(5, barang.getHarga_beli());
            statement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw  new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
                try {
                statement.close();
            } catch (SQLException e) {
            }
            }
        }
    }

    @Override
    public void updateBarang(Barang barang) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(updateBarang);
            statement.setString(1, barang.getKode());
            statement.setString(2, barang.getNama_barang());
            statement.setInt(3, barang.getStok());
            statement.setInt(4, barang.getHarga_jual());
            statement.setInt(5, barang.getHarga_beli());
            statement.setString(6, barang.getKode());
            statement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw  new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
                try {
                statement.close();
            } catch (SQLException e) {
            }
            }
        }
    }

    @Override
    public void daleteBarang(String kode) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(deleteBarang);
            statement.setString(1, kode);
            statement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw  new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
                try {
                statement.close();
            } catch (SQLException e) {
            }
            }
        }
    }

    @Override
    public Barang getBarang(String kode) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(getByKode);
            statement.setString(1, kode);
            
            ResultSet result = statement.executeQuery();
            Barang barang = null;
            if (result.next()) {
                barang = new Barang();
                barang.setKode(result.getString("KODE"));
                barang.setNama_barang(result.getString("NAMA_BARANG"));
                barang.setStok(result.getInt("STOK"));
                barang.setHarga_jual(result.getInt("HARGA_JUAL"));
                barang.setHarga_beli(result.getInt("HARGA_BELI"));
            } else {
                throw new BarangException("Barang dengan kode "+kode+" tidak ditemukan");
            }
            connection.commit();
            return barang;
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw  new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
                try {
                statement.close();
            } catch (SQLException e) {
            }
            }
        }
    }

    @Override
    public List<Barang> selectAllBarang() throws BarangException {
    Statement statement = null;
    List<Barang> list = new ArrayList<Barang>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            Barang barang = null;
            while (result.next()) {
                barang = new Barang();
                barang.setKode(result.getString("KODE"));
                barang.setNama_barang(result.getString("NAMA_BARANG"));
                barang.setStok(result.getInt("STOK"));
                barang.setHarga_jual(result.getInt("HARGA_JUAL"));
                barang.setHarga_beli(result.getInt("HARGA_BELI"));
                list.add(barang);
            }
            connection.commit();
            return list;
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw  new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
                try {
                statement.close();
            } catch (SQLException e) {
            }
            }
        }
    }

    @Override
    public Barang getCari(String cari) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(cariBarang);
            statement.setString(1, cari);
            
            ResultSet result = statement.executeQuery();
            Barang barang = null;
            if (result.next()) {
                barang = new Barang();
                barang.setKode(result.getString("KODE"));
                barang.setNama_barang(result.getString("NAMA_BARANG"));
                barang.setStok(result.getInt("STOK"));
                barang.setHarga_jual(result.getInt("HARGA_JUAL"));
                barang.setHarga_beli(result.getInt("HARGA_BELI"));
            } else {
                throw new BarangException("Barang dengan kode "+cari+" tidak ditemukan");
            }
            connection.commit();
            return barang;
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw  new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
                try {
                statement.close();
            } catch (SQLException e) {
            }
            }
        }
    }

    @Override
    public List<Barang> selectCariBarang(String nama) throws BarangException {
        Statement statement = null;
    List<Barang> list = new ArrayList<Barang>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM BARANG WHERE NAMA_BARANG LIKE '%"+nama+"%'");
            Barang barang = null;
            while (result.next()) {
                barang = new Barang();
                barang.setKode(result.getString("KODE"));
                barang.setNama_barang(result.getString("NAMA_BARANG"));
                barang.setStok(result.getInt("STOK"));
                barang.setHarga_jual(result.getInt("HARGA_JUAL"));
                barang.setHarga_beli(result.getInt("HARGA_BELI"));
                list.add(barang);
            }
            connection.commit();
            return list;
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw  new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
                try {
                statement.close();
            } catch (SQLException e) {
            }
            }
        }
    }
}
