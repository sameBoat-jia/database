package five;

public class Student {
    private int Sno;
    private String Sname;
    private String Ssex;
    private String Sbirth;
    private String Sclass;
    private String Sphone;
    private String Smail;

    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public String getSbirth() {
        return Sbirth;
    }

    public void setSbirth(String sbirth) {
        Sbirth = sbirth;
    }

    public String getSclass() {
        return Sclass;
    }

    public void setSclass(String sclass) {
        Sclass = sclass;
    }

    public String getSphone() {
        return Sphone;
    }

    public void setSphone(String sphone) {
        Sphone = sphone;
    }

    public String getSmail() {
        return Smail;
    }

    public void setSmail(String smail) {
        Smail = smail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Sno=" + Sno +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sbirth='" + Sbirth + '\'' +
                ", Sclass='" + Sclass + '\'' +
                ", Sphone='" + Sphone + '\'' +
                ", Smail='" + Smail + '\'' +
                '}';
    }
}
