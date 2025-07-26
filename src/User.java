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

public class User extends JFrame
{
   String id;
   String username;
   String password;
   String namalengkap;
   String alamat;
   String jeniskelamin;
   String foto;

   public static String ID;
   DefaultTableModel dtm=new DefaultTableModel();
   JTable table=new JTable(dtm);

   JLabel gambar1=new JLabel(new ImageIcon("image/CAMPUR (139).JPG"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   ImageIcon icon2=new ImageIcon("image/view.gif");

   JLabel lbid = new JLabel ("ID User");
   JLabel lbusername = new JLabel ("Username ");
   JLabel lbpassword = new JLabel ("Password");
   JLabel lbnamalengkap = new JLabel ("Nama User");
   JLabel lbalamat = new JLabel ("Alamat ");
   JLabel lbjeniskelamin = new JLabel ("Jenis Kelamin");
   JLabel lbfoto = new JLabel ("Foto");

   JTextField txid = new JTextField ("");
   JTextField txusername = new JTextField ("");
   JPasswordField txpassword= new JPasswordField();
   JTextField txnamalengkap = new JTextField ("");
   JTextField txalamat = new JTextField ("");
   JTextField txjeniskelamin = new JTextField ("");
   JTextField txfoto = new JTextField("");

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

   public User()
   {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setTitle("Form USER");
       setSize(420,520);
       int lebar = (screen.width-getSize().width) / 2;
       int tinggi = (screen.height-getSize().height) / 2;
       setLocation(lebar, tinggi);
       setResizable(false);
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


   public String setid()
   {
        id=txid.getText();
        return id;
   }
   public String setusername()
   {
        username= txusername.getText();
        return username;
   }
   public String setpassword()
   {
        password=txpassword.getText();
        return password;
   }
   public String setnamalengkap()
   {
        namalengkap=txnamalengkap.getText();
        return namalengkap;
   }
   public String setalamat()
   {
        alamat=txalamat.getText();
        return alamat;
   }
   public String setjeniskelamin()
   {
        jeniskelamin =txjeniskelamin.getText();
        return jeniskelamin;
   }
   public String setfoto()
   {
        foto= txfoto.getText();
        return foto;
   }

   void komponenVisual()
   {
        setIconImage(icon1.getImage());
        getContentPane().setLayout(null);

        getContentPane().add(lbid);
        lbid.setBounds(25,20,250,20);
        getContentPane().add(txid);
        txid.setBounds(137,20,158,20);
        txid.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbusername);
        lbusername.setBounds(25,50,250,20);
        getContentPane().add(txusername);
        txusername.setBounds(137,50,248,20);
        //txnama.setEditable(false);
        txusername.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbpassword);
        lbpassword.setBounds(25,80,250,20);
        getContentPane().add(txpassword);
        txpassword.setBounds(137,80,248,20);
        txpassword.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbnamalengkap);
        lbnamalengkap.setBounds(25,110,250,20);
        getContentPane().add(txnamalengkap);
        txnamalengkap.setBounds(137,110,248,20);
        txnamalengkap.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbalamat);
        lbalamat.setBounds(25,140,250,20);
        getContentPane().add(txalamat);
        txalamat.setDocument(new saring_karakter().getOnlyLetter());            // khusus untuk karakter aja
        txalamat.setBounds(137,140,248,20);
        txalamat.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbjeniskelamin);
        lbjeniskelamin.setBounds(25,170,250,20);
        getContentPane().add(txjeniskelamin);
        txjeniskelamin.setBounds(137,170,248,20);
        txjeniskelamin.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbfoto);
        lbfoto.setBounds(25,200,250,20);
        getContentPane().add(txfoto);
        txfoto.setBounds(137,200,248,20);
        txfoto.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(btdel);
        btdel.setBounds(137,230,100,30);

        getContentPane().add(btcari);
        btcari.setBounds(305,20,78,20);

        getContentPane().add(btsave);
        btsave.setBounds(25,430,60,30);

        getContentPane().add(btupdate);
        btupdate.setBounds(95,430,70,30);

        getContentPane().add(bthapus);
        bthapus.setBounds(175,430,60,30);

        getContentPane().add(btrefresh);
        btrefresh.setBounds(245,430,70,30);

        getContentPane().add(btview);
        btview.setBounds(325,430,60,30);

        JScrollPane scrollpane=new JScrollPane(table);
        getContentPane().add(scrollpane);
        scrollpane.setBounds(25,280,360,140);

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
                       String Kode=txid.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="SELECT * FROM tbuser WHERE id like '"+Kode+"'";
                       ResultSet rs =statement.executeQuery(sql);
                       if(rs.next())
                       {
                          //txid.setText(rs.getString(0));
                          txusername.setText(rs.getString(2));
                          txpassword.setText(rs.getString(3));
                          txnamalengkap.setText(rs.getString(4));
                          txalamat.setText(rs.getString(5));
                          txjeniskelamin.setText(rs.getString(6));
                          txfoto.setText(rs.getString(7));
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
              txid.requestFocus();
           }
        });
    /*    btdel.addActionListener(new ActionListener()
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
        });                                                       */

        txid.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txusername.requestFocus();
                }
            }
        });
        txusername.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txpassword.requestFocus();
                }
            }
        });
        txpassword.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txnamalengkap.requestFocus();
                }
            }
        });
        txnamalengkap.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txalamat.requestFocus();
                }
            }
        });
        txalamat.addKeyListener(new KeyAdapter()
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
                    txfoto.requestFocus();
                }
            }
        });

        txid.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    try
                    {
                       String cari=txid.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM tbUser WHERE id LIKE '"+cari+"'";

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][7];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          //data[p][2]=rs.getString(3);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          data[p][5]=rs.getString(6);
                          //
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID User","Username","Password","Nama","Alamat","Kel"});
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
        txfoto.addKeyListener(new KeyAdapter()
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
                  if(txusername.getText().equals("")||txpassword.getText().equals("")||txnamalengkap.getText().equals("")||txjeniskelamin.getText().equals("")||txalamat.getText().equals(""))
                  {
                       JOptionPane.showMessageDialog(null, "Maaf Anda Belum Melengkapi Data-data Yang Dibutuhkan");
                  }
                  else
                  {
                     //String hrtgl=txtgl.getText();
                     KonekUser k=new KonekUser();
                     k.saveUser(connection,setid(),setusername(),setpassword(),setnamalengkap(),setalamat(),setjeniskelamin(),setfoto());
                     JOptionPane.showMessageDialog(null, "Data Telah Masuk");
                     //txidpas.requestFocus();

                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM tbuser ";

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][6];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          data[p][5]=rs.getString(6);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID","Username","Pasword","Nama","Alamat","KET"});
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
                  KonekUser k=new KonekUser();
                  k.updateUser(connection,setid(),setusername(),setpassword(),setnamalengkap(),setalamat(),setjeniskelamin(),setfoto());
                  JOptionPane.showMessageDialog(null, "Data Telah Teredit");

                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM tbuser ";

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][6];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          data[p][5]=rs.getString(6);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID","Username","Pasword","Nama","Alamat","KET"});
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

        btdel.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
              {
                  KonekUser k=new KonekUser();
                  k.delUser(connection,setid(),setusername(),setpassword(),setnamalengkap(),setalamat(),setjeniskelamin(),setfoto());
                  JOptionPane.showMessageDialog(null, "Data Telah Terhapus");

                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM tbuser ";

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][6];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          data[p][5]=rs.getString(6);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID","Username","Pasword","Nama","Alamat","KET"});
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

               txid.setText("");
               txpassword.setText("");
               txusername.setText("");
               txnamalengkap.setText("");
               txjeniskelamin.setText("");
               txalamat.setText("");
               txfoto.setText("");
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
                       String sql="SELECT * FROM tbuser ";

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
                          data[p][2]=rs.getString(4);
                          data[p][3]=rs.getString(5);
                          data[p][4]=rs.getString(6);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"ID","Username","Nama","Alamat","KET"});
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

      // txalamat.setDocument(new saring_karakter().getOnlyLetter());
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
        User u=new User();
        u.komponenVisual();
        u.aksiReaksi();
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