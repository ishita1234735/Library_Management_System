import DB_Loader.DBLoader;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Add__Book extends javax.swing.JFrame {
      JLabel lb;
    public Add__Book() {
        initComponents();
        lb=new JLabel();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int h=(int)d.getHeight();
        int w=(int)d.getWidth();
        setSize(w,h);
        lb.setBounds(0, 0, w, h);
        ImageIcon ic=new ImageIcon("src\\myuploads3\\add2.jpg");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        tf5 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        yc1 = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("ADD BOOK");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(540, 80, 300, 70);

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Book ISBN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 190, 220, 30);

        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Book Title");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(380, 260, 170, 30);

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Author Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 330, 190, 30);

        jLabel5.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Publisher Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(380, 400, 230, 30);

        jLabel6.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Published Year");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(380, 470, 230, 30);

        jLabel7.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("Language");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(380, 530, 230, 30);

        tf1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        getContentPane().add(tf1);
        tf1.setBounds(770, 190, 350, 30);

        tf2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf2ActionPerformed(evt);
            }
        });
        getContentPane().add(tf2);
        tf2.setBounds(770, 260, 350, 30);

        tf3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        tf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf3ActionPerformed(evt);
            }
        });
        getContentPane().add(tf3);
        tf3.setBounds(770, 330, 350, 30);

        tf4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        getContentPane().add(tf4);
        tf4.setBounds(780, 400, 350, 30);

        tf5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        getContentPane().add(tf5);
        tf5.setBounds(790, 530, 360, 30);

        bt1.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        bt1.setText("SUBMIT");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(470, 600, 210, 100);

        bt2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        bt2.setText("CLEAR");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(810, 620, 150, 60);
        getContentPane().add(yc1);
        yc1.setBounds(790, 470, 60, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf2ActionPerformed
       
    }//GEN-LAST:event_tf2ActionPerformed

    private void tf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf3ActionPerformed

    }//GEN-LAST:event_tf3ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        String Book_ID= tf1.getText();
        String Book_Title= tf2.getText();
        String Author_Name= tf3.getText();
        String Publisher_Name= tf4.getText();
        String Published_Year=String.valueOf(yc1.getYear());
        String Language=tf5.getText();
        if ( Book_ID.isEmpty() || Book_Title.isEmpty() ||Author_Name.isEmpty() || 
        Publisher_Name.isEmpty() ||Published_Year.isEmpty() ||Language.isEmpty())
        {
        JOptionPane.showMessageDialog(this, "All fields are required!");
        return;
        }
        
        try {
            ResultSet rs = DBLoader.executeSQL("select * from add_book where Book_ID='" + Book_ID + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Book ID Already Exists");
            } else
             {
                rs.moveToInsertRow();
                rs.updateString ("Book_ID", Book_ID);
                rs.updateString("Book_Title", Book_Title);
                rs.updateString("Author_Name", Author_Name);
                rs.updateString("Publisher_Name", Publisher_Name);
                rs.updateString("Publisher_Year", Published_Year);
                rs.updateString("Language", Language);
                rs.insertRow();
                JOptionPane.showMessageDialog(this, "Book Added Successfully");
             
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
             tf1.setText("");
             tf2.setText("");
             tf3.setText("");
             tf4.setText("");
             tf5.setText("");
             yc1.setYear(2025);
    }//GEN-LAST:event_bt2ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add__Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private com.toedter.calendar.JYearChooser yc1;
    // End of variables declaration//GEN-END:variables
}
