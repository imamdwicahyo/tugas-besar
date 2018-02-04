/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok5.tugasbesarpbo.view;

import edu.kelompok5.tugasbesarpbo.controller.BarangController;
import edu.kelompok5.tugasbesarpbo.database.EasyShopDatabase;
import edu.kelompok5.tugasbesarpbo.entity.Barang;
import edu.kelompok5.tugasbesarpbo.eror.BarangException;
import edu.kelompok5.tugasbesarpbo.event.BarangListener;
import edu.kelompok5.tugasbesarpbo.model.BarangModel;
import edu.kelompok5.tugasbesarpbo.model.TabelBarangCari;
import edu.kelompok5.tugasbesarpbo.model.TabelBarangModel;
import edu.kelompok5.tugasbesarpbo.service.BarangDao;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author IDC
 */
public class MainViewShop extends javax.swing.JFrame implements BarangListener, ListSelectionListener{

    /**
     * Creates new form MainViewShop
     */
    private TabelBarangModel tabelModel;
    private TabelBarangCari tabelCari;
    private BarangModel model;
    private BarangController controller;
    private TableModel tmodel;
    private String cari2;
    private String username;
    private String pass;
    
    
    public MainViewShop() {
        tabelModel = new TabelBarangModel();
        tabelCari = new TabelBarangCari();
        tmodel = new DefaultTableModel();
        
        model = new BarangModel();
        model.setListener(this);
        
        controller = new BarangController();
        controller.setModel(model);
        
        initComponents();
        jTableBarang.getSelectionModel().addListSelectionListener((ListSelectionListener) this);
        jTableBarang.setModel(tabelModel);     
        hasilCari.setModel(tabelCari);
        
        panelRegister.setVisible(false);
        panelMenu.setVisible(false);
        menuLeft.setVisible(false);
        menuTop.setVisible(false);
        menuCount.setVisible(false);
        menuEdit.setVisible(false);
        menuShow.setVisible(false);
        menuEasy.setVisible(true);
    }
    
    String cariBarang;
    String jenisBarang;

    public JTextField getjAddHBeli() {
        return jAddHBeli;
    }

    public JTextField getjAddHJual() {
        return jAddHJual;
    }

    public JTextField getjAddKode() {
        return jAddKode;
    }

    public JTextField getjAddNama() {
        return jAddNama;
    }

    public JTextField getjAddStok() {
        return jAddStok;
    }

    public JTextField getjDeleteKode() {
        return jDeleteKode;
    }

    public JTextField getjRegEmail() {
        return jRegEmail;
    }

    public JPasswordField getjRegPassword() {
        return jRegPassword;
    }

    public JTextField getjRegTelephone() {
        return jRegTelephone;
    }

    public JTextField getjRegUsername() {
        return jRegUsername;
    }

    public JTable getjTableBarang() {
        return jTableBarang;
    }

    public JTextField getjUpdateHBeli() {
        return jUpdateHBeli;
    }

    public JTextField getjUpdateHJual() {
        return jUpdateHJual;
    }

    public JTextField getjUpdateKode() {
        return jUpdateKode;
    }

    public JTextField getjUpdateNama() {
        return jUpdateNama;
    }

    public JTextField getjUpdateStok() {
        return jUpdateStok;
    }

    public String getCariBarang() {
        return cariBarang;
    }

    public void setCariBarang(String cariBarang) {
        this.cariBarang = cariBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public JTextField getCari() {
        return cari;
    }

    public void setCari(JTextField cari) {
        this.cari = cari;
    }

    public JTable getHasilCari() {
        return hasilCari;
    }

    public void setHasilCari(JTable hasilCari) {
        this.hasilCari = hasilCari;
    }

    public String getCari2() {
        return cari2;
    }

    public void setTabelCari(TabelBarangCari tabelCari) {
        this.tabelCari = tabelCari;
    }

    Color hitam = new Color(18,18,18);
    Color hitam2 = new Color(20, 20, 20);
    Color abu = new Color(24, 24, 24);
    
    private void btnReset(){
        panelLogin.setVisible(false);
        panelRegister.setVisible(false);
        panelMenu.setVisible(false);
        menuLeft.setVisible(false);
        menuTop.setVisible(false);
        menuCount.setVisible(false);
        menuEdit.setVisible(false);
        menuShow.setVisible(false);
        menuEasy.setVisible(false);
    }
    
    private void btnDefaultMenu(){
        panelMenu.setVisible(true);
        menuLeft.setVisible(true);
        menuTop.setVisible(true);
    }
    
    private void btnLogin(){
        btnReset();
        panelLogin.setVisible(true);
    }
    
    private void btnRegister(){
        btnReset();
        panelRegister.setVisible(true);
    }
    
    private void btnMenu(){
        btnReset();
        btnDefaultMenu();
        menuEasy.setVisible(true);
        jUserName.setText(username);
    }
    
    private void btnEasy(){
        btnReset();
        btnDefaultMenu();
        menuEasy.setVisible(true);
    }
    
    private void btnEasyClick(){
        warna1.setBackground(Color.WHITE);
        warna2.setBackground(hitam);
        warna3.setBackground(hitam);
        warna4.setBackground(hitam);
    }
    
    private void btnEdit(){
        btnReset();
        btnDefaultMenu();
        menuEdit.setVisible(true);
    }
    
    private void btnEditClick(){
        warna1.setBackground(hitam);
        warna2.setBackground(Color.WHITE);
        warna3.setBackground(hitam);
        warna4.setBackground(hitam);
    }
    
    private void btnShow(){
        btnReset();
        btnDefaultMenu();
        menuShow.setVisible(true);
    }
    
    private void btnShowClick(){
        warna1.setBackground(hitam);
        warna2.setBackground(hitam);
        warna3.setBackground(Color.WHITE);
        warna4.setBackground(hitam);
    }
    
    private void btnCount(){
        btnReset();
        btnDefaultMenu();
        menuCount.setVisible(true);;
    }
    
    private void btnCountClick(){
        warna1.setBackground(hitam);
        warna2.setBackground(hitam);
        warna3.setBackground(hitam);
        warna4.setBackground(Color.WHITE);
    }
    
    private void btnMenuEnter(JPanel btn){
        btnMenuEasy.setBackground(hitam);
        btnMenuEdit.setBackground(hitam);
        btnMenuCounting.setBackground(hitam);
        btnMenuShow.setBackground(hitam);
        if (btn == btnMenuEasy) {
            btnMenuEasy.setBackground(hitam2);
        } else if (btn == btnMenuEdit) {
            btnMenuEdit.setBackground(hitam2);
        } else if (btn == btnMenuShow) {
            btnMenuShow.setBackground(hitam2);
        } else if (btn == btnMenuCounting) {
            btnMenuCounting.setBackground(hitam2);
        }
    }
    
    private void btnMenuExit(JPanel btn){
        btnMenuEasy.setBackground(hitam);
        btnMenuEdit.setBackground(hitam);
        btnMenuCounting.setBackground(hitam);
        btnMenuShow.setBackground(hitam);
        if (btn == btnMenuEasy) {
            btnMenuEasy.setBackground(hitam);
        } else if (btn == btnMenuEdit) {
            btnMenuEdit.setBackground(hitam);
        } else if (btn == btnMenuShow) {
            btnMenuShow.setBackground(hitam);
        } else if (btn == btnMenuCounting) {
            btnMenuCounting.setBackground(hitam);
        }
    }
    
    public void btnAdd(){
        tambahData.setVisible(true);
        updateData.setVisible(false);
        DeleteData.setVisible(false);
        jAddKode.setText("Kode Barang");
        jAddNama.setText("Nama Barang");
        jAddStok.setText("Stok");
        jAddHBeli.setText("Harga Beli");
        jAddHJual.setText("Harga Jual");
                
    }

    private void btnupdate(){
        tambahData.setVisible(false);
        updateData.setVisible(true);
        DeleteData.setVisible(false);
        jUpdateKode.setText("Kode Barang");
        jUpdateNama.setText("Nama Barang");
        jUpdateStok.setText("Stok");
        jUpdateHBeli.setText("Harga Beli");
        jUpdateHJual.setText("Harga Jual");
    }
    
    private void btnDelete(){
        tambahData.setVisible(false);
        updateData.setVisible(false);
        DeleteData.setVisible(true);
        jDeleteKode.setText("Kode Barang");
    }
    
    private void btnEditColor(JPanel btn){
        btnAddData.setBackground(hitam);
        btnUpdateData.setBackground(hitam);
        btnDeleteData.setBackground(hitam);
        if (btn == btnAddData) {
            btnAddData.setBackground(abu);
        } else if (btn == btnUpdateData){
            btnUpdateData.setBackground(abu);
        } else if (btn == btnDeleteData){
            btnDeleteData.setBackground(abu);
        }
    }
    
    public void resetText(JTextField text, String same){
    if (text.getText().equals(same)) {
            text.setText("");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLoginPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLoginUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegister2 = new javax.swing.JLabel();
        jWallpaper = new javax.swing.JLabel();
        panelRegister = new javax.swing.JPanel();
        btnLogin2 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRegPassword = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jRegUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jRegEmail = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jRegTelephone = new javax.swing.JTextField();
        jWallpaper1 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        menuLeft = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnMenuEasy = new javax.swing.JPanel();
        warna1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnMenuEdit = new javax.swing.JPanel();
        warna2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnMenuShow = new javax.swing.JPanel();
        warna3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnMenuCounting = new javax.swing.JPanel();
        warna4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnExit = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        menuRight = new javax.swing.JPanel();
        menuTop = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        menuEasy = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hasilCari = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        cari = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        menuEdit = new javax.swing.JPanel();
        btnAddData = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnUpdateData = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnDeleteData = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        tambahData = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jAddStok = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jAddNama = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jAddKode = new javax.swing.JTextField();
        btnAddBarang = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jAddHBeli = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jAddHJual = new javax.swing.JTextField();
        updateData = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jUpdateStok = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jUpdateNama = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jUpdateKode = new javax.swing.JTextField();
        btnUpdateBarang = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jUpdateHJual = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jUpdateHBeli = new javax.swing.JTextField();
        DeleteData = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jDeleteKode = new javax.swing.JTextField();
        btnDeleteBarang = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        menuShow = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBarang = new javax.swing.JTable();
        btnAddData1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        btnUpdateData1 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnDeleteData1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        menuCount = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLoginPassword.setText("jPasswordField1");
        jLoginPassword.setBorder(null);
        jLoginPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLoginPasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLoginPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelLogin.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 260, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLoginUsername.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLoginUsername.setText("Username");
        jLoginUsername.setBorder(null);
        jLoginUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLoginUsernameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLoginUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelLogin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 260, 40));

        btnLogin.setBackground(new java.awt.Color(51, 51, 51));
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sign In");

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLoginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 90, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/kelompok5/tugasbesarpbo/images/icons8-shopping-bag-full-50.png"))); // NOI18N
        jLabel1.setText("  Easy Shop");
        panelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 180, -1));

        btnRegister2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnRegister2.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister2.setText("Sign Up");
        btnRegister2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegister2MouseClicked(evt);
            }
        });
        panelLogin.add(btnRegister2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, -1, 30));

        jWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/kelompok5/tugasbesarpbo/images/curve-simplicity.jpg"))); // NOI18N
        panelLogin.add(jWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        getContentPane().add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        panelRegister.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnLogin2.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin2.setText("Sign In");
        btnLogin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogin2MouseClicked(evt);
            }
        });
        panelRegister.add(btnLogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, -1, 30));

        btnRegister.setBackground(new java.awt.Color(51, 51, 51));
        btnRegister.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sign Up");

        javax.swing.GroupLayout btnRegisterLayout = new javax.swing.GroupLayout(btnRegister);
        btnRegister.setLayout(btnRegisterLayout);
        btnRegisterLayout.setHorizontalGroup(
            btnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
            .addGroup(btnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegisterLayout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        btnRegisterLayout.setVerticalGroup(
            btnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(btnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnRegisterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        panelRegister.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 90, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jRegPassword.setText("jPasswordField1");
        jRegPassword.setBorder(null);
        jRegPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRegPasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRegPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRegister.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 260, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jRegUsername.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jRegUsername.setText("Username");
        jRegUsername.setBorder(null);
        jRegUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRegUsernameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRegUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRegister.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 260, 40));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/kelompok5/tugasbesarpbo/images/icons8-shopping-bag-full-50.png"))); // NOI18N
        jLabel4.setText("  Easy Shop");
        panelRegister.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 180, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jRegEmail.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jRegEmail.setText("Email");
        jRegEmail.setBorder(null);
        jRegEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRegEmailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRegEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRegister.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 260, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jRegTelephone.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jRegTelephone.setText("Telephone");
        jRegTelephone.setBorder(null);
        jRegTelephone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRegTelephoneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRegTelephone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRegister.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 260, 40));

        jWallpaper1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/kelompok5/tugasbesarpbo/images/curve-simplicity.jpg"))); // NOI18N
        panelRegister.add(jWallpaper1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        getContentPane().add(panelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLeft.setBackground(new java.awt.Color(18, 18, 18));
        menuLeft.setPreferredSize(new java.awt.Dimension(200, 650));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/kelompok5/tugasbesarpbo/images/icons8-shopping-bag-full-50.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Easy");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SHOP");

        btnMenuEasy.setBackground(new java.awt.Color(18, 18, 18));
        btnMenuEasy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuEasyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuEasyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuEasyMouseExited(evt);
            }
        });
        btnMenuEasy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warna1.setBackground(new java.awt.Color(255, 255, 255));
        warna1.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout warna1Layout = new javax.swing.GroupLayout(warna1);
        warna1.setLayout(warna1Layout);
        warna1Layout.setHorizontalGroup(
            warna1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        warna1Layout.setVerticalGroup(
            warna1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMenuEasy.add(warna1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Easy");
        btnMenuEasy.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 50, 30));

        btnMenuEdit.setBackground(new java.awt.Color(18, 18, 18));
        btnMenuEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuEditMouseExited(evt);
            }
        });
        btnMenuEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warna2.setBackground(new java.awt.Color(18, 18, 18));
        warna2.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout warna2Layout = new javax.swing.GroupLayout(warna2);
        warna2.setLayout(warna2Layout);
        warna2Layout.setHorizontalGroup(
            warna2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        warna2Layout.setVerticalGroup(
            warna2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMenuEdit.add(warna2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Edit Data");
        btnMenuEdit.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 90, 30));

        btnMenuShow.setBackground(new java.awt.Color(18, 18, 18));
        btnMenuShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuShowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuShowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuShowMouseExited(evt);
            }
        });
        btnMenuShow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warna3.setBackground(new java.awt.Color(18, 18, 18));
        warna3.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout warna3Layout = new javax.swing.GroupLayout(warna3);
        warna3.setLayout(warna3Layout);
        warna3Layout.setHorizontalGroup(
            warna3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        warna3Layout.setVerticalGroup(
            warna3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMenuShow.add(warna3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Show Data");
        btnMenuShow.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 110, 30));

        btnMenuCounting.setBackground(new java.awt.Color(18, 18, 18));
        btnMenuCounting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuCountingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuCountingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuCountingMouseExited(evt);
            }
        });
        btnMenuCounting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warna4.setBackground(new java.awt.Color(18, 18, 18));
        warna4.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout warna4Layout = new javax.swing.GroupLayout(warna4);
        warna4.setLayout(warna4Layout);
        warna4Layout.setHorizontalGroup(
            warna4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        warna4Layout.setVerticalGroup(
            warna4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMenuCounting.add(warna4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Counting");
        btnMenuCounting.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 90, 30));

        btnExit.setBackground(new java.awt.Color(18, 18, 18));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        btnExit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(18, 18, 18));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnExit.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Exit");
        btnExit.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 90, 30));

        javax.swing.GroupLayout menuLeftLayout = new javax.swing.GroupLayout(menuLeft);
        menuLeft.setLayout(menuLeftLayout);
        menuLeftLayout.setHorizontalGroup(
            menuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLeftLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnMenuEasy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMenuEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMenuShow, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(btnMenuCounting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLeftLayout.setVerticalGroup(
            menuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLeftLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(menuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuLeftLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnMenuEasy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuCounting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMenu.add(menuLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuRight.setBackground(new java.awt.Color(255, 255, 255));
        menuRight.setPreferredSize(new java.awt.Dimension(900, 650));
        menuRight.setRequestFocusEnabled(false);
        menuRight.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuTop.setBackground(new java.awt.Color(18, 18, 18));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/kelompok5/tugasbesarpbo/images/icons8-customer-50.png"))); // NOI18N

        jUserName.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jUserName.setForeground(new java.awt.Color(255, 255, 255));
        jUserName.setText("Username");

        javax.swing.GroupLayout menuTopLayout = new javax.swing.GroupLayout(menuTop);
        menuTop.setLayout(menuTopLayout);
        menuTopLayout.setHorizontalGroup(
            menuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTopLayout.createSequentialGroup()
                .addContainerGap(646, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jUserName)
                .addGap(69, 69, 69))
        );
        menuTopLayout.setVerticalGroup(
            menuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTopLayout.createSequentialGroup()
                .addGroup(menuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuTopLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel15))
                    .addGroup(menuTopLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jUserName)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        menuRight.add(menuTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

        menuEasy.setBackground(new java.awt.Color(24, 24, 24));
        menuEasy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hasilCari.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(hasilCari);

        menuEasy.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 740, 180));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        cari.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cari.setText("Cari Barang");
        cari.setBorder(null);
        cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariMouseClicked(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuEasy.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 740, 40));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Cara Mudah Cari Barang..");
        menuEasy.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Easy....");
        menuEasy.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        menuRight.add(menuEasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 550));

        menuEdit.setBackground(new java.awt.Color(24, 24, 24));
        menuEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddData.setBackground(new java.awt.Color(24, 24, 24));
        btnAddData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddDataMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Add Data");

        javax.swing.GroupLayout btnAddDataLayout = new javax.swing.GroupLayout(btnAddData);
        btnAddData.setLayout(btnAddDataLayout);
        btnAddDataLayout.setHorizontalGroup(
            btnAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(btnAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAddDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnAddDataLayout.setVerticalGroup(
            btnAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
            .addGroup(btnAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAddDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuEdit.add(btnAddData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        btnUpdateData.setBackground(new java.awt.Color(18, 18, 18));
        btnUpdateData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateDataMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Update Data");

        javax.swing.GroupLayout btnUpdateDataLayout = new javax.swing.GroupLayout(btnUpdateData);
        btnUpdateData.setLayout(btnUpdateDataLayout);
        btnUpdateDataLayout.setHorizontalGroup(
            btnUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(btnUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnUpdateDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnUpdateDataLayout.setVerticalGroup(
            btnUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
            .addGroup(btnUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnUpdateDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuEdit.add(btnUpdateData, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 300, -1));

        btnDeleteData.setBackground(new java.awt.Color(18, 18, 18));
        btnDeleteData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteDataMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Delete Data");

        javax.swing.GroupLayout btnDeleteDataLayout = new javax.swing.GroupLayout(btnDeleteData);
        btnDeleteData.setLayout(btnDeleteDataLayout);
        btnDeleteDataLayout.setHorizontalGroup(
            btnDeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(btnDeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDeleteDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnDeleteDataLayout.setVerticalGroup(
            btnDeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
            .addGroup(btnDeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDeleteDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuEdit.add(btnDeleteData, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 300, -1));

        tambahData.setBackground(new java.awt.Color(24, 24, 24));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jAddStok.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddStok.setText("Stok");
        jAddStok.setBorder(null);
        jAddStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddStokMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAddStok, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddStok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jAddNama.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddNama.setText("Nama Barang");
        jAddNama.setBorder(null);
        jAddNama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddNamaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAddNama, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jAddKode.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddKode.setText("Kode Barang");
        jAddKode.setBorder(null);
        jAddKode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddKodeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAddKode, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddKode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnAddBarang.setBackground(new java.awt.Color(18, 18, 18));
        btnAddBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAddBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddBarangMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Add");

        javax.swing.GroupLayout btnAddBarangLayout = new javax.swing.GroupLayout(btnAddBarang);
        btnAddBarang.setLayout(btnAddBarangLayout);
        btnAddBarangLayout.setHorizontalGroup(
            btnAddBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAddBarangLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(116, 116, 116))
        );
        btnAddBarangLayout.setVerticalGroup(
            btnAddBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAddBarangLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(42, 42, 42))
        );

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jAddHBeli.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddHBeli.setText("Harga Beli");
        jAddHBeli.setBorder(null);
        jAddHBeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddHBeliMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jAddHBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddHBeli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jAddHJual.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddHJual.setText("Harga Jual");
        jAddHJual.setBorder(null);
        jAddHJual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddHJualMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jAddHJual, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddHJual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tambahDataLayout = new javax.swing.GroupLayout(tambahData);
        tambahData.setLayout(tambahDataLayout);
        tambahDataLayout.setHorizontalGroup(
            tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahDataLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambahDataLayout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tambahDataLayout.createSequentialGroup()
                        .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tambahDataLayout.createSequentialGroup()
                                .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(209, 209, 209))
                            .addGroup(tambahDataLayout.createSequentialGroup()
                                .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnAddBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        tambahDataLayout.setVerticalGroup(
            tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahDataLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambahDataLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tambahDataLayout.createSequentialGroup()
                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tambahDataLayout.createSequentialGroup()
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE))))
                    .addGroup(tambahDataLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnAddBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        menuEdit.add(tambahData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 900, 510));

        updateData.setBackground(new java.awt.Color(24, 24, 24));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateStok.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateStok.setText("Stok");
        jUpdateStok.setBorder(null);
        jUpdateStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateStokMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jUpdateStok, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateStok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateNama.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateNama.setText("Nama Barang");
        jUpdateNama.setBorder(null);
        jUpdateNama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateNamaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jUpdateNama, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateKode.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateKode.setText("Kode Barang");
        jUpdateKode.setBorder(null);
        jUpdateKode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateKodeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jUpdateKode, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateKode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnUpdateBarang.setBackground(new java.awt.Color(18, 18, 18));
        btnUpdateBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnUpdateBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateBarangMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Update");

        javax.swing.GroupLayout btnUpdateBarangLayout = new javax.swing.GroupLayout(btnUpdateBarang);
        btnUpdateBarang.setLayout(btnUpdateBarangLayout);
        btnUpdateBarangLayout.setHorizontalGroup(
            btnUpdateBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUpdateBarangLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(116, 116, 116))
        );
        btnUpdateBarangLayout.setVerticalGroup(
            btnUpdateBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUpdateBarangLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(42, 42, 42))
        );

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Masukan Kode barang yang akan di ubah");

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateHJual.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateHJual.setText("Harga Jual");
        jUpdateHJual.setBorder(null);
        jUpdateHJual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateHJualMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jUpdateHJual, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateHJual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateHBeli.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateHBeli.setText("Harga Beli");
        jUpdateHBeli.setBorder(null);
        jUpdateHBeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateHBeliMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jUpdateHBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateHBeli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout updateDataLayout = new javax.swing.GroupLayout(updateData);
        updateData.setLayout(updateDataLayout);
        updateDataLayout.setHorizontalGroup(
            updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateDataLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateDataLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(144, Short.MAX_VALUE))
                    .addGroup(updateDataLayout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(updateDataLayout.createSequentialGroup()
                        .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        updateDataLayout.setVerticalGroup(
            updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateDataLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateDataLayout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnUpdateBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        menuEdit.add(updateData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 900, 510));

        DeleteData.setBackground(new java.awt.Color(24, 24, 24));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        jDeleteKode.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jDeleteKode.setText("Kode Barang");
        jDeleteKode.setBorder(null);
        jDeleteKode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteKodeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDeleteKode, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDeleteKode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnDeleteBarang.setBackground(new java.awt.Color(18, 18, 18));
        btnDeleteBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnDeleteBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteBarangMouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Delete");

        javax.swing.GroupLayout btnDeleteBarangLayout = new javax.swing.GroupLayout(btnDeleteBarang);
        btnDeleteBarang.setLayout(btnDeleteBarangLayout);
        btnDeleteBarangLayout.setHorizontalGroup(
            btnDeleteBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDeleteBarangLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(116, 116, 116))
        );
        btnDeleteBarangLayout.setVerticalGroup(
            btnDeleteBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDeleteBarangLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(42, 42, 42))
        );

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Masukan Kode barang yang akan di Hapus");

        javax.swing.GroupLayout DeleteDataLayout = new javax.swing.GroupLayout(DeleteData);
        DeleteData.setLayout(DeleteDataLayout);
        DeleteDataLayout.setHorizontalGroup(
            DeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteDataLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeleteBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        DeleteDataLayout.setVerticalGroup(
            DeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteDataLayout.createSequentialGroup()
                .addGroup(DeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteDataLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel24))
                    .addGroup(DeleteDataLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90)
                .addComponent(btnDeleteBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        menuEdit.add(DeleteData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 900, 510));

        menuRight.add(menuEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 550));

        menuShow.setBackground(new java.awt.Color(24, 24, 24));
        menuShow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Daftar Barang");
        menuShow.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 200, 30));

        jTableBarang.setBackground(new java.awt.Color(204, 204, 204));
        jTableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableBarang.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTableBarang);

        menuShow.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, 840, 350));
        jScrollPane1.getAccessibleContext().setAccessibleParent(this);

        btnAddData1.setBackground(new java.awt.Color(18, 18, 18));
        btnAddData1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnAddData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddData1MouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Add Data");

        javax.swing.GroupLayout btnAddData1Layout = new javax.swing.GroupLayout(btnAddData1);
        btnAddData1.setLayout(btnAddData1Layout);
        btnAddData1Layout.setHorizontalGroup(
            btnAddData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
            .addGroup(btnAddData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAddData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnAddData1Layout.setVerticalGroup(
            btnAddData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
            .addGroup(btnAddData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAddData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuShow.add(btnAddData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 160, -1));

        btnUpdateData1.setBackground(new java.awt.Color(18, 18, 18));
        btnUpdateData1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnUpdateData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateData1MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Update Data");

        javax.swing.GroupLayout btnUpdateData1Layout = new javax.swing.GroupLayout(btnUpdateData1);
        btnUpdateData1.setLayout(btnUpdateData1Layout);
        btnUpdateData1Layout.setHorizontalGroup(
            btnUpdateData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(btnUpdateData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnUpdateData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnUpdateData1Layout.setVerticalGroup(
            btnUpdateData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(btnUpdateData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnUpdateData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuShow.add(btnUpdateData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, -1, -1));

        btnDeleteData1.setBackground(new java.awt.Color(18, 18, 18));
        btnDeleteData1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnDeleteData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteData1MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Delete Data");

        javax.swing.GroupLayout btnDeleteData1Layout = new javax.swing.GroupLayout(btnDeleteData1);
        btnDeleteData1.setLayout(btnDeleteData1Layout);
        btnDeleteData1Layout.setHorizontalGroup(
            btnDeleteData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
            .addGroup(btnDeleteData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDeleteData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnDeleteData1Layout.setVerticalGroup(
            btnDeleteData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
            .addGroup(btnDeleteData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDeleteData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuShow.add(btnDeleteData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, -1, -1));

        menuRight.add(menuShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 550));

        menuCount.setBackground(new java.awt.Color(24, 24, 24));
        menuCount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        menuRight.add(menuCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 550));

        panelMenu.add(menuRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 899, 650));

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLoginUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoginUsernameMouseClicked
        resetText(jLoginUsername, "Username");
    }//GEN-LAST:event_jLoginUsernameMouseClicked

    private void jLoginPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoginPasswordMouseClicked
        resetText(jLoginPassword, "jPasswordField1");
    }//GEN-LAST:event_jLoginPasswordMouseClicked

    private void jRegPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegPasswordMouseClicked
        resetText(jRegPassword, "jPasswordField1");
    }//GEN-LAST:event_jRegPasswordMouseClicked

    private void jRegUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegUsernameMouseClicked
        resetText(jRegUsername, "Username");
    }//GEN-LAST:event_jRegUsernameMouseClicked

    private void jRegEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegEmailMouseClicked
        resetText(jRegEmail, "Email");
    }//GEN-LAST:event_jRegEmailMouseClicked

    private void jRegTelephoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegTelephoneMouseClicked
        resetText(jRegTelephone, "Telephone");
    }//GEN-LAST:event_jRegTelephoneMouseClicked

    private void btnLogin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin2MouseClicked
        btnLogin();
    }//GEN-LAST:event_btnLogin2MouseClicked

    private void btnRegister2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegister2MouseClicked
        btnRegister();
    }//GEN-LAST:event_btnRegister2MouseClicked

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        if (jLoginUsername.getText().equals(username)&&jLoginPassword.getText().equals(pass)) {
            btnMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Username atau Password salah");
        }
        
        
    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        btnLogin();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnMenuEasyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEasyMouseClicked
        btnEasy();
        btnEasyClick();
        cari.setText("Cari Barang");
    }//GEN-LAST:event_btnMenuEasyMouseClicked

    private void btnMenuEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEditMouseClicked
        btnEdit();
        btnEditClick();
    }//GEN-LAST:event_btnMenuEditMouseClicked

    private void btnMenuShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuShowMouseClicked
        btnShow();
        btnShowClick();
    }//GEN-LAST:event_btnMenuShowMouseClicked

    private void btnMenuCountingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuCountingMouseClicked
        btnCount();
        btnCountClick();
    }//GEN-LAST:event_btnMenuCountingMouseClicked

    private void btnAddDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddDataMouseClicked
        btnAdd();
        btnEditColor(btnAddData);
    }//GEN-LAST:event_btnAddDataMouseClicked

    private void btnUpdateDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateDataMouseClicked
        btnupdate();
        btnEditColor(btnUpdateData);
    }//GEN-LAST:event_btnUpdateDataMouseClicked

    private void btnDeleteDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteDataMouseClicked
        btnDelete();
        btnEditColor(btnDeleteData);
    }//GEN-LAST:event_btnDeleteDataMouseClicked

    private void btnAddBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddBarangMouseClicked
         // TODO add your handling code here:
         controller.insertBarang(this);
    }//GEN-LAST:event_btnAddBarangMouseClicked

    private void btnUpdateBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateBarangMouseClicked
         // TODO add your handling code here:
         controller.updateBarang(this);
    }//GEN-LAST:event_btnUpdateBarangMouseClicked

    private void btnDeleteBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteBarangMouseClicked
         // TODO add your handling code here:
         controller.deleteBarang(this);
    }//GEN-LAST:event_btnDeleteBarangMouseClicked

    private void btnMenuEasyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEasyMouseEntered
         // TODO add your handling code here:
         btnMenuEnter(btnMenuEasy);
    }//GEN-LAST:event_btnMenuEasyMouseEntered

    private void btnMenuEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEditMouseEntered
         // TODO add your handling code here:
         btnMenuEnter(btnMenuEdit);
    }//GEN-LAST:event_btnMenuEditMouseEntered

    private void btnMenuShowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuShowMouseEntered
         // TODO add your handling code here:
         btnMenuEnter(btnMenuShow);
    }//GEN-LAST:event_btnMenuShowMouseEntered

    private void btnMenuCountingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuCountingMouseEntered
         // TODO add your handling code here:
         btnMenuEnter(btnMenuCounting);
    }//GEN-LAST:event_btnMenuCountingMouseEntered

    private void btnMenuEasyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEasyMouseExited
         // TODO add your handling code here:
         btnMenuExit(btnMenuEasy);
    }//GEN-LAST:event_btnMenuEasyMouseExited

    private void btnMenuEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEditMouseExited
         // TODO add your handling code here:
         btnMenuExit(btnMenuEdit);
    }//GEN-LAST:event_btnMenuEditMouseExited

    private void btnMenuShowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuShowMouseExited
         // TODO add your handling code here:
         btnMenuExit(btnMenuShow);
    }//GEN-LAST:event_btnMenuShowMouseExited

    private void btnMenuCountingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuCountingMouseExited
         // TODO add your handling code here:
         btnMenuExit(btnMenuCounting);
    }//GEN-LAST:event_btnMenuCountingMouseExited

    private void jAddKodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddKodeMouseClicked
         // TODO add your handling code here:
         resetText(jAddKode, "Kode Barang");
    }//GEN-LAST:event_jAddKodeMouseClicked

    private void jAddNamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddNamaMouseClicked
         // TODO add your handling code here:
         resetText(jAddNama, "Nama Barang");
    }//GEN-LAST:event_jAddNamaMouseClicked

    private void jAddStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddStokMouseClicked
        // TODO add your handling code here:
        resetText(jAddStok, "Stok");
    }//GEN-LAST:event_jAddStokMouseClicked

    private void jAddHBeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddHBeliMouseClicked
        // TODO add your handling code here:
        resetText(jAddHBeli, "Harga Beli");
    }//GEN-LAST:event_jAddHBeliMouseClicked

    private void jAddHJualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddHJualMouseClicked
        // TODO add your handling code here:
        resetText(jAddHJual, "Harga Jual");
    }//GEN-LAST:event_jAddHJualMouseClicked

    private void jUpdateKodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateKodeMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateKode, "Kode Barang");
    }//GEN-LAST:event_jUpdateKodeMouseClicked

    private void jUpdateNamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateNamaMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateNama, "Nama Barang");
    }//GEN-LAST:event_jUpdateNamaMouseClicked

    private void jUpdateStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateStokMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateStok, "Stok");
    }//GEN-LAST:event_jUpdateStokMouseClicked

    private void jUpdateHBeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateHBeliMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateHBeli, "Harga Beli");
    }//GEN-LAST:event_jUpdateHBeliMouseClicked

    private void jUpdateHJualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateHJualMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateHJual, "Harga Jual");
    }//GEN-LAST:event_jUpdateHJualMouseClicked

    private void jDeleteKodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteKodeMouseClicked
        // TODO add your handling code here:
        resetText(jDeleteKode, "Kode Barang");
    }//GEN-LAST:event_jDeleteKodeMouseClicked

    private void btnAddData1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddData1MouseClicked
        // TODO add your handling code here:
        btnReset();
        btnDefaultMenu();
        menuEdit.setVisible(true);
        btnAdd();
        btnEditClick();
    }//GEN-LAST:event_btnAddData1MouseClicked

    private void btnUpdateData1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateData1MouseClicked
        // TODO add your handling code here:
        if (getjTableBarang().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang akan diubah");
            return;
        }
        btnEdit();
        updateData.setVisible(true);
        tambahData.setVisible(false);
        DeleteData.setVisible(false);
        btnEditColor(btnUpdateData);
        btnEditClick();
    }//GEN-LAST:event_btnUpdateData1MouseClicked

    private void btnDeleteData1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteData1MouseClicked
        // TODO add your handling code here:
        if (getjTableBarang().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang akan dihapus");
            return;
        }
        btnEdit();
        updateData.setVisible(false);
        tambahData.setVisible(false);
        DeleteData.setVisible(true);
        btnEditColor(btnDeleteData);
        btnEditClick();
    }//GEN-LAST:event_btnDeleteData1MouseClicked

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        // TODO add your handling code here:
        hasilCari.setModel(tmodel);
        cari2 = cari.getText();
            try {          
            BarangDao dao = EasyShopDatabase.getbarangDao();
            tabelCari.setList(dao.selectCariBarang(cari2)); 
            hasilCari.setModel(tabelCari);
            } catch (SQLException ex) {
            Logger.getLogger(MainViewShop.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BarangException ex) {
            Logger.getLogger(MainViewShop.class.getName()).log(Level.SEVERE, null, ex);
            }
            hasilCari.setModel(tabelCari);
            onChange(model);       
    }//GEN-LAST:event_cariKeyReleased

    private void cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariMouseClicked
         // TODO add your handling code here:
         resetText(cari, "Cari Barang");
    }//GEN-LAST:event_cariMouseClicked

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        // TODO add your handling code here:
        username = jRegUsername.getText();
        pass = jRegPassword.getText();
        JOptionPane.showMessageDialog(null, "Pendaftaran berhasil silakan lakukan login");
        btnReset();
        btnLogin();
    }//GEN-LAST:event_btnRegisterMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainViewShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainViewShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainViewShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainViewShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainViewShop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeleteData;
    private javax.swing.JPanel btnAddBarang;
    private javax.swing.JPanel btnAddData;
    private javax.swing.JPanel btnAddData1;
    private javax.swing.JPanel btnDeleteBarang;
    private javax.swing.JPanel btnDeleteData;
    private javax.swing.JPanel btnDeleteData1;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnLogin;
    private javax.swing.JLabel btnLogin2;
    private javax.swing.JPanel btnMenuCounting;
    private javax.swing.JPanel btnMenuEasy;
    private javax.swing.JPanel btnMenuEdit;
    private javax.swing.JPanel btnMenuShow;
    private javax.swing.JPanel btnRegister;
    private javax.swing.JLabel btnRegister2;
    private javax.swing.JPanel btnUpdateBarang;
    private javax.swing.JPanel btnUpdateData;
    private javax.swing.JPanel btnUpdateData1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cari;
    private javax.swing.JTable hasilCari;
    private javax.swing.JTextField jAddHBeli;
    private javax.swing.JTextField jAddHJual;
    private javax.swing.JTextField jAddKode;
    private javax.swing.JTextField jAddNama;
    private javax.swing.JTextField jAddStok;
    private javax.swing.JTextField jDeleteKode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jLoginPassword;
    private javax.swing.JTextField jLoginUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jRegEmail;
    private javax.swing.JPasswordField jRegPassword;
    private javax.swing.JTextField jRegTelephone;
    private javax.swing.JTextField jRegUsername;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBarang;
    private javax.swing.JTextField jUpdateHBeli;
    private javax.swing.JTextField jUpdateHJual;
    private javax.swing.JTextField jUpdateKode;
    private javax.swing.JTextField jUpdateNama;
    private javax.swing.JTextField jUpdateStok;
    private javax.swing.JLabel jUserName;
    private javax.swing.JLabel jWallpaper;
    private javax.swing.JLabel jWallpaper1;
    private javax.swing.JPanel menuCount;
    private javax.swing.JPanel menuEasy;
    private javax.swing.JPanel menuEdit;
    private javax.swing.JPanel menuLeft;
    private javax.swing.JPanel menuRight;
    private javax.swing.JPanel menuShow;
    private javax.swing.JPanel menuTop;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelRegister;
    private javax.swing.JPanel tambahData;
    private javax.swing.JPanel updateData;
    private javax.swing.JPanel warna1;
    private javax.swing.JPanel warna2;
    private javax.swing.JPanel warna3;
    private javax.swing.JPanel warna4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(BarangModel model) {
        jUpdateKode.setText(model.getKode());
        jUpdateNama.setText(model.getNama_barang());
        jUpdateStok.setText( model.getStok()+"");
        jUpdateHJual.setText(model.getHarga_jual()+"");
        jUpdateHBeli.setText(model.getHarga_beli()+"");
    }

    @Override
    public void onInsert(Barang barang) {
        tabelModel.add(barang);
    }

    @Override
    public void onDelete() {
         int index = jTableBarang.getSelectedRow();
         tabelModel.remove(index);
    }

    @Override
    public void onUpdate(Barang barang) {
        int index = jTableBarang.getSelectedRow();
        tabelModel.set(index, barang);
    }
    
    public void loadDatabase() throws SQLException, BarangException{
        BarangDao dao = EasyShopDatabase.getbarangDao();
        tabelModel.setList(dao.selectAllBarang());
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        try {
            Barang model = tabelModel.get(jTableBarang.getSelectedRow());
            jUpdateKode.setText(model.getKode());
            jDeleteKode.setText(model.getKode());
            jUpdateNama.setText(model.getNama_barang());
            jUpdateStok.setText(model.getStok()+"");
            jUpdateHJual.setText(model.getHarga_jual()+"");
            jUpdateHBeli.setText(model.getHarga_beli()+"");
        } catch (IndexOutOfBoundsException exception) {
        }
    }

}
