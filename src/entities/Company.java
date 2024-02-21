package entities;

//pessoa jurídica
public class Company extends TaxPayer {
	private Integer numberOfEmployees;
	
	public Company() {
		super();
	}
	public Company(String name, Double anualIncome, Integer numEmp) {
		super(name, anualIncome);
		this.numberOfEmployees = numEmp;
	}
	
	public Integer getNumEmp() {
		return numberOfEmployees;
	}
	public void setNumEmp(Integer numEmp) {
		this.numberOfEmployees = numEmp;
	}
	
	@Override
	public Double tax() {
		double comTax = getNumEmp() <= 10 ? getAnualIncome() * 0.16 : getAnualIncome() * 0.14;
		return comTax;
	}
}