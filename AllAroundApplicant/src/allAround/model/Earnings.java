package allAround.model;

public class Earnings {
	protected int EarningsId;
	protected int Year;
	protected int StudentCount;
	protected int Earnings10YrsAfterEntryMedian;
	protected int Earnings10YrsAfterNotEnrolledMeanEarnings;
	protected int Earnings6YrsAfterEntryMedian;
	protected int Earnings6YrsAfterNotEnrolledMeanEarnings;
	protected Schools school;
	public Earnings(int earningsId, int year, int studentCount, int earnings10YrsAfterEntryMedian,
			int earnings10YrsAfterNotEnrolledMeanEarnings, int earnings6YrsAfterEntryMedian,
			int earnings6YrsAfterNotEnrolledMeanEarnings, Schools school) {
		super();
		EarningsId = earningsId;
		Year = year;
		StudentCount = studentCount;
		Earnings10YrsAfterEntryMedian = earnings10YrsAfterEntryMedian;
		Earnings10YrsAfterNotEnrolledMeanEarnings = earnings10YrsAfterNotEnrolledMeanEarnings;
		Earnings6YrsAfterEntryMedian = earnings6YrsAfterEntryMedian;
		Earnings6YrsAfterNotEnrolledMeanEarnings = earnings6YrsAfterNotEnrolledMeanEarnings;
		this.school = school;
	}
	public int getEarningsId() {
		return EarningsId;
	}
	public void setEarningsId(int earningsId) {
		EarningsId = earningsId;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getStudentCount() {
		return StudentCount;
	}
	public void setStudentCount(int studentCount) {
		StudentCount = studentCount;
	}
	public int getEarnings10YrsAfterEntryMedian() {
		return Earnings10YrsAfterEntryMedian;
	}
	public void setEarnings10YrsAfterEntryMedian(int earnings10YrsAfterEntryMedian) {
		Earnings10YrsAfterEntryMedian = earnings10YrsAfterEntryMedian;
	}
	public int getEarnings10YrsAfterNotEnrolledMeanEarnings() {
		return Earnings10YrsAfterNotEnrolledMeanEarnings;
	}
	public void setEarnings10YrsAfterNotEnrolledMeanEarnings(int earnings10YrsAfterNotEnrolledMeanEarnings) {
		Earnings10YrsAfterNotEnrolledMeanEarnings = earnings10YrsAfterNotEnrolledMeanEarnings;
	}
	public int getEarnings6YrsAfterEntryMedian() {
		return Earnings6YrsAfterEntryMedian;
	}
	public void setEarnings6YrsAfterEntryMedian(int earnings6YrsAfterEntryMedian) {
		Earnings6YrsAfterEntryMedian = earnings6YrsAfterEntryMedian;
	}
	public int getEarnings6YrsAfterNotEnrolledMeanEarnings() {
		return Earnings6YrsAfterNotEnrolledMeanEarnings;
	}
	public void setEarnings6YrsAfterNotEnrolledMeanEarnings(int earnings6YrsAfterNotEnrolledMeanEarnings) {
		Earnings6YrsAfterNotEnrolledMeanEarnings = earnings6YrsAfterNotEnrolledMeanEarnings;
	}
	public Schools getSchool() {
		return school;
	}
	public void setSchool(Schools school) {
		this.school = school;
	}
	
	
}
