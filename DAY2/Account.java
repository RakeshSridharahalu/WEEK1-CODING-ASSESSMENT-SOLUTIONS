package DAY2;

public class Account {
 private int Acno;
 private String Actype;
 private int AcBal;
 public void setAccountDetails(int Acno,String Actype, int AcBal) {
	 this.Acno=Acno;
	 this.Actype=Actype;
	 this.AcBal=AcBal;
 }
 public int withdraw() {
	 AcBal=AcBal-1000;
	 return AcBal;
 }
 public int deposit() {
	 AcBal=50000;
	 AcBal=AcBal+1000; 
	 return AcBal;
 }
 public void dispAccountDetails() {
	 System.out.println(+Acno+"   "+Actype+"  "+AcBal);
 }
}
