
package javaapplication11;


import java.util.Date;
import sun.util.calendar.BaseCalendar;


public class accprp 
{
  private int accno;
  private String accnam;
  private Date aacrtdat;
  private String accadd;
  private String accloc; 
  private String accphnno;
  private String acctyp;

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getAccnam() {
        return accnam;
    }

    public void setAccnam(String accnam) {
        this.accnam = accnam;
    }

    public Date getAacrtdat() {
        return aacrtdat;
    }

    public void setAacrtdat(Date aacrtdat) {
        this.aacrtdat = aacrtdat;
    }

    public String getAccadd() {
        return accadd;
    }

    public void setAccadd(String accadd) {
        this.accadd = accadd;
    }

    public String getAccloc() {
        return accloc;
    }

    public void setAccloc(String accloc) {
        this.accloc = accloc;
    }

    public String getAccphnno() {
        return accphnno;
    }

    public void setAccphnno(String accphnno) {
        this.accphnno = accphnno;
    }

    public String getAcctyp() {
        return acctyp;
    }

    public void setAcctyp(String acctyp) {
        this.acctyp = acctyp;
    }
}
