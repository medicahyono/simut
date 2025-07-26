import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class Loading extends JFrame
{
   JLabel gambar1=new JLabel(new ImageIcon("image/ok.jpg"));
   ImageIcon icon1=new ImageIcon("image/UIN MALANG.gif");
   JLabel lbgmbr=new JLabel(new ImageIcon("image/loading.GIF"));
   JProgressBar proses = new JProgressBar();
   private Timer timer;
   JLabel tulisan = new JLabel("");
   int i = 0;

   Loading()
   {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       //setTitle ("LOADING... ");
       setSize(570,100);
       int lebar = (screen.width-getSize().width) / 2;
       int tinggi = (screen.height-getSize().height) / 2;
       setLocation(lebar, tinggi);
       setResizable(false);
       //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       setUndecorated(true);
   }
   void tampil()
   {
       setIconImage(icon1.getImage());

       getContentPane().setLayout(null);
       proses = new JProgressBar(0,100);
       proses.setValue(0);
       proses.setStringPainted(true);

       getContentPane().add(proses);
       proses.setBounds(15,50,530,35);
       getContentPane().add(tulisan);
       tulisan.setBounds(15,30,250,25);
       tulisan.setFont(new Font("Anasthesia",Font.BOLD,13));

       getContentPane().add(lbgmbr);
       lbgmbr.setBounds(500,10,50,50);
       getContentPane().add(gambar1);
       gambar1.setBounds(0,-150,700,500);
       setResizable(false);
       setVisible(true);
   }

   void pro()
   {
       timer = new Timer(30, new ActionListener()
       {
           public void actionPerformed(ActionEvent evt)
           {
               i++;  //penambahan value
               proses.setValue(i);
               double b =proses.getPercentComplete();
               if(proses.getPercentComplete()==0.01)
               {
                  tulisan.setText("Created by. . .");
               }
               if(proses.getPercentComplete()==0.40)
               {
                  tulisan.setText("Syabab UIN MALIKI . . .");
               }
               if(proses.getPercentComplete()==0.55)
               {
                  tulisan.setText(". . .");
               }
               if(proses.getPercentComplete()==0.60)
               {
                  tulisan.setText(" Muhammad Edi Cahyono ");
               }
               if(proses.getPercentComplete()==0.8)
               {
                  tulisan.setText("Reading Project");
               }
               if(proses.getPercentComplete()==0.85)
               {
                  tulisan.setText("Preparing Class. . .");
               }
               if(proses.getPercentComplete()==0.87)
               {
                  tulisan.setText("Last Process . . .");
               }
               if(proses.getPercentComplete()==0.9)
               {
                  tulisan.setText("Loading DataBase Source . . .");
               }
               if(proses.getPercentComplete()==0.95)
               {
                  tulisan.setText("Complete 100% . . .");
               }
               if(proses.getPercentComplete()==1.0)
               {
                  tulisan.setBounds(70,40,200,100);
                  timer.stop();
                  //JOptionPane.showMessageDialog(null,"Completed !!!");
                  proses.setValue(proses.getMinimum());
                  setVisible(false);

                  Reaksi rk=new Reaksi();                                       // dipanggil dari kelas REAKSI.JAVA
                  rk.AksiReaksi();                                              // gunanya yaitu untuk mengkonekkkan <LOADING > dengan Item2 yang ada di klass reaksi
                  rk.KomponenVisual();
                  rk.jam();
               }
           }
       });
       timer.start();
   }

   public static void main(String args[])
   {
     try
     {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     }
     catch (Exception e)
     {
        System.err.println(e);
     }
     Loading load = new Loading();
     load.tampil();
     load.pro();

   }
}