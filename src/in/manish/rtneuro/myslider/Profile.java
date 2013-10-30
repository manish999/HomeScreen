package in.manish.rtneuro.myslider;

import java.io.Serializable;

/**
 *  @author Manish Pathak
 */
@SuppressWarnings("serial") 
public class Profile implements Serializable{
	private String AccountID;
	private String AccountRowID;
	private String AccountToken;
	private String Currency;
	private String ID;
	private Integer IsFavorite;
	private String ProfileID;
	private String ProfileName;
	private String TimeZone;
	private String WebProfileID;
	private String datasetID;//a38927772w67724807p69701808/

	/**
	 * Method getAccountID.
	 * @return String
	 */
	public String getAccountID() {
		return this.AccountID;
	}

	/**
	 * Method getAccountRowID.
	 * @return String
	 */
	public String getAccountRowID() {
		return this.AccountRowID;
	}

	/**
	 * Method getAccountToken.
	 * @return String
	 */
	public String getAccountToken() {
		return this.AccountToken;
	}

	/**
	 * Method getCurrency.
	 * @return String
	 */
	public String getCurrency() {
		return this.Currency;
	}

	/**
	 * Method getID.
	 * @return String
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * Method getIsFavorite.
	 * @return Integer
	 */
	public Integer getIsFavorite() {
		return this.IsFavorite;
	}

	/**
	 * Method getProfileID.
	 * @return String
	 */
	public String getProfileID() {
		return this.ProfileID;
	}

	/**
	 * Method getProfileName.
	 * @return String
	 */
	public String getProfileName() {
		return this.ProfileName;
	}

	/**
	 * Method getTimeZone.
	 * @return String
	 */
	public String getTimeZone() {
		return this.TimeZone;
	}

	/**
	 * Method getWebProfileID.
	 * @return String
	 */
	public String getWebProfileID() {
		return this.WebProfileID;
	}

	/**
	 * Method setAccountID.
	 * @param paramString String
	 */
	public void setAccountID(String paramString) {
		this.AccountID = paramString;
	}

	/**
	 * Method setAccountRowID.
	 * @param paramString String
	 */
	public void setAccountRowID(String paramString) {
		this.AccountRowID = paramString;
	}

	/**
	 * Method setAccountToken.
	 * @param paramString String
	 */
	public void setAccountToken(String paramString) {
		this.AccountToken = paramString;
	}

	/**
	 * Method setCurrency.
	 * @param paramString String
	 */
	public void setCurrency(String paramString) {
		this.Currency = paramString;
	}

	/**
	 * Method setID.
	 * @param paramString String
	 */
	public void setID(String paramString) {
		this.ID = paramString;
	}

	/**
	 * Method setIsFavorite.
	 * @param paramInteger Integer
	 */
	public void setIsFavorite(Integer paramInteger) {
		this.IsFavorite = paramInteger;
	}

	/**
	 * Method setProfileID.
	 * @param paramString String
	 */
	public void setProfileID(String paramString) {
		this.ProfileID = paramString;
	}

	/**
	 * Method setProfileName.
	 * @param paramString String
	 */
	public void setProfileName(String paramString) {
		this.ProfileName = paramString;
	}

	/**
	 * Method setTimeZone.
	 * @param paramString String
	 */
	public void setTimeZone(String paramString) {
		this.TimeZone = paramString;
	}

	/**
	 * Method setWebProfileID.
	 * @param paramString String
	 */
	public void setWebProfileID(String paramString) {
		this.WebProfileID = paramString;
	}

	public String getDatasetID() {
		return datasetID;
	}

	public void setDatasetID(String datasetID) {
		this.datasetID = datasetID;
	}
	
}