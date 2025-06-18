import java.sql.*;
import DB_Loader.DBLoader;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
public class Search extends javax.swing.JFrame {

     ArrayList<View_1> al;
       mytablemodel tm;
     JLabel lb;
    public Search() {
        lb=new JLabel();
        al=new ArrayList<>();
        tm=new mytablemodel();
        initComponents();
        tb1.setModel(tm);
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
    
 class mytablemodel extends AbstractTableModel
    { 
        @Override
        public int getRowCount() 
        {
            return al.size();
        }

        @Override
        public int getColumnCount() 
        {
              return 6;
        }

        @Override
        public String getColumnName(int j)
        {
               String col[]={"Book_ISBN","Book_Title", "Author_Name","Publisher_Name" ,"Published_Year","Language"};
               return col[j];
        }

        @Override
        public Object getValueAt(int i, int j) 
        {
            View_1 ve=al.get(i);
            if(j==0)
            {  return ve.Book_ID; }
            else if(j==1)
            {  return ve.Book_Title;}
             else if(j==2)
            {  return ve.Author_Name;}
             else if(j==3)
            {   return ve.Publisher_Name;  }
             else if(j==4)
            {  return ve.Published_Year;  }
             else 
            { return ve.Language;}
        }  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 48)); // NOI18N
        jLabel1.setText("Search Book");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 10, 356, 58);

        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(770, 100, 450, 40);

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel2.setText("Book Title");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 180, 160, 30);

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel3.setText("Author Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 250, 200, 30);
        getContentPane().add(tf2);
        tf2.setBounds(770, 180, 450, 40);

        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel4.setText("ISBN");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(250, 110, 130, 30);
        getContentPane().add(tf3);
        tf3.setBounds(770, 250, 460, 40);

        bt1.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        bt1.setText("Search");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(630, 630, 180, 70);

        tb1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(290, 330, 1000, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
              
    }//GEN-LAST:event_tf1ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
              String ISBN=tf1.getText();
              String Book_Title=tf2.getText();
              String Author_Name =tf3.getText();
                  ResultSet rs=null;
                  boolean found=false;
              try {
                       al.clear();
          
                      if (ISBN.equals("") && Book_Title.equals("") && Author_Name.equals("")) {
                    JOptionPane.showMessageDialog(this, "At least one search field is required");
                       return;  }
                      
                      
                     if(!ISBN.equals(""))
                     {
                             rs=DBLoader.executeSQL("select * from add_book where Book_ID ='"+ISBN+"'");
                     }
                      if(!Book_Title.equals(""))
                     {
                           rs=DBLoader.executeSQL("select * from add_book where Book_Title like'%"+Book_Title+"%'");
                     } 
                       if(!Author_Name.equals("")) 
                      {  rs=DBLoader.executeSQL("select * from add_book where Author_Name like'%" +Author_Name+"%'"); } 
                    
                      while(rs!=null && rs.next())
                      {
                            found=true;
                            int Book_ID=rs.getInt("Book_ID");
                             Book_Title = rs.getString("Book_Title");
                             Author_Name = rs.getString("Author_Name");
                            String Publisher_Name = rs.getString("Publisher_Name");
                            int Published_Year = rs.getInt("Publisher_Year");
                             String Language = rs.getString("Language");
                          
                    View_1 ve = new View_1(Book_ID, Book_Title, Author_Name, Publisher_Name,Published_Year, Language);
                  al.add(ve);
                     }
                      if(!found)
                      {
                           JOptionPane.showMessageDialog(this,"No Matching Book Found, Kindly Enter Correct Data");
                      }
                     
                  tm.fireTableDataChanged();
                   }
              catch(Exception e)
              {
                    e.printStackTrace();
              }
              
    }//GEN-LAST:event_bt1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    // End of variables declaration//GEN-END:variables
}
