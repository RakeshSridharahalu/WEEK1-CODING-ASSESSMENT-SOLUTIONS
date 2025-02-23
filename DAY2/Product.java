package DAY2;

public class Product {
	public int pno;
	public int quantity;
	public String pname;
	public float price;
	public void setdetails(int pno,int quantity,String pname,float price) {
		this.pno=pno;
		this.quantity=quantity;
		this.pname=pname;
		this.price=price;
	}
	public void getdet() {
		System.out.println("PNo   PName   Quantity   Price   Total Amount\"");
		System.out.println(pno+"    "+pname+"   "+quantity+"          "+price+"          "+quantity*price);
	}
	
	public static void main(String[] args) {
		Product p1=new Product();
		p1.setdetails(58, 3, "Bottle", 50);
		p1.getdet();

	}

}
