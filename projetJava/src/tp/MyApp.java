package tp;


public class MyApp {

	public static void main(String[] args) {
		System.out.println("MyApp");
        //testType();
        //testComparaison();
        //testCompte();
		//testPersonne();
		//testStringEtTableau();
		//testGc();
		//testStatic();
		//MyApp myApp = new MyApp(); myApp.testMath();//si testMath() n'est pas static
		//testEmploye();
		//testAvionV1();
		testAvionV2();
		//testPorte();
	}
	
	
	public static void testAvionV2() {
		System.out.println("======== testAvionV2 ==========");
		AvionV2 avion  = new AvionV2();
		avion.initialiser(); //avec déjà pilote, hotesse
		avion.addElement(new Personne("passager 1" , 35 , 78.8));
		avion.addElement(new Personne("passager 2" , 25 , 68.8));
		avion.addElement(new Bagage("valise" , 25 , 56.8));
		avion.addElement(new Bagage("sac" , 10 , 15.8));
		avion.afficher();
	}
	
	public static void testAvionV1() {
		System.out.println("======== testAvionV1 ==========");
		AvionV1 avion  = new AvionV1();
		avion.initialiser(); //avec déjà pilote, hotesse
		avion.addElement(new Personne("passager 1" , 35 , 78.8));
		avion.addElement(new Personne("passager 2" , 25 , 68.8));
		avion.afficher();
	}
	
	public static void testStatic() {
        String nom = MyUtil.input("nom:");
        MyUtil.display("nom="+nom);
        //Integer age = Integer.parseInt(MyUtil.inputDlg("age:"));
        //MyUtil.displayDlg("age="+age);
        MyUtil.display("VITESSE_MAXI_STOP="+Reglements.VITESSE_MAXI_STOP);

        MyUtil.display("vitesseMaxiAgglomeration="+Reglements.vitesseMaxiAgglomeration);
        Reglements.vitesseMaxiAgglomeration=45;
        MyUtil.display("vitesseMaxiAgglomeration="+Reglements.vitesseMaxiAgglomeration);
    }

    public /*static*/ void testMath() {
        double x = Math.sin(Math.PI/2);
        System.out.println("x="+x);
    }
	
	public static void testStringEtTableau() {
		String s1="azerty";
		//construire s1Inverse et l'afficher (.charAt(i))
		StringBuilder buffer=new StringBuilder(s1.length());
		for(int i=s1.length()-1;i>=0;i--) {
			buffer.append(s1.charAt(i));
		}
		String s1Inverse = buffer.toString();
		System.out.println("s1Inverse ="+s1Inverse);
		
		String s2="juin";
		//afficher en majuscule
		String s2Maj = s2.toUpperCase();
		System.out.println("s2Maj="+s2Maj);
		
		String s3="rueXy;75001;Paris";
		//récuperer et afficher la sous-chaine entre les 2 ;
		//.indexOf()  , .lastIndexOf() , .substring
		int posPremierPointVirgule=s3.indexOf(";");
		int posDeuxiemePointVirgule=s3.lastIndexOf(";");
		String codePostal = s3.substring(posPremierPointVirgule+1, posDeuxiemePointVirgule);
		System.out.println("codePostal="+codePostal);
		
		//construire un tableau de 10 entier avec les valeurs 0,1,9
		int[] tab1 = new int[10];
		for(int i=0;i<tab1.length;i++) {
			tab1[i]=i;
		}
		int[] tab2 = new int[tab1.length];
		//construire un 2eme tableau ou chaque valeur est le double du tableau 1 
		//+ affichage (version boucle while ET AUSSI boucle for)
		for(int i=0;i<tab1.length;i++) {
			tab2[i]=2*tab1[i];
		}
		int index=0;
		while(index<tab2.length) {
			System.out.println(tab2[index]);
			index++;
		}
		
		int tab3[] = { 2 , 5 , 8 ,9, 4 };
		//calculer et afficher la moyenne
		int somme=0;
		for(int i=0;i<tab3.length;i++) {
			somme+=tab3[i];//somme=somme+tab3[i];
		}
		int moyenne = somme/tab3.length;
		System.out.println("moyenne="+moyenne);
	}
	
	public static void travaillerAvec10Comptes() {
		int n=10;
		Compte[] tabRefCompte = new Compte[n];
	    for(int i=0;i<n;i++) {
	    	tabRefCompte[i]=new Compte(String.valueOf(i),i);
	    	System.out.println(tabRefCompte[i].toString());
	    }
	    //NB: lorsque l'exécution de la sous fonction travaillerAvec10Comptes()
	    //est terminée , la variable locale tabRefCompte est supprimée (dans la zone mémoire "pile")
	    //et indirectement tous les objets Compte référencés par le tableau
	    //vont se retrouver "plus référencés" et seront donc automatiquement détruits
	    //par le "ramasse miettes / garbage collector" en tâche de fond différée.
	}
	
	public static void testGc() {
		int n=10;
	    Personne[] tabRefPers = new Personne[n];
	    for(int i=0;i<n;i++) {
	    	tabRefPers[i]=new Personne();
	    }
	    for(int i=0;i<n;i++) {
	    	tabRefPers[i]=null;
	    }
	    travaillerAvec10Comptes();
	    System.gc();
	    try {
			Thread.sleep(1000*5); //5000ms = 5s de pause
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println("fin de testGc");
	}
	
	public static void testEmploye() {
		System.out.println("======== testEmploye ==========");
		Personne eOuP = null;
		Employe e1 = new Employe();
		e1.setNom("axelle Aire"); e1.setPoids(67.7); 
		e1.setAge(33);
		e1.setSalaire(2500.0);
		//e1.afficher();
		MyUtil.display(e1.toString());
		
		//eOuP=new Personne("toto",45,67.89);
		eOuP=e1;
		//eOuP=new Employe();
		eOuP.incrementerAge(); 
		if(eOuP instanceof Employe) {
			//Employe eOuPasEmploye = (Employe) eOuP;
			//eOuPasEmploye.setSalaire(2700.0);
			((Employe)eOuP).setSalaire(2000.0);
		}
		
		//Personne eOuP = null; quelques lignes au dessus
		eOuP = new Personne("nom1",45,67.0);
		MyUtil.display("** eOuP.toString()="+eOuP.toString()); //Polymorphisme
		eOuP = new Employe("nom1",45,67.0,2500.0);
		MyUtil.display("** eOuP.toString()="+eOuP.toString()); //Polymorphisme
		
		
		
		Employe e2 = new Employe("alex Therieur",45,88.88,2000.0);//nom,age,poids,salaire
	    e2.augmenterSalairePct(3); //3% augmentation
	    e2.incrementerAge();
		MyUtil.display(e2.toString());
		
		
		Commercial c1;
		c1 = new Commercial("c1",43,67.0,2000.0);
		c1.setTauxCommission(0.5);
		c1.setVentesDuMois(30000.0);
		
		Employe eOuC;
		eOuC=c1;
		MyUtil.display("salaireTotal de eOuC=c1 :"+eOuC.getSalaireTotal());
		eOuC=e1;
		MyUtil.display("salaireTotal de eOuC=e1 :"+eOuC.getSalaireTotal());
	}
	
	public static void testPorte() {
		Porte p=null;
		//p=new Porte(); // new Porte() maintenant interdit si classe Porte abstraite
		PorteCoulissante pc = new PorteCoulissante();
		PorteBattant pb = new PorteBattant();
		p = pc;
		p.ouvrir(); p.fermer(); //Polymorphisme
		p.setCouleur("rouge"); System.out.println(" ... de couleur " + p.getCouleur());
		/*
		 En langage C , if( p.type == PORTE_COULISSANTE)
		          ouvrirPorteCoulissante(p);
		      else if( p.type == PORTE_BATTANT)
		            ouvrirPorteBattant(p);
		 */
		p = pb;
		p.ouvrir(); p.fermer(); //Polymorphisme
		
		//En plus des méthodes polymorphes abstraites ou concrètes ,
		//une classe abstraite peut comporter des attributs et méthodes concrets (ici couleur):
		p.setCouleur("vert");  System.out.println(" ... de couleur " + p.getCouleur());
		
		//------------- polymorphisme en boucle -----
		Porte[] tabRefPortes = new Porte[2];
		tabRefPortes[0]=pc;
		tabRefPortes[1]=pb;
		for(int i=0;i<2;i++) {
			tabRefPortes[i].ouvrir();
		}
		for(int i=0;i<2;i++) {
			tabRefPortes[i].fermer();
		}
	}
	
	public static void testPersonne() {
		System.out.println("======== testPersonne ==========");
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
		
		if(p1 instanceof Personne) System.out.println("p1 est une personne");
		
		
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
