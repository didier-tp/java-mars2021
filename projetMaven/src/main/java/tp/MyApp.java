package tp;

import javax.swing.JOptionPane;

/**
 * 
 * @author didier
 *
 * classe principale application java
 *
 */

public class MyApp {

	public MyApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * fonction principale.
	 * @param args = arguments falcultatifs du programme
	 */
	public static void main(String[] args) {
		//JOptionPane.showMessageDialog(null, "MyApp");
		System.out.println("MyApp");
		testDivision();
	  try {
			double x=9.0;
			double y = racineCarree(x);
			System.out.println(y);
			x=-9;
			y = racineCarree(x);
			System.out.println(y);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void testDivision(){
		try {
			int a=6;
			int b=0;
			int res = a /b;
			System.out.println("res="+res);
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
		}
	}
	
	public static double racineCarree(double x) throws RuntimeException{
		if(x>=0)
			return Math.sqrt(x);
		else
			throw new RuntimeException("racine carree interdite sur valeur negative");
	}
	

}
