package allAround.model;
import java.text.DecimalFormat;

public class Admission {
	protected int AdmissionId;
	protected Schools School;
	protected int Year;
	protected double AdmissionRateOverall;
	protected double AdmissionRateByOpeId;
    protected int SatScores25thPercentileCriticalReading;
    protected int SatScores75thPercentileCriticalReading;
    protected int SatScores25thPercentileMath;
    protected int SatScores75thPercentileMath;
    protected int SatScores25thPercentileWriting;
    protected int SatScores75thPercentileWriting;
    protected int SatScoresMidpointCriticalReading;
    protected int SatScoresMidpointMath;
    protected int SatScoresMidpointWriting;
    protected int ActScores25thPercentileCumulative;
    protected int ActScores75thPercentileCumulative;
    protected int ActScores25thPercentileEnglish;
    protected int ActScores75thPercentileEnglish;
    protected int ActScores25thPercentileMath;
    protected int ActScores75thPercentileMath;
    protected int ActScores25thPercentileWriting;
    protected int ActScores75thPercentileWriting;
    protected int ActScoresMidpointCumulative;
    protected int ActScoresMidpointEnglish;
    protected int ActScoresMidpointMath;
    protected int ActScoresMidpointWriting;
    protected int SatScoresAverageOverall;
    protected int SatScoresAverageByOpeId;
	public Admission(int admissionId, Schools school, int year, double admissionRateOverall,
			double admissionRateByOpeId, int satScores25thPercentileCriticalReading,
			int satScores75thPercentileCriticalReading, int satScores25thPercentileMath,
			int satScores75thPercentileMath, int satScores25thPercentileWriting, int satScores75thPercentileWriting,
			int satScoresMidpointCriticalReading, int satScoresMidpointMath, int satScoresMidpointWriting,
			int actScores25thPercentileCumulative, int actScores75thPercentileCumulative,
			int actScores25thPercentileEnglish, int actScores75thPercentileEnglish, int actScores25thPercentileMath,
			int actScores75thPercentileMath, int actScores25thPercentileWriting, int actScores75thPercentileWriting,
			int actScoresMidpointCumulative, int actScoresMidpointEnglish, int actScoresMidpointMath,
			int actScoresMidpointWriting, int satScoresAverageOverall, int satScoresAverageByOpeId) {
		super();
		AdmissionId = admissionId;
		School = school;
		Year = year;
		AdmissionRateOverall = admissionRateOverall;
		AdmissionRateByOpeId = admissionRateByOpeId;
		SatScores25thPercentileCriticalReading = satScores25thPercentileCriticalReading;
		SatScores75thPercentileCriticalReading = satScores75thPercentileCriticalReading;
		SatScores25thPercentileMath = satScores25thPercentileMath;
		SatScores75thPercentileMath = satScores75thPercentileMath;
		SatScores25thPercentileWriting = satScores25thPercentileWriting;
		SatScores75thPercentileWriting = satScores75thPercentileWriting;
		SatScoresMidpointCriticalReading = satScoresMidpointCriticalReading;
		SatScoresMidpointMath = satScoresMidpointMath;
		SatScoresMidpointWriting = satScoresMidpointWriting;
		ActScores25thPercentileCumulative = actScores25thPercentileCumulative;
		ActScores75thPercentileCumulative = actScores75thPercentileCumulative;
		ActScores25thPercentileEnglish = actScores25thPercentileEnglish;
		ActScores75thPercentileEnglish = actScores75thPercentileEnglish;
		ActScores25thPercentileMath = actScores25thPercentileMath;
		ActScores75thPercentileMath = actScores75thPercentileMath;
		ActScores25thPercentileWriting = actScores25thPercentileWriting;
		ActScores75thPercentileWriting = actScores75thPercentileWriting;
		ActScoresMidpointCumulative = actScoresMidpointCumulative;
		ActScoresMidpointEnglish = actScoresMidpointEnglish;
		ActScoresMidpointMath = actScoresMidpointMath;
		ActScoresMidpointWriting = actScoresMidpointWriting;
		SatScoresAverageOverall = satScoresAverageOverall;
		SatScoresAverageByOpeId = satScoresAverageByOpeId;
	}
	public int getAdmissionId() {
		return AdmissionId;
	}
	public void setAdmissionId(int admissionId) {
		AdmissionId = admissionId;
	}
	public Schools getSchool() {
		return School;
	}
	public void setSchool(Schools school) {
		School = school;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	/*public double getAdmissionRateOverall() {
		return AdmissionRateOverall;
	}*/
	
	public String getAdmissionRateOverall(){
		DecimalFormat df = new DecimalFormat("0.00%");
		if(AdmissionRateOverall == 0){
			return "0";
		} else {
			String output = df.format(AdmissionRateOverall);
			return output;
        }
	}
	
	public void setAdmissionRateOverall(double admissionRateOverall) {
		AdmissionRateOverall = admissionRateOverall;
	}
	public String getAdmissionRateByOpeId() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(AdmissionRateByOpeId == 0){
			return "0";
		} else {
			String output = df.format(AdmissionRateByOpeId);
			return output;
        }
	}
	public void setAdmissionRateByOpeId(double admissionRateByOpeId) {
		AdmissionRateByOpeId = admissionRateByOpeId;
	}
	public int getSatScores25thPercentileCriticalReading() {
		return SatScores25thPercentileCriticalReading;
	}
	public void setSatScores25thPercentileCriticalReading(int satScores25thPercentileCriticalReading) {
		SatScores25thPercentileCriticalReading = satScores25thPercentileCriticalReading;
	}
	public int getSatScores75thPercentileCriticalReading() {
		return SatScores75thPercentileCriticalReading;
	}
	public void setSatScores75thPercentileCriticalReading(int satScores75thPercentileCriticalReading) {
		SatScores75thPercentileCriticalReading = satScores75thPercentileCriticalReading;
	}
	public int getSatScores25thPercentileMath() {
		return SatScores25thPercentileMath;
	}
	public void setSatScores25thPercentileMath(int satScores25thPercentileMath) {
		SatScores25thPercentileMath = satScores25thPercentileMath;
	}
	public int getSatScores75thPercentileMath() {
		return SatScores75thPercentileMath;
	}
	public void setSatScores75thPercentileMath(int satScores75thPercentileMath) {
		SatScores75thPercentileMath = satScores75thPercentileMath;
	}
	public int getSatScores25thPercentileWriting() {
		return SatScores25thPercentileWriting;
	}
	public void setSatScores25thPercentileWriting(int satScores25thPercentileWriting) {
		SatScores25thPercentileWriting = satScores25thPercentileWriting;
	}
	public int getSatScores75thPercentileWriting() {
		return SatScores75thPercentileWriting;
	}
	public void setSatScores75thPercentileWriting(int satScores75thPercentileWriting) {
		SatScores75thPercentileWriting = satScores75thPercentileWriting;
	}
	public int getSatScoresMidpointCriticalReading() {
		return SatScoresMidpointCriticalReading;
	}
	public void setSatScoresMidpointCriticalReading(int satScoresMidpointCriticalReading) {
		SatScoresMidpointCriticalReading = satScoresMidpointCriticalReading;
	}
	public int getSatScoresMidpointMath() {
		return SatScoresMidpointMath;
	}
	public void setSatScoresMidpointMath(int satScoresMidpointMath) {
		SatScoresMidpointMath = satScoresMidpointMath;
	}
	public int getSatScoresMidpointWriting() {
		return SatScoresMidpointWriting;
	}
	public void setSatScoresMidpointWriting(int satScoresMidpointWriting) {
		SatScoresMidpointWriting = satScoresMidpointWriting;
	}
	public int getActScores25thPercentileCumulative() {
		return ActScores25thPercentileCumulative;
	}
	public void setActScores25thPercentileCumulative(int actScores25thPercentileCumulative) {
		ActScores25thPercentileCumulative = actScores25thPercentileCumulative;
	}
	public int getActScores75thPercentileCumulative() {
		return ActScores75thPercentileCumulative;
	}
	public void setActScores75thPercentileCumulative(int actScores75thPercentileCumulative) {
		ActScores75thPercentileCumulative = actScores75thPercentileCumulative;
	}
	public int getActScores25thPercentileEnglish() {
		return ActScores25thPercentileEnglish;
	}
	public void setActScores25thPercentileEnglish(int actScores25thPercentileEnglish) {
		ActScores25thPercentileEnglish = actScores25thPercentileEnglish;
	}
	public int getActScores75thPercentileEnglish() {
		return ActScores75thPercentileEnglish;
	}
	public void setActScores75thPercentileEnglish(int actScores75thPercentileEnglish) {
		ActScores75thPercentileEnglish = actScores75thPercentileEnglish;
	}
	public int getActScores25thPercentileMath() {
		return ActScores25thPercentileMath;
	}
	public void setActScores25thPercentileMath(int actScores25thPercentileMath) {
		ActScores25thPercentileMath = actScores25thPercentileMath;
	}
	public int getActScores75thPercentileMath() {
		return ActScores75thPercentileMath;
	}
	public void setActScores75thPercentileMath(int actScores75thPercentileMath) {
		ActScores75thPercentileMath = actScores75thPercentileMath;
	}
	public int getActScores25thPercentileWriting() {
		return ActScores25thPercentileWriting;
	}
	public void setActScores25thPercentileWriting(int actScores25thPercentileWriting) {
		ActScores25thPercentileWriting = actScores25thPercentileWriting;
	}
	public int getActScores75thPercentileWriting() {
		return ActScores75thPercentileWriting;
	}
	public void setActScores75thPercentileWriting(int actScores75thPercentileWriting) {
		ActScores75thPercentileWriting = actScores75thPercentileWriting;
	}
	public int getActScoresMidpointCumulative() {
		return ActScoresMidpointCumulative;
	}
	public void setActScoresMidpointCumulative(int actScoresMidpointCumulative) {
		ActScoresMidpointCumulative = actScoresMidpointCumulative;
	}
	public int getActScoresMidpointEnglish() {
		return ActScoresMidpointEnglish;
	}
	public void setActScoresMidpointEnglish(int actScoresMidpointEnglish) {
		ActScoresMidpointEnglish = actScoresMidpointEnglish;
	}
	public int getActScoresMidpointMath() {
		return ActScoresMidpointMath;
	}
	public void setActScoresMidpointMath(int actScoresMidpointMath) {
		ActScoresMidpointMath = actScoresMidpointMath;
	}
	public int getActScoresMidpointWriting() {
		return ActScoresMidpointWriting;
	}
	public void setActScoresMidpointWriting(int actScoresMidpointWriting) {
		ActScoresMidpointWriting = actScoresMidpointWriting;
	}
	public int getSatScoresAverageOverall() {
		return SatScoresAverageOverall;
	}
	public void setSatScoresAverageOverall(int satScoresAverageOverall) {
		SatScoresAverageOverall = satScoresAverageOverall;
	}
	public int getSatScoresAverageByOpeId() {
		return SatScoresAverageByOpeId;
	}
	public void setSatScoresAverageByOpeId(int satScoresAverageByOpeId) {
		SatScoresAverageByOpeId = satScoresAverageByOpeId;
	}
	
	
	
}
