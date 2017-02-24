package allAround.model;
/**
 * 
 * @author Xiao Ai
 * Nov 17, 2016
 */
public class CIP {
	protected int cipCode;
	protected String title;
	protected String description;

	public CIP(int cipCode, String title, String description) {
		this.cipCode = cipCode;
		this.title = title;
		this.description = description;
	}

	public int getCipCode() {
		return cipCode;
	}

	public void setCipCode(int cipCode) {
		this.cipCode = cipCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
