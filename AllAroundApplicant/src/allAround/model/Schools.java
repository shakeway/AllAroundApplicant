package allAround.model;

/**
 * 
 * @author Xiao Ai
 * Nov 17, 2016
 */
public class Schools {
	protected int unitId;
	protected String name;
	protected String city;
	protected String state;
	protected int zip;
	protected double lat;
	protected double lon;
	protected String schoolUrl;
	protected String priceCalculatorUrl;
	protected boolean mainCampus;
	protected int branches;
	protected int predominant;
	protected int highest;
	protected int ownership;
	protected int stateFips;
	protected int regionId;
	protected int carnegieBasic;
	protected int carnegieUndergrad;
	protected int carnegieSizeSetting;
	protected boolean menOnly;
	protected boolean womenOnly;
	protected int religiousAffiliation;

	public Schools(int unitId, String name, String city, String state, int zip, double lat, double lon,
			String schoolUrl, String priceCalculatorUrl, boolean mainCampus, int branches, int predominant, int highest,
			int ownership, int stateFips, int regionId, int carnegieBasic, int carnegieUndergrad,
			int carnegieSizeSetting, boolean menOnly, boolean womenOnly, int religiousAffiliation) {
		super();
		this.unitId = unitId;
		this.name = name;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.lat = lat;
		this.lon = lon;
		this.schoolUrl = schoolUrl;
		this.priceCalculatorUrl = priceCalculatorUrl;
		this.mainCampus = mainCampus;
		this.branches = branches;
		this.predominant = predominant;
		this.highest = highest;
		this.ownership = ownership;
		this.stateFips = stateFips;
		this.regionId = regionId;
		this.carnegieBasic = carnegieBasic;
		this.carnegieUndergrad = carnegieUndergrad;
		this.carnegieSizeSetting = carnegieSizeSetting;
		this.menOnly = menOnly;
		this.womenOnly = womenOnly;
		this.religiousAffiliation = religiousAffiliation;
	}
	
	public Schools(int unitId) {
		this.unitId = unitId;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getSchoolUrl() {
		return schoolUrl;
	}

	public void setSchoolUrl(String schoolUrl) {
		this.schoolUrl = schoolUrl;
	}

	public String getPriceCalculatorUrl() {
		return priceCalculatorUrl;
	}

	public void setPriceCalculatorUrl(String priceCalculatorUrl) {
		this.priceCalculatorUrl = priceCalculatorUrl;
	}

	public boolean isMainCampus() {
		return mainCampus;
	}

	public void setMainCampus(boolean mainCampus) {
		this.mainCampus = mainCampus;
	}

	public int getBranches() {
		return branches;
	}

	public void setBranches(int branches) {
		this.branches = branches;
	}

	public int getPredominant() {
		return predominant;
	}

	public void setPredominant(int predominant) {
		this.predominant = predominant;
	}

	public int getHighest() {
		return highest;
	}

	public void setHighest(int highest) {
		this.highest = highest;
	}

	public int getOwnership() {
		return ownership;
	}

	public void setOwnership(int ownership) {
		this.ownership = ownership;
	}

	public int getStateFips() {
		return stateFips;
	}

	public void setStateFips(int stateFips) {
		this.stateFips = stateFips;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getCarnegieBasic() {
		return carnegieBasic;
	}

	public void setCarnegieBasic(int carnegieBasic) {
		this.carnegieBasic = carnegieBasic;
	}

	public int getCarnegieUndergrad() {
		return carnegieUndergrad;
	}

	public void setCarnegieUndergrad(int carnegieUndergrad) {
		this.carnegieUndergrad = carnegieUndergrad;
	}

	public int getCarnegieSizeSetting() {
		return carnegieSizeSetting;
	}

	public void setCarnegieSizeSetting(int carnegieSizeSetting) {
		this.carnegieSizeSetting = carnegieSizeSetting;
	}

	public boolean isMenOnly() {
		return menOnly;
	}

	public void setMenOnly(boolean menOnly) {
		this.menOnly = menOnly;
	}

	public boolean isWomenOnly() {
		return womenOnly;
	}

	public void setWomenOnly(boolean womenOnly) {
		this.womenOnly = womenOnly;
	}

	public int getReligiousAffiliation() {
		return religiousAffiliation;
	}

	public void setReligiousAffiliation(int religiousAffiliation) {
		this.religiousAffiliation = religiousAffiliation;
	}

}
