
package javaapplication11;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class clsvst
{
public void insvst(vstprp p) throws IOException, ClassNotFoundException, SQLException
 {
     d2hcon.getcon();
     CallableStatement stm=d2hcon.con.prepareCall("{call insvst(?,?,?,?)}");
     stm.setDate(1, new java.sql.Date(p.getVstdat().getYear()+1900,p.getVstdat().getMonth()+1,p.getVstdat().getDate()));
     //stm.setDate(1,new java.sql.Date(p.getVstdat()));
     stm.setInt(2,p.getVstcmpcod());
     stm.setString(3,p.getVstdsc());
     stm.setInt(4,p.getVstfed());
     stm.execute();
     d2hcon.closecon();
 } 
 
 public void updvst(vstprp p) throws IOException, ClassNotFoundException, SQLException
 {
     d2hcon.getcon();
     CallableStatement stm = d2hcon.con.prepareCall("{call updvst(?,?,?,?,?)}");
     stm.setInt(1,p.getVstcod());
     stm.setDate(2, (Date) p.getVstdat());
     stm.setString(3,p.getVstdsc());
     stm.setInt(4,p.getVstfed());
     stm.setInt(5,p.getVstcmpcod());
     stm.execute();
     d2hcon.closecon();
 }
  
 public void delvst(vstprp p) throws IOException, ClassNotFoundException, SQLException
 {
     d2hcon.getcon();
     CallableStatement stm = d2hcon.con.prepareCall("{(call delvst(?)}");
     stm.setInt(1,p.getVstcod());
     stm.execute();
     d2hcon.closecon();
 }
 
 public vstprp findvst(int vcod) throws IOException, ClassNotFoundException, SQLException
 {
     d2hcon.getcon();
     CallableStatement stm=d2hcon.con.prepareCall("{call findvst(?)}");
     stm.setInt(1,vcod);
     ResultSet rs=stm.executeQuery();
     vstprp p=new vstprp();
     if(rs.next())
     {
         p.setVstcod(rs.getInt("vstcod"));
         p.setVstdat(rs.getDate("vstdat"));
         p.setVstcmpcod(rs.getInt("vstcpcod"));
         p.setVstdsc(rs.getString("vstdsc"));
         p.setVstfed(rs.getInt("vstfed"));
     }
     d2hcon.closecon();
     return p;
 }
 
 
 public List <vstprp> dspvst() throws IOException, ClassNotFoundException, SQLException
 {
  d2hcon.getcon();
  CallableStatement stm=d2hcon.con.prepareCall("{call dspvst()}");
  ResultSet rs=stm.executeQuery();
  List<vstprp> k=new ArrayList<vstprp>();
  while(rs.next())
  {
      vstprp p=new vstprp();
      p.setVstcod(rs.getInt("vstcod"));
      p.setVstdat(rs.getDate("vstdat"));
      p.setVstcmpcod(rs.getInt("vstcpcod"));
      p.setVstdsc(rs.getString("vstdsc"));
      p.setVstfed(rs.getInt("vstfed"));
      k.add(p);
  }
  d2hcon.closecon();
  return k;
  }


    
}
