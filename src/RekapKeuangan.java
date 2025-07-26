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

/*import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;  */

public class RekapKeuangan extends JFrame
{
   String No;
   String Tanggal;
   String Keterangan;
   String Jumlah;
   String Debit;
   String Kredit;
   String Saldo;

   public static String ID;                                 // tabel
   DefaultTableModel dtm=new DefaultTableModel();
   JTable table=new JTable(dtm);


   JLabel gambar1=new JLabel(new ImageIcon("image/CAMPUR (139).JPG"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   ImageIcon icon2=new ImageIcon("image/view.gif");

   JLabel lbno = new JLabel ("No Transaksi");
   JLabel lbtanggal = new JLabel ("Tanggal");
   JLabel lbketerangan = new JLabel ("Keterangan ");
   JLabel lbdebit = new JLabel ("Debit");
   JLabel lbkredit = new JLabel ("Kredit ");
  // JLabel lbkategori = new JLabel ("Kategori ");
  // String[]kategori={"------------------------","Debit","Kredit"};
  // JComboBox cbkategori=new JComboBox(kategori);
  // JLabel lbjumlah = new JLabel ("Jumlah");
   JLabel lbsaldo = new JLabel ("Saldo");

   JTextField txno  = new JTextField ("");
   JTextField txtanggal = new JTextField ("");
   JTextField txketerangan = new JTextField ("");
  // JTextField txjumlah = new JTextField ("");
   JTextField txsaldo = new JTextField ("");
   JTextField txdebit = new JTextField ("0");
   JTextField txkredit = new JTextField ("0");

   JButton btsave = new JButton ("Save");
   JButton btupdate = new JButton ("Update");
   JButton bthapus = new JButton ("Delete");

   JTable tabelp1=new JTable();
   JScrollPane jScrollPanep1 = new JScrollPane();
   DefaultTableModel tabMode;

   Date kalender=new Date();
   int day=kalender.getDay();
   int date=kalender.getDate();
   int month=kalender.getMonth();
   int year=kalender.getYear()+1900;

   String hari[]={"Ahad", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu",};
   String bulan[]={"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
   JLabel tanggal=new JLabel ();

   public Connection connection;
   public Statement statement;

   //KonekPengajuan k=new KonekPengajuan();

   public RekapKeuangan()
   {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setTitle("Rekap Keuangan Media Umat");
       setSize(420,520);
       int lebar = (screen.width-getSize().width) / 2;
       int tinggi = (screen.height-getSize().height) / 2;
       setLocation(lebar, tinggi);
       setResizable(true);
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


   public String setNo()
   {
        No=txno.getText();
        return No;
   }
   public String setTanggal()
   {
        Tanggal=txtanggal.getText();
        return Tanggal;
   }
   public String setKeterangan()
   {
        Keterangan=txketerangan.getText();
        return Keterangan;
   }
 /*  public String setJumlah()
   {
        Jumlah=txjumlah.getText();
        return Jumlah;
   }                      */
   public String setDebit()
   {
        Debit =txdebit.getText();
        return Debit;
   }
   public String setKredit()
   {
        Kredit =txkredit.getText();
        return Kredit;
   }
   public String setSaldo()
   {
       Saldo =txsaldo.getText();
       return Saldo;
   }

   void komponenVisual()
   {

        setIconImage(icon1.getImage());
        getContentPane().setLayout(null);

        getContentPane().add(lbno);
        lbno.setBounds(25,20,250,20);
        getContentPane().add(txno);
        txno.setBounds(137,20,160,20);
        txno.setBorder(BorderFactory.createEtchedBorder(1));

    /*  getContentPane().add(lbkategori);
        lbkategori.setBounds(25,50,250,20);
        //lbkategori.setFont(new Font("Georgia",Font.BOLD,12));
        lbkategori.setFont(new Font("Georgia",12,12));
        getContentPane().add(cbkategori);
        cbkategori.setBounds(137,50,250,20);
        cbkategori.setFont(new Font("Century Gothic",12,12));
        cbkategori.setForeground(Color.blue);
        cbkategori.setBackground(Color.PINK);           */

        getContentPane().add(lbdebit);
        lbdebit.setBounds(25,50,250,20);
        getContentPane().add(txdebit);
        txdebit.setBounds(137,50,250,20);
        //txtanggal.setEditable(false);
        txdebit.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbkredit);
        lbkredit.setBounds(25,80,250,20);
        getContentPane().add(txkredit);
        txkredit.setBounds(137,80,250,20);
        //txtanggal.setEditable(false);
        txkredit.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbtanggal);
        lbtanggal.setBounds(25,110,250,20);
        getContentPane().add(txtanggal);
        txtanggal.setBounds(137,110,250,20);
        //txtanggal.setEditable(false);
        txtanggal.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(lbketerangan);
        lbketerangan.setBounds(25,140,250,20);
        getContentPane().add(txketerangan);
        txketerangan.setBounds(137,140,250,20);
        txketerangan.setBorder(BorderFactory.createEtchedBorder(1));

     /*   getContentPane().add(lbjumlah);
        lbjumlah.setBounds(25,170,250,20);
        getContentPane().add(txjumlah);
        txjumlah.setBounds(137,170,250,20);
        txjumlah.setBorder(BorderFactory.createEtchedBorder(1));          */

        getContentPane().add(lbsaldo);
        lbsaldo.setBounds(25,170,250,20);
        getContentPane().add(txsaldo);
        txsaldo.setBounds(137,170,250,20);
        txsaldo.setBorder(BorderFactory.createEtchedBorder(1));

        getContentPane().add(btsave);
        btsave.setBounds(25,450,60,30);

        getContentPane().add(btupdate);
        btupdate.setBounds(95,450,70,30);

        getContentPane().add(bthapus);
        bthapus.setBounds(175,450,70,30);

        JScrollPane scrollpane=new JScrollPane(table);
        getContentPane().add(scrollpane);
        scrollpane.setBounds(25,230,363,210);

        //jtp.addTab("<html><font size=4 face=Georgia><b>&nbsp My Akunt &nbsp&nbsp</b></font></html>", new ImageIcon("pop3.jpg"), panel4);

        getContentPane().add(gambar1);
        gambar1.setBounds(0,0,500,500);
        setResizable(false);
        setVisible(true);
    }

    void aksiReaksi()
    {
        //tanggal.setText(hari[day]+", "+date+" "+bulan[month]+" "+year);
        //txtgl.setText(" "+hari[day]+", "+date+" "+bulan[month]+" "+year);
        txno.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                   // cbkategori.requestFocus();
                }
            }
        });

     /*  txno.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    try
                    {
                       String cari=txno.getText();
                       String dbname="jdbc:odbc:SIMEDIAUMAT";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                       Statement statement = con.createStatement();
                       Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       String sql="SELECT * FROM RekapKeuangan WHERE No LIKE '"+cari+"'";

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
                          //data[p][6]=rs.getString(7);
                          //data[p][7]=rs.getString(8);
                          //data[p][8]=rs.getString(9);
                          p++;
                       }
                       DefaultTableModel dtm= new DefaultTableModel(data, new String [] {"NO", "TANGGAL", "KETERANGAN", "DEBIT", "KREDIT", "SALDO"});
                       //tabel.setModel(dtm);
                       rs.beforeFirst();
                       dtm=createTable(rs);
                       table.setModel(dtm);
                       statement.close();
                       con.close();

                     // dtm=createTable(rs);
                     //  table.setModel(dtm);
                     //  state.close();
                       //con.close();
                    }
                    catch(Exception DBExeption)
                    {
                       System.err.println("Error:"+DBExeption);
                    }
                }
            }
        });           */
     /*   cbkategori.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    txketerangan.requestFocus();
                }
            }
        });           */
        txketerangan.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                  //  txjumlah.requestFocus();
                }
            }
        });
      /*  txjumlah.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                if(event.getKeyCode()==event.VK_ENTER)
                {
                    btsave.requestFocus();
                }
            }
        });         */

        tanggal.setText(hari[day]+", "+date+" "+bulan[month]+" "+year);
        txtanggal.setText(" "+hari[day]+", "+date+" "+bulan[month]+" "+year);


        btsave.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
              try
              {
                  if(txno.getText().equals("")||txsaldo.getText().equals("")||txtanggal.getText().equals(""))
                  {
                       JOptionPane.showMessageDialog(null, "Maaf Anda Belum Melengkapi Data-data Yang Dibutuhkan");
                  }
                  else
                  {
                     //String hrtgl=txtgl.getText();
                     KonekRekapKeuangan k=new KonekRekapKeuangan();
                     k.saveRekapKeuangan(connection,setNo(),setTanggal(),setKeterangan(),setSaldo(),setDebit(),setKredit());
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
                  KonekRekapKeuangan k=new KonekRekapKeuangan();
                  k.updateRekapKeuangan(connection,setNo(),setTanggal(),setKeterangan(),setDebit(),setKredit(),setSaldo());
                  JOptionPane.showMessageDialog(null, "Data Telah Teredit");
              }
              catch (Exception e)
              {
                  System.out.println("Erorr = "+e);
              }
           }
        });
       /* btrefresh.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {

               txidpelanggan.setText("");
               txnama.setText("");
               txalmt.setText("");
               txtelp.setText("");
               txjeniskelamin.setText("");
            }
        });                                   */

     /*  bthapus.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
             try
             {
                 viewRekapKeuangan ts= new viewRekapKeuangan();
                 ts.koneksi();
                 ts.komponenvisual();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "problem");
             }
          }
       });  */


     /*  bthapus.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
              setVisible(false);
          }
       });*/

     /*  btcari.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent evt)
         {
             int hit=table.getRowCount();
             for(int i=0;i<hit;i++)
             dtm.removeRow(0);
             String cari=txno.getText();
             try
             {
               /* koneksi konek=new koneksi();
                Connection con=konek.logon();
                Statement statement=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); */

             /*   String dbname="jdbc:odbc:SIMEDIAUMAT";
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                String sql="SELECT * FROM RekapKeuangan WHERE No like '%"+cari+"%'";
                ResultSet rs=statement.executeQuery(sql);
                rs.last();
                if(rs.getRow()==0)
                {
                    JOptionPane.showMessageDialog(null,"Data Tidak Ditemukan");
                }
                else
                {
                    System.out.println("bisa, ditemukan "+rs.getRow()+" data");
                }
                rs.beforeFirst();
                dtm=createTable(rs);
                table.setModel(dtm);
                statement.close();
                con.close();
             }
             catch(Exception e)
             {
                System.out.println("Erorr"+e);
             }
         }
       });                      */
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
      RekapKeuangan pel=new RekapKeuangan();
      pel.komponenVisual();
      pel.aksiReaksi();

    }

    private DefaultTableModel createTable(ResultSet rs) throws SQLException
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
    }
}