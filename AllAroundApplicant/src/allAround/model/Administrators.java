package allAround.model;

import java.util.Date;

public class Administrators extends Users {
	protected Date loginTime;
	
	public Administrators(String userName, String password, String firstName, String lastName, String email,
			String phone, Date loginTime) {
		super(userName, password, firstName, lastName, email, phone);
		
		this.loginTime = loginTime;
	}
	
	public Administrators(String userName){
		super(userName);
	}

	public Date getLogInTime() {
		return loginTime;
	}

	public void setLogInTime(Date logInTime) {
		this.loginTime = logInTime;
	}	
}
