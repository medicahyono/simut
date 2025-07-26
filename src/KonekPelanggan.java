import java.sql.*;
import java.io.File;
import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.design.*;
//import net.sf.jasperreports.engine.xml.*;
//import net.sf.jasperreports.view.JasperViewer;

public class KonekPelanggan
{
   public void savePelanggan(Connection connection,String a1,String a2,String a3,String a4,String a5)
   {
      try
      {
         String dbname="jdbc:odbc:SIMEDIAUMAT";
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
         Statement statement = con.createStatement();
         String sql="insert into Pelanggan values ('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"');";
         statement.executeUpdate(sql);
         statement.close();
         con.close();
      }
      catch (Exception e)
      {
         System.out.println("Erorr = "+e);
         System.out.println(a1);
         System.out.println(a2);
         System.out.println(a3);
         System.out.println(a4);
         System.out.println(a5);
      }
   }

   public void updatePelanggan(Connection connection, String b1,String b2,String b3,String b4,String b5)
   {
         try
         {
            String dbname="jdbc:odbc:SIMEDIAUMAT";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
            Statement statement = con.createStatement();
            String sql="update Pelanggan set NamaPelanggan='"+b2+"',AlamatPelanggan='"+b3+"',TeleponPelanggan='"+b4+"',JenisKelamin='"+b5+"'where IdPelanggan='"+b1+"'";
            statement.executeUpdate(sql);
            statement.close();
            con.close();
         }
         catch (Exception e)
         {
            System.out.println("Erorr = "+e);
         }
   }
}