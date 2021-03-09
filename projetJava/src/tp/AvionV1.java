package tp;

public class AvionV1 {
	
	public static final int TAILLE_MAX=50;
	
	private Personne[] tabElements = new Personne[TAILLE_MAX];
	//en V1, tabElements est un tableau de références 
	//sur des futurs objets "Personne"
	
	private int nbElements=0; //nombre d'éléments utilisés du tableau
	
	public void addElement(Personne p) {
		//on ajoute la référence p dans le tableau
		//interne privé tabElements s'il reste de la place
		if(nbElements<TAILLE_MAX) {
			this.tabElements[nbElements++]=p;
		}
	}
	
	public void afficher() {
		//on affiche nbElements
		System.out.println("nombre d'éléments dans avion=" + this.nbElements);
		//on affiche tous les éléments (Personne) référencés par le tableau
		for(int i=0;i<nbElements;i++) {
			//System.out.println(tabElements[i]); //avec .toString() implicite
			//ou bien explicitement tabElements[i].toString()
			System.out.println(tabElements[i].toString());
			//POLYMORPHISME ICI sur .toString() (version Personne et Employe)
		}
	}
	
	public void initialiser() {
		//on initialise un jeu de données
		this.addElement(new Employe("pilote",45,68.4,4000.0));
		this.addElement(new Employe("hotesse",35,58.4,2000.0));
	}


	//+ constructeur , + get/Set , ....
	public AvionV1() {
		super();
	}

	public Personne[] getTabElements() {
		return tabElements;
	}

	/*
	public void setTabElements(Personne[] tabElements) {
		this.tabElements = tabElements;
	}
   */
	public int getNbElements() {
		return nbElements;
	}

	/*
	public void setNbElements(int nbElements) {
		this.nbElements = nbElements;
	}
	*/
	
}
