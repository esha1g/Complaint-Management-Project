
package javaapplication11;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class clsemp 
{
 public void insemp(empprp p) throws IOException, ClassNotFoundException, SQLException,NullPointerException
 {
     d2hcon.getcon();
     CallableStatement stm=d2hcon.con.prepareCall("{call insemp(?,?,?,?)}");
     stm.setString(1,p.getEmpnam());
     stm.setString(2,p.getEmppic());
     stm.setString(3,p.getEmploc());
     stm.setString(4,p.getEmpphnno());
     stm.execute();
     d2hcon.closecon();
 }

 
 
public void updemp(empprp p) throws IOException, ClassNotFoundException, SQLException,NullPointerException
 {
     d2hcon.getcon();
     CallableStatement stm = d2hcon.con.prepareCall("{call updemp(?,?,?,?,?)}");
     stm.setInt(1,p.getEmpcod());
     stm.setString(2,p.getEmpnam());
     stm.setString(3,p.getEmppic());
     stm.setString(4,p.getEmploc());
     stm.setString(5,p.getEmpphnno());
     stm.execute();
     d2hcon.closecon();
 }


public void delemp(empprp p) throws IOException, ClassNotFoundException, SQLException
 {
     d2hcon.getcon();
     CallableStatement stm = d2hcon.con.prepareCall("{(call delemp(?)}");
     stm.setInt(1,p.getEmpcod());
     stm.execute();
     d2hcon.closecon();
 }
 
public List<empprp> dspempbyloc(String loc)
    {
        List<empprp> arr=new ArrayList<empprp>();
        try
        {
            d2hcon.getcon();
            CallableStatement stm = d2hcon.con.prepareCall("{call dspempbyloc(?)}");
            stm.setString(1,loc);
            ResultSet rs=stm.executeQuery();
            
            while(rs.next())
            {
                empprp p=new empprp();
                p.setEmpcod(rs.getInt("empcod"));
                p.setEmpnam(rs.getString("empnam"));
               p.setEmppic(rs.getString("emppic"));
                p.setEmploc(rs.getString("emploc"));               
                p.setEmpphnno(rs.getString("empphnno"));              
                arr.add(p);
            }
            d2hcon.closecon();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return arr;
    }

public empprp findemp(int ecod) throws IOException, ClassNotFoundException, SQLException,NullPointerException
 {
     d2hcon.getcon();
     CallableStatement stm=d2hcon.con.prepareCall("{call findemp(?)}");
     stm.setInt(1,ecod);
     ResultSet rs=stm.executeQuery();
     empprp p=new empprp();
     if(rs.next())
     {
         p.setEmpcod(rs.getInt("empcod"));
         p.setEmpnam(rs.getString("empnam"));
         p.setEmppic(rs.getString("emppic"));
         p.setEmploc(rs.getString("emploc"));
         p.setEmpphnno(rs.getString("empphnno"));
     }
     d2hcon.closecon();
     return p;
 }
 
 
 public List <empprp> dspemp() throws IOException, ClassNotFoundException, SQLException,NullPointerException
 {
  d2hcon.getcon();
  CallableStatement stm=d2hcon.con.prepareCall("{call dspemp()}");
  ResultSet rs=stm.executeQuery();
  List<empprp> k=new ArrayList<empprp>();
  while(rs.next())
  {
      empprp p=new empprp();
      p.setEmpcod(rs.getInt("empcod"));
      p.setEmpnam(rs.getString("empnam"));
      p.setEmppic(rs.getString("emppic"));
      p.setEmploc(rs.getString("emploc"));
      p.setEmpphnno(rs.getString("empphnno"));
      k.add(p);
  }
  d2hcon.closecon();
  return k;
  }
 
    
}
