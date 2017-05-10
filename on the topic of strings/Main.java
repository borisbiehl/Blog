public class Main {
	
	private static void callByReferenceCheck(String s) {
		s = "Other";
	}
	
	private static void example1() {
		String a = "Hello";
		String b = a;
		a = " World!";
		System.out.println(b + a);
	}
	
	public static void example1BehindTheScenes() {
		String a = new String(new char[] {'H', 'e', 'l', 'l', 'o'});
		String b = new String(a);
		a = new String(new char[]{' ', 'W', 'o', 'r', 'l', 'd', '!'});
		System.out.println(new String(new StringBuilder(b).append(a)));
	}
	
	private static void example2() {
		String a = "Hello";
		char[] chars = {' ', 'W', 'o', 'r', 'l', 'd', '!'};
		String b = new String(chars);
		
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		sb.append(b);
		
		String msg = new String(sb);
		System.out.println(msg);
	}
	
	private static void example3() {
		String a = "Test";
		String b = "Te";
		b += "st";
		System.out.println(a + " " + b);
		System.out.println(a == b);
		System.out.println(a.equals(b));
		
		String c = "TEST";
		System.out.println(a.equalsIgnoreCase(c));
	}
	
	private static void example4() {
		String s = "a string with a lot of characters in it. Is it a lot to ask?";
		System.out.println(s.indexOf('a'));
		System.out.println(s.indexOf('a', 19));
		System.out.println(s.lastIndexOf('a'));
		System.out.println(s.lastIndexOf('a', 19));
		System.out.println("------------");
		System.out.println(s.indexOf("lot"));
		System.out.println(s.indexOf("lot", 19));
		System.out.println(s.lastIndexOf("lot"));
		System.out.println(s.lastIndexOf("lot", 19));
	}
	
	private static void example5() {
		String filePath1 = "data/myimage.png";
		String filePath2 = "data/myimage2.jpeg";
		String directory = "data/";
		
		System.out.println(filePath1.endsWith(".mp4"));
		System.out.println(filePath2.startsWith("myimage", directory.length()));
	}
	
	private static void example6() {
		String s = "  It was a dark and stormy night...  ";
		s = s.trim(); // Remove leading and trailing whitespace
		String[] regsplit = s.split(" ");
		for (String sub : regsplit) {
			System.out.print("[" + sub + "]");
		}
		System.out.println();
		
		String[] charsplit = s.split("");
		for (String sub : charsplit) {
			System.out.print("[" + sub + "]");
		}
		System.out.println();
		
		char[] properCharSplit = s.toCharArray();
		for (char c : properCharSplit) {
			System.out.print("[" + c + "]");
		}
		System.out.println();
		
		System.out.println(s.substring(9));
		System.out.println(s.substring(9, 14));
	}
	
	public static void main(String [] args) {
		example1();
		example1BehindTheScenes();
		example2();
		example3();
		example4();
		example5();
		example6();
		
		String s = "Test";
		callByReferenceCheck(s);
		System.out.println(s);
	}
}