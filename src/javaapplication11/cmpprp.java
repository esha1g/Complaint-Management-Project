package javaapplication11;

import java.util.Date;



public class cmpprp
{
private int cmpasgempcod,cmpcod,cmpaccno;
private Date cmpdat;
private String cmpdsc,cmpsts;

public cmpprp()
{
    cmpdsc=new String();
    cmpsts=new String();
}

    public int getCmpcod() {
        return cmpcod;
    }

    public void setCmpcod(int cmpcod) {
        this.cmpcod = cmpcod;
    }

    public int getCmpaccno() {
        return cmpaccno;
    }

    public void setCmpaccno(int cmpaccno) {
        this.cmpaccno = cmpaccno;
    }

    public Date getCmpdat() {
        return cmpdat;
    }

    public void setCmpdat(Date cmpdat) {
        this.cmpdat = cmpdat;
    }

    public String getCmpdsc() {
        return cmpdsc;
    }

    public void setCmpdsc(String cmpdsc) {
        this.cmpdsc = cmpdsc;
    }

    public int getCmpasgempcod() {
        return cmpasgempcod;
    }

    public void setCmpasgempcod(int cmpasgempcod) {
        this.cmpasgempcod = cmpasgempcod;
    }

    public String getCmpsts() {
        return cmpsts;
    }

    public void setCmpsts(String cmpsts) {
        this.cmpsts = cmpsts;
    }
}
