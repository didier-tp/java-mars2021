package tp;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("Hello world 2");
        //testType();
        //testComparaison();
        //testCompte();
		testPersonne();
	}
	
	public static void testPersonne() {
		Personne p1 = null;
		Personne p2 = null;
		p1 = new Personne();
		p1.setNom("dupond") ; p1.setAge(40); p1.setPoids(67.89);
		p1.afficher();
		/*p2 = new Personne();
		p2.setNom("durand") ; p2.setAge(30); p2.setPoids( 77.56);*/
		p2 = new Personne("durand" , 30 , 77.56);
		System.out.println("le nom de p2 est " + p2.getNom());
		p2.setAge(-80);//valeur qui sera refusée (pas  prise en compte)
		p2.setAge(45);//valeur qui sera acceptée (prise en compte)
		System.out.println(p2.toString());
		if(p1.equals(p2)) {
			System.out.println("p1 et p2 ont les mêmes valeurs");
		}else {
			System.out.println("p1 et p2 ont des valeurs différentes");
		}
		
		/*
		int a; //variable locale (sans valeur par défaut)
		int b; //à obligatoirement initialiser
		int res = a + b;
		*/
		
		int a=5; //variable locale (sans valeur par défaut)
		int b=6; //à obligatoirement initialiser
		int res = a + b;
		
	}
	
	public static void testCompte() {
		Compte c1, c2;
		c1=new Compte();
		c1.setNumero("101"); c1.setSolde(100);
		/*c2 = new Compte();
		c2.setNumero("102"); c2.setSolde(200);*/
		c2 = new Compte ("102" , 200);
		
		c1.crediter(10); c2.debiter(10);
		
		System.out.println("Le compte num = " + c1.getNumero() + " a un solde de " + c1.getSolde() );
		System.out.println("Le compte num = " + c2.getNumero() + " a un solde de " + c2.getSolde() );
	    System.out.println("c1="+c1.toString());
	}
	
	public static void testComparaison() {
		String ch1 = "abc" ; //new String("abc");
		String ch2 = new String("def");
		String ch3 = ch1 + ch2;
		if(ch3.equals("abcdef")) {
			System.out.println("ch3 vaut abcdef");
		}else{
			System.out.println("ch3 ne vaut pas abcdef");
		}
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
