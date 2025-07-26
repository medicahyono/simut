import javax.swing.*;
import java.awt.event.*;

class Reaksi extends Utama
{
   void AksiReaksi()
   {
       itemPelanggan.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());
                       Pelanggan pel=new Pelanggan();
                       pel.komponenVisual();
                       pel.aksiReaksi();
                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       itemMediaUmat.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());
                       MediaUmat pel=new MediaUmat();
                       pel.komponenVisual();
                       pel.aksiReaksi();
                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       itemUser.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());
                       User us= new User();
                       us.komponenVisual();
                       us.aksiReaksi();
                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       itemPemesanan.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());

                       Pemesanan pem =new Pemesanan();
                       pem.komponenVisual();
                       pem.aksiReaksi();

                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       itemPembayaran.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());
                       Pembayaran pem =new Pembayaran();
                       pem.komponenVisual();
                       pem.aksiReaksi();
                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       itemKeluar.addActionListener(new ActionListener()
       {
         @Override
		public void actionPerformed(ActionEvent evt)
         {
           try
           {
             timer = new Timer(7, new ActionListener()
             {
                @Override
				public void actionPerformed(ActionEvent e)
                {

                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());

                       String msg="Anda Yakin Menutup Program?";
                       int result = JOptionPane.showOptionDialog(null,new Object[] {msg},"Konfirmasi", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon("AlienAqua Help.png"),null, null);
                       if(result==JOptionPane.YES_OPTION)
                       {
                          Awalan awl= new Awalan ();
                          awl.KomponenVisual();                                                        // yang memunculkan KOMPONEN DALAM KELAS <HalamanPertama>
                          awl.jam();                                                                   // yang menmunculkan HARI,JAM,dan TANGGAL
                          awl.AksiReaksi();
                          //System.exit(0);
                       }

                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                       setVisible(false);

                       AksiAwalan rk=new AksiAwalan();
                       rk.AksiReaksi();
                       rk.KomponenVisual();
                       rk.jam();
                     }
                }
             });
             timer.start();
           }
           catch(Exception e)
           {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error"+e);
           }
         }
       });

       itemAboutProgrammer.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());

                       Programmer prog= new Programmer ();
                       prog.KomponenVisual();
                       prog.Aksi();

                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       itemAboutThisProgram.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());

                       AboutThisProgram ab=new AboutThisProgram();
                       ab.KomponenVisual();
                       ab.AksiReaksi();

                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });
       pelanggan.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());
                       Pelanggan pel=new Pelanggan();
                       pel.komponenVisual();
                       pel.aksiReaksi();
                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       mediaumat.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());
                       MediaUmat pel=new MediaUmat();
                       pel.komponenVisual();
                       pel.aksiReaksi();
                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       pemesanan.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());

                       Pemesanan pem =new Pemesanan();
                       pem.komponenVisual();
                       pem.aksiReaksi();

                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       pembayaran.addActionListener(new ActionListener()
       {
          @Override
		public void actionPerformed(ActionEvent evt)
          {
             try
             {
                timer = new Timer(7, new ActionListener()
                {
                   @Override
				public void actionPerformed(ActionEvent e)
                   {
                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());
                       Pembayaran pem =new Pembayaran();
                       pem.komponenVisual();
                       pem.aksiReaksi();
                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                   }
                });
                timer.start();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error"+e);
             }
          }
       });

       // button
       ttgprogram.addActionListener(new ActionListener()
       {
         @Override
		public void actionPerformed(ActionEvent evt)
         {
           try
           {
             timer = new Timer(7, new ActionListener()
             {
                @Override
				public void actionPerformed(ActionEvent e)
                {

                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());
                       AboutThisProgram ab=new AboutThisProgram();
                       ab.KomponenVisual();
                       ab.AksiReaksi();

                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                }
             });
             timer.start();
           }
           catch(Exception e)
           {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error"+e);
           }
         }
       });

       view.addActionListener(new ActionListener()
       {
         @Override
		public void actionPerformed(ActionEvent evt)
         {
           try
           {
             timer = new Timer(7, new ActionListener()
             {
                @Override
				public void actionPerformed(ActionEvent e)
                {

                     loading.setVisible(true);
                     i++;
                     loading.setValue(i);
                     double ld=loading.getPercentComplete();
                     if(loading.getPercentComplete()==1.0)
                     {
                       loading.setValue(loading.getMinimum());
                       KonekPembayaran kp= new KonekPembayaran();
                       kp.cetakPembayaran();

                       i=0;
                       timer.stop();
                       loading.setVisible(false);
                     }
                }
             });
             timer.start();
           }
           catch(Exception e)
           {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error"+e);
           }
         }
       });

    }

    public static void main(String args[])
    {
       Reaksi rea= new Reaksi();
       rea.AksiReaksi();
    }
}