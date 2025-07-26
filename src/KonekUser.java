import java.sql.*;
import java.io.File;
import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class KonekUser
{
   public void saveUser(Connection connection,String a1,String a2,String a3,String a4,String a5,String a6,String a7)
   {
      try
      {
         String dbname="jdbc:odbc:SIMEDIAUMAT";
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
         Statement statement = con.createStatement();
         String sql="insert into tbuser values ('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"');";
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
      }
   }

   public void updateUser(Connection connection, String b1,String b2,String b3,String b4,String b5,String b6, String b7)
   {
         try
         {
            String dbname="jdbc:odbc:SIMEDIAUMAT";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
            Statement statement = con.createStatement();
            String sql="update tbUser set username='"+b2+"',password='"+b3+"',namalengkap='"+b4+"',alamat='"+b5+"',jeniskelamin='"+b6+"',foto='"+b7+"'where id='"+b1+"'";
            statement.executeUpdate(sql);
            statement.close();
            con.close();
         }
         catch (Exception e)
         {
            System.out.println("Erorr = "+e);
         }
   }

   public void delUser(Connection connection, String c1, String c2,String c3,String c4,String c5, String c6,String c7)
   {
          try
          {
            String dbname="jdbc:odbc:SIMEDIAUMAT";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
            Statement statement = con.createStatement();
            //String sql="delete tbUser username='"+c2+"',password='"+c3+"',namalengkap='"+c4+"',alamat='"+c5+"',jeniskelamin='"+c6+"',foto='"+c7+"'where id='"+c1+"'";
            String sql="delete from tbUser where id='"+c1+"'";
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