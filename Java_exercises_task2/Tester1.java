package JavaExcersise2;

import java.util.Scanner;

public class Tester1 {
	public static void getCapitalized(String s) {
		String arr[]=s.split(" ");
		for(int i=0;i<arr.length;i++) {
		arr[i]= arr[i].replace(arr[i].charAt(0),Character.toUpperCase(arr[i].charAt(0)));
		System.out.print(arr[i]+" ");
		//System.out.print(" ");

		
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		Tester.getCapitalized(s);
		

	}

}
