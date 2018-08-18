
package javaapplication11;

import java.io.IOException;
import static java.rmi.Naming.list;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

public class clsacc 
{
    
    
 public void insacc(accprp p) throws IOException, ClassNotFoundException, SQLException
 {
     d2hcon.getcon();
     CallableStatement stm=d2hcon.con.prepareCall("{call instb(?,?,?,?,?,?)}");
     stm.setString(1,p.getAccnam());
     java.sql.Date s=new java.sql.Date(p.getAacrtdat().getTime());
     stm.setDate(2, s);
     stm.setString(3,p.getAccadd());
     stm.setString(4,p.getAccloc());
     stm.setString(5,p.getAccphnno());
     stm.setString(6,p.getAcctyp());
     stm.execute();
     d2hcon.closecon();
 } 
 
 public void updacc(accprp p) throws IOException, ClassNotFoundException, SQLException
 {
     d2hcon.getcon();
     CallableStatement stm = d2hcon.con.prepareCall("{call updtb(?,?,?,?,?,?)}");
     stm.setInt(1,p.getAccno());
     stm.setString(2,p.getAccnam());
     stm.setString(3,p.getAccadd());
     stm.setString(4,p.getAccloc());
     stm.setString(5,p.getAccphnno());
     stm.setString(6,p.getAcctyp());
     stm.execute();
     d2hcon.closecon();
 }
  
 public void delacc(accprp p) throws IOException, ClassNotFoundException, SQLException
 {
     try{
     d2hcon.getcon();
     CallableStatement stm = d2hcon.con.prepareCall("{call deltb(?)}");
     stm.setInt(1,p.getAccno());
     stm.execute();
     d2hcon.closecon();
 }
     catch(Exception exp)
        {
            exp.printStackTrace();
        }
 }
 
 public accprp findacc(int ano) throws IOException, ClassNotFoundException, SQLException
 {
     d2hcon.getcon();
     CallableStatement stm=d2hcon.con.prepareCall("{call findtb(?)}");
     stm.setInt(1,ano);
     ResultSet rs=stm.executeQuery();
     accprp p=new accprp();
     if(rs.next())
     {
         p.setAccno(rs.getInt("accno"));
         p.setAccnam(rs.getString("accnam"));
         p.setAccadd(rs.getString("accadd"));
         p.setAccloc(rs.getString("accloc"));
         p.setAccphnno(rs.getString("accphnno"));
         p.setAcctyp(rs.getString("acctyp"));
     }
     d2hcon.closecon();
     return p;
 }
 
 
 public List <accprp> dspacc() throws IOException, ClassNotFoundException, SQLException
 {
  d2hcon.getcon();
  CallableStatement stm=d2hcon.con.prepareCall("{call dsptb()}");
  ResultSet rs=stm.executeQuery();
  List<accprp> k=new ArrayList<accprp>();
  while(rs.next())
  {
      accprp p=new accprp();
      p.setAccno(rs.getInt("accno"));
      p.setAccnam(rs.getString("accnam"));
//      java.sql.Date s=new java.sql.Date(rs.getDate("accrtdat").getTime());
//      p.setAacrtdat(s);
      p.setAccadd(rs.getString("accadd"));
      p.setAccloc(rs.getString("accloc"));
      p.setAccphnno(rs.getString("accphnno"));
      p.setAcctyp(rs.getString("acctyp"));
      k.add(p);
  }
  d2hcon.closecon();
  return k;
  }
     
     
     
 }
     
     
     
 




    

