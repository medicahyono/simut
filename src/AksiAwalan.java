import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class AksiAwalan extends Awalan      // ini dibuat dari turunan kelas <awalan >
{
   void AksiReaksi()
   {
       btmulai.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
             try
             {
                 Loading load = new Loading();                     // ini adalah isi dari < btmulai >
                 load.tampil();  //method tampil                   // diambil dari kelas < Loading >
                 load.pro();     //method pro
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
                 String msg="Are u sure?";
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

    public static void main(String args[])                                       // untuk method <AksiHalPertama > harus sama dengan method yang ada pd < HalamanPertama> karena berlaku inheritense tersebut
    {                                                                            // method main di sini tidak ditulis tidak apa-apa
      Awalan awl=new Awalan();
      awl.AksiReaksi();                                                           // method tampil dan method pro tidak bisa di panggil dari sini karena method tsb tdk ada di kelas ini
    }
}