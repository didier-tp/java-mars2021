package tp;

public class Commercial extends Employe {
	
	private Double ventesDuMois;
	private Double tauxCommission;//en %

	@Override
	public Double getSalaireTotal() {
		Double salaireFixe = super.getSalaireTotal();
		Double salaireTotal = null;
		if(this.ventesDuMois !=null && this.tauxCommission != null) {
			salaireTotal =  salaireFixe + ventesDuMois * tauxCommission/100.0;
		}else{
			salaireTotal = salaireFixe;
		}
		return salaireTotal;
	}

	public Commercial() {
		super();
	}

	public Commercial(String nom, Integer age, Double poids, Double salaire) {
		super(nom, age, poids, salaire);
	}

	public Commercial(String nom, Integer age, Double poids) {
		super(nom, age, poids);
	}

	public Double getVentesDuMois() {
		return ventesDuMois;
	}

	public void setVentesDuMois(Double ventesDuMois) {
		this.ventesDuMois = ventesDuMois;
	}

	public Double getTauxCommission() {
		return tauxCommission;
	}

	public void setTauxCommission(Double tauxCommission) {
		this.tauxCommission = tauxCommission;
	}
	

}
