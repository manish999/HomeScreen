package in.manish.rtneuro.myslider;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  @author Manish Pathak
 */
@SuppressWarnings("serial")
public class Account implements Serializable {
	private String AccountID;
	private String AccountName;
	private String ID;
	private String accountToken;
	private ArrayList<Profile> profiles;

	/**
	 * Method getAccountID.
	 * @return String
	 */
	public String getAccountID() {
		return this.AccountID;
	}

	/**
	 * Method getAccountName.
	 * @return String
	 */
	public String getAccountName() {
		return this.AccountName;
	}

	/**
	 * Method getAccountToken.
	 * @return String
	 */
	public String getAccountToken() {
		return this.accountToken;
	}

	/**
	 * Method getID.
	 * @return String
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * Method setAccountID.
	 * @param paramString String
	 */
	public void setAccountID(String paramString) {
		this.AccountID = paramString;
	}

	/**
	 * Method setAccountName.
	 * @param paramString String
	 */
	public void setAccountName(String paramString) {
		this.AccountName = paramString;
	}

	/**
	 * Method setAccountToken.
	 * @param paramString String
	 */
	public void setAccountToken(String paramString) {
		this.accountToken = paramString;
	}

	/**
	 * Method setID.
	 * @param paramString String
	 */
	public void setID(String paramString) {
		this.ID = paramString;
	}

	/**
	 * Method getProfiles.
	 * @return ArrayList<Profile>
	 */
	public ArrayList<Profile> getProfiles() {
		return profiles;
	}

	/**
	 * Method setProfiles.
	 * @param profiles ArrayList<Profile>
	 */
	public void setProfiles(ArrayList<Profile> profiles) {
		this.profiles = profiles;
	}

}