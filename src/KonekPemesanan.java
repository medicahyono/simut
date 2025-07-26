import java.sql.*;
import java.io.File;
import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class KonekPemesanan
{
   public void savePemesanan(Connection connection,String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,String a9,String a10,String a11, String a12,String a13)
   {
      try
      {
         String dbname="jdbc:odbc:SIMEDIAUMAT";
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
         Statement statement = con.createStatement();
         String sql="insert into Pemesanan values ('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+a11+"','"+a12+"','"+a13+"');";
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
         System.out.println(a9);
         System.out.println(a10);
         System.out.println(a11);
         System.out.println(a12);
         System.out.println(a13);
      }
   }

   public void updatePemesanan(Connection connection, String b1,String b2,String b3)
   {
         try
         {
            String dbname="jdbc:odbc:SIMEDIAUMAT";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
            Statement statement = con.createStatement();
            String sql="update Pemesanan set JumlahPemesanan='"+b2+"',TotalPemesanan='"+b3+"'where IdPemesanan='"+b1+"'";
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