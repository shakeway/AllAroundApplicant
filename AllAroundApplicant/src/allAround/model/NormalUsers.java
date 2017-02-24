package allAround.model;

import java.util.Date;

public class NormalUsers extends Users{
	protected Date DOB;
	protected Status status;
	
	public enum Status{
		Applicant, CollegeStudent, Parent
	}
	
	public NormalUsers(String userName, String password, String firstName, String lastName, String email,
			String phone, Date dob, Status status) {
		super(userName, password, firstName, lastName, email, phone);
		this.DOB = dob;		
		this.status = status;
	}
	
    public NormalUsers(String userName) {
		super(userName);
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dob) {
		this.DOB = dob;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
