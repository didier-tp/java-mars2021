package tp;

public class Bagage implements Descriptible {
	private String label;
	private double poids;
	private double volume;

	public Bagage() {
	}


	public Bagage(String label, double poids, double volume) {
		super();
		this.label = label;
		this.poids = poids;
		this.volume = volume;
	}

	
	@Override
	public String toString() {
		return "Bagage [label=" + label + ", poids=" + poids + ", volume=" + volume + "]";
	}


	@Override
	public String getDesignation() {
		return this.toString();
	}

	@Override
	public double getPoids() {
		return this.poids;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	
	
}
