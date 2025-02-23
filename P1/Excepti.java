package P1;

public class Excepti {

	public static void main(String[] args) {
		int a=10;
		int b=0;
//		int c=a/b;
		int d[]= {1,2,3};
		try {
			System.out.println(d[3]);
			try {
			int c=a/b;
			System.out.println(c);}
			catch(ArithmeticException e) {
				System.out.println(e);}
		}
			
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
		
//		catch(ArithmeticException e) {
//			System.out.println(e);
//			e.printStackTrace();
		}
	}


