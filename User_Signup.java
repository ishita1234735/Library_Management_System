import DB_Loader.DBLoader;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class User_Signup extends javax.swing.JFrame {

    JLabel lb;
    public User_Signup()
    {
        lb=new JLabel();
        initComponents();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int h=(int)d.getHeight();
        int w=(int)d.getWidth();
        setSize(w,h);
        lb.setBounds(0, 0, w, h);
        ImageIcon ic=new ImageIcon("src\\myuploads3\\login10.jpg");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 48)); // NOI18N
        jLabel1.setText("User Signup");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 10, 340, 60);

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel2.setText("UserName");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 120, 140, 30);

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel3.setText("UserEmail");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(270, 200, 140, 30);
        getContentPane().add(tf1);
        tf1.setBounds(710, 110, 390, 30);
        getContentPane().add(tf2);
        tf2.setBounds(710, 190, 390, 30);

        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 280, 140, 30);

        jLabel5.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel5.setText("Contact No");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(260, 360, 180, 30);
        getContentPane().add(tf3);
        tf3.setBounds(710, 270, 390, 30);
        getContentPane().add(tf4);
        tf4.setBounds(710, 360, 390, 30);

        jButton1.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jButton1.setText("Signup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(410, 500, 230, 90);

        jLabel6.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel6.setText("Already have an Account?");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(660, 530, 280, 30);

        jButton2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(960, 520, 130, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String Name = tf1.getText();
         String email = tf2.getText();
         String Password = tf3.getText();
         String Contact_no = tf4.getText();
        try {
            ResultSet rs = DBLoader.executeSQL("select * from user_table where email='" + email + "'");
            if (rs.next())
            {
                JOptionPane.showMessageDialog(this, "User Already Exist...Kindly Select Different email address");
            } else
             {
                rs.moveToInsertRow();
                rs.updateString("name", Name);
                rs.updateString("email", email);
                rs.updateString("password", Password);
                rs.updateString("contact_no", Contact_no);
                rs.insertRow();
                JOptionPane.showMessageDialog(this, "Your Account has been created");
                Login ul =new Login();
             }    
         }
         catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
               Login ul =new Login();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    // End of variables declaration//GEN-END:variables
}
