import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import DB_Loader.DBLoader;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Return extends javax.swing.JFrame {

     JLabel lb;
     public Return() {
        lb=new JLabel();
        initComponents();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int h=(int)d.getHeight();
        int w=(int)d.getWidth();
        setSize(w,h);
        lb.setBounds(0, 0, w, h);
        ImageIcon ic=new ImageIcon("src\\myuploads3\\book3.jpg");
        Image img=ic.getImage().getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon icl=new ImageIcon(img);
        lb.setIcon(icl);
        add(lb);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 48)); // NOI18N
        jLabel1.setText("Return Book");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(390, 20, 380, 70);

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel2.setText("ISBN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 190, 130, 30);

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel3.setText("Student ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 290, 160, 30);
        getContentPane().add(tf1);
        tf1.setBounds(660, 170, 350, 40);
        getContentPane().add(tf2);
        tf2.setBounds(660, 280, 350, 40);

        jButton1.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 440, 210, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
            String ISBN=tf1.getText();
            String Student_ID=tf2.getText();
              if(ISBN.isEmpty() || Student_ID.isBlank())
                {
                      JOptionPane.showMessageDialog(this,"Both the Fields are required");
                }
             
         try
         {     ResultSet rs = DBLoader.executeSQL("SELECT * FROM issue_book "+ "WHERE Book_ID = '" + ISBN + "' AND Return_Date IS  NULL");
          if(rs.next())
          {
                rs.updateString("Return_Date", LocalDate.now().toString());
                rs.updateRow();
                JOptionPane.showMessageDialog(this, "Book returned Successfulluy");
          }
           
         else
          {
                    JOptionPane.showMessageDialog(this,"This book is not currently issued");
          }
         }
         catch(Exception e)
         {
              e.printStackTrace();
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    // End of variables declaration//GEN-END:variables
}
