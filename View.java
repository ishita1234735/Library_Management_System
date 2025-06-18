import DB_Loader.DBLoader;
import java.sql.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

public class View extends javax.swing.JFrame {

     ArrayList<View_1> al;
     mytablemodel tm;
     JLabel lb;
    public View() {
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
        ImageIcon ic=new ImageIcon("src\\myuploads3\\add2.jpg");
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
        sp1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        bt1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 48)); // NOI18N
        jLabel1.setText("View All Books");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(630, 110, 430, 70);

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
        sp1.setViewportView(tb1);

        getContentPane().add(sp1);
        sp1.setBounds(390, 230, 870, 270);

        bt1.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        bt1.setText("View");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(720, 560, 190, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
               try
               {
                      al.clear();
                      ResultSet rs=DBLoader.executeSQL("select * from add_book");
                      while(rs.next())
                      {
                            int Book_ID=rs.getInt("Book_ID");
                            String Book_Title = rs.getString("Book_Title");
                            String Author_Name = rs.getString("Author_Name");
                            String Publisher_Name = rs.getString("Publisher_Name");
                            int Published_Year = rs.getInt("Publisher_Year");
                             String Language = rs.getString("Language");

                    View_1 ve = new View_1(Book_ID, Book_Title, Author_Name, Publisher_Name,Published_Year, Language);
                  al.add(ve);
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
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane sp1;
    private javax.swing.JTable tb1;
    // End of variables declaration//GEN-END:variables
}
