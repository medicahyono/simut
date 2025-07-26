import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AboutThisProgram extends JFrame
{
    JLabel gambar1=new JLabel(new ImageIcon("image/ImgeAbout.JPG"));
    ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");

    JLabel lbqardh=new JLabel ("Sistem Informasi Media Umat");
    JTextArea lbtentang=new JTextArea (
    "   "+"Media Umat Adalah merupakan Sarana Informasi yg"+
    "\n"+"berkaitan dengan berita2 terbaru, ter update, ter-"+
    "\n"+"kini baik berupa berita2 politik, agama, atau lain"+
    "\n"+"nya.Semua dicakup dan diliput di dalam media cetak"+
    "\n"+"ini. Oleh karena itu untuk memudahkan proses tran-"+
    "\n"+"saksi dibuatlah "+"Sistem Informasi Media Umat"+"."+
    "\n"+
    "\n"+"   Jika Anda Tertarik, dan membutuhkan solusi ten-"+
    "\n"+"tang SOFTWARE untuk segala permasalahan anda.  Si-"+
    "\n"+"lahkan hubungi programmer di No.Hp 085731372643"+
    "\n"+
    "\n"+
    "\n"+"Saran & Masukan silahkan kirim ke email programmer"+
    "\n"+"             [ediuinmaliki@gmail.com]");

    JButton btback=new JButton("OK");

    AboutThisProgram()
    {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setTitle("About This Program");
       setSize(410,350);
       int lebar = (screen.width-getSize().width) / 2;
       int tinggi = (screen.height-getSize().height) / 2;
       setLocation(lebar, tinggi);
       setResizable(false);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void KomponenVisual ()
    {
       setIconImage(icon1.getImage());
       getContentPane().setLayout(null);

       getContentPane().add(lbqardh);
       lbqardh.setBounds(80,20,250,20);
       lbqardh.setFont(new Font("Callibri",Font.BOLD,17));
       lbqardh.setForeground(new java.awt.Color(220,225,150));

       getContentPane().add(lbtentang);
       lbtentang.setBounds(20,50,365,210);
       lbtentang.setEditable(false);
       lbtentang.setFont(new Font("Consolas",Font.PLAIN,12));
       lbtentang.setForeground(Color.BLACK);
       lbtentang.setBackground(new java.awt.Color(220,225,150));
       //lbtentang.setBackground(new java.awt.Color(0,40,150));

       getContentPane().add(btback);
       btback.setBounds(300,275,80,30);
       getContentPane().add(gambar1);
       gambar1.setBounds(-70,-70,500,500);
       setVisible (true);
    }

    void AksiReaksi()
    {
        btback.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
              setVisible(false);
           }
        });
    }

    public static void main (String []args)
    {
         try
         {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         }
         catch(Exception exc)
         {

         }
         AboutThisProgram ab=new AboutThisProgram();
         ab.KomponenVisual();
         ab.AksiReaksi();
    }
}