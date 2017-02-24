package allAround.model;

public class Cost {
	protected int costId;
  protected Schools school;
  protected int year;
  protected int annualCost;
  protected int tuitionInState;
  protected int tuitionOutState;
  protected int netPriceAverage;
  protected int netPriceFamily1;
  protected int netPriceFamily2;
  protected int netPriceFamily3;
  protected int netPriceFamily4;
  protected int netPriceFamily5;
  
	public Cost(int costId, Schools school, int year, int annualCost,
	    int tuitionInState, int tuitionOutState, int netPriceAverage,
	    int netPriceFamily1, int netPriceFamily2, int netPriceFamily3,
	    int netPriceFamily4, int netPriceFamily5) {
		super();
		this.costId = costId;
		this.school = school;
		this.year = year;
		this.annualCost = annualCost;
		this.tuitionInState = tuitionInState;
		this.tuitionOutState = tuitionOutState;
		this.netPriceAverage = netPriceAverage;
		this.netPriceFamily1 = netPriceFamily1;
		this.netPriceFamily2 = netPriceFamily2;
		this.netPriceFamily3 = netPriceFamily3;
		this.netPriceFamily4 = netPriceFamily4;
		this.netPriceFamily5 = netPriceFamily5;
	}

	public int getCostId() {
		return costId;
	}

	public void setCostId(int costId) {
		this.costId = costId;
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

	public int getAnnualCost() {
		return annualCost;
	}

	public void setAnnualCost(int annualCost) {
		this.annualCost = annualCost;
	}

	public int getTuitionInState() {
		return tuitionInState;
	}

	public void setTuitionInState(int tuitionInState) {
		this.tuitionInState = tuitionInState;
	}

	public int getTuitionOutState() {
		return tuitionOutState;
	}

	public void setTuitionOutState(int tuitionOutState) {
		this.tuitionOutState = tuitionOutState;
	}

	public int getNetPriceAverage() {
		return netPriceAverage;
	}

	public void setNetPriceAverage(int netPriceAverage) {
		this.netPriceAverage = netPriceAverage;
	}

	public int getNetPriceFamily1() {
		return netPriceFamily1;
	}

	public void setNetPriceFamily1(int netPriceFamily1) {
		this.netPriceFamily1 = netPriceFamily1;
	}

	public int getNetPriceFamily2() {
		return netPriceFamily2;
	}

	public void setNetPriceFamily2(int netPriceFamily2) {
		this.netPriceFamily2 = netPriceFamily2;
	}

	public int getNetPriceFamily3() {
		return netPriceFamily3;
	}

	public void setNetPriceFamily3(int netPriceFamily3) {
		this.netPriceFamily3 = netPriceFamily3;
	}

	public int getNetPriceFamily4() {
		return netPriceFamily4;
	}

	public void setNetPriceFamily4(int netPriceFamily4) {
		this.netPriceFamily4 = netPriceFamily4;
	}

	public int getNetPriceFamily5() {
		return netPriceFamily5;
	}

	public void setNetPriceFamily5(int netPriceFamily5) {
		this.netPriceFamily5 = netPriceFamily5;
	}
  
	
	
}
