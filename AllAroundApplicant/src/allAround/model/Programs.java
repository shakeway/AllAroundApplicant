package allAround.model;

import java.text.DecimalFormat;

/**
 * 
 * @author Xiao Ai Nov 17, 2016
 */
public class Programs {
	protected int programId;
	protected int year;
	protected double percentage;
	protected boolean cert1;
	protected boolean cert2;
	protected boolean cert4;
	protected boolean associate;
	protected boolean bachelor;
	protected CIP cip;
	protected Schools school;

	public Programs(int programId) {
		this.programId = programId;
	}

	public Programs(int programId, int year, double percentage, boolean cert1, boolean cert2, boolean cert4,
			boolean associate, boolean bachelor, CIP cip, Schools school) {
		this.programId = programId;
		this.year = year;
		this.percentage = percentage;
		this.cert1 = cert1;
		this.cert2 = cert2;
		this.cert4 = cert4;
		this.associate = associate;
		this.bachelor = bachelor;
		this.cip = cip;
		this.school = school;
	}

	public Programs(int year, double percentage, boolean cert1, boolean cert2, boolean cert4, boolean associate,
			boolean bachelor, CIP cip, Schools school) {
		this.year = year;
		this.percentage = percentage;
		this.cert1 = cert1;
		this.cert2 = cert2;
		this.cert4 = cert4;
		this.associate = associate;
		this.bachelor = bachelor;
		this.cip = cip;
		this.school = school;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPercentage() {
		DecimalFormat df = new DecimalFormat("0.00%");
		if(percentage == 0){
			return "0";
		} else {
			String output = df.format(percentage);
			return output;
        }
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public boolean isCert1() {
		return cert1;
	}

	public void setCert1(boolean cert1) {
		this.cert1 = cert1;
	}

	public boolean isCert2() {
		return cert2;
	}

	public void setCert2(boolean cert2) {
		this.cert2 = cert2;
	}

	public boolean isCert4() {
		return cert4;
	}

	public void setCert4(boolean cert4) {
		this.cert4 = cert4;
	}

	public boolean isAssociate() {
		return associate;
	}

	public void setAssociate(boolean associate) {
		this.associate = associate;
	}

	public boolean isBachelor() {
		return bachelor;
	}

	public void setBachelor(boolean bachelor) {
		this.bachelor = bachelor;
	}

	public CIP getCip() {
		return cip;
	}

	public void setCip(CIP cip) {
		this.cip = cip;
	}

	public Schools getSchool() {
		return school;
	}

	public void setSchool(Schools school) {
		this.school = school;
	}

}
