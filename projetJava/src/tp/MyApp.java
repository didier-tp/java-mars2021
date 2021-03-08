package tp;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("Hello world 2");
        testType();
	}
	
	
	public static void testType() {
		String chX="3.5";
		double x = Double.parseDouble(chX);
		double y = x -1;
		System.out.println("y="+y);
		int a=0; //-1 , 0 , 23 , (null impossible)
		Integer b=null; // -1 , 0 , 23 , null (valeur inconnue ou non renseignée)
		b = a; // ou bien = new Integer(a); en vieux java
		System.out.println("b="+b);
	}

}
