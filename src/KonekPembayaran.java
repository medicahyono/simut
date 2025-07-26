import java.sql.*;
import java.io.File;
import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.xml.*;
import net.sf.jasperreports.view.JasperViewer;

public class KonekPembayaran
{
   public void savePembayaran(Connection connection,String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,String a9,String a10,String a11,String a12)
   {

   }

   public void updatePembayaran(Connection connection, String b1,String b2,String b3)
   {
         try
         {
            String dbname="jdbc:odbc:SIMEDIAUMAT";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
            Statement statement = con.createStatement();
            String sql="update Pemesanan set JmlBayar='"+b2+"',TglBayar='"+b3+"' where IdPemesanan='"+b1+"'";
            statement.executeUpdate(sql);
            statement.close();
            con.close();
         }
         catch (Exception e)
         {
            System.out.println("Erorr = "+e);
         }
   }

   public void cetakPembayaran()
   {
      try
      {
         //String file="C:/Users/FreiRangga/Documents/laporanpersonal.jasper";
         String file="pembayaran2.jasper";
         String file1="pembayaran2.jrxml";
         String dbname="jdbc:odbc:SIMEDIAUMAT";
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection conn = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");

         HashMap param=new HashMap();
         //Class.forName(driver);
         //Connection conn=DriverManager.getConnection(konek, user, pass);

         JasperDesign design=JRXmlLoader.load(file1);
         JasperReport jr=JasperCompileManager.compileReport(design);
         JasperPrint jp=JasperFillManager.fillReport(jr, param,conn);
         JasperViewer.viewReport(jp,false);
         JasperViewer.setDefaultLookAndFeelDecorated(true);

      }
      catch (Exception rt)
      {
         System.out.println(rt.getMessage());
      }
   }
}