import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
import java.io.File;
import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class Pelanggan extends JFrame
{
   String IdPelanggan;
   String NamaPelanggan;
   String AlamatPelanggan;
   String TeleponPelanggan;
   String JenisKelamin;

   public static String ID;
   DefaultTableModel dtm=new DefaultTableModel();
   JTable table=new JTable(dtm);

   JLabel gambar1=new JLabel(new ImageIcon("image/CAMPUR (139).JPG"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   ImageIcon icon2=new ImageIcon("image/view.gif");

   JLabel lbidpelanggan = new JLabel ("ID Pelanggan");
   JLabel lbnama = new JLabel ("Nama Pelanggan");
   JLabel lbalmt = new JLabel ("Alamat ");
   JLabel lbtelp = new JLabel ("Telepon");
   JLabel lbjeniskelamin = new JLabel ("Jenis Kelamin");

   JTextField txidpelanggan = new JTextField ("");
   JTextField txnama = new JTextField ("");
   JTextField txalmt = new JTextField ("");
   JTextField txtelp = new JTextField ("");
   JTextField txjeniskelamin = new JTextField ("");

   JButton btcari = new JButton ("Search");
   JButton btsave = new JButton ("Save");
   JButton btupdate = new JButton ("Update");
   JButton bthapus = new JButton ("Back");
   JButton btrefresh = new JButton ("Refresh");
   JButton btview = new JButton ("View");
   JButton btdel = new JButton ("Hapus");

   public Connection connection;
   public Statement statement;

   //KonekPengajuan k=new KonekPengajuan();

   public Pelanggan()
   {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setTitle("PENDAFTARAN PELANGGAN MED. UMAT");
       setSize(420,450);
       int lebar = (screen.width-getSize().width) / 2;
       int tinggi = (screen.height-getSize().height) / 2;
       setLocation(lebar, tinggi);
       setResizable(false);
       setAlwaysOnTop(false);
       //setUndecorated(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       try
       {
          String dbname="jdbc:odbc:SIMEDIAUMAT";
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          Connection connection = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
          System.out.println("Koneksi berhasil");
          connection.close();
       }
       catch (Exception e)
       {
          System.out.println("Error "+e);
       }
   }


   public String setIdPelanggan()
   {
        IdPelanggan=txidpelanggan.getText();
        return IdPelanggan;
   }
   public String setNamaPelanggan()
   {
        NamaPelanggan=txnama.getText();
        return NamaPelanggan;
   }
   public String setAlamatPelanggan()
   {
        AlamatPelanggan=txalmt.getText();
        return AlamatPelanggan;
   }
   public String setTeleponPelanggan()
   {
        TeleponPelanggan=txtelp.getText();
        return TeleponPelanggan;
   }
   public String setJenisKelamin()
   {
        JenisKelamin =txjeniskelamin.getText();
        return JenisKelamin;
   }

   void komponenVisual()
   {
        setIconImage(icon1.getImage());
        getContentPane().setLayout(null);

        getContentPane().add(lbidpelanggan);
        lbidpelanggan.setBounds(25,20,250,20);
        getContentPane().add(txidpelanggan);
        txidpelanggan.setBounds(137,20,158,20);
        txidpelanggan.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbnama);
        lbnama.setBounds(25,50,250,20);
        getContentPane().add(txnama);
        txnama.setBounds(137,50,248,20);
        //txnama.setEditable(false);
        txnama.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbalmt);
        lbalmt.setBounds(25,80,250,20);
        getContentPane().add(txalmt);
        txalmt.setBounds(137,80,248,20);
        txalmt.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbtelp);
        lbtelp.setBounds(25,110,250,20);
        getContentPane().add(txtelp);
        txtelp.setBounds(137,110,248,20);
        txtelp.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbjeniskelamin);
        lbjeniskelamin.setBounds(25,140,250,20);
        getContentPane().add(txjeniskelamin);
        txjeniskelamin.setBounds(137,140,248,20);
        txjeniskelamin.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(btdel);
        btdel.setBounds(137,170,100,30);

        getContentPane().add(btcari);
        btcari.setBounds(305,20,78,20);

        getContentPane().add(btsave);
        btsave.setBounds(25,360,60,30);

        getContentPane().add(btupdate);
        btupdate.setBounds(95,360,70,30);

        getContentPane().add(bthapus);
        bthapus.setBounds(175,360,60,30);

        getContentPane().add(btrefresh);
        btrefresh.setBounds(245,360,70,30);

        getContentPane().add(btview);
        btview.setBounds(325,360,60,30);

        JScrollPane scrollpane=new JScrollPane(table);
        getContentPane().add(scrollpane);
        scrollpane.setBounds(25,210,360,140);

        getContentPane().add(gambar1);
        gambar1.setBounds(0,0,500,500);

        setResizable(true);
        setVisible(true);
    }

    void aksiReaksi()
    {
        //tanggal.setText(hari[day]+", "+date+" "+bulan[month]+" "+year);
        //txtgl.setText(" "+hari[day]+", "+date+" "+bulan[month]+" "+year);

        btcari.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
                    {
                       String Kode=txidpelanggan.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="SELECT NamaPelanggan,AlamatPelanggan,TeleponPelanggan,JenisKelamin FROM Pelanggan WHERE IdPelanggan like '"+Kode+"'";
                       ResultSet rs =statement.executeQuery(sql);
                       if(rs.next())
                       {
                          txnama.setText(rs.getString(1));
                          txalmt.setText(rs.getString(2));
                          txtelp.setText(rs.getString(3));
                          txjeniskelamin.setText(rs.getString(4));
                       }
                       else
                       {
                          JOptionPane.showMessageDialog(null,"Maaf Data Tidak Ditemukan");
                       }

                       statement.close();
                       con.close();
                    }
                    catch(Exception ex)
                    {
                       System.out.println("Erorr "+ex);
                    }
              txidpelanggan.requestFocus();
           }
        });
        btdel.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
                {
                       String Kode=txidpelanggan.getText();
                       JOptionPane.showConfirmDialog(null,"Apakah Anda Benar benar Ingin menghapus Pelanggan tsb ?");
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="Delete FROM Pelanggan WHERE IdPelanggan like '"+Kode+"'";
                       ResultSet rs =statement.executeQuery(sql);
                       if(rs.next())
                       {
                          txnama.setText(rs.getString(1));
                          txalmt.setText(rs.getString(2));
                          txtelp.setText(rs.getString(3));
                          txjeniskelamin.setText(rs.getString(4));
                       }
                       else
                       {
                          JOptionPane.showMessageDialog(null,"Maaf Data Tidak Ditemukan");
                       }
                       statement.close();
                       con.close();
                    }
                    catch(Exception ex)
                    {
                       System.out.println("Erorr "+ex);
                    }

                    try
                    {
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM Pelanggan ";

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][5];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID","Nama","Alamat","Telepon","KET"});
                       table.setModel(dtm);
                       state.close();
                       con.close();
                    }
                    catch (Exception e)
                    {
                          System.out.println("Erorr = "+e);
                    }
                    txidpelanggan.setText("");
                    txnama.setText("");
                    txalmt.setText("");
                    txtelp.setText("");
                    txjeniskelamin.setText("");
           }
        });

        txidpelanggan.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txnama.requestFocus();
                }
            }
        });

        txidpelanggan.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    try
                    {
                       String cari=txidpelanggan.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM Pelanggan WHERE IdPelanggan LIKE '"+cari+"'";

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][5];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID Pelanggan","Nama Pelanggan","Alamat","Telepon","Jenis Kelamin"});
                       table.setModel(dtm);
                       state.close();
                       con.close();
                    }
                    catch(Exception DBExeption)
                    {
                       System.err.println("Error:"+DBExeption);
                    }
                }
                else
                {
                 //JOptionPane.showMessageDialog(null,"Data Tidak Ada");
                }
            }
        });
        txnama.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txalmt.requestFocus();
                }
            }
        });
        txalmt.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txtelp.requestFocus();
                }
            }
        });
        txtelp.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txjeniskelamin.requestFocus();
                }
            }
        });

        txjeniskelamin.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    btsave.requestFocus();
                }
            }
        });
        btsave.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
              {
                  if(txidpelanggan.getText().equals("")||txnama.getText().equals("")||txalmt.getText().equals("")||txtelp.getText().equals("")||txjeniskelamin.getText().equals(""))
                  {
                       JOptionPane.showMessageDialog(null, "Maaf Anda Belum Melengkapi Data-data Yang Dibutuhkan");
                  }
                  else
                  {
                     //String hrtgl=txtgl.getText();
                     KonekPelanggan k=new KonekPelanggan();
                     k.savePelanggan(connection,setIdPelanggan(),setNamaPelanggan(),setAlamatPelanggan(),setTeleponPelanggan(),setJenisKelamin());
                     JOptionPane.showMessageDialog(null, "Data Telah Masuk");
                     //txidpas.requestFocus();

                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM Pelanggan ";

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][5];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID","Nama","Alamat","Telepon","KET"});
                       table.setModel(dtm);
                       state.close();
                       con.close();
                  }
              }
              catch (Exception e)
              {
                  System.out.println("Erorr = "+e);
              }
           }
        });
        btupdate.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
              {
                  KonekPelanggan k=new KonekPelanggan();
                  k.updatePelanggan(connection,setIdPelanggan(),setNamaPelanggan(),setAlamatPelanggan(),setTeleponPelanggan(),setJenisKelamin());
                  JOptionPane.showMessageDialog(null, "Data Telah Teredit");

                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM Pelanggan ";

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][5];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID","Nama","Alamat","Telepon","KET"});
                       table.setModel(dtm);
                       state.close();
                       con.close();
              }
              catch (Exception e)
              {
                  System.out.println("Erorr = "+e);
              }
           }
        });
        btrefresh.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {

               txidpelanggan.setText("");
               txnama.setText("");
               txalmt.setText("");
               txtelp.setText("");
               txjeniskelamin.setText("");
            }
        });

       btview.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
             try
             {
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM Pelanggan ";

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][5];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID","Nama","Alamat","Telepon","KET"});
                       table.setModel(dtm);
                       state.close();
                       con.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Program di Komputer Anda belum terkoneksi dengan database ..!!\nHubungi Programmer ediuinmaliki@gmail.com",".:Warning:.",JOptionPane.WARNING_MESSAGE);
             }
          }
       });
       bthapus.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
              setVisible(false);
          }
       });
    }
    public static void main(String args[])
    {
        try
        {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception exc)
        {

        }
        Pelanggan pel=new Pelanggan();
        pel.komponenVisual();
        pel.aksiReaksi();
    }
   /* private DefaultTableModel createTable(ResultSet rs) throws SQLException
    {
      ResultSetMetaData rsmd=rs.getMetaData();
      int intNum=rsmd.getColumnCount();
      String[] str=new String[intNum];
      for (int i=0;i<intNum;i++)
      {
         str[i]=rsmd.getColumnName(i+1);
      }
      dtm.setColumnIdentifiers(str);
      while(rs.next())
      {
         String[] data=new String[intNum];
         for(int i=0;i<intNum;i++)
         {
             data[i]=rs.getString(i+1);
         }
         dtm.addRow(data);
      }
      return dtm;
    } */
}