package DAY2;

public class Instancecounter {
	private static int count=0;
	public Instancecounter() {
		count++;
	}
	public static int getCount() {
		return count;
	}
	public static void main(String[] args) {
		Instancecounter o1=new Instancecounter();
		Instancecounter o2=new Instancecounter();
		System.out.println(Instancecounter.getCount());

	}

}
