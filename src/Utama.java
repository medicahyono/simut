import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.*;

public class Utama extends JFrame
{

   JLabel gambar1=new JLabel(new ImageIcon("image/alam.jpg"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   //ImageIcon icadmin=new ImageIcon("icadministrasi.gif");
   ImageIcon icexit=new ImageIcon("image/ickeluar.gif");
   ImageIcon icpel=new ImageIcon("image/pelanggan.gif");
   ImageIcon icuser= new ImageIcon("image/user1.png");
   ImageIcon icmediaumat=new ImageIcon("image/icmediaumat.gif");
   ImageIcon icpemesanan=new ImageIcon("image/pelanggan.gif");
   ImageIcon icpembayaran=new ImageIcon("image/bayar.gif");
   ImageIcon icaboutthisprogram=new ImageIcon("image/about.gif");
   ImageIcon icme=new ImageIcon("image/programmer.png");

   JLabel lbtgl=new JLabel();
   JLabel lbjam=new JLabel();
   JMenuBar mnuBar=new JMenuBar();
   JMenu mnuFile = new JMenu("  File ");
   //mnuFile.setFont(new java.awt.Font("Dialog",Font.BOLD, 15));
   JMenu mnuEdit = new JMenu(" Edit ");
   JMenu mnuReport = new JMenu("  Report ");
   JMenu mnuAbout = new JMenu("  About ");
   //JMenuItem itemAdministrasi = new JMenuItem("Administrasi    ",icadmin);
   JMenuItem itemPelanggan = new JMenuItem("Pelanggan ",icpel);
   JMenuItem itemMediaUmat = new JMenuItem("Media Umat    ",icmediaumat);
   JMenuItem itemKeluar = new JMenuItem("Keluar    ",icexit);
   JMenuItem itemUser = new JMenuItem("User",icuser);
   JMenuItem itemPemesanan = new JMenuItem("Pemesanan Media Umat ",icpemesanan);
   JMenuItem itemPembayaran = new JMenuItem("Pembayaran Media Umat    ",icpembayaran);
   JMenuItem itemAboutThisProgram = new JMenuItem("About This Program    ",icaboutthisprogram);
   JMenuItem itemAboutProgrammer = new JMenuItem("About Programmer    ",icme);

   JButton pelanggan = new JButton(new ImageIcon("image/image/user.png"));
   JButton mediaumat = new JButton(new ImageIcon("image/image/mediaumat.png"));
   JButton pemesanan = new JButton(new ImageIcon("image/image/pemesanan.png"));
   JButton pembayaran = new JButton(new ImageIcon("image/image/pembayaran.png"));
   JButton view = new JButton(new ImageIcon("image/image/cetak.png"));
   JButton ttgprogram = new JButton(new ImageIcon("image/image/help.png"));

   Date kalender=new Date();
   int day=kalender.getDay();
   int date=kalender.getDate();
   int month=kalender.getMonth();
   int year=kalender.getYear()+1900;

   String hari[]={"Ahad", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu",};
   String bulan[]={"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
   JLabel tanggal=new JLabel ();

   JProgressBar loading = new JProgressBar();
   public Timer timer;
   int i =0;

   Utama()
   {
      super("SISTEM INFORMASI MEDIA UMMAT Versi 11.1");
      java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
      setSize(750,650);
      java.awt.Dimension dialogSize = getSize();
      setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   void KomponenVisual()
   {
       setIconImage(icon1.getImage());

       getContentPane().add(lbtgl);
       lbtgl.setBounds(450,7,280,30);
       lbtgl.setFont(new Font("Georgia",Font.BOLD,20));
       lbtgl.setForeground(Color.white);
       getContentPane().add(lbjam);
       lbjam.setBounds(510,27,200,30);
       lbjam.setFont(new Font("Georgia",Font.BOLD,20));
       lbjam.setForeground(Color.white);

       /*label copyright
       JLabel lbotentics=new JLabel("( copyright@syababuin08#Juraiz Al-Harits Al-Hizby )");
       getContentPane().add(lbotentics);
       lbotentics.setBounds(200,40,300,30);
       lbotentics.setFont(new Font("MV Boli",Font.BOLD,17));     */

       // button
       getContentPane().add(pelanggan);
       pelanggan.setBounds(212,450,52,52);
       pelanggan.setOpaque(false);
       pelanggan.setToolTipText("Sign Up");
       pelanggan.setCursor(new Cursor(Cursor.HAND_CURSOR));
       getContentPane().add(mediaumat);
       mediaumat.setBounds(267,450,52,52);
       mediaumat.setOpaque(false);
       mediaumat.setToolTipText("Rekap Med.Umat");
       mediaumat.setCursor(new Cursor(Cursor.HAND_CURSOR));
       getContentPane().add(pemesanan);
       pemesanan.setBounds(320,450,52,52);
       pemesanan.setOpaque(false);
       pemesanan.setToolTipText("Pemesanan Media Umat");
       pemesanan.setCursor(new Cursor(Cursor.HAND_CURSOR));
       getContentPane().add(pembayaran);
       pembayaran.setBounds(373,450,52,52);
       pembayaran.setOpaque(false);
       pembayaran.setToolTipText("Pembayaran Media Umat");
       pembayaran.setCursor(new Cursor(Cursor.HAND_CURSOR));
       getContentPane().add(view);
       view.setBounds(426,450,52,52);
       view.setOpaque(false);
       view.setToolTipText("Cetak Data Pembayaran");
       view.setCursor(new Cursor(Cursor.HAND_CURSOR));
       getContentPane().add(ttgprogram);
       ttgprogram.setBounds(479,450,52,52);
       ttgprogram.setOpaque(false);
       ttgprogram.setToolTipText("Tentang Program ini");
       ttgprogram.setCursor(new Cursor(Cursor.HAND_CURSOR));

       setJMenuBar(mnuBar);

       itemPelanggan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
       mnuFile.add(itemPelanggan);
       itemMediaUmat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
       mnuFile.add(itemMediaUmat);
       itemKeluar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));
       //mnuFile.addSeparator();
       mnuFile.add(itemKeluar);

       mnuEdit.add(itemUser);
       //mnuEdit.addSeparator();
       itemUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));

       itemPemesanan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_MASK));
       mnuReport.add(itemPemesanan);
       itemPembayaran.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,KeyEvent.CTRL_MASK));
       mnuReport.add(itemPembayaran);

       itemAboutThisProgram.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_MASK));
       mnuAbout.add(itemAboutThisProgram);
       itemAboutProgrammer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,KeyEvent.CTRL_MASK));
       mnuAbout.add(itemAboutProgrammer);

       mnuBar.add(mnuFile);
       mnuBar.add(mnuReport);
       mnuBar.add(mnuEdit);
       mnuBar.add(mnuAbout);

       getContentPane().add(loading);
       loading.setBounds(20,530,700,30);
       loading.setVisible(false);
       //loading = new JProgressBar(0,100);
       //loading.setValue(0);
       //loading.setStringPainted(true);

       getContentPane().add(gambar1);
       gambar1.setBounds(0,0,500,500);
       show();
       setResizable(false);
       setVisible(true);
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
      Utama u=new Utama();
      u.KomponenVisual();
      u.jam();
      //u.aksireaksi();
   }
}