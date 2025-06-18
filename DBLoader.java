package DB_Loader;
import java.sql.*;

public class DBLoader{

    public static ResultSet executeSQL(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loading Done");

            Connection conn
             = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library_management_system", "root", "system");
            System.out.println("Conection Done");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Done");

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Result Set Created");
            return rs;
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

}