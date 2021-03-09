package tp;

public class Employe extends Personne {
	
	private Double salaire;
	
	public Employe() {
		super();
	}

	public Employe(String nom, Integer age, Double poids) {
		super(nom, age, poids);
	}

	public Employe(String nom, Integer age, Double poids,Double salaire) {
		super(nom, age, poids);
		this.salaire=salaire;
	}

	@Override
	public String toString() {
		return "Employe [salaire=" + salaire + ", heritant de =" + super.toString() + "]";
	}
	
	public void augmenterSalairePct(double pctAugmentation) {
		this.salaire = this.salaire * (1 + pctAugmentation/100);
	}
	
	public Double getSalaireTotal() {
		return salaire; //considéré comme salaire fixe
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	
	

}
