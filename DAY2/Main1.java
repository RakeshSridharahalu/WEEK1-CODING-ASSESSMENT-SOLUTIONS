package DAY2;

public class Main1 {

	public static void main(String[] args) {
		Account ac=new Account();
		ac.setAccountDetails(143,"Savings",50000);
		System.out.println(ac.withdraw());
		System.out.println(ac.deposit());
		ac.dispAccountDetails();

	}

}
