
package javaapplication11;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class d2hcon 
{
  static Connection con;
 public static void getcon() throws IOException, ClassNotFoundException, SQLException
 {
     if(con==null)
     {
         FileInputStream fis = new FileInputStream("admin.properties");
         Properties prp = new Properties();
         prp.load(fis);
         fis.close();
         Class.forName(prp.getProperty("driver"));
         con=DriverManager.getConnection(prp.getProperty("url"),prp.getProperty("unam"),"");
     }
 }
 
 public static void closecon() throws SQLException
 {
     if(con!=null)
         return;
     else
     {
         con.close();
         con=null;
     }
 }  
}
