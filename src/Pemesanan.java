import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;

public class Pemesanan extends JFrame
{
   String IdPemesanan;
   String Edisi;
   String Judul;
   String IdPelanggan;
   String NamaPelanggan;
   String AlamatPelanggan;
   String TeleponPelanggan;
   String JenisKelamin;
   String JumlahPemesanan;
   String TotalPemesanan;
   String TglBayar;
   String JmlBayar;
   String Harga;

   public Connection connection;
   JLabel gambar1=new JLabel(new ImageIcon("image/CAMPUR (139).JPG"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   ImageIcon icon2=new ImageIcon("image/view.gif");

   JLabel lbidpemesanan = new JLabel ("ID Pemesanan");
   JLabel lbedisi = new JLabel ("Edisi");
   JLabel lbjudul = new JLabel ("Judul");
   JLabel lbidpel = new JLabel ("ID Pelanggan");
   JLabel lbnama = new JLabel ("Nama Pelanggan");
   JLabel lbalamat = new JLabel ("Alamat ");
   JLabel lbtelepon= new JLabel ("Telepon");
   JLabel lbjk = new JLabel ("Jenis Kelamin");
   JLabel lbjmlpemesanan = new JLabel ("Jumlah Pemesanan");
   JLabel lbttlpemesanan = new JLabel ("Total Pemesanan");
   JLabel lbhrg= new JLabel("Harga per Exp.");

//   JLabel lbjmlkembali = new JLabel ("Jml Pengembalian");
//   JLabel lbstatus = new JLabel ("Status");

   JTextField txidpemesanan = new JTextField ("");
   JTextField txedisi = new JTextField ("");
   JTextField txjudul = new JTextField ("");
   JTextField txidpel = new JTextField ("");
   JTextField txnama = new JTextField ("");

   JTextField txalamat = new JTextField ("");
   JTextField txtelepon = new JTextField ("");
   JTextField txjk = new JTextField ("");

   JTextField txjmlpemesanan = new JTextField ("");
   JTextField txttlpemesanan = new JTextField ("");
   JTextField txtglbayar = new JTextField ("");
   JTextField txjmlbayar = new JTextField ("");
   JTextField txhrg= new JTextField("");
     /*Date kalender=new Date();
   int day=kalender.getDay();
   int date=kalender.getDate();
   int month=kalender.getMonth();
   int year=kalender.getYear()+1900;

   String hari[]={"Ahad", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu",};
   String bulan[]={"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
   JLabel tanggal=new JLabel ();            */

   JButton btcari = new JButton ("Search");
   JButton btsave = new JButton ("Save");
   JButton btupdate = new JButton ("Update");
   JButton btback = new JButton ("Back");
   JButton btrefresh = new JButton ("Refresh");
   JButton btview = new JButton ("View");
   JButton btdel = new JButton ("Hapus");
  // public Connection connection;
   //public Statement statement;

   //KonekPengajuan k=new KonekPengajuan();

   public Pemesanan()
   {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setTitle("Pemesanan Med. Umat");
       setSize(420,450);
       int lebar = (screen.width-getSize().width) / 2;
       int tinggi = (screen.height-getSize().height) / 2;
       setLocation(lebar, tinggi);
       setResizable(false);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       //setUndecorated(false);
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
   public String setIdPemesanan()
   {
        IdPemesanan=txidpemesanan.getText();
        System.out.println(IdPemesanan);
        return IdPemesanan;
   }
   public String setEdisi()
   {
        Edisi=txedisi.getText();
        System.out.println(Edisi);
        return Edisi;
   }
   public String setJudul()
   {
        Judul=txjudul.getText();
        System.out.println(Judul);
        return Judul;
   }
   public String setIdPelanggan()
   {
        IdPelanggan=txidpel.getText();
        System.out.println(IdPelanggan);
        return IdPelanggan;
   }
   public String setNamaPelanggan()
   {
        NamaPelanggan=txnama.getText();
        System.out.println(NamaPelanggan);
        return NamaPelanggan;
   }
   public String setAlamatPelanggan()
   {
        AlamatPelanggan=txalamat.getText();
        System.out.println(AlamatPelanggan);
        return AlamatPelanggan;
   }
   public String setTeleponPelanggan()
   {
        TeleponPelanggan=txtelepon.getText();
        System.out.println(TeleponPelanggan);
        return TeleponPelanggan;
   }
   public String setJenisKelamin()
   {
        JenisKelamin=txjk.getText();
        System.out.println(JenisKelamin);
        return JenisKelamin;
   }
   public String setJumlahPemesanan()
   {
        JumlahPemesanan=txjmlpemesanan.getText();
        System.out.println(JumlahPemesanan);
        return JumlahPemesanan;
   }
   public String setTotalPemesanan()
   {
        TotalPemesanan=txttlpemesanan.getText();
        System.out.println(TotalPemesanan);
        return TotalPemesanan;
   }

   public String setTglBayar()
   {
        TglBayar=txtglbayar.getText();
        System.out.println(TglBayar);
        return TglBayar;
   }
   public String setJmlBayar()
   {
        JmlBayar=txjmlbayar.getText();
        System.out.println(JmlBayar);
        return JmlBayar;
   }
   public String setHarga()
   {
        Harga=txhrg.getText();
        System.out.println(Harga);
        return Harga;
   }

   void komponenVisual()
   {
        setIconImage(icon1.getImage());
        getContentPane().setLayout(null);

        getContentPane().add(lbidpemesanan);
        lbidpemesanan.setBounds(25,20,250,20);
        getContentPane().add(txidpemesanan);
        txidpemesanan.setBounds(137,20,160,20);
        //txidpemesanan.setEditable(false);
        txidpemesanan.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbedisi);
        lbedisi.setBounds(25,50,250,20);
        getContentPane().add(txedisi);
        txedisi.setBounds(137,50,250,20);
        txedisi.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbjudul);
        lbjudul.setBounds(25,80,250,20);
        getContentPane().add(txjudul);
        txjudul.setBounds(137,80,250,20);
        txjudul.setEditable(false);
        txjudul.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbidpel);
        lbidpel.setBounds(25,110,250,20);
        getContentPane().add(txidpel);
        txidpel.setBounds(137,110,250,20);
        //txidpel.setEditable(false);
        txidpel.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbnama);
        lbnama.setBounds(25,140,250,20);
        getContentPane().add(txnama);
        txnama.setBounds(137,140,250,20);
        txnama.setEditable(false);
        txnama.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbalamat);
        lbalamat.setBounds(25,170,250,20);
        getContentPane().add(txalamat);
        txalamat.setBounds(137,170,250,20);
        txalamat.setEditable(false);
        txalamat.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbtelepon);
        lbtelepon.setBounds(25,200,250,20);
        getContentPane().add(txtelepon);
        txtelepon.setBounds(137,200,250,20);
        txtelepon.setEditable(false);
        txtelepon.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbjk);
        lbjk.setBounds(25,230,250,20);
        getContentPane().add(txjk);
        txjk.setBounds(137,230,250,20);
        txjk.setEditable(false);
        txjk.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbjmlpemesanan);
        lbjmlpemesanan.setBounds(25,260,250,20);
        getContentPane().add(txjmlpemesanan);
        txjmlpemesanan.setBounds(137,260,50,20);
        txjmlpemesanan.setBorder(BorderFactory.createEtchedBorder(1));

        // Harga
        getContentPane().add(lbhrg);
        lbhrg.setBounds(220,260,100,20);
        getContentPane().add(txhrg);
        txhrg.setBounds(308,260,80,20);
        txhrg.setBorder(BorderFactory.createEtchedBorder(1));
        txhrg.setEditable(false);

        getContentPane().add(lbttlpemesanan);
        lbttlpemesanan.setBounds(25,290,250,20);
        getContentPane().add(txttlpemesanan);
        txttlpemesanan.setBounds(137,290,250,20);

        getContentPane().add(txtglbayar);
        txtglbayar.setBounds(0,0,0,0);
        getContentPane().add(txjmlbayar);
        txjmlbayar.setBounds(0,0,0,0);

        txttlpemesanan.setEditable(false);
        txttlpemesanan.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(btcari);
        btcari.setBounds(305,20,80,20);
        getContentPane().add(btdel);
        btdel.setBounds(138,320,100,30);

        getContentPane().add(btsave);
        btsave.setBounds(25,365,60,30);

        getContentPane().add(btupdate);
        btupdate.setBounds(95,365,70,30);

        getContentPane().add(btback);
        btback.setBounds(175,365,60,30);

        getContentPane().add(btrefresh);
        btrefresh.setBounds(245,365,70,30);
        getContentPane().add(btview);
        btview.setBounds(325,365,60,30);
        getContentPane().add(gambar1);
        gambar1.setBounds(0,0,500,500);
        setResizable(false);
        setVisible(true);
    }

    void aksiReaksi()
    {
        btcari.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
                    {
                       String Kode=txidpemesanan.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="SELECT IdPemesanan,Edisi,Judul,IdPelanggan,NamaPelanggan,AlamatPelanggan,TeleponPelanggan,JenisKelamin,JumlahPemesanan,TotalPemesanan,Harga FROM Pemesanan WHERE IdPemesanan like '"+Kode+"'";
                       ResultSet rs=statement.executeQuery(sql);
                       if(rs.next())
                       {
                          txidpemesanan.setText(rs.getString(1));
                          txedisi.setText(rs.getString(2));
                          txjudul.setText(rs.getString(3));
                          txidpel.setText(rs.getString(4));
                          txnama.setText(rs.getString(5));
                          txalamat.setText(rs.getString(6));
                          txtelepon.setText(rs.getString(7));
                          txjk.setText(rs.getString(8));
                          txjmlpemesanan.setText(rs.getString(9));
                          txttlpemesanan.setText(rs.getString(10));
                          txhrg.setText(rs.getString(11));
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
               txidpemesanan.requestFocus();
           }
        });
        txidpemesanan.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
               if(event.getKeyCode()==event.VK_ENTER)
               {
                   txedisi.requestFocus();
               }
            }
        });
        txedisi.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    try
                    {
                       String Kode=txedisi.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="SELECT judul,Harga FROM MediaUmat WHERE Edisi like '"+Kode+"'";
                       ResultSet rs=statement.executeQuery(sql);
                       if(rs.next())
                       {
                          txjudul.setText(rs.getString(1));
                          txhrg.setText(rs.getString(2));
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
                    txidpel.requestFocus();
                }
            }
        });

        txidpel.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    try
                    {
                       String Kode=txidpel.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="SELECT NamaPelanggan,AlamatPelanggan,TeleponPelanggan,JenisKelamin FROM Pelanggan WHERE IdPelanggan like '"+Kode+"'";
                       ResultSet rs=statement.executeQuery(sql);
                       if(rs.next())
                       {
                          txnama.setText(rs.getString(1));
                          txalamat.setText(rs.getString(2));
                          txtelepon.setText(rs.getString(3));
                          txjk.setText(rs.getString(4));
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
                    txjmlpemesanan.requestFocus();
                }
            } //

        });

        txjmlpemesanan.addKeyListener(new KeyAdapter()
        {
           public void keyPressed(KeyEvent event)
           {
             if(event.getKeyCode()==event.VK_ENTER)
               {
                 String hrgmediaumat=txhrg.getText();
                 int hrgmediaumat2= Integer.parseInt(hrgmediaumat);

                 String jumlah1=txjmlpemesanan.getText();
                 int njumlah1=Integer.parseInt(jumlah1);

                 int hrgtotalpesan=(njumlah1*hrgmediaumat2);
                 String nttlpemesanan=String.valueOf(hrgtotalpesan);
                 txttlpemesanan.setText(nttlpemesanan);
                 btsave.requestFocus();
                 // TODO add your handling code here:
               }
           }
        });

        btsave.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
              {
                  //if(txidpemesanan.getText().equals("")||txedisi.getText().equals("")||txjudul.getText().equals("")||txidpel.getText().equals("")||txnama.getText().equals("")||txalamat.getText().equals("")||txtelepon.getText().equals("")||txjk.getText().equals("")||txjmlpemesanan.getText().equals("")||txttlpemesanan.getText().equals(""))
                  if(txidpemesanan.getText().equals("")||txedisi.getText().equals("")||txidpel.getText().equals("")||txjmlpemesanan.getText().equals("")||txttlpemesanan.getText().equals(""))
                  {
                       JOptionPane.showMessageDialog(null, "Maaf Anda Belum Melengkapi Data-data Yang Dibutuhkan");
                  }
                  else
                  {
                       KonekPemesanan kp= new KonekPemesanan();
                       kp.savePemesanan(connection,setIdPemesanan(),setEdisi(),setJudul(),setIdPelanggan(),setNamaPelanggan(),setAlamatPelanggan(),setTeleponPelanggan(),setJenisKelamin(),setJumlahPemesanan(),setTotalPemesanan(),setTglBayar(),setJmlBayar(),setHarga());
                       JOptionPane.showMessageDialog(null, "Data Telah Masuk");
                     //txidpas.requestFocus();
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
                  KonekPemesanan k=new KonekPemesanan();
                  k.updatePemesanan(connection,setIdPemesanan(),setJumlahPemesanan(),setTotalPemesanan());
                  JOptionPane.showMessageDialog(null, "Data Telah Teredit");
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

               txidpemesanan.setText("");
               txedisi.setText("");
               txjudul.setText("");
               txidpel.setText("");
               txnama.setText("");
               txalamat.setText("");
               txtelepon.setText("");
               txjk.setText("");
               txjmlpemesanan.setText("");
               txttlpemesanan.setText("");
               //txstatus.setText("");
            }
        });
        btdel.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
                {
                       String Kode=txidpemesanan.getText();
                       //JOptionPane.showConfirmDialog(null,"Apakah Anda Benar benar Ingin menghapus Pelanggan tsb ?");
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="Delete FROM pemesanan WHERE idpemesanan like '"+Kode+"'";
                       ResultSet rs =statement.executeQuery(sql);
                       statement.close();
                       con.close();
                    }
                    catch(Exception ex)
                    {
                       System.out.println("Erorr "+ex);
                    }
                    txidpemesanan.setText("");
                    txedisi.setText("");
                    txjudul.setText("");
                    txidpel.setText("");
                    txnama.setText("");
                    txalamat.setText("");
                    txtelepon.setText("");
                    txjk.setText("");
                    txjmlpemesanan.setText("");
                    txttlpemesanan.setText("");
                    JOptionPane.showMessageDialog(null,"Data telah Terhapus !");
           }
        });

        btback.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            setVisible(false);
            //zbr.KomponenVisual();
            //zbr.AksiReaksi();
            //dispose ();
          }
        });

       btview.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
             try
             {
                 viewPemesanan tp=new viewPemesanan();
                 tp.koneksi();
                 tp.komponenvisual();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Program di Komputer Anda belum terkoneksi dengan database ..!!\nHubungi Programmer ediuinmaliki@gmail.com",".:Warning:.",JOptionPane.WARNING_MESSAGE);
             }
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
        Pemesanan pem =new Pemesanan();
        pem.komponenVisual();
        pem.aksiReaksi();
    }
}