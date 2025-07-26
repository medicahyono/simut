import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

class SIMEDIAUMAT
{
   public static void main(String args[])
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