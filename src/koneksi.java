import java.sql.*;
import javax.swing.*;

public class koneksi
{
    void testkoneksi()
    {
        try
        {
            String dbname="jdbc:odbc:SIMEDIAUMAT";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection(dbname,"SIMEDIAUMAT","SIMEDIAUMAT");
            JOptionPane.showMessageDialog(null, "Koneksi sudah shohih ","Insert Data",JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Koneksi Masih belum berhasil \nHubungi Programmer di eduinmaliki@gmail.com ",".:Eror:. ",JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main (String args[])
    {
        koneksi test = new koneksi();
        test.testkoneksi();
        System.exit(0);
    }
}