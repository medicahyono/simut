import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
import java.io.File;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.text.NumberFormat;
import java.sql.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;
public class MediaUmat extends JFrame
{
   String Edisi;
   String Judul;
   String TanggalTerbit;
   String TanggalMassaAkhir;
   String JumlahPesan;
   String PembayaranDistributor;
   String KasEdisi;
   String Harga;

   JLabel gambar1=new JLabel(new ImageIcon("image/CAMPUR (139).JPG"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   ImageIcon icon2=new ImageIcon("image/view.gif");

   JLabel lbedisi = new JLabel ("Edisi");
   JLabel lbjudul= new JLabel ("Judul");
   JLabel lbtglterbit = new JLabel ("Tanggal Terbit ");
   JLabel lbtglakhir = new JLabel ("Massa Akhir");
   JLabel lbjmlpesan= new JLabel ("Jumlah Pesan");
   JLabel lbpembayran = new JLabel ("Pembayaran ");
   JLabel lbkasedisi = new JLabel ("Kas Edisi");
   JLabel lbhrg= new JLabel ("Harga per Eks.");
   JLabel lbtotal1 = new JLabel();
   JLabel lbtotal2 = new JLabel("Total Kas : ");
   JTextField uang= new JTextField("");

   JTextField txedisi = new JTextField ("");
   JTextField txjudul = new JTextField ("");
   JTextField txtglterbit = new JTextField ("");
   JTextField txtglakhir = new JTextField ("");
   JTextField txjmlpesan = new JTextField ("");
   JTextField txpembayran = new JTextField ("");
   JTextField txkasedisi = new JTextField ("");
   JTextField txhrg = new JTextField ("");

   JButton btcari = new JButton ("Search");
   JButton btsave = new JButton ("Save");
   JButton btupdate = new JButton ("Update");
   JButton bthapus = new JButton ("Back");
   JButton btrefresh = new JButton ("Refresh");
   JButton btview = new JButton ("View");
   JButton btdel = new JButton ("Hapus");
   public Connection connection;
   public Statement statement;

   public MediaUmat()
   {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setTitle("PENDAFTARAN MED. UMAT");
       setSize(420,400);
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


   public String setEdisi()
   {
        Edisi=txedisi.getText();
        return Edisi;
   }
   public String setJudul()
   {
        Judul=txjudul.getText();
        return Judul;
   }
   public String setTanggalTerbit()
   {
        TanggalTerbit=txtglterbit.getText();
        return TanggalTerbit;
   }
   public String setTanggalMassaAkhir()
   {
        TanggalMassaAkhir=txtglakhir.getText();
        return TanggalMassaAkhir;
   }
   public String setJumlahPesan()
   {
        JumlahPesan=txjmlpesan.getText();
        return JumlahPesan;
   }
   public String setPembayaranDistributor()
   {
        PembayaranDistributor=txpembayran.getText();
        return PembayaranDistributor;
   }
   public String setKasEdisi()
   {
        KasEdisi=txkasedisi.getText();
        return KasEdisi;
   }
   public String setHarga()
   {
        Harga=txhrg.getText();
        return Harga;
   }

   void komponenVisual()
   {
        setIconImage(icon1.getImage());
        getContentPane().setLayout(null);

        getContentPane().add(lbedisi);
        lbedisi.setBounds(25,20,250,20);
        getContentPane().add(txedisi);
        txedisi.setBounds(137,20,160,20);
        txedisi.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbjudul);
        lbjudul.setBounds(25,50,250,20);
        getContentPane().add(txjudul);
        txjudul.setBounds(137,50,250,20);
        //txnama.setEditable(false);
        txjudul.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbtglterbit);
        lbtglterbit.setBounds(25,80,250,20);
        getContentPane().add(txtglterbit);
        txtglterbit.setBounds(137,80,250,20);
        txtglterbit.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbtglakhir);
        lbtglakhir.setBounds(25,110,250,20);
        getContentPane().add(txtglakhir);
        txtglakhir.setBounds(137,110,250,20);
        txtglakhir.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbjmlpesan);
        lbjmlpesan.setBounds(260,140,150,20);
        getContentPane().add(txjmlpesan);
        txjmlpesan.setBounds(337,140,50,20);
        txjmlpesan.setBorder(BorderFactory.createEtchedBorder(1));
        //      Harga per edisi
        getContentPane().add(lbhrg);
        lbhrg.setBounds(25,140,250,20);
        getContentPane().add(txhrg);
        txhrg.setBounds(137,140,100,20);
        txhrg.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbpembayran);
        lbpembayran.setBounds(25,170,250,20);
        getContentPane().add(txpembayran);
        txpembayran.setBounds(137,170,250,20);
        txpembayran.setEditable(false);
        txpembayran.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbkasedisi);
        lbkasedisi.setBounds(25,200,250,20);
        getContentPane().add(txkasedisi);
        txkasedisi.setBounds(137,200,250,20);
        txkasedisi.setEditable(false);
        txkasedisi.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(btdel);
        btdel.setBounds(138,250,100,30);
        btdel.setEnabled(false);

        getContentPane().add(lbtotal1);    // nominal
        lbtotal1.setFont(new java.awt.Font("Dialog",Font.BOLD, 15));
        lbtotal1.setBounds(340,250,80,30);

        getContentPane().add(lbtotal2);    // Tulisan
        lbtotal2.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        lbtotal2.setBounds(260,250,100,30);

        getContentPane().add(btcari);
        btcari.setBounds(305,20,80,20);

        getContentPane().add(btsave);
        btsave.setBounds(25,320,60,30);
        btsave.setEnabled(false);

        getContentPane().add(btupdate);
        btupdate.setBounds(95,320,70,30);
        btupdate.setEnabled(false);

        getContentPane().add(bthapus);
        bthapus.setBounds(175,320,60,30);

        //getContentPane().add(uang);                                               // TULISAN UANG
        //uang.setBounds(5,330,200,30);
        //uang.setDocument(new RupiahToy().test02());
        //uang.setBackground(Color.DARK_GRAY);


        getContentPane().add(btrefresh);
        btrefresh.setBounds(245,320,70,30);
        getContentPane().add(btview);
        btview.setBounds(325,320,60,30);
        getContentPane().add(gambar1);
        gambar1.setBounds(0,0,500,500);
        setResizable(false);
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
                       String Kode=txedisi.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="SELECT Edisi,Judul,TanggalTerbit,TanggalMassaAkhir,JumlahPesan,PembayaranDistributor,KasEdisi,Harga FROM MediaUmat WHERE Edisi like '"+Kode+"'";
                       ResultSet rs=statement.executeQuery(sql);
                       if(rs.next())
                       {
                          txedisi.setText(rs.getString(1));
                          txjudul.setText(rs.getString(2));
                          txtglterbit.setText(rs.getString(3));
                          txtglakhir.setText(rs.getString(4));
                          txjmlpesan.setText(rs.getString(5));
                          txpembayran.setText(rs.getString(6));
                          txkasedisi.setText(rs.getString(7));
                          txhrg.setText(rs.getString(8));
                          btdel.setEnabled(true);
                          btsave.setEnabled(false);
                          btupdate.setEnabled(true);
                          btview.setEnabled(true);
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
               txedisi.requestFocus();
           }
        });

        txjmlpesan.addKeyListener(new KeyAdapter()
        {
           public void keyPressed(KeyEvent event)
           {
             if(event.getKeyCode()==event.VK_ENTER)
              {
                                                                                  // CHARAC TER AJA
                   // char c= evt.getKeyChar();
                   // if(!Character.isDigit(c))
                   // evt.consume();
                    String jmlpesan= txjmlpesan.getText();
                    int jmlpesan1= Integer.parseInt(jmlpesan);
                    String hrgedisi= txhrg.getText();
                    int hrgedisi1=Integer.parseInt(hrgedisi);
                    int hrgtotal=(hrgedisi1*jmlpesan1);
                    String hrgtotal3 =String.valueOf(hrgtotal);
                    txpembayran.setText(hrgtotal3);
            /*
                int hrgmediaumat=3500;
                String jumlah1=txjmlpesan.getText();
                int njumlah1=Integer.parseInt(jumlah1);

                int hrgtotalpesan=(njumlah1*hrgmediaumat);
                String nttlpemesanan=String.valueOf(hrgtotalpesan);
                txpembayran.setText(nttlpemesanan); */
                //btsave.requestFocus();
                // TODO add your handling code here:
             /*   else
                {
                     JOptionPane.showMessageDialog(null,"Maaf Harga Media Umat Belum Anda Isi");
                } */
              }
           }
        });
        txjmlpesan.addKeyListener(new KeyAdapter()
        {
           public void keyPressed(KeyEvent event)
           {
              if(event.getKeyCode()==event.VK_ENTER)
              {
                int hrgmediaumat=500;
                String jumlah1=txjmlpesan.getText();
                int njumlah1=Integer.parseInt(jumlah1);

                int hrgtotalpesan=(njumlah1*hrgmediaumat);
                String nttlpemesanan=String.valueOf(hrgtotalpesan);
                txkasedisi.setText(nttlpemesanan);
                btsave.requestFocus();
                btsave.setEnabled(true);
                btview.setEnabled(true);
                // TODO add your handling code here:
              }
           }
        });


        txedisi.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
               if(event.getKeyCode()==event.VK_ENTER)
               {
                   txjudul.requestFocus();
               }
            }
        });
        txjudul.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txtglterbit.requestFocus();
                }
            }
        });

        txtglterbit.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txtglakhir.requestFocus();
                }
            }
        });

        txtglakhir.addKeyListener(new KeyAdapter()
        {
           public void keyPressed(KeyEvent event)
           {
               if(event.getKeyCode()==event.VK_ENTER)
               {
                   txhrg.requestFocus();
               }
           }
        });
        txhrg.addKeyListener(new KeyAdapter()
        {
           public void keyPressed(KeyEvent event)
           {
               if(event.getKeyCode()==event.VK_ENTER)
               {
                   txjmlpesan.requestFocus();
               }
           }
        });

        btsave.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
              {
                  if(txedisi.getText().equals("")||txjudul.getText().equals("")||txtglterbit.getText().equals("")||txtglakhir.getText().equals(""))
                  {
                       JOptionPane.showMessageDialog(null, "Maaf Anda Belum Melengkapi Data-data Yang Dibutuhkan");
                  }
                  else
                  {
                     //String hrtgl=txtgl.getText();
                     KonekMediaUmat k=new KonekMediaUmat();
                     k.saveMediaUmat(connection,setEdisi(),setJudul(),setTanggalTerbit(),setTanggalMassaAkhir(),setJumlahPesan(),setPembayaranDistributor(),setKasEdisi(),setHarga());
                     JOptionPane.showMessageDialog(null, "Data Telah Masuk");
                     btsave.setEnabled(false);
                     btupdate.setEnabled(true);
                     btdel.setEnabled(true);

                     String tota = null;
                     try
                     {

                     String dbname="jdbc:odbc:SIMEDIAUMAT";
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                     Statement statement = con.createStatement();
                     Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                     String sql="Select sum(KasEdisi) as tot from MediaUmat ";
                     ResultSet rs=state.executeQuery(sql);
                     while (rs.next())
                     {
                        tota = rs.getString("tot");
                        tota = tota.substring(0, tota.length() - 2);
                     }
                     }
                     catch (Exception ie)
                     {
                        System.out.println(ie);
                     }
                     double money = Double.parseDouble(tota);
                     String format = NumberFormat.getNumberInstance(Locale.ENGLISH).format(money);
                     StringTokenizer token = new StringTokenizer(format, ".");
                     format = token.nextToken();
                     format = format.replace(',', '.');
                     lbtotal1.setText(format);
                  }
                     //txidpas.requestFocus();
              }
              catch (Exception e)
              {
                  System.out.println("Erorr = "+e);
              }
              }
        });

       //Untuk menampilkan KAS edisi yang tercantum pada Label
        String tota = null;
        try
           {

             String dbname="jdbc:odbc:SIMEDIAUMAT";
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
             Statement statement = con.createStatement();
             Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             String sql="Select sum(KasEdisi) as tot from MediaUmat ";
             ResultSet rs=state.executeQuery(sql);
             while (rs.next())
             {
               tota = rs.getString("tot");
               tota = tota.substring(0, tota.length() - 2);
             }
           }
           catch (Exception ie)
           {
              System.out.println(ie);
           }
           double money = Double.parseDouble(tota);
           String format = NumberFormat.getNumberInstance(Locale.ENGLISH).format(money);
           StringTokenizer token = new StringTokenizer(format, ".");
           format = token.nextToken();
           format = format.replace(',', '.');
           lbtotal1.setText(format);



        btupdate.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
              {
                  KonekMediaUmat k=new KonekMediaUmat();
                  k.updateMediaUmat(connection,setEdisi(),setJudul(),setTanggalTerbit(),setTanggalMassaAkhir(),setJumlahPesan(),setPembayaranDistributor(),setKasEdisi(),setHarga());
                  JOptionPane.showMessageDialog(null, "Data Telah Teredit");
                  btsave.setEnabled(false);
                  btview.setEnabled(true);

                  String tota = null;
                     try
                     {

                     String dbname="jdbc:odbc:SIMEDIAUMAT";
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                     Statement statement = con.createStatement();
                     Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                     String sql="Select sum(KasEdisi) as tot from MediaUmat ";
                     ResultSet rs=state.executeQuery(sql);
                     while (rs.next())
                     {
                        tota = rs.getString("tot");
                        tota = tota.substring(0, tota.length() - 2);
                     }
                     }
                     catch (Exception ie)
                     {
                        System.out.println(ie);
                     }
                     double money = Double.parseDouble(tota);
                     String format = NumberFormat.getNumberInstance(Locale.ENGLISH).format(money);
                     StringTokenizer token = new StringTokenizer(format, ".");
                     format = token.nextToken();
                     format = format.replace(',', '.');
                     lbtotal1.setText(format);


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

               txedisi.setText("");
               txjudul.setText("");
               txtglterbit.setText("");
               txtglakhir.setText("");
               txjmlpesan.setText("");
               txpembayran.setText("");
               txkasedisi.setText("");
               //txhrg.setText("");
            }
        });

       btview.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
             try
             {
                 viewMediaUmat tp=new viewMediaUmat();
                 tp.koneksi();
                 tp.komponenvisual();
                 btview.setEnabled(false);
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Program di Komputer Anda belum terkoneksi dengan database ..!!\nHubungi Programmer ediuinmaliki@gmail.com",".:Warning:.",JOptionPane.WARNING_MESSAGE);
             }
          }
       });
       bthapus.addActionListener(new ActionListener()  // tombol back
       {
          public void actionPerformed(ActionEvent evt)
          {
              setVisible(false);
          }
       });
       btdel.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
                {
                       String Kode=txedisi.getText();
                       JOptionPane.showConfirmDialog(null,"Apakah Anda Benar benar Ingin menghapus Pelanggan tsb ?");
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="Delete FROM MediaUmat WHERE Edisi like '"+Kode+"'";
                       ResultSet rs =statement.executeQuery(sql);
                       statement.close();
                       con.close();
                    }
                    catch(Exception ex)
                    {
                       System.out.println("Erorr "+ex);
                    }
                    txedisi.setText("");
                    txjudul.setText("");
                    txtglterbit.setText("");
                    txtglakhir.setText("");
                    txjmlpesan.setText("");
                    txpembayran.setText("");
                    txkasedisi.setText("");
                    txhrg.setText("");

                    btdel.setEnabled(false);
                    btview.setEnabled(true);

                     String tota = null;
                     try
                     {

                     String dbname="jdbc:odbc:SIMEDIAUMAT";
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                     Statement statement = con.createStatement();
                     Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                     String sql="Select sum(KasEdisi) as tot from MediaUmat ";
                     ResultSet rs=state.executeQuery(sql);
                     while (rs.next())
                     {
                        tota = rs.getString("tot");
                        tota = tota.substring(0, tota.length() - 2);
                     }
                     }
                     catch (Exception ie)
                     {
                        System.out.println(ie);
                     }
                     double money = Double.parseDouble(tota);
                     String format = NumberFormat.getNumberInstance(Locale.ENGLISH).format(money);
                     StringTokenizer token = new StringTokenizer(format, ".");
                     format = token.nextToken();
                     format = format.replace(',', '.');
                     lbtotal1.setText(format);
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
        MediaUmat pel=new MediaUmat();
        pel.komponenVisual();
        pel.aksiReaksi();
    }
}