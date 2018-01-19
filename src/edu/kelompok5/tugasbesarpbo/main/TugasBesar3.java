/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.main;

import edu.kelompok5.tugasbesarpbo.database.EasyShopDatabase;
import edu.kelompok5.tugasbesarpbo.entity.Barang;
import edu.kelompok5.tugasbesarpbo.eror.BarangException;
import edu.kelompok5.tugasbesarpbo.service.BarangDao;
import edu.kelompok5.tugasbesarpbo.view.MainViewShop;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author IDC
 */
public class TugasBesar3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, BarangException {       
        
        //BarangDao dao = EasyShopDatabase.getbarangDao();
        //Barang barang = dao.getBarang("1023981323123");
        //dao.daleteBarang("1023981323123");
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainViewShop barang = new MainViewShop();
                    barang.loadDatabase();
                    barang.setVisible(true);
                } catch (SQLException e) {
                } catch (BarangException ex) {
                    Logger.getLogger(TugasBesar3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    } 
}
