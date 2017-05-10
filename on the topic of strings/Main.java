public class Main {
	
	private static void example1() {
		String a = "Hello";
		String b = a;
		a = " World!";
		System.out.println(b + a);
	}
	
	public static void main(String [] args) {
		example1();
	}
}