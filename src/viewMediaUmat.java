import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class viewMediaUmat extends JFrame
{
   String [] headers={"Edisi","Judul ","Tanggal Terbit","Tanggal Berakhir","Jml Pesan","Jml Pembayaran ","Kas Edisi"};
   String[][] data;
   JTable tableView;
   int n;
   JButton cetak=new JButton("PRINT");

   viewMediaUmat()
   {
       super(" Laporan Media Umat");
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setSize(700,300);
       int lebar = (screen.width-getSize().width) / 2;
       int tinggi = (screen.height-getSize().height) / 2;
       setLocation(lebar, tinggi);
       setResizable(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }

   void komponenvisual()
   {
      tableView =new JTable(data,headers);
      JScrollPane scrollpane=new JScrollPane(tableView);
      scrollpane.setPreferredSize(new Dimension(800,100));
      getContentPane().setLayout(new BorderLayout());
      getContentPane().add(BorderLayout.CENTER,scrollpane);
      getContentPane().add(BorderLayout.SOUTH,cetak);
      pack();
      setVisible(true);
   }

   void koneksi()
   {
      try
      {
          String dbname="jdbc:odbc:SIMEDIAUMAT";
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
          Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
          //Statement statement = con.createStatement();
          String sql="SELECT * FROM MediaUmat";
          ResultSet rs=state.executeQuery(sql);

          rs.last();
          n=rs.getRow();
          data=new String[n][7];
          int m=0;
          rs.beforeFirst();

          while(rs.next())
          {
             data[m][0]=rs.getString(1);
             data[m][1]=rs.getString(2);
             data[m][2]=rs.getString(3);
             data[m][3]=rs.getString(4);
             data[m][4]=rs.getString(5);
             data[m][5]=rs.getString(6);
             data[m][6]=rs.getString(7);
             //data[m][7]=rs.getString(8);

             m++;
          }
          state.close();
          con.close();
      }
      catch(Exception DBExeption)
      {
         System.err.println("Error:"+DBExeption);
      }
   }

   public static void main (String args[])
   {
      try
      {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch(Exception exc)
      {

      }
      viewMediaUmat ts= new viewMediaUmat();
      ts.koneksi();
      ts.komponenvisual();
   }
}