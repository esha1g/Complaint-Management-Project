
package javaapplication11;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clscmp 
{
 
    /**
     *
     * @param p
     * @return
     */
    public void inscmp(cmpprp p) 
 {
   try{
     d2hcon.getcon();
     CallableStatement stm=d2hcon.con.prepareCall("{call inscmp(?,?,?,?,?)}");
     stm.setInt(1,p.getCmpaccno());
      java.sql.Date s = new java.sql.Date(p.getCmpdat().getTime());
            stm.setDate(2,s);
    // stm.setDate(2, (Date) p.getCmpdat());
     stm.setString(3,p.getCmpdsc());
     stm.setInt(4,p.getCmpasgempcod());
     stm.setString(5,p.getCmpsts());
     //stm.registerOutParameter(6,Types.INTEGER);
     
     stm.execute();
      //int a=stm.getInt(6);
            d2hcon.closecon();
            //return a;
     }
     catch(Exception exp)
        {
            exp.printStackTrace();
            
        }
           
  } 
 
 
 public void updcmp(cmpprp p) throws SQLException
 {
     try
     {
     d2hcon.getcon();
     CallableStatement stm = d2hcon.con.prepareCall("{call updcmp(?,?,?,?,?,?)}");
     stm.setInt(1,p.getCmpaccno());
    stm.setDate(2, (Date) p.getCmpdat());
    stm.setString(3,p.getCmpdsc());
    stm.setInt(4,p.getCmpasgempcod());
     stm.setString(5,p.getCmpsts());
     stm.setInt(6,p.getCmpcod());
     stm.execute();
     d2hcon.closecon();
 }
     catch(Exception exp)
     {
        exp.printStackTrace();
     }
 }
  
 public void delcmp(cmpprp p) throws IOException, ClassNotFoundException, SQLException
 {
     d2hcon.getcon();
     CallableStatement stm = d2hcon.con.prepareCall("{(call delcmp(?)}");
     stm.setInt(1,p.getCmpcod());
     stm.execute();
     d2hcon.closecon();
 }
  public ResultSet dispcmpofmonth()  
  {
      ResultSet rs=null;
      try {
          d2hcon.getcon();
          CallableStatement stm=d2hcon.con.prepareCall("{call dispcurrmonthrep()}");
         
          rs=stm.executeQuery();
         // obj.disconnect();
      } catch (SQLException ex) {
          Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException | ClassNotFoundException ex) {
         Logger.getLogger(clscmp.class.getName()).log(Level.SEVERE, null, ex);
     }
    
      return rs;
  }
 
 public cmpprp findcmp(int ccod) throws SQLException 
 {
     cmpprp p=new cmpprp();
     try{
     javax.swing.JOptionPane.showMessageDialog(null,"compliant no. "+ccod);
     d2hcon.getcon();
     CallableStatement stm=d2hcon.con.prepareCall("{call findcmp(?)}");
     stm.setInt(1,ccod);
     ResultSet rs=stm.executeQuery();
     
     if(rs.next())
     {
         p.setCmpcod(rs.getInt("cmpcod"));
                p.setCmpaccno(rs.getInt("cmpaccno"));
               p.setCmpdat(rs.getDate("cmpdat"));
                p.setCmpdsc(rs.getString("cmpdsc"));               
                p.setCmpasgempcod(rs.getInt("cmpasgempcod"));
               p.setCmpsts(rs.getString("cmpsts"));
     }
     d2hcon.closecon();
     }
     catch(Exception exp)
     {
         exp.printStackTrace();
     }
     
     return p;
 }
 
 
 public List <cmpprp> dspcmp() throws SQLException 
 {
     List<cmpprp> k=new ArrayList<cmpprp>();
     try{
  d2hcon.getcon();
  CallableStatement stm=d2hcon.con.prepareCall("{call dspcmp()}");
  ResultSet rs=stm.executeQuery();
  
  while(rs.next())
  {
      cmpprp p=new cmpprp();
      p.setCmpcod(rs.getInt("cmpcod"));
      p.setCmpaccno(rs.getInt("cmpano"));
      p.setCmpdat(rs.getDate("cmpdat"));
      p.setCmpdsc(rs.getString("cmpdsc"));
      p.setCmpasgempcod(rs.getInt("cmpasgempcod"));
      p.setCmpsts(rs.getString("cmpsts"));
      k.add(p);
  }
  d2hcon.closecon();
     }
     catch(Exception exp)
     {
         exp.printStackTrace();
     }
  return k;
  }     
}
