package tp;

public class Personne {
	private String nom; /*="?";*/ // null par defaut
	private int age; //0 par defaut
	private double poids; //0.0 par défaut
	

	public Personne() {
		super(); // v1, valeur par defaut selon type de données
		
		/*
		//v2 : mes valeurs par defaut (que j'aime)
		this.nom="?";
		this.age = 0;
		this.poids = 50.0;
		*/
		
		//v3 (appel d'une autre variante du constructeur):
		//this("?" , 0, 50.0); 
		
	}
	
	protected void finalize() {
		System.out.println("finalize - objet Personne");
	}


	public Personne(String nom, int age, double poids) {
		super();
		this.nom = nom;
		this.age = age;
		this.poids = poids;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		if(age >=0 )
		    this.age = age;
		else System.out.println("age négatif invalide"); 
		//plus tard throw new RuntimeException("age négatif invalide");
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}


	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age + ", poids=" + poids + "]";
	}


	public void afficher() {
		System.out.println(this.toString());
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(poids);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (age != other.age)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Double.doubleToLongBits(poids) != Double.doubleToLongBits(other.poids))
			return false;
		return true;
	}


	

}
