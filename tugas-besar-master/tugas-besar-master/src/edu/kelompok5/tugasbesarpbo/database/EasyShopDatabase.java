/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.kelompok5.tugasbesarpbo.impl.BarangDaoImpl;
import edu.kelompok5.tugasbesarpbo.service.BarangDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author IDC
 */
public class EasyShopDatabase {
    
    private static Connection connection;
    private static BarangDao barangDao;
    
    public static Connection getConnection() throws SQLException{
        if (connection==null) {
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setURL("jdbc:mysql://localhost:3306/easyshop");
            datasource.setUser("root");
            datasource.setPassword("");
            connection = datasource.getConnection();
        }
        return connection;
    }
    
    public static BarangDao getbarangDao() throws SQLException{
        if (barangDao==null) {
            barangDao = new BarangDaoImpl(getConnection());
        }
        return barangDao;
    }
    
}
