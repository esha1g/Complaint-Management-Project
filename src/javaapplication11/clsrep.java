
package javaapplication11;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clsrep 
{
    public ResultSet cmpasgbyemp(int ecod) 
  {
      ResultSet rs=null;
      try {
          d2hcon.getcon();
          CallableStatement stm=d2hcon.con.prepareCall("{call cmpasgbyemp(?)}");
          stm.setInt(1, ecod);
          rs=stm.executeQuery();
         // obj.disconnect();
      } catch (SQLException ex) {
          Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
            Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
        }
      return rs;
  }
    public ResultSet cmpforcurmon() 
  {
      ResultSet rs=null;
      try {
         d2hcon.getcon();
          CallableStatement stm=d2hcon.con.prepareCall("{call cmpforcurmon()}");
          rs=stm.executeQuery();
         // obj.disconnect();
      } catch (SQLException ex) {
          Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
            Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
        }
      return rs;
  }
     public ResultSet empprfformon() 
  {
      ResultSet rs=null;
      try {
          d2hcon.getcon();
          CallableStatement stm=d2hcon.con.prepareCall("{call empprfformon()}");
          rs=stm.executeQuery();
          //obj.disconnect();
      } catch (SQLException ex) {
          Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
            Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
        }
      return rs;
  }
}
