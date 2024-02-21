package entities;

//pessoa física
public class Individual extends TaxPayer {
	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	public Individual(String name, Double anualIncome, Double healthExp) {
		super(name, anualIncome);
		this.healthExpenditures = healthExp;
	}
	
	public Double getHealthExp() {
		return healthExpenditures;
	}
	public void setHealthExp(Double healthExp) {
		this.healthExpenditures = healthExp;
	}
	
	@Override
	public Double tax() {
		double indTax = getAnualIncome() < 20000 ? getAnualIncome() * 0.15 - getHealthExp() * 0.5 : getAnualIncome() * 0.25 - getHealthExp() * 0.5;
		return indTax;
	}
}