package tp;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import tp.data.Devise;

/**
 * 
 * @author didier
 *
 * classe principale application java
 *
 */

public class MyApp {
	
	public enum Jour { DIMANCHE , LUNDI, MARDI, MERCREDI , JEUDI , VENDREDI, SAMEDI };

	
	public static void printCollection(Collection<String> col){
		for(String e : col) {
			System.out.println("e="+e);
		}
	}
	
	public static void main(String[] args) {
		//m1();
		m2();
		//...
		//m3();
		testDate();
		testEnum();
		testPrintf();
		testBundleSelonLangueLocale();
	}
	
	public static void testEnum() {
		System.out.println("***************** testEnum ******");
		Jour j0 = Jour.DIMANCHE; 
		Jour j1 = Jour.LUNDI; 
		System.out.println("j1="+j1 + " , j1.ordinal()=" + j1.ordinal());
		
		for (Jour j : Jour.values() )
			System.out.println(j + " [" + j.ordinal() + "]" );
		switch(j1) {
		   //NB: bizarrement pas de case Jour.LUNDI mais case LUNDI
	        case LUNDI: System.out.println("Lundi c'est ravioli"); break;
	        case MARDI: System.out.println("Mardi c'est brocoli"); break;
	        default : System.out.println("autre jour");
	        }
	}
	
	public static void fonctionAvecNbArgsVariables(String ...args) {
		System.out.println("**** fonctionAvecNbArgsVariables appelee avec " + args.length + " args");
		if(args.length > 0)
			System.out.println(args[0]);
		if(args.length > 1)
			System.out.println(args[1]);
		for(int i=2; i<args.length ; i++)
			System.out.println(args[i]);
	}
	
	public static void testPrintf() {
		   System.out.println("***************** testPrintf ******");
		   int a=5;
		   double x=12.798765;
		   String s="abc";
		   //NB: %.2f pour n'afficher que 2 chiffres après la virgule
		   System.out.printf("a=%d , x=%.2f , s=%s", a, x, s);
		   
		   fonctionAvecNbArgsVariables();
		   fonctionAvecNbArgsVariables("rouge");
		   fonctionAvecNbArgsVariables("vert", "bleu" , "noir");
	}
	
	public static void testBundleSelonLangueLocale() {
		ResourceBundle myResources = null;
		myResources = ResourceBundle.getBundle("tp.MyResources");
		String libelle = myResources.getString("msg.welcome");
		System.out.println("libelle_welcome="+libelle);
	}
	
	public static void testDate() {
		   System.out.println("***************** testDate ******");
		   //java.util.Date d = new java.util.Date(); //sans import
		   Date d = new Date(); //date aujourd'hui à l'instant présent (mb ms depuis 01/01/1970 GMT)
		   //System.nanoTime()
		   /*
		   Calendar cal = Calendar.getInstance();
		   cal.set(1969,7-1,11); //11/07/1969
		   d=cal.getTime();
		   */
		   System.out.println("d="+d);
		   SimpleDateFormat simpleDateFormat_us = new SimpleDateFormat("yyyy-MM-dd");
		   String sdate_us = simpleDateFormat_us.format(d);
		   System.out.println("sdate_us="+sdate_us);
		   SimpleDateFormat simpleDateFormat_fr = new SimpleDateFormat("dd/MM/yyyy");
		   String sdate_fr = simpleDateFormat_fr.format(d);
		   System.out.println("sdate_fr="+sdate_fr);
		}
	
	public static void m3() {
		List<Devise> listeDevises = new ArrayList<>();
		Devise d1 = new Devise("EUR","Euro",1.0);
		listeDevises.add(d1);
		listeDevises.add(new Devise("USD","Dollar",1.1));
		listeDevises.add(new Devise("GBP","Livre",0.9));
		listeDevises.add(new Devise("JPY","Yen",120.0));
		
		java.util.Collections.sort(listeDevises, new java.util.Comparator<Devise>(){
			@Override
			public int compare(Devise d1, Devise d2) {
				if (d1.getChange() > d2.getChange()) { return 1; }
				else if (d1.getChange() < d2.getChange()) { return -1; }
				else { return 0; }
			}
			});
		
		System.out.println("listeDevises="+listeDevises);//listeDevises.toString() appelé implicitement
	}
	
	public static void m2() {
		System.out.println("***************** m2, testListe ******");
		//déclarer et construire une liste de Double
		List<Double> listeD = new ArrayList<>();
		//ajouter quelques valeurs dans la liste
		//ex: 1.2  3.3   5    2.8  2.9  4.0
		listeD.add(1.2);		listeD.add(3.3);
		listeD.add(5.0);		listeD.add(2.8);
		listeD.add(2.9);		listeD.add(4.0);
		//parcourir les valeurs de la liste et calculer la somme 
		double somme =0.0;
		for(Double d : listeD) {
			somme+=d;//ou bien somme=somme+d;
		}
		//calculer et afficher la moyenne
		double moyenne=somme/listeD.size();
		System.out.println("moyenne approchée(sans mise en forme)="+moyenne);
		NumberFormat nfmt = NumberFormat.getInstance();
		nfmt.setMaximumFractionDigits(2);
		nfmt.setMinimumFractionDigits(2);
		System.out.println("La moyenne arrondie à 2 chiffres après la virgule est : " + nfmt.format(moyenne));
		
		System.out.println("avant tri, listeD="+listeD);
		java.util.Collections.sort(listeD);//trier
		System.out.println("apres tri, listeD="+listeD);
	}
	
	public static void m1() {
		Set<String> set1 = new HashSet<String>();
		set1.add("France");
		set1.add("Espagne");
		//set1.add("France"); //ligne inutile car France déjà ajouté
		printCollection(set1);
		
		//List<String> liste1 = new LinkedList<String>();
		//List<Object> listeChoses = new ArrayList<Object>();
		List<String> liste1 = new ArrayList<String>();
		liste1.add("lundi");
		liste1.add("mardi");
		liste1.add("mercredi");
		liste1.add("jeudi");
		//liste1.add(5); erreur vue par le compilateur
		liste1.remove("lundi");
		System.out.println("nb elts de liste1="+ liste1.size());
        //liste1.clear();
		
		printCollection(liste1);
		
		for(String jour : liste1) {
			System.out.println("jour="+jour);
		}
		
		for(int i=0;i<liste1.size();i++) {
			String jour = liste1.get(i); //ressemble à tab1[i]
			System.out.println("i="+i +" jour="+jour);
		}
		
        System.out.println("liste1="+liste1.toString());
        
        
        List<Integer> liste2 = new ArrayList<Integer>();
        //List<int> liste2Bis = new ArrayList<int>(); IMPOSSIBLE car int n'est pas un cas particulier de Object
        //liste2.add(new Integer(10));
        liste2.add(10); 
        liste2.add(20);
        for(Integer val : liste2) {
			System.out.println("val="+val);
		}
        
	}
	
	
}
