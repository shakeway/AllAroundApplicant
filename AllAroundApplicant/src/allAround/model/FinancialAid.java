package allAround.model;
import java.math.BigDecimal;

public class FinancialAid {
	protected int financialAidId;
  protected Schools school;
  protected int year;
  protected BigDecimal ratioFedLoan; 
  protected BigDecimal debtMedian; 
  protected BigDecimal gradDebtMedian; 
  protected BigDecimal lowIncomeDebtMedian; 
  protected BigDecimal medIncomeDebtMedian; 
  protected BigDecimal hiIncomeDebtMedian; 
  protected BigDecimal depDebtMedian; 
  protected BigDecimal indepDebtMedian; 
  protected BigDecimal femaleDebtMedian; 
  protected BigDecimal maleDebtMedian;
  
	public FinancialAid(int financialAidId, Schools school, int year,
	    BigDecimal ratioFedLoan, BigDecimal debtMedian, BigDecimal gradDebtMedian,
	    BigDecimal lowIncomeDebtMedian, BigDecimal medIncomeDebtMedian,
	    BigDecimal hiIncomeDebtMedian, BigDecimal depDebtMedian,
	    BigDecimal indepDebtMedian, BigDecimal femaleDebtMedian,
	    BigDecimal maleDebtMedian) {
		super();
		this.financialAidId = financialAidId;
		this.school = school;
		this.year = year;
		this.ratioFedLoan = ratioFedLoan;
		this.debtMedian = debtMedian;
		this.gradDebtMedian = gradDebtMedian;
		this.lowIncomeDebtMedian = lowIncomeDebtMedian;
		this.medIncomeDebtMedian = medIncomeDebtMedian;
		this.hiIncomeDebtMedian = hiIncomeDebtMedian;
		this.depDebtMedian = depDebtMedian;
		this.indepDebtMedian = indepDebtMedian;
		this.femaleDebtMedian = femaleDebtMedian;
		this.maleDebtMedian = maleDebtMedian;
	}
	
	public FinancialAid(Schools school, int year,
	    BigDecimal ratioFedLoan, BigDecimal debtMedian, BigDecimal gradDebtMedian,
	    BigDecimal lowIncomeDebtMedian, BigDecimal medIncomeDebtMedian,
	    BigDecimal hiIncomeDebtMedian, BigDecimal depDebtMedian,
	    BigDecimal indepDebtMedian, BigDecimal femaleDebtMedian,
	    BigDecimal maleDebtMedian) {
		this.school = school;
		this.year = year;
		this.ratioFedLoan = ratioFedLoan;
		this.debtMedian = debtMedian;
		this.gradDebtMedian = gradDebtMedian;
		this.lowIncomeDebtMedian = lowIncomeDebtMedian;
		this.medIncomeDebtMedian = medIncomeDebtMedian;
		this.hiIncomeDebtMedian = hiIncomeDebtMedian;
		this.depDebtMedian = depDebtMedian;
		this.indepDebtMedian = indepDebtMedian;
		this.femaleDebtMedian = femaleDebtMedian;
		this.maleDebtMedian = maleDebtMedian;
	}

	public int getFinancialAidId() {
		return financialAidId;
	}

	public void setFinancialAidId(int financialAidId) {
		this.financialAidId = financialAidId;
	}

	public Schools getSchool() {
		return school;
	}

	public void setSchool(Schools school) {
		this.school = school;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getRatioFedLoan() {
		return ratioFedLoan;
	}

	public void setRatioFedLoan(BigDecimal ratioFedLoan) {
		this.ratioFedLoan = ratioFedLoan;
	}

	public BigDecimal getDebtMedian() {
		return debtMedian;
	}

	public void setDebtMedian(BigDecimal debtMedian) {
		this.debtMedian = debtMedian;
	}

	public BigDecimal getGradDebtMedian() {
		return gradDebtMedian;
	}

	public void setGradDebtMedian(BigDecimal gradDebtMedian) {
		this.gradDebtMedian = gradDebtMedian;
	}

	public BigDecimal getLowIncomeDebtMedian() {
		return lowIncomeDebtMedian;
	}

	public void setLowIncomeDebtMedian(BigDecimal lowIncomeDebtMedian) {
		this.lowIncomeDebtMedian = lowIncomeDebtMedian;
	}

	public BigDecimal getMedIncomeDebtMedian() {
		return medIncomeDebtMedian;
	}

	public void setMedIncomeDebtMedian(BigDecimal medIncomeDebtMedian) {
		this.medIncomeDebtMedian = medIncomeDebtMedian;
	}

	public BigDecimal getHiIncomeDebtMedian() {
		return hiIncomeDebtMedian;
	}

	public void setHiIncomeDebtMedian(BigDecimal hiIncomeDebtMedian) {
		this.hiIncomeDebtMedian = hiIncomeDebtMedian;
	}

	public BigDecimal getDepDebtMedian() {
		return depDebtMedian;
	}

	public void setDepDebtMedian(BigDecimal depDebtMedian) {
		this.depDebtMedian = depDebtMedian;
	}

	public BigDecimal getIndepDebtMedian() {
		return indepDebtMedian;
	}

	public void setIndepDebtMedian(BigDecimal indepDebtMedian) {
		this.indepDebtMedian = indepDebtMedian;
	}

	public BigDecimal getFemaleDebtMedian() {
		return femaleDebtMedian;
	}

	public void setFemaleDebtMedian(BigDecimal femaleDebtMedian) {
		this.femaleDebtMedian = femaleDebtMedian;
	}

	public BigDecimal getMaleDebtMedian() {
		return maleDebtMedian;
	}

	public void setMaleDebtMedian(BigDecimal maleDebtMedian) {
		this.maleDebtMedian = maleDebtMedian;
	}	

}
