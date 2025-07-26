import javax.swing.text.*;
import javax.swing.*;

class saring_karakter
{
  public saring_karakter()
  {
  }

  /** methode ini dipakai untuk mengeset dan mendapatkan filter
   *  @return mengembalikan filter bertype PlainDocument
   *  Menyaring Hanya karakter angka (Digit) yang bisa dimasukkan
   */
  public PlainDocument getOnlyDigit()
  {
    PlainDocument filterDigit = new PlainDocument()
    {
      public void insertString(int offs, String str, AttributeSet a) throws
      BadLocationException
      {
        StringBuffer buffer = new StringBuffer();
        int s = 0;
        char[] dataInput = str.toCharArray();
        // Memeriksa semua data yang dimasukkan
        for (int i = 0; i < dataInput.length; i++)
        {
          // Menyaring Apakah data masukkan berupa DIGIT ??
          boolean isOnlyDigit = Character.isLetter(dataInput[i]);
          if (isOnlyDigit == false)
          {
            dataInput[s] = dataInput[i];
            s++;
          }
        }
        buffer.append(dataInput, 0, s);
        super.insertString(offs, new String(buffer), a);
      }
    };
    return filterDigit;
  }

  /** methode ini dipakai untuk mengeset dan mendapatkan filter
   *  @return mengembalikan filter bertype PlainDocument
   *  Menyaring Hanya karakter huruf (Letter) yang bisa dimasukkan
   */
  public PlainDocument getOnlyLetter()
  {
    PlainDocument filterLetter = new PlainDocument()
    {
      public void insertString(int offs, String str, AttributeSet a) throws
      BadLocationException
      {
        StringBuffer buffer = new StringBuffer();
        int s = 0;
        char[] dataInput = str.toCharArray();
        // Memeriksa semua data yang dimasukkan
        for (int i = 0; i < dataInput.length; i++)
        {
          // Menyaring Apakah data masukkan berupa LETTER ??
          boolean isOnlyLetter = Character.isDigit(dataInput[i]);

          if (isOnlyLetter == false)
          {
            dataInput[s] = dataInput[i];
            s++;
          }
        }
        buffer.append(dataInput, 0, s);
        super.insertString(offs, new String(buffer), a);
      }
    };
    return filterLetter;
  }

  /** methode ini dipakai untuk mengeset dan mendapatkan filter
   *  @return mengembalikan filter bertype PlainDocument
   *  Menyaring Karakter menjadi hurif besar (Upper Case)
   */
  public PlainDocument getToUpperCase()
  {
    PlainDocument filterUpper = new PlainDocument()
    {
      public void insertString(int offs, String str, AttributeSet a) throws
      BadLocationException
      {
        char[] upper = str.toCharArray();
        for (int i = 0; i < upper.length; i++)
        {
          // Menjadi upper case
          upper[i] = Character.toUpperCase(upper[i]);
        }
        super.insertString(offs, new String(upper), a);
      }
    };
    return filterUpper;
  }
}