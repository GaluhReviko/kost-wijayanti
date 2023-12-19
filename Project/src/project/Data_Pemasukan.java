/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static project.Data_Pemesanan.rs;
import static project.Data_Pemesanan.stm;


/**
 *
 * @author ASUS
 */
public class Data_Pemasukan extends javax.swing.JFrame {
public static Connection con;
public static Statement stm;
public static ResultSet rs;
    /**
     * Creates new form NewJFrame1
     */
    public Data_Pemasukan() {
        initComponents();
        koneksimysql();
        tampiltable();
        cari();
    }
    
        public void koneksimysql(){
    try{
        String url="jdbc:mysql://localhost/koswijayanti";
        String user="root";
        String pass="";
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(url, user, pass);
        stm = (Statement) con.createStatement();
    }catch (Exception e){
        System.err.println("koneksi Gagal"+e.getMessage());
    }
}
        
        public void tampiltable(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("No");
        tb.addColumn("Tanggal");
        tb.addColumn("Jenis Pembayaran");
        tb.addColumn("Nomor Kamar");
        tb.addColumn("Nama Penyewa");
        tb.addColumn("Jumlah");
        
        jTable1.setModel(tb);
        try {
            rs = stm.executeQuery("SELECT * FROM pemasukan ORDER BY ID_Transaksi ASC");
            while(rs.next()){
                tb.addRow(new Object[]{
                rs.getString("ID_Transaksi"),
                rs.getString("Tanggal_Pembayaran"),
                rs.getString("Jenis_Pembayaran"),
                rs.getString("Nomor_Kamar"),
                rs.getString("Nama_Penyewa"),
                rs.getString("Total_Harga")

            }
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
        public void cari(){
            DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("No");
        tb.addColumn("Tanggal");
        tb.addColumn("Jenis Pembayaran");
        tb.addColumn("Nomor Kamar");
        tb.addColumn("Nama Penyewa");
        tb.addColumn("Jumlah");
        
        jTable1.setModel(tb);
        try {
             String sql = "SELECT * FROM pemasukan WHERE ID_Transaksi like '%" +txtcari.getText() + "%' ORDER BY ID_Transaksi ASC";
            rs = stm.executeQuery(sql);
            while(rs.next()){
                tb.addRow(new Object[]{
                rs.getString("ID_Transaksi"),
                rs.getString("Tanggal_Pembayaran"),
                rs.getString("Jenis_Pembayaran"),
                rs.getString("Nomor_Kamar"),
                rs.getString("Nama_Penyewa"),
                rs.getString("Total_Harga")

            }
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setSelectionBackground(new java.awt.Color(153, 51, 0));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 1270, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 51, 0));
        jLabel2.setText("DATA PEMASUKAN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 51, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        txtcari.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });
        getContentPane().add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 260, 420, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/zzzz.png"))); // NOI18N
        jLabel3.setText(" ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -100, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/ooo.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/yyy.png"))); // NOI18N
        jLabel8.setText("Admin");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 180, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Template 2 (fix).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new Laporan().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setVisible(false);
        new Berandaa().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
                cari();
    }//GEN-LAST:event_txtcariKeyReleased

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
            java.util.logging.Logger.getLogger(Data_Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Pemasukan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}
