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
import java.text.*;

public class Pembayaran extends JFrame
{
   String IdPemesanan;
   String Edisi;
   String Judul;
   String IdPelanggan;
   String NamaPelanggan;
   String JumlahPemesanan;
   String TanggalPembayaran;
   String JumlahPembayaran;

   public static String ID;
   DefaultTableModel dtm=new DefaultTableModel();
   JTable table=new JTable(dtm);

   public Connection connection;
   JLabel gambar1=new JLabel(new ImageIcon("image/CAMPUR (139).JPG"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   ImageIcon icon2=new ImageIcon("image/view.gif");

   JLabel lbidpemesanan = new JLabel ("ID Pemesanan");
   JLabel lbedisi = new JLabel ("Edisi");
   JLabel lbjudul = new JLabel ("Judul");
   JLabel lbidpel = new JLabel ("ID Pelanggan");
   JLabel lbnama = new JLabel ("Nama Pelanggan");
   JLabel lbjmlpemesanan = new JLabel ("Jumlah Pemesanan");
   JLabel lbtglbayar= new JLabel ("Tanggal Pembayaran");
   JLabel lbjmlbayar = new JLabel ("Jumlah Pembayaran");
   JLabel lblihat = new JLabel("LIHAT BERDASARKAN:");
   JLabel lblihat1 = new JLabel("Edisi ");
   JLabel lblihat2 = new JLabel ("KODE PELANGGAN");
   JLabel lbjmlbyr= new JLabel ("Total");

   JTextField txidpemesanan = new JTextField ("");
   JTextField txedisi = new JTextField ("");
   JTextField txjudul = new JTextField ("");
   JTextField txidpel = new JTextField ("");
   JTextField txnama = new JTextField ("");
   JTextField txjmlpemesanan = new JTextField ("");
   JTextField txtglbayar = new JTextField ("");
   JTextField txjmlbayar = new JTextField ("");
   JTextField txlihat1 = new JTextField("");
   JTextField txlihat2 = new JTextField("");
   JTextField txjmlbyr= new JTextField("");

   Date kalender=new Date();
   int day=kalender.getDay();
   int date=kalender.getDate();
   int month=kalender.getMonth();
   int year=kalender.getYear()+1900;

   String hari[]={"Ahad", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu",};
   String bulan[]={"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
   JLabel tanggal=new JLabel ();

   JButton btdel = new JButton ("Hapus");
   JButton btcari = new JButton ("Search");
   JButton btlihat = new JButton (">");
   JButton btupdate = new JButton ("BAYAR");
   JButton btcetak = new JButton ("Cetak");
   JButton btrefresh = new JButton ("Refresh");
   JButton btview = new JButton ("P.All");

   public Pembayaran()
   {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setTitle("Pembayaran Med. Umat");
       setSize(420,538);
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
   public String setIdPemesanan()
   {
        IdPemesanan=txidpemesanan.getText();
        return IdPemesanan;
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
   public String setIdPelanggan()
   {
        IdPelanggan=txidpel.getText();
        return IdPelanggan;
   }
   public String setNamaPelanggan()
   {
        NamaPelanggan=txnama.getText();
        return NamaPelanggan;
   }

   public String setJumlahPemesanan()
   {
        JumlahPemesanan=txjmlpemesanan.getText();
        return JumlahPemesanan;
   }
   public String setTanggalPembayaran()
   {
        TanggalPembayaran=txtglbayar.getText();
        return TanggalPembayaran;
   }
   public String setJumlahPembayaran()
   {
        JumlahPembayaran=txjmlbayar.getText();
        return JumlahPembayaran;
   }

   void komponenVisual()
   {
        setIconImage(icon1.getImage());
        getContentPane().setLayout(null);

        getContentPane().add(lbidpemesanan);
        lbidpemesanan.setBounds(25,20,250,20);
        getContentPane().add(txidpemesanan);
        txidpemesanan.setBounds(137,20,125,20);
        //txidpemesanan.setEditable(false);
        txidpemesanan.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbedisi);
        lbedisi.setBounds(25,50,250,20);
        getContentPane().add(txedisi);
        txedisi.setBounds(137,50,250,20);
        txedisi.setEditable(false);
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
        txidpel.setEditable(false);
        txidpel.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbnama);
        lbnama.setBounds(25,140,250,20);
        getContentPane().add(txnama);
        txnama.setBounds(137,140,250,20);
        txnama.setEditable(false);
        txnama.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbjmlpemesanan);
        lbjmlpemesanan.setBounds(25,170,150,20);
        getContentPane().add(txjmlpemesanan);
        txjmlpemesanan.setBounds(137,170,125,20);
        txjmlpemesanan.setEditable(false);
        txjmlpemesanan.setBorder(BorderFactory.createEtchedBorder(1));

        // Yang Harus di bayar
        getContentPane().add(lbjmlbyr);
        lbjmlbyr.setBounds(275,170,80,20);
        getContentPane().add(txjmlbyr);
        txjmlbyr.setBounds(308,170,80,20);
        txjmlbyr.setEditable(false);
        txjmlbyr.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbtglbayar);
        lbtglbayar.setBounds(25,200,250,20);
        getContentPane().add(txtglbayar);
        txtglbayar.setBounds(137,200,250,20);
        txtglbayar.setEditable(false);
        txtglbayar.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbjmlbayar);
        lbjmlbayar.setBounds(25,230,250,20);
        getContentPane().add(txjmlbayar);
        txjmlbayar.setBounds(137,230,250,20);
        txjmlbayar.setBorder(BorderFactory.createEtchedBorder(1));

        // LIHAT YANG BELUM BAYAR
        getContentPane().add(lblihat);
        lblihat.setBounds(25,270,150,20);

        getContentPane().add(lblihat1);
        lblihat1.setBounds(152,270,50,20);
        getContentPane().add(txlihat1);
        txlihat1.setBounds(175,270,30,20);
        txlihat1.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lblihat2);
        lblihat2.setBounds(210,270,100,20);
        getContentPane().add(txlihat2);
        txlihat2.setBounds(305,270,30,20);
        txlihat2.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(btcari);
        btcari.setBounds(305,20,80,20);

        getContentPane().add(btlihat);
        btlihat.setBounds(340,270,45,20);

        getContentPane().add(btdel);
        btdel.setBounds(30,455,70,30);
        btdel.setEnabled(false);

        getContentPane().add(btupdate);
        btupdate.setBounds(103,455,70,30);
        btupdate.setEnabled(false);

        getContentPane().add(btcetak);
        btcetak.setBounds(245,455,60,30);
        btcetak.setEnabled(false);

        getContentPane().add(btrefresh);
        btrefresh.setBounds(315,455,70,30);
        getContentPane().add(btview);
        btview.setBounds(175,455,60,30);

        JScrollPane scrollpane=new JScrollPane(table);
        getContentPane().add(scrollpane);
        scrollpane.setBounds(25,300,360,140);

        getContentPane().add(gambar1);
        gambar1.setBounds(0,0,500,500);
        setResizable(true);
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
                       String sql="SELECT Edisi,Judul,IdPelanggan,NamaPelanggan,JumlahPemesanan,JmlBayar,TotalPemesanan FROM Pemesanan WHERE IdPemesanan like '"+Kode+"'";
                       ResultSet rs=statement.executeQuery(sql);
                       if(rs.next())
                       {
                          txedisi.setText(rs.getString(1));
                          txjudul.setText(rs.getString(2));
                          txidpel.setText(rs.getString(3));
                          txnama.setText(rs.getString(4));
                          txjmlpemesanan.setText(rs.getString(5));
                          txjmlbayar.setText(rs.getString(6));
                          txjmlbyr.setText(rs.getString(7));
                          //txjmlbayar.setText(rs.getString(7));
                          btdel.setEnabled(true);
                          btupdate.setEnabled(true);
                          btcetak.setEnabled(false);
                         // txjmlbyr.setText(rs.getString(8));
                         // txjmlbayar.setText("");
                       }
                       else
                       {
                          JOptionPane.showMessageDialog(null,"Maaf Data Tidak Ditemukan");
                          btdel.setEnabled(false);
                          btupdate.setEnabled(false);
                          btcetak.setEnabled(false);
                          txidpemesanan.requestFocus();
                       }
                       statement.close();
                       con.close();
                    }
                    catch(Exception ex)
                    {
                       System.out.println("Erorr "+ex);
                    }
               //txedisi.requestFocus();
           }
        });
        txidpemesanan.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    try
                    {
                       String Kode=txidpemesanan.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       String sql="SELECT Edisi,Judul,IdPelanggan,NamaPelanggan,JumlahPemesanan,TotalPemesanan,JmlBayar FROM Pemesanan WHERE IdPemesanan like '"+Kode+"'";
                       ResultSet rs=statement.executeQuery(sql);
                       if(rs.next())
                       {
                          txedisi.setText(rs.getString(1));
                          txjudul.setText(rs.getString(2));
                          txidpel.setText(rs.getString(3));
                          txnama.setText(rs.getString(4));
                          txjmlpemesanan.setText(rs.getString(5));
                          txjmlbyr.setText(rs.getString(6));
                          txjmlbayar.setText(rs.getString(7));

                          btdel.setEnabled(true);
                          btcetak.setEnabled(false);
                          btupdate.setEnabled(true);

                          //txjmlbayar.setText(rs.getString(6));

                       }
                       else
                       {
                          JOptionPane.showMessageDialog(null,"Maaf Data Tidak Ditemukan");
                          txidpemesanan.requestFocus();
                       }
                       statement.close();
                       con.close();
                    }
                    catch(Exception ex)
                    {
                       System.out.println("Erorr "+ex);
                    }
                    txjmlbayar.requestFocus();
                }
            } //
        });
        txlihat1.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    try
                    {
                       String cari=txlihat1.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM Pemesanan WHERE Edisi LIKE '"+cari+"'";
                      // String sql="SELECT * FROM Pemesanan" ;

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][8];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          //mengatur format mata uang
                          /* Double y= Double.parseDouble(rs.getString(10));
                          NumberFormat nf= NumberFormat.getCurrencyInstance();
                          String z= nf.format(y); */

                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          data[p][5]=rs.getString(9);
                          data[p][6]=rs.getString(10);
                          data[p][7]=rs.getString(12);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"Kode","Edisi","Judul","ID Pel","Nama","Jml","Utang","Bayar"});
                       table.setModel(dtm);
                       state.close();
                       con.close();
                    }
                    catch(Exception DBExeption)
                    {
                       System.err.println("Error:"+DBExeption);
                    }
                    txjmlbayar.requestFocus();
                }
            } //
        });
        txlihat2.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    try
                    {
                       String cari=txlihat2.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM Pemesanan WHERE IdPelanggan LIKE '"+cari+"'";
                      // String sql="SELECT * FROM Pemesanan" ;

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][8];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          data[p][5]=rs.getString(9);
                          data[p][6]=rs.getString(10);
                          data[p][7]=rs.getString(12);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"Kode","Edisi","Judul","ID Pel","Nama","Jml","Utang","Bayar"});
                       table.setModel(dtm);
                       state.close();
                       con.close();
                    }
                    catch(Exception ex)
                    {
                       System.out.println("Erorr "+ex);
                    }
                    txjmlbayar.requestFocus();
                }
            } //
        });

        tanggal.setText(hari[day]+", "+date+" "+bulan[month]+" "+year);
        txtglbayar.setText(" "+hari[day]+", "+date+" "+bulan[month]+" "+year);

        txjmlbayar.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    btupdate.requestFocus();
                    btupdate.setEnabled(true);
                }
            }
        });
        btlihat.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
            try
                    {
                       String cari=txlihat1.getText();
                       String cari2=txlihat2.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM Pemesanan WHERE IdPelanggan ='"+cari2+"' AND Edisi= '"+cari+"'" ;

                       ResultSet rs=state.executeQuery(sql);
                       rs.last();
                       int n=rs.getRow();
                       Object data[][]=new Object[n][8];
                       int p=0;
                       rs.beforeFirst();

                       while(rs.next())
                       {
                          data[p][0]=rs.getString(1);
                          data[p][1]=rs.getString(2);
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          data[p][5]=rs.getString(9);
                          data[p][7]=rs.getString(12);
                          data[p][6]=rs.getString(13);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"Kode","Edisi","Judul","ID Pel","Nama","Jml","@","Bayar"});
                       table.setModel(dtm);
                       state.close();
                       con.close();
                    }
                    catch(Exception DBExeption)
                    {
                       System.err.println("Error:"+DBExeption);
                    }
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
                    txjmlpemesanan.setText("");
                    txtglbayar.setText("");
                    txjmlbayar.setText("");
                    txjmlbyr.setText("");
                    JOptionPane.showMessageDialog(null,"Data telah Terhapus !");
           }
        });

        btupdate.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
              {
                  KonekPembayaran k=new KonekPembayaran();
                  k.updatePembayaran(connection ,setIdPemesanan(),setJumlahPembayaran(),setTanggalPembayaran());
                  JOptionPane.showMessageDialog(null, "Data Pembayaran Telah Masuk");

                       String cari=txidpemesanan.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM Pemesanan WHERE IdPemesanan LIKE '"+cari+"'";

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
                          data[p][2]=rs.getString(3);
                          data[p][3]=rs.getString(4);
                          data[p][4]=rs.getString(5);
                          data[p][5]=rs.getString(9);
                          data[p][6]=rs.getString(12);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"Kode Psn","Edisi","Judul","ID Pel","Nama","Jml","Bayar"});
                       table.setModel(dtm);
                       btcetak.setEnabled(true);
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

               txidpemesanan.setText("");
               txedisi.setText("");
               txjudul.setText("");
               txidpel.setText("");
               txnama.setText("");
               txjmlpemesanan.setText("");
               txlihat1.setText("");
               txlihat2.setText("");
               //txtglbayar.setText("");
               txjmlbayar.setText("");
            }
        });

        btcetak.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
              int y = 0;
              Frame fr = new Frame();
              PrintJob print = fr.getToolkit().getPrintJob(fr, "Prinnting", null, null);
              if (print != null)
              {
                  Graphics g = print.getGraphics();
                  if (g != null)
                  {
                      g.setFont(new Font("Dialog", 1, 11));
                      g.drawString("STRUK PEMBAYARAN MEDIA UMAT", 30, 40);
                      g.drawString("UIN MALIKI MALANG", 30, 50);
                      g.drawString("BY: M edi cahyono", 30, 60);
                      g.setFont(new Font("Dialog", 0, 8));
                      g.drawString(tanggal.getText() , 30, 70);
                      //g.drawString(tanggal.getText() + " / " + Njam.getText() + " / " + no_tran.getText(), 30, 70);
                      String idpemesanan = table.getColumnName(0);
                      String edisi = table.getColumnName(1);
                      String judul = table.getColumnName(2);
                      String idpel = table.getColumnName(3);
                      String nama = table.getColumnName(4);
                      String jmlpemesanan = table.getColumnName(5);
                      //String tglbayar = table.getColumnName(6);                   // Tidak bisa di cetak karena ia tidak Di edit ato sudah terdeklarasi
                      //String jmlbayar = table.getColumnName(6);
                      String jmlbyr = table.getColumnName(6);
                      g.drawLine(30, 74, 220, 74);
                      g.setFont(new Font("Dialog", 1, 8));
                      g.drawString(idpemesanan, 30, 90);                            // posisi KOLOM ID PEMESANAN
                      g.drawString(":", 90, 90);
                      g.drawString(txidpemesanan.getText(), 95, 90);
                      g.drawString(edisi, 30, 100);
                      g.drawString(":", 90, 100);
                      g.drawString(txedisi.getText(), 95, 100);
                      g.drawString(judul, 30, 110);
                      g.drawString(":", 90, 110);
                      g.drawString(txjudul.getText(), 95, 110);
                      g.drawString(idpel, 30, 120);
                      g.drawString(":", 90, 120);
                      g.drawString(txidpel.getText(), 95, 120);
                      g.drawString(nama, 30,130);
                      g.drawString(":", 90, 130);
                      g.drawString(txnama.getText(), 95, 130);
                      g.drawString(jmlpemesanan, 30,140);
                      g.drawString(":", 90, 140);
                      g.drawString(txjmlpemesanan.getText(), 95, 140);
                      g.drawString(jmlbyr, 30,150);
                      g.drawString(":", 90, 150);
                      g.drawString(txjmlbyr.getText(), 95, 150);
                      g.drawLine(30, 155, 220, 155);
                      g.setFont(new Font("Dialog", 1, 8));
                      btdel.setEnabled(false);
                      btupdate.setEnabled(false);
                      btcetak.setEnabled(false);
                      txidpemesanan.setText("");
                      txedisi.setText("");
                      txjudul.setText("");
                      txidpel.setText("");
                      txnama.setText("");
                      txjmlpemesanan.setText("");
                      txjmlbyr.setText("");
                      txlihat1.setText("");
                      txlihat2.setText("");
                      //txtglbayar.setText("");
                      txjmlbayar.setText("");
                  }
                  print.end();
                  print.end();
              }
          }
        });
        btview.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
             try
             {
               //  viewPembayaran ts= new viewPembayaran();
               //  ts.koneksi();
               //  ts.komponenvisual();
                setVisible(false);

               //===  CETAK JASPER BELUM BISA PAKAI AJ 3.5===
              KonekPembayaran kp= new KonekPembayaran();
              kp.cetakPembayaran();
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
        Pembayaran pem =new Pembayaran();
        pem.komponenVisual();
        pem.aksiReaksi();
    }
}