import DB_Loader.DBLoader;
import java.sql.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Issue extends javax.swing.JFrame {

     JLabel lb;
   public Issue() {
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
        tf1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 48)); // NOI18N
        jLabel1.setText("Issue Book");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 20, 320, 70);

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel2.setText("Book ISBN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 180, 150, 30);
        getContentPane().add(tf1);
        tf1.setBounds(690, 170, 400, 40);

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel3.setText("Student ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(330, 300, 170, 30);
        getContentPane().add(tf2);
        tf2.setBounds(690, 290, 400, 40);

        bt1.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        bt1.setText("Issue");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(500, 450, 220, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
                String ISBN = tf1.getText();
                String Student_ID = tf2.getText();
                if(ISBN.isEmpty() || Student_ID.isBlank())
                {
                      JOptionPane.showMessageDialog(this,"Both the Fields are required");
                }
          
         try
         {     ResultSet rs = DBLoader.executeSQL("SELECT * FROM issue_book "+ "WHERE Book_ID = '" + ISBN + "' AND Return_Date IS  NULL");
          if(rs.next())
          {
                JOptionPane.showMessageDialog(this, "Book Already Issued");
          }
           
         else
          {
                String Issue_Date = LocalDate.now().toString();
               
                rs.moveToInsertRow();
                rs.updateString ("Book_ID", ISBN);
                rs.updateString("Student_ID", Student_ID);
                rs.updateString("Issue_Date", Issue_Date);
                
                rs.insertRow();
                JOptionPane.showMessageDialog(this, "Book Issued Successfully");
           }
         
     }
    catch(Exception e)
    {
         e.printStackTrace();
    }     
    }//GEN-LAST:event_bt1ActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    // End of variables declaration//GEN-END:variables
}
