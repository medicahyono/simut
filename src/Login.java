import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import java.sql.*;

public class Login extends JFrame
{
    JLabel head=new JLabel(new ImageIcon("image/head1.png"));
    JLabel foot=new JLabel(new ImageIcon("image/foot3.png"));
    JLabel exit= new JLabel("");
    private ImageIcon icon=new ImageIcon("image/key.png");
    //JLabel gb2=new JLabel(new ImageIcon("AlienAqua avedesk.png"));
    private ImageIcon icon1=new ImageIcon("image/undo.gif");
    private ImageIcon icon2=new ImageIcon("image/icon_extract.gif");
    private ImageIcon icon3= new ImageIcon("image/help.png");
    JPanel panel0=new JPanel();
    JPanel panel1=new JPanel();
    JPanel panel2=new JPanel();
    JPanel panel3=new JPanel();
    JPanel panel4=new JPanel();
    JLabel lbfoto=new JLabel(new ImageIcon("image/user.png"));
    JLabel lbuser= new JLabel("Username");
    JTextField txuser= new JTextField();
    JLabel lbtulisan=new JLabel("** Please Enter Username And Password! **");
    JLabel lbpasword=new JLabel("Password");
    JPasswordField txpasword=new JPasswordField();
    JButton btlogin=new JButton("Login",icon2);
    JButton btcancel=new JButton("Cancel",icon1);
    JButton bthelp= new JButton ("Help",icon3);


    Login()
    {
       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       setTitle("Login");
       setSize(380,230);
       int lebar = (screen.width-getSize().width) / 2;
       int tinggi = (screen.height-getSize().height) / 2;
       setLocation(lebar, tinggi);
       setResizable(false);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setUndecorated(true);
       //setAlwaysOnTop(true);

    }

    void KomponenVisual()
    {
       getContentPane().setBackground(Color.LIGHT_GRAY);

       setIconImage(icon.getImage());
       lbtulisan.setPreferredSize(new Dimension(300,20));
       lbuser.setPreferredSize(new Dimension(85,20)); // panjang,lebar <lb user>
       lbuser.setForeground(Color.RED);
       txuser.setPreferredSize(new Dimension(130,20)); //panjang,lebar <tx user>
       txuser.setOpaque(false);
       lbpasword.setPreferredSize(new Dimension(85,20));
       lbpasword.setForeground(Color.red);
       txpasword.setPreferredSize(new Dimension(130,20));
       txpasword.setOpaque(false);

       getContentPane().add(exit);
       exit.setIcon(new ImageIcon("image/Fex.png"));
       exit.setBounds(0,-2,50,20);

       getContentPane().add(head);
       head.setBounds(-2,-5,600,30);

       getContentPane().add(foot);
       foot.setBounds(-2,205,600,30);

       getContentPane().add(lbtulisan);
       lbtulisan.setForeground(Color.white);
       lbtulisan.setBounds(50,30, 350,30);

       getContentPane().add(lbuser);
       lbuser.setBounds(40,95, 150,20);
       getContentPane().add(txuser);
       txuser.setFont(new Font("Arial",Font.BOLD,14));
       txuser.setBounds(140,95, 180,20);
       txuser.setForeground(Color.BLACK);
       //txuser.setBackground(new Color(130,0,0));
       //txuser.setDragEnabled(true);
       txuser.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,Color.red));

       getContentPane().add(lbpasword);
       lbpasword.setBounds(40,120, 150,20);
       getContentPane().add(txpasword);
       txpasword.setBounds(140,120, 180,20);
       txpasword.setFont(new Font("Arial",Font.BOLD,18));
       txpasword.setForeground(Color.BLACK);
       txpasword.setBorder(BorderFactory.createEtchedBorder(Color.lightGray, Color.red));

       getContentPane().add(bthelp);
       bthelp.setOpaque(false);
       bthelp.setBounds(40, 170, 70, 20) ;
       bthelp.setToolTipText("Help") ;
       bthelp.setCursor(new Cursor(Cursor.HAND_CURSOR));
       bthelp.setBorder(BorderFactory.createRaisedBevelBorder());

       getContentPane().add(btlogin);
       btlogin.setBounds(140, 170, 80, 20) ;
       btlogin.setToolTipText("Masuk") ;
       btlogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
       //btlogin.setOpaque(false);
       //btlogin.setFocusPainted(false);
       //btlogin.setContentAreaFilled(true);
       //btlogin.setBackground(Color.red);
       btlogin.setBorder(BorderFactory.createRaisedBevelBorder());

       getContentPane().add(btcancel);
       btcancel.setBounds(240, 170, 80,20);
       btcancel.setToolTipText("Batal");
       btcancel.setBorder(BorderFactory.createRaisedBevelBorder());
       //setVisible(true);

       lbuser.setFont(new Font("Agency FB",Font.BOLD,15));
       lbpasword.setFont(new Font("Agency FB",Font.BOLD,13));
       lbtulisan.setFont(new Font("Agency FB",Font.BOLD,20));
       getContentPane().add(lbfoto);
       lbfoto.setBounds(0,0,173,130);

     /*
       panel0.add(lbfoto);
       panel0.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));      // 5 5 adalah jarak antar panel
       panel0.setOpaque(true);

       panel1.add(lbuser);
       panel1.add(txuser);
       panel1.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
       panel1.setOpaque(false);

       panel2.add(lbpasword);
       panel2.add(txpasword);
       panel2.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));

       panel3.add(panel0);
       panel3.add(panel1);
       panel3.add(panel2);
       panel3.setBorder(BorderFactory.createCompoundBorder(
          BorderFactory.createEmptyBorder(20,10,10,20),  //20 merupakan jarak tepi kanan  dg panel yang lain
          BorderFactory.createBevelBorder(BevelBorder.LOWERED)));

       panel4.add(btlogin);
       panel4.add(btcancel);
       panel4.setLayout(new GridLayout(1,0,5,5));// posisi button login dan panjang pendeknya
       panel4.setBorder(BorderFactory.createCompoundBorder(
          BorderFactory.createEmptyBorder(20,10,10,20),
          BorderFactory.createBevelBorder(BevelBorder.LOWERED)));// 20 tsb adl batas kiri dari tombol <cancel>

       getContentPane().add(panel3,"Center");
       getContentPane().add(panel4,"South"); */

       setVisible(true);
    }

    void aksi()
    {
       // exit
       exit.addMouseListener(new MouseAdapter()
       {
          public void mouseEntered(MouseEvent e)
          {
             exit.setIcon( new ImageIcon("image/fex2.png"));
          }
          public void mouseExited(MouseEvent e)
          {
             exit.setIcon(new ImageIcon("image/fex.png"));
          }
          public void mousePressed(MouseEvent e)
          {
            System.exit(0);
          }
       });


       btlogin.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent evt)
          {
             try
             {

           /*
                String hasil="0";
                String sql = "Select count(*) as jml from tbUser where username = '"+txUserName.getText().trim()+"' "+"and password='"+txPassword.getText().trim()+"' ";
                stat = koneksi.con.createStatement();
                set = stat.executeQuery(sql);
                set.next(); */

                String hasil="0";
                String dbname="jdbc:odbc:SIMEDIAUMAT";
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
                Statement statement = con.createStatement();
                Statement state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                String sql="Select count(*) as jml from tbUser where username= '"+txuser.getText().trim()+"' "+" and password= '"+txpasword.getText().trim()+"'";
                ResultSet rs=state.executeQuery(sql);
                rs.next();

                hasil =rs.getString("jml");
                if (Integer.valueOf(hasil)> 0)
                {
                   System.out.println("Login Sukses!");
                   AksiAwalan aw= new AksiAwalan();
                   aw.AksiReaksi();
                   aw.KomponenVisual();
                   aw.jam();
                   aw.setVisible(true);
                   dispose();
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "Login GAGAL");
                   System.out.println("Login GAGAL");
                }
                System.out.println("isi jml :"+hasil);
             }
             catch (Exception e)
             {
               // System.out.println("Kesalahan : "+e.toString());
               JOptionPane.showMessageDialog(null, "Mohon Periksa kembali Username dan password Anda\nUntuk mendapatkan Password & Username \nHubungi ediuinmaliki@gmail.com !!",".:Warning:.",JOptionPane.INFORMATION_MESSAGE);
               txuser.setText("");
               txpasword.setText("");
               txuser.requestFocus();
             }
          }
             /*try
             {
                String u = txuser.getText();
                String p = txpasword.getText();

                if((u.equals("edi"))&&(p.equals("syababuin")))
                {
                   //this.setVisible(false);
                   AksiAwalan aw= new AksiAwalan();// memanggil berawal dari aksi yang paling awal
                   aw.AksiReaksi();           // menuju ke kelas Reaksi.java karena method <AksiReaksi()> hanya ada dsana, tujuanya
                   aw.KomponenVisual();       // menuju ke kelas Utama.java  karena method <KomponenVisual()> hanya ada dsana
                   aw.jam();
                   aw.setVisible(true);
                   dispose();
                }
                else if((u.equals("juraiz"))&&(p.equals("alharitz")))
                {
                   AksiAwalan aw= new AksiAwalan();// memanggil berawal dari aksi yang paling awal
                   aw.AksiReaksi();           // menuju ke kelas Reaksi.java karena method <AksiReaksi()> hanya ada dsana, tujuanya
                   aw.KomponenVisual();       // menuju ke kelas Utama.java  karena method <KomponenVisual()> hanya ada dsana
                   aw.jam();
                   aw.setVisible(true);
                   dispose();
                }
                else if((u.equals("muhammadedi"))&&(p.equals("alfatih")))
                {
                   AksiAwalan aw= new AksiAwalan();// memanggil berawal dari aksi yang paling awal
                   aw.AksiReaksi();           // menuju ke kelas Reaksi.java karena method <AksiReaksi()> hanya ada dsana, tujuanya
                   aw.KomponenVisual();       // menuju ke kelas Utama.java  karena method <KomponenVisual()> hanya ada dsana
                   aw.jam();
                   aw.setVisible(true);
                   dispose();
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "Mohon Periksa kembali Username dan password Anda\nUntuk mendapatkan Password & Username \nHubungi ediuinmaliki@gmail.com !!",".:Warning:.",JOptionPane.INFORMATION_MESSAGE);
                   txuser.setText("");
                   txpasword.setText("");
                   txuser.requestFocus();
                }
             }
             catch(Exception ex)
             {
                System.out.println("Error \n"+ ex);
             } */

       });
       txuser.addKeyListener(new KeyAdapter()
       {
           public void keyPressed(KeyEvent event)
           {
             if(event.getKeyCode()==event.VK_ENTER)
               {
                 txpasword.requestFocus();
                 // TODO add your handling code here:
               }
           }
       });
       txpasword.addKeyListener(new KeyAdapter()
       {
           public void keyPressed(KeyEvent event)
           {
             if(event.getKeyCode()==event.VK_ENTER)
               {
                 btlogin.requestFocus();
                 // TODO add your handling code here:
               }
           }
       });

      btcancel.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            try
            {
               System.exit(0);
            }
            catch(Exception ex)
            {
               System.out.println("Error \n"+ ex);
            }
         }
      });
      bthelp.addActionListener( new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            JOptionPane.showMessageDialog(null, " Silahkan isi username pada kolom username \n dan isikan password pada kolom password \n jika anda tidak dapat login, \n Hubungi ediuinmaliki@gmail.com");
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
     {}
     Login L=new Login();
     L.KomponenVisual();
     L.aksi();
  }
}