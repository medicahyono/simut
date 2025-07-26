import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Programmer extends JFrame//JInternalFrame
{
   JLabel gambar1=new JLabel(new ImageIcon("image/CAMPUR (139).JPG"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   //JLabel lbdesain=new JLabel(new ImageIcon("image/designed.gif"));
   JLabel lbfotoq=new JLabel(new ImageIcon("image/me1.jpg"));

   JLabel lbme=new JLabel("Muhammad Edi Cahyono");
   JLabel lbnim=new JLabel("085731372643");
   JLabel lbemail=new JLabel("ediuinmaliki@gmail.com");
   JLabel lbweb=new JLabel("technologi-soko.wordpress.com");
   JLabel lbweb1=new JLabel("www.syababuin.co.cc");
   JButton btback=new JButton("OK");

   Programmer()
   {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setTitle("About Programmer");
       setSize(400,350);
       int lebar = (screen.width-getSize().width) / 2;
       int tinggi = (screen.height-getSize().height) / 2;
       setLocation(lebar, tinggi);
       setResizable(false);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       //setUndecorated(false);
   }

   void KomponenVisual()
   {
      setIconImage(icon1.getImage());
      getContentPane().setLayout(null);

      getContentPane().add(lbme);
      lbme.setBounds(30,170,300,20);
      lbme.setFont(new Font("Callibri",Font.BOLD,17));

      getContentPane().add(lbnim);
      lbnim.setBounds(30,200,300,20);
      //lbnim.setFont(new Font("MV Boli",Font.BOLD,17));
      lbnim.setFont(new Font("Agency FB",Font.BOLD,25));

      //getContentPane().add(lbdesain);
      //lbdesain.setBounds(0,100,173,130);

      getContentPane().add(lbfotoq);
      lbfotoq.setBounds(10,30,173,130);

      getContentPane().add(lbemail);
      lbemail.setBounds(30,220,300,20);
      lbemail.setFont(new Font("Agency FB",Font.BOLD,18));

      getContentPane().add(lbweb);
      lbweb.setBounds(30,240,300,20);
      lbweb.setFont(new Font("Agency FB",Font.BOLD,18));
      getContentPane().add(lbweb1);
      lbweb1.setBounds(30,260,320,20);
      lbweb1.setFont(new Font("Agency FB",Font.BOLD,18));
      getContentPane().add(btback);
      btback.setBounds(270,260,80,30);

      getContentPane().add(gambar1);
      gambar1.setBounds(-80,-70,500,500);
      //setResizable(false);
      setVisible(true);
   }

   void Aksi()
   {
      btback.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
             setVisible(false);
         }
      });
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
        Programmer prog= new Programmer ();
        prog.KomponenVisual();
        prog.Aksi();
   }

}