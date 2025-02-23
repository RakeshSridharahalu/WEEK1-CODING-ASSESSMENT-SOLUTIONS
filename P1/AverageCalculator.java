package P1;

import java.util.Scanner;

public class AverageCalculator {
	public double calAverage(int n) throws except {
//		try {
//			try {
			if(n<=0) {
				throw new except("Enter a number>0");
			}
//			catch{
//	
//			}
		//}
//		try {
		double d=n*(n+1)/n;
		return d;
//		}
//		
		
	}

	public static void main(String[] args) throws except {
		AverageCalculator ac=new AverageCalculator();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(ac.calAverage(n));

	}

}
