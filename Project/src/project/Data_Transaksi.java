
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class Data_Transaksi extends javax.swing.JFrame {
public static Connection con;
public static Statement stm;
public static ResultSet rs;
public static PreparedStatement psht;

JasperReport JasRep;
    JasperPrint  JasPri;
    Map param = new HashMap();
    JasperDesign Jasdes;
    /**
     * Creates new form Data_Transaksi
     */
    public Data_Transaksi() {
        initComponents();
        koneksimysql();
        tampiltable();
        tampil_combobox();
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
    
    public void tampil_combobox(){
         try {
                         String sql = "SELECT * FROM transaksi";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                combopesanan.addItem(rs.getString("ID_Transaksi"));
            }
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
         } catch (Exception e) {
         }
     }
    
     public void cari(){
         DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Nomor Pemesanan");
        tb.addColumn("Jenis Pembayaran");
        tb.addColumn("Harga Per Bulan");
        tb.addColumn("Lama Menyewa");
        tb.addColumn("Total");
        
        tbltransaksi.setModel(tb);
        try {
            String sql = "SELECT * FROM detail_transaksi WHERE ID_Transaksi like '%" +txtcari.getText() + "%' ORDER BY ID_Transaksi ASC";
            rs = stm.executeQuery(sql);
            while(rs.next()){
                tb.addRow(new Object[]{
                rs.getString("ID_Transaksi"),
                rs.getString("Jenis_Pembayaran"),
                rs.getString("Harga_Sewa"),
                rs.getString("Lama_Sewa"),
                rs.getString("Total_Harga")
               
            }
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void tampiltable(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Nomor Pemesanan");
        tb.addColumn("Jenis Pembayaran");
        tb.addColumn("Harga Per Bulan");
        tb.addColumn("Lama Menyewa");
        tb.addColumn("Total");
        
        tbltransaksi.setModel(tb);
        try {
            rs = stm.executeQuery("SELECT * FROM detail_transaksi ORDER BY ID_Transaksi ASC ");
            while(rs.next()){
                tb.addRow(new Object[]{
                rs.getString("ID_Transaksi"),
                rs.getString("Jenis_Pembayaran"),
                rs.getString("Harga_Sewa"),
                rs.getString("Lama_Sewa"),
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txtlama = new javax.swing.JTextField();
        txtjenis = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btntransaksi = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btncetak = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        combopesanan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/zzzz.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, -1, 90));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/ooo.png"))); // NOI18N
        jLabel8.setText(" ");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Penyewa");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Kamar");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Transaksi");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Total");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("No Pesanan");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 160, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Jenis Pembayaran");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Harga Sewa");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 160, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Lama Sewa");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 160, -1));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 240, 30));

        txtlama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlamaActionPerformed(evt);
            }
        });
        getContentPane().add(txtlama, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 240, 30));

        txtjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjenisActionPerformed(evt);
            }
        });
        getContentPane().add(txtjenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 240, 30));
        getContentPane().add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 240, 30));

        btntambah.setBackground(new java.awt.Color(153, 51, 0));
        btntambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btntambah.setForeground(new java.awt.Color(255, 255, 255));
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        getContentPane().add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, 30));

        btnclear.setBackground(new java.awt.Color(153, 51, 0));
        btnclear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 80, 30));

        btnhapus.setBackground(new java.awt.Color(153, 51, 0));
        btnhapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnhapus.setForeground(new java.awt.Color(255, 255, 255));
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 80, 30));

        btntransaksi.setBackground(new java.awt.Color(153, 51, 0));
        btntransaksi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btntransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btntransaksi.setText("Pemesanan");
        btntransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btntransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 30));

        btnupdate.setBackground(new java.awt.Color(153, 51, 0));
        btnupdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 80, 30));

        jButton1.setBackground(new java.awt.Color(153, 51, 0));
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, -1, 30));

        btncetak.setBackground(new java.awt.Color(153, 51, 0));
        btncetak.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncetak.setForeground(new java.awt.Color(255, 255, 255));
        btncetak.setText("Cetak");
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });
        getContentPane().add(btncetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 80, 30));

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
        getContentPane().add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 360, 350, 30));

        combopesanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH NO PESANAN" }));
        getContentPane().add(combopesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 240, 30));

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbltransaksi.setSelectionBackground(new java.awt.Color(153, 51, 0));
        tbltransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltransaksi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 401, 1330, 350));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/yyy.png"))); // NOI18N
        jLabel12.setText("Admin");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 170, 60));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Template 2 (fix).png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    this.setVisible(false);
    new Berandaa().setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
    this.setVisible(false);
    new Penyewa().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txtjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjenisActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
    koneksimysql();
      try {
            String sql = "insert into detail_transaksi values("
                       
                        + "'"+combopesanan.getSelectedItem()+"',"
                        + "'"+txtjenis.getText()+"',"
                        + "'"+txtharga.getText()+"',"
                        + "'"+txtlama.getText()+"',"
                        + "'"+txttotal.getText()+"')";
            
         psht = con.prepareStatement(sql);
         psht.executeUpdate();
         koneksimysql();
         JOptionPane.showMessageDialog(null, "Data Telah Tersimpan");
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, " Data tidak berhasil disimpan"); 
        }
         tampiltable();
          
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
   
    combopesanan.setSelectedIndex(0);
    txtjenis.setText("");
    txtharga.setText("");
    txtlama.setText("");
    txttotal.setText("");        

    }//GEN-LAST:event_btnclearActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
     koneksimysql();
      try {
            String sql = "DELETE FROM detail_transaksi WHERE ID_Transaksi = ?";
            PreparedStatement psht = con.prepareStatement(sql);

            int idTransaksi = Integer.parseInt((String) combopesanan.getSelectedItem());
            psht.setInt(1, idTransaksi);
            
            psht.executeUpdate();
       
         JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Data tidak berhasil dihapus");
        }
        tampiltable();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntransaksiActionPerformed
     this.setVisible(false);
    new Data_Pemesanan().setVisible(true);      
    }//GEN-LAST:event_btntransaksiActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
    koneksimysql();
    try {
    String sql = "UPDATE detail_transaksi SET ID_Transaksi = ?, Jenis_Pembayaran = ?, Harga_Sewa = ?, Lama_Sewa = ?, Total_Harga = ? WHERE ID_Transaksi = ?";
    PreparedStatement psht = con.prepareStatement(sql);

    // Get the selected ID_Transaksi value from combobox and parse it as integer
    int idTransaksi = Integer.parseInt((String) combopesanan.getSelectedItem());
    psht.setInt(1, idTransaksi);
    psht.setString(2, txtjenis.getText());
    psht.setDouble(3, Double.parseDouble(txtharga.getText()));
    psht.setString(4, txtlama.getText());
    psht.setString(5, txttotal.getText());
    psht.setInt(6, idTransaksi);

    psht.executeUpdate();
    JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Data tidak berhasil diupdate");
}

        tampiltable();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
    cari();        
    }//GEN-LAST:event_txtcariActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
    cari();    
    }//GEN-LAST:event_txtcariKeyReleased

    private void tbltransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltransaksiMouseClicked
     int tabel = tbltransaksi.getSelectedRow();
        String pemesanan = tbltransaksi.getValueAt(tabel, 0).toString();
        for (int i = 0; i<combopesanan.getItemCount();i++) {
            if (combopesanan.getItemAt(i).toString().equalsIgnoreCase(pemesanan)) {
                combopesanan.setSelectedIndex(i);
            }
        }    
         txtjenis.setText((String) tbltransaksi.getValueAt(tabel, 1));
         txtharga.setText((String) tbltransaksi.getValueAt(tabel, 2));
         txtlama.setText((String) tbltransaksi.getValueAt(tabel, 3));
         txttotal.setText((String) tbltransaksi.getValueAt(tabel, 4));
    }//GEN-LAST:event_tbltransaksiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    double totaljumlah = Double.parseDouble(txtharga.getText()) * Double.parseDouble(txtlama.getText());
        txttotal.setText(""+totaljumlah);       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        // TODO add your handling code here:
        try {
            File file = new File("src/report/struk.jrxml");
            Jasdes = JRXmlLoader.load(file);
            param.put("no", combopesanan.getSelectedItem());
            JasRep = JasperCompileManager.compileReport(Jasdes);
            JasPri = JasperFillManager.fillReport(JasRep, param,con);
            JasperViewer jasperviewer =  new JasperViewer(JasPri, false);
            jasperviewer.setExtendedState(jasperviewer.getExtendedState() | javax.swing.JFrame.MAXIMIZED_BOTH);
            jasperviewer.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btncetakActionPerformed

    private void txtlamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlamaActionPerformed
     String input1 = txtharga.getText();
    int value1 = Integer.parseInt(input1);
    
    // Mengambil nilai dari JTextField kedua
    String input2 = txtlama.getText();
    int value2 = Integer.parseInt(input2);
    
    // Melakukan perkalian
    int result = value1 * value2;
    
    txttotal.setText(Integer.toString(result));
    }//GEN-LAST:event_txtlamaActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    this.setVisible(false);
    new DataKamar().setVisible(true);  
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(Data_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btncetak;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntransaksi;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> combopesanan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbltransaksi;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjenis;
    private javax.swing.JTextField txtlama;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
