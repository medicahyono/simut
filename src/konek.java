import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
*
* @author Rachmad
*/
public class konek {
public static void koneksiDatabase ()
{
   try
   {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   }
   catch (ClassNotFoundException cnf) {}

   try
   {
     con = DriverManager.getConnection("jdbc:odbc:SIMEDIAUMAT","simediaumat", "simediaumat");
     JOptionPane.showMessageDialog(null,"Koneksi Sukses");
   }
   catch (SQLException se)
   {
     System.out.println("Koneksi gagal : " + se);
     JOptionPane.showMessageDialog(null, "Koneksi GAGAL!!");
   }

   catch (Exception e) {}
   }
   public static Connection con;
}