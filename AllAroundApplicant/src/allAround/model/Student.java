package allAround.model;
import java.text.DecimalFormat;
public class Student {
	protected int StudentId;
	protected int Year;
	protected Schools School;
	protected int Size;
	protected int EnrollmentAll;
    protected double DemographicsRaceEthnicityWhite;
    protected double DemographicsRaceEthnicityBlack;
    protected double DemographicsRaceEthnicityHispanic;
    protected double DemographicsRaceEthnicityAsian;
    protected double DemographicsRaceEthnicityAian;
    protected double DemographicsRaceEthnicityNhpi;
    protected double DemographicsRaceEthnicityTwoOrMore;
    protected double DemographicsRaceEthnicityNonResidentAlien;
    protected double DemographicsRaceEthnicityUnknown;
    protected double DemographicsRaceEthnicityWhiteNonHispanic;
    protected double DemographicsRaceEthnicityBlackNonHispanic;
    protected double DemographicsRaceEthnicityAsianPacificIslander;
    protected double DemographicsRaceEthnicityAianPrior2009;
    protected double DemographicsRaceEthnicityHispanicPrior2009;
    protected double DemographicsNonResidentAliens2000;
    protected double DemographicsRaceEthnicityUnknown2000;
    protected double DemographicsRaceEthnicityWhite2000;
    protected double DemographicsRaceEthnicityBlack2000;
    protected double DemographicsRaceEthnicityApi2000;
    protected double DemographicsRaceEthnicityAian2000;
    protected double DemographicsRaceEthnicityHispanic2000;
    protected double PartTimeShare;
    protected double PartTimeShare2000;
	public Student(int studentId, int year, Schools school, int size, int enrollmentAll,
			double demographicsRaceEthnicityWhite, double demographicsRaceEthnicityBlack,
			double demographicsRaceEthnicityHispanic, double demographicsRaceEthnicityAsian,
			double demographicsRaceEthnicityAian, double demographicsRaceEthnicityNhpi,
			double demographicsRaceEthnicityTwoOrMore, double demographicsRaceEthnicityNonResidentAlien,
			double demographicsRaceEthnicityUnknown, double demographicsRaceEthnicityWhiteNonHispanic,
			double demographicsRaceEthnicityBlackNonHispanic, double demographicsRaceEthnicityAsianPacificIslander,
			double demographicsRaceEthnicityAianPrior2009, double demographicsRaceEthnicityHispanicPrior2009,
			double demographicsNonResidentAliens2000, double demographicsRaceEthnicityUnknown2000,
			double demographicsRaceEthnicityWhite2000, double demographicsRaceEthnicityBlack2000,
			double demographicsRaceEthnicityApi2000, double demographicsRaceEthnicityAian2000,
			double demographicsRaceEthnicityHispanic2000, double partTimeShare, double partTimeShare2000) {
		super();
		StudentId = studentId;
		Year = year;
		School = school;
		Size = size;
		EnrollmentAll = enrollmentAll;
		DemographicsRaceEthnicityWhite = demographicsRaceEthnicityWhite;
		DemographicsRaceEthnicityBlack = demographicsRaceEthnicityBlack;
		DemographicsRaceEthnicityHispanic = demographicsRaceEthnicityHispanic;
		DemographicsRaceEthnicityAsian = demographicsRaceEthnicityAsian;
		DemographicsRaceEthnicityAian = demographicsRaceEthnicityAian;
		DemographicsRaceEthnicityNhpi = demographicsRaceEthnicityNhpi;
		DemographicsRaceEthnicityTwoOrMore = demographicsRaceEthnicityTwoOrMore;
		DemographicsRaceEthnicityNonResidentAlien = demographicsRaceEthnicityNonResidentAlien;
		DemographicsRaceEthnicityUnknown = demographicsRaceEthnicityUnknown;
		DemographicsRaceEthnicityWhiteNonHispanic = demographicsRaceEthnicityWhiteNonHispanic;
		DemographicsRaceEthnicityBlackNonHispanic = demographicsRaceEthnicityBlackNonHispanic;
		DemographicsRaceEthnicityAsianPacificIslander = demographicsRaceEthnicityAsianPacificIslander;
		DemographicsRaceEthnicityAianPrior2009 = demographicsRaceEthnicityAianPrior2009;
		DemographicsRaceEthnicityHispanicPrior2009 = demographicsRaceEthnicityHispanicPrior2009;
		DemographicsNonResidentAliens2000 = demographicsNonResidentAliens2000;
		DemographicsRaceEthnicityUnknown2000 = demographicsRaceEthnicityUnknown2000;
		DemographicsRaceEthnicityWhite2000 = demographicsRaceEthnicityWhite2000;
		DemographicsRaceEthnicityBlack2000 = demographicsRaceEthnicityBlack2000;
		DemographicsRaceEthnicityApi2000 = demographicsRaceEthnicityApi2000;
		DemographicsRaceEthnicityAian2000 = demographicsRaceEthnicityAian2000;
		DemographicsRaceEthnicityHispanic2000 = demographicsRaceEthnicityHispanic2000;
		PartTimeShare = partTimeShare;
		PartTimeShare2000 = partTimeShare2000;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public Schools getSchool() {
		return School;
	}
	public void setSchool(Schools school) {
		School = school;
	}
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public int getEnrollmentAll() {
		return EnrollmentAll;
	}
	public void setEnrollmentAll(int enrollmentAll) {
		EnrollmentAll = enrollmentAll;
	}
	public String getDemographicsRaceEthnicityWhite() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityWhite == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityWhite);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityWhite(double demographicsRaceEthnicityWhite) {
		DemographicsRaceEthnicityWhite = demographicsRaceEthnicityWhite;
	}
	public String getDemographicsRaceEthnicityBlack() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityBlack == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityBlack);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityBlack(double demographicsRaceEthnicityBlack) {
		DemographicsRaceEthnicityBlack = demographicsRaceEthnicityBlack;
	}
	public String getDemographicsRaceEthnicityHispanic() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityHispanic == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityHispanic);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityHispanic(double demographicsRaceEthnicityHispanic) {
		DemographicsRaceEthnicityHispanic = demographicsRaceEthnicityHispanic;
	}
	public String getDemographicsRaceEthnicityAsian() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityAsian == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityAsian);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityAsian(double demographicsRaceEthnicityAsian) {
		DemographicsRaceEthnicityAsian = demographicsRaceEthnicityAsian;
	}
	public String getDemographicsRaceEthnicityAian() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityAian == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityAian);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityAian(double demographicsRaceEthnicityAian) {
		DemographicsRaceEthnicityAian = demographicsRaceEthnicityAian;
	}
	public String getDemographicsRaceEthnicityNhpi() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityNhpi == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityNhpi);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityNhpi(double demographicsRaceEthnicityNhpi) {
		DemographicsRaceEthnicityNhpi = demographicsRaceEthnicityNhpi;
	}
	public String getDemographicsRaceEthnicityTwoOrMore() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityTwoOrMore == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityTwoOrMore);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityTwoOrMore(double demographicsRaceEthnicityTwoOrMore) {
		DemographicsRaceEthnicityTwoOrMore = demographicsRaceEthnicityTwoOrMore;
	}
	public String getDemographicsRaceEthnicityNonResidentAlien() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityNonResidentAlien == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityNonResidentAlien);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityNonResidentAlien(double demographicsRaceEthnicityNonResidentAlien) {
		DemographicsRaceEthnicityNonResidentAlien = demographicsRaceEthnicityNonResidentAlien;
	}
	public String getDemographicsRaceEthnicityUnknown() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityUnknown == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityUnknown);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityUnknown(double demographicsRaceEthnicityUnknown) {
		DemographicsRaceEthnicityUnknown = demographicsRaceEthnicityUnknown;
	}
	public String getDemographicsRaceEthnicityWhiteNonHispanic() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityWhiteNonHispanic == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityWhiteNonHispanic);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityWhiteNonHispanic(double demographicsRaceEthnicityWhiteNonHispanic) {
		DemographicsRaceEthnicityWhiteNonHispanic = demographicsRaceEthnicityWhiteNonHispanic;
	}
	public String getDemographicsRaceEthnicityBlackNonHispanic() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityBlackNonHispanic == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityBlackNonHispanic);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityBlackNonHispanic(double demographicsRaceEthnicityBlackNonHispanic) {
		DemographicsRaceEthnicityBlackNonHispanic = demographicsRaceEthnicityBlackNonHispanic;
	}
	public String getDemographicsRaceEthnicityAsianPacificIslander() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityAsianPacificIslander == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityAsianPacificIslander);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityAsianPacificIslander(double demographicsRaceEthnicityAsianPacificIslander) {
		DemographicsRaceEthnicityAsianPacificIslander = demographicsRaceEthnicityAsianPacificIslander;
	}
	public String getDemographicsRaceEthnicityAianPrior2009() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityAianPrior2009 == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityAianPrior2009);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityAianPrior2009(double demographicsRaceEthnicityAianPrior2009) {
		DemographicsRaceEthnicityAianPrior2009 = demographicsRaceEthnicityAianPrior2009;
	}
	public String getDemographicsRaceEthnicityHispanicPrior2009() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityHispanicPrior2009 == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityHispanicPrior2009);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityHispanicPrior2009(double demographicsRaceEthnicityHispanicPrior2009) {
		DemographicsRaceEthnicityHispanicPrior2009 = demographicsRaceEthnicityHispanicPrior2009;
	}
	public String getDemographicsNonResidentAliens2000() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsNonResidentAliens2000 == 0){
			return "0";
		} else {
			String output = df.format(DemographicsNonResidentAliens2000);
			return output;
        }
	}
	public void setDemographicsNonResidentAliens2000(double demographicsNonResidentAliens2000) {
		DemographicsNonResidentAliens2000 = demographicsNonResidentAliens2000;
	}
	public String getDemographicsRaceEthnicityUnknown2000() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityUnknown2000 == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityUnknown2000);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityUnknown2000(double demographicsRaceEthnicityUnknown2000) {
		DemographicsRaceEthnicityUnknown2000 = demographicsRaceEthnicityUnknown2000;
	}
	public String getDemographicsRaceEthnicityWhite2000() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityWhite2000 == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityWhite2000);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityWhite2000(double demographicsRaceEthnicityWhite2000) {
		DemographicsRaceEthnicityWhite2000 = demographicsRaceEthnicityWhite2000;
	}
	public String getDemographicsRaceEthnicityBlack2000() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityBlack2000 == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityBlack2000);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityBlack2000(double demographicsRaceEthnicityBlack2000) {
		DemographicsRaceEthnicityBlack2000 = demographicsRaceEthnicityBlack2000;
	}
	public String getDemographicsRaceEthnicityApi2000() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityApi2000 == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityApi2000);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityApi2000(double demographicsRaceEthnicityApi2000) {
		DemographicsRaceEthnicityApi2000 = demographicsRaceEthnicityApi2000;
	}
	public String getDemographicsRaceEthnicityAian2000() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityAian2000 == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityAian2000);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityAian2000(double demographicsRaceEthnicityAian2000) {
		DemographicsRaceEthnicityAian2000 = demographicsRaceEthnicityAian2000;
	}
	public String getDemographicsRaceEthnicityHispanic2000() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(DemographicsRaceEthnicityHispanic2000 == 0){
			return "0";
		} else {
			String output = df.format(DemographicsRaceEthnicityHispanic2000);
			return output;
        }
	}
	public void setDemographicsRaceEthnicityHispanic2000(double demographicsRaceEthnicityHispanic2000) {
		DemographicsRaceEthnicityHispanic2000 = demographicsRaceEthnicityHispanic2000;
	}
	public String getPartTimeShare() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(PartTimeShare == 0){
			return "0";
		} else {
			String output = df.format(PartTimeShare);
			return output;
        }
	}
	public void setPartTimeShare(double partTimeShare) {
		PartTimeShare = partTimeShare;
	}
	public String getPartTimeShare2000() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(PartTimeShare2000 == 0){
			return "0";
		} else {
			String output = df.format(PartTimeShare2000);
			return output;
        }
	}
	public void setPartTimeShare2000(double partTimeShare2000) {
		PartTimeShare2000 = partTimeShare2000;
	}
    
}
