/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domainModels.KhachHang;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.KhachHangService;
import services.impl.IManageKhachHangService;
import viewModel.ViewModelKhachHang;

/**
 *
 * @author Admin
 */
public class TTKHView extends javax.swing.JFrame {

    private DefaultTableModel model;
    private IManageKhachHangService khrp = new KhachHangService();

    /**
     * Creates new form GetKHView
     */
    public TTKHView() {
        initComponents();
        loadtb();
        loadthgdautien();
    }

    public void loadtb() {
        model = (DefaultTableModel) tbbang.getModel();
        model.setRowCount(0);
        List<ViewModelKhachHang> kh = khrp.getListKhachHang();
        for (ViewModelKhachHang x : kh) {
            model.addRow(new Object[]{
                x.getID(), x.getMa(), x.getTenkh(), x.getSdt(), x.getDiachi()
            });
        }

    }

    public void loadthgdautien() {
        int index = 0;
        txtid.setText(tbbang.getValueAt(index, 0).toString());
        txtma.setText(tbbang.getValueAt(index, 1).toString());
        txtten.setText(tbbang.getValueAt(index, 2).toString());
        txtsdt.setText(tbbang.getValueAt(index, 3).toString());
        txtdiachi.setText(tbbang.getValueAt(index, 4).toString());
    }
    public boolean checksdt() { //check sdt khachhang
        String sdt = txtsdt.getText();
        List<ViewModelKhachHang> kh = khrp.getListKhachHang();
        for (ViewModelKhachHang v : kh) {
            if (sdt.equals(v.getSdt())) {
                JOptionPane.showMessageDialog(this, "so dien thoai đã tồn tại!");
                return false;
            }
        }
        return true;
    }
    public boolean valydatefrom() {
        try {
            if (txtten.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không được để trống");
                return false;
            }
            if (txtsdt.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không được để trống");
                return false;
            }
            if (txtdiachi.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không được để trống");
                return false;
            }
            try {
                if (txtten.getText().length() > 11) {
                    JOptionPane.showMessageDialog(this, "tên khách hàng không được để quá 10 ký tự");
                    return false;
                }
            } catch (HeadlessException headlessException) {
                return false;
            }

            try {
                if (txtsdt.getText().length() > 11) {
                    JOptionPane.showMessageDialog(this, "sdt < 11");
                    return false;
                }
            } catch (HeadlessException headlessException) {
                return false;
            }
            try {
                if (txtdiachi.getText().length() > 30) {
                    JOptionPane.showMessageDialog(this, "địa chỉ k đc 30 ký tự");
                    return false;
                }
            } catch (HeadlessException headlessException) {
                return false;
            }

            if (!txtten.getText().matches("^[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Tên chỉ chữ ");
                return false;
            }
            if (!txtsdt.getText().matches("0[1-9]{1}[0-9 ]{8}")) {
                JOptionPane.showMessageDialog(this, "số điện thoại số nguyên vàđúng form 0(1-9)xxxxxxxx");
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }
     public void getNameKhachHang(String ten) {
        model = (DefaultTableModel) tbbang.getModel();
        model.setRowCount(0);
        List<ViewModelKhachHang> kh = khrp.getListKhachHangByName(ten);
        for (ViewModelKhachHang x : kh) {
            model.addRow(new Object[]{
                x.getID(), x.getMa(), x.getTenkh(), x.getSdt(), x.getDiachi()
            });
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbang = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txttimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/timkiemicon.png"))); // NOI18N
        jButton1.setText("chọn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "MA", "TEN", "SDT", "DiaChi"
            }
        ));
        tbbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbang);

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/timkiemicon.png"))); // NOI18N
        jButton2.setText("Tạo Nhanh Khách Hàng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtid.setBackground(new java.awt.Color(255, 153, 153));
        txtid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 153)));

        txtma.setBackground(new java.awt.Color(255, 153, 153));
        txtma.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 153)));

        txtten.setBackground(new java.awt.Color(255, 153, 153));
        txtten.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 153)));

        txtsdt.setBackground(new java.awt.Color(255, 153, 153));
        txtsdt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 153)));

        txtdiachi.setBackground(new java.awt.Color(255, 153, 153));
        txtdiachi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 153)));

        jLabel1.setText("Ma");

        jLabel2.setText("Id");

        jLabel3.setText("Ten");

        jLabel4.setText("sdt");

        jLabel5.setText("DiaChi");

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/timkiemicon.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txttimKiem.setBackground(new java.awt.Color(255, 153, 204));
        txttimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "TIM KIEM"));
        txttimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(125, 125, 125))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                                .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(306, 306, 306))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(698, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txttimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2)
                    .addContainerGap(604, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        BanHangView.TTKHView("an", "01111231", "hanoi");
            int index = tbbang.getSelectedRow();
      
            BanHangView.TTKHView(tbbang.getValueAt(index,0).toString(), tbbang.getValueAt(index, 2).toString(),tbbang.getValueAt(index, 3).toString());
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         KhachHang kh = new KhachHang();
        kh.setTenKhachHang(txtten.getText());
        kh.setSdt(txtsdt.getText());
        kh.setDiaChi(txtdiachi.getText());
        if (checksdt() && valydatefrom() == true) {
            boolean b = khrp.add(kh);
            if (b == true) {

                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/img/themmoiicon.png"));
                JOptionPane.showMessageDialog(this, "Thêm thành công", "Sản Phẩm", JOptionPane.INFORMATION_MESSAGE, icon);
                loadtb();

            } else {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/img/deleteicon.png"));
                JOptionPane.showMessageDialog(this, "Thêm ko thành công!", "Sản Phẩm", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        } else {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbangMouseClicked

        int index = tbbang.getSelectedRow();
        txtid.setText(tbbang.getValueAt(index, 0).toString());
        txtma.setText(tbbang.getValueAt(index, 1).toString());
        txtten.setText(tbbang.getValueAt(index, 2).toString());
        txtsdt.setText(tbbang.getValueAt(index, 3).toString());
        txtdiachi.setText(tbbang.getValueAt(index, 4).toString());
    }//GEN-LAST:event_tbbangMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        BanHangView v = new BanHangView("", "", "");
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txttimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimKiemKeyReleased
        if (txttimKiem.getText().equals("")) {
            loadtb();
        } else {
            getNameKhachHang(txttimKiem.getText());
        }
    }//GEN-LAST:event_txttimKiemKeyReleased

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
            java.util.logging.Logger.getLogger(TTKHView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TTKHView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TTKHView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TTKHView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TTKHView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbbang;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txttimKiem;
    // End of variables declaration//GEN-END:variables
}
