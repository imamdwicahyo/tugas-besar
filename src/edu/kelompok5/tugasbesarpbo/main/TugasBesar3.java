/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.main;

import edu.kelompok5.tugasbesarpbo.view.MainViewShop;
import javax.swing.SwingUtilities;

/**
 *
 * @author IDC
 */
public class TugasBesar3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainViewShop shopApp = new MainViewShop();
                shopApp.setVisible(true);
            }
        });
    }
    
}
