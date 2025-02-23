package Assignment4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class CityStateMap {
	private String city;
	private String state;
//	public String getCity() {
//		return city;
//	}
//	public String getState() {
//		return state;}

	public static void main(String[] args) {
		HashMap<String,String> map=new HashMap<>();
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		sc.nextLine();
		while(a!=0) {
		System.out.println("Enter City");
		String str1=sc.nextLine();
		System.out.println("Enter State");
		String str2=sc.nextLine();
		map.put(str1,str2);
		a=a-1;
		}
//		map.put("A","KURNOOL");
//		map.put("B","KADAPA");
//		map.put("C","ANANTAPUR");
//		map.put("D","CHITOOR");
		Iterator<Map.Entry<String,String>> itr=map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String,String> ent=itr.next(); 
			System.out.println(""+ent.getKey()+","+ent.getValue());
//			System.out.println(""+ent.getValue());
		}
		Iterator<Map.Entry<String,String>> itr1=map.entrySet().iterator();
		while(itr1.hasNext()) {
			Map.Entry<String,String> entnew=itr1.next(); 
			if(entnew.getValue().equals("AB")) {
				System.out.print(entnew.getKey()+",");
			}
			if(entnew.getValue().equals("AB")) {
				itr1.remove();
			}
		}
		System.out.println("\n"+map);
		

	}

}
