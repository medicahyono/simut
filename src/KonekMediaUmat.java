import java.sql.*;
import java.io.File;
import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class KonekMediaUmat
{
   public void saveMediaUmat(Connection connection,String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8)
   {
      try
      {
         String dbname="jdbc:odbc:SIMEDIAUMAT";
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
         Statement statement = con.createStatement();
         String sql="insert into MediaUmat values ('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"');";
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
         System.out.println(a6);
         System.out.println(a7);
         System.out.println(a8);
      }
   }

   public void updateMediaUmat(Connection connection, String b1,String b2,String b3,String b4,String b5,String b6,String b7,String b8)
   {
         try
         {
            String dbname="jdbc:odbc:SIMEDIAUMAT";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
            Statement statement = con.createStatement();
            String sql="update MediaUmat set Judul='"+b2+"',TanggalTerbit='"+b3+"',TanggalMassaAkhir='"+b4+"',JumlahPesan='"+b5+"',PembayaranDistributor='"+b6+"',KasEdisi='"+b7+"',Harga='"+b8+"' where Edisi='"+b1+"'";
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