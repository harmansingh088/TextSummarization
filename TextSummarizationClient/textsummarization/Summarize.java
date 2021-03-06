/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textsummarization;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static textsummarization.LoginPage.skt;

/**
 *
 * @author dell1
 */
public class Summarize extends javax.swing.JPanel {

    /**
     * Creates new form Summarize
     */
    public Summarize() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFileName = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEnterText = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();

        jLabel1.setText("Select File");

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        jLabel3.setText("Enter Your Text");

        txtEnterText.setColumns(20);
        txtEnterText.setRows(5);
        jScrollPane1.setViewportView(txtEnterText);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlLayout.createSequentialGroup()
                            .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBrowse))
                        .addComponent(jScrollPane1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed

        JFileChooser jfc = new JFileChooser("E:\\machine learning");
        jfc.showDialog(null, "choose");
        txtFileName.setText(String.valueOf(jfc.getSelectedFile()));
        txtEnterText.setEnabled(false);

// TODO add your handling code here:
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        
        if (txtFileName.getText().isEmpty() && txtEnterText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select one of the above!", "Empty Field", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtEnterText.getText().isEmpty()) {
            DataOutputStream dos = null;

            DataInputStream dis = null;
            FileOutputStream fos = null;
            try {

                dos = new DataOutputStream(skt.getOutputStream());

                File f = new File(txtFileName.getText());
                long size = f.length();
                dos.writeLong(size);

                FileInputStream fis = new FileInputStream(txtFileName.getText());
                byte b[] = new byte[4096];
                int c;
                while ((c = fis.read(b)) != -1) {
                    dos.write(b, 0, c);
                }
                System.out.println("Data Sent Successfully");

                dis = new DataInputStream(skt.getInputStream());

                fos = new FileOutputStream("AfterSummary.txt");
                byte[] b1 = new byte[1024];
                int d;
                while ((d = dis.read(b1)) != -1) {

                    fos.write(b1, 0, d);
                }
                System.out.println("before");
                fos.close();
                System.out.println("after");
                JOptionPane.showMessageDialog(null, "Your file has been summarized");

            } catch (Exception e) {
                System.out.println("Exception in Submit:" + e);
            } finally {
                try {
                    dis.close();

                    dos.close();

                } catch (Exception e) {
                    System.out.println("Exception in finally of submit" + e);
                }

            }
        }
        else if(txtFileName.getText().isEmpty())
        {
            String str=txtEnterText.getText();     
            DataOutputStream dos = null;

            DataInputStream dis = null;
            FileOutputStream fos = null;
            try {
                
                
                PrintStream ps=new PrintStream("dummy.txt");
                ps.print(str);
                
                ps.close();
                 

                dos = new DataOutputStream(skt.getOutputStream());

                File f = new File("dummy.txt");
                long size = f.length();
                dos.writeLong(size);
                
                

                FileInputStream fis = new FileInputStream("dummy.txt");
                byte b[] = new byte[4096];
                int c;
                while ((c = fis.read(b)) != -1) {
                    dos.write(b, 0, c);
                }
                System.out.println("Data Sent Successfully");

                dis = new DataInputStream(skt.getInputStream());

                fos = new FileOutputStream("AfterSummary.txt");
                byte[] b1 = new byte[1024];
                int d;
                while ((d = dis.read(b1)) != -1) {

                    fos.write(b1, 0, d);
                }
                System.out.println("before");
                fos.close();
                System.out.println("after");

            } catch (Exception e) {
                System.out.println("Exception in Submit:" + e);
            } finally {
                try {
                    dis.close();

                    dos.close();

                } catch (Exception e) {
                    System.out.println("Exception in finally of submit" + e);
                }

            }
            
            
           
        }
        else
        {
          JOptionPane.showMessageDialog(this, "Please select only one of the above!", "Empty Field", JOptionPane.INFORMATION_MESSAGE);  
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl;
    private javax.swing.JTextArea txtEnterText;
    private javax.swing.JTextField txtFileName;
    // End of variables declaration//GEN-END:variables
}
