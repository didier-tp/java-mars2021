package tp;

public class AvionV2 {
	
	public static final int TAILLE_MAX=50;
	
	//NB: Descriptible[] tabElements pour TP java avec interface
	//dans vrai avion, on ne mélange pas Bagages et Personnes
	
	private Descriptible[] tabElements = new Descriptible[TAILLE_MAX];
	//en V2, tabElements est un tableau de références 
	//sur des futurs objets "Descriptible"
	
	private int nbElements=0; //nombre d'éléments utilisés du tableau
	
	public void addElement(Descriptible p) {
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
		double poidsTotal=0;
		int nbPersonnes=0;
		int nbBagages=0;
		for(int i=0;i<nbElements;i++) {
			Descriptible choseDescriptible  = tabElements[i];
			//POLYMORPHISME ICI sur .getDesignation() et .getPoids()
			//(implémentés par Personne , Employe ou Bagage)
			System.out.println(choseDescriptible.getDesignation());
			poidsTotal += choseDescriptible.getPoids();
			
			if(choseDescriptible instanceof Bagage) nbBagages++;
			if(choseDescriptible instanceof Personne) nbPersonnes++;
		}
		System.out.println("poids total des éléments de l'avion : " + poidsTotal);
		System.out.println("nbPersonnes dans l'avion : " + nbPersonnes);
		System.out.println("nbBagages dans l'avion : " + nbBagages);
	}
	
	public void initialiser() {
		//on initialise un jeu de données
		this.addElement(new Employe("pilote",45,68.4,4000.0));
		this.addElement(new Bagage("bagage_pilote",5.4,20.4));
		this.addElement(new Employe("hotesse",35,58.4,2000.0));
		this.addElement(new Bagage("bagage_hotesse",3.7,30.7));
	}


	//+ constructeur , + get/Set , ....
	public AvionV2() {
		super();
	}

	public Descriptible[] getTabElements() {
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
