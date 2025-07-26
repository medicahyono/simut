import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.*;

public class Awalan extends JFrame
{

   JLabel gambar1=new JLabel(new ImageIcon("image/islamic.jpg"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   ImageIcon icstart=new ImageIcon("image/start.png");
   ImageIcon icexit=new ImageIcon("image/stop.png");
   JLabel lbtgl=new JLabel();
   JLabel lbjam=new JLabel();
   JLabel lbintruksi=new JLabel("<< Press This Button >>");
   JButton btmulai = new JButton (icstart);
   JButton btexit = new JButton (icexit);

   Date kalender=new Date();
   int day=kalender.getDay();
   int date=kalender.getDate();
   int month=kalender.getMonth();
   int year=kalender.getYear()+1900;

   String hari[]={"Ahad", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu",};
   String bulan[]={"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
   JLabel tanggal=new JLabel ();

   Awalan()
   {
      super("Welcome To Media Umat System Information Versi 11.1");
      java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
      setSize(635,500);
      java.awt.Dimension dialogSize = getSize();
      setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   void KomponenVisual()
   {
       setIconImage(icon1.getImage());

       getContentPane().add(lbtgl);
       lbtgl.setBounds(80,230,280,30);
       //lbtgl.setFont(new Font("Georgia",Font.BOLD,20));
       lbtgl.setFont(new Font("Agency FB",Font.BOLD,25));
       lbtgl.setForeground(Color.white);
       getContentPane().add(lbjam);

       lbjam.setBounds(93,260,200,30);
       lbjam.setFont(new Font("Agency FB",Font.BOLD,25));
       lbjam.setForeground(Color.white);

       getContentPane().add(lbintruksi);
       lbintruksi.setBounds(333,225,350,40);
       //lbintruksi.setFont(new Font("DigifaceWide",Font.BOLD,25));
       lbintruksi.setFont(new Font("Agency FB",Font.BOLD,35));
       lbintruksi.setForeground(Color.GREEN);

       getContentPane().add(btmulai);
       btmulai.setBounds(500,280,100,60);
       btmulai.setToolTipText("START");
       btmulai.setCursor(new Cursor(Cursor.HAND_CURSOR));
       getContentPane().add(btexit);
       btexit.setBounds(500,360,100,60);
       btexit.setToolTipText("STOP");
       btexit.setCursor(new Cursor(Cursor.HAND_CURSOR));

       getContentPane().add(gambar1);
       gambar1.setBounds(0,0,500,500);
       show();
       setResizable(false);
       setVisible(true);
   }

   void AksiReaksi()
   {
       btmulai.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
             try
             {
                 Loading load = new Loading();
                 load.tampil();
                 load.pro();
                 setVisible(false);
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 System.out.println("Error "+e);
             }
          }
       });

       btexit.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
             try
             {
                 String msg="Are u Sure ?";
                 int result = JOptionPane.showOptionDialog(null,new Object[] {msg},"Konfirmasi", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon("AlienAqua Help.png"),null, null);
                 if(result==JOptionPane.YES_OPTION)
                 {
                    System.exit(0);
                 }
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 System.out.println("Error "+e);
             }
          }
       });
    }

   void jam()
   {
      //-----------------tanggal----------------------//

      lbtgl.setText(hari[day]+", "+date+" "+bulan[month]+" "+year);

      //-------------------jam------------------------//
      ActionListener taskPerformer = new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            String nol_jam = "";
            String nol_menit = "";
            String nol_detik = "";

            Date dt = new Date();

            int nilai_jam = dt.getHours();
            int nilai_menit = dt.getMinutes();
            int nilai_detik = dt.getSeconds();
            // Jika  JAM lebih kecil dari 10
            if (nilai_jam <= 9)
            {
               // Tambah "0" didepannya
               nol_jam = "0";
            }
            if (nilai_menit <= 9)
            {
               nol_menit = "0";
            }
            if (nilai_detik <= 9)
            {
               nol_detik = "0";
            }
            // Membuat String JAM, MENIT, DETIK
            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);
            // Menampilkan jam
            lbjam.setText(jam + " : " + menit + " : " + detik + " WIB  ");
         }
      };
      // Timer
      new Timer(1000, taskPerformer).start();
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
      Awalan awl= new Awalan ();
      awl.KomponenVisual();                                                        // yang memunculkan KOMPONEN DALAM KELAS <HalamanPertama>
      awl.jam();                                                                   // yang menmunculkan HARI,JAM,dan TANGGAL
      awl.AksiReaksi();                                                            // yang memunculkan menu MMULAI dan EXIT
   }
}