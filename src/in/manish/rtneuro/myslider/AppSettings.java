package in.manish.rtneuro.myslider;

import in.manish.rtneuro.util.StringUtils;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Manish Pathak
 *
 */
public class AppSettings {
	//	AppSettings.setPreference(getApplicationContext(), AppSettings.MESSAGE,txtMessage.getText().toString());
	//	AppSettings.getPrefernce(getApplicationContext(), AppSettings.MOBILE_NUMBER),AppSettings.getPrefernce(getApplicationContext(), AppSettings.MESSAGE)
	 
	private static final String PREF_NAME = "analyticpref";
	public static final String PREF_NAME_OTHER = "otherpref";
	
	public static final String USER_SELECTED_MAIL_ID = "usermailid";
	public static final String ACCOUNT_NAME = "acname";
	public static final String ACCOUNT_TOKEN = "token";
	public static final String PROFILE_ID = "profileid";
	public static final String DATA_SET_ID= "datasetid";
	public static final String PROFILE_NAME= "profilename";
	public static final String REALTIME_LOGIN_MAILID= "realtimeloginMailid";
	
	public static final String MAX_RESULT = "maxresult";
	
	public static final String DATES = "dates";
	public static final String DATE_SELECTED_BY_SETTING_PERIOD = "dateselectedwhichperiod";//either from main action bar or from setting
	public static final String START_DATE = "startdate";
	public static final String END_DATE = "enddate";
	public static final String DONT_SHOW_DIALOG = "dontshow";
	public static final String KEEP_SCREEN_ON_OFF = "keepscreenon";

	public static Object getPrefernce(Context context, String prefName, String tag, Object defaultValue){
		return getObject(context,prefName, tag, defaultValue);
	}
//don't use it
//	public static Integer getPrefernceInt(Context context, String prefName, String tag){
//		return (Integer)getObject(context, prefName , tag);
//	}
	public static String getPrefernceString(Context context, String prefName, String tag){
		return (String)getObject(context, prefName , tag);
	}

	public static void setPreference(Context context, String prefName, String tag,Object value){
		putString(context,prefName,tag,value);
	}
	public static void setPreference(Context context,String prefName, String tag, Integer value){
		putString(context,prefName,tag,String.valueOf(value));
	}

	private static Object getObject(Context context, String prefName, String tag) {
		SharedPreferences pref;
		if(StringUtils.notEmpty(prefName) && prefName.equalsIgnoreCase(PREF_NAME_OTHER)) {
			pref = context.getSharedPreferences(PREF_NAME_OTHER, 0);
		} else {
			pref = context.getSharedPreferences(PREF_NAME, 0);
		}
		Map<String, ?> map = pref.getAll();
		Object value = map.get(tag);
		if(value instanceof Boolean)
			return pref.getBoolean(tag, false);
		else if(value instanceof Integer)
			return pref.getInt(tag, 0);
		else if(value instanceof Float)
			return pref.getFloat(tag, 0);
		else if(value instanceof Long)
			return pref.getLong(tag, 0);
		else 
			return pref.getString(tag, "");
	}

	private static Object getObject(Context context, String prefName, String tag, Object defaultValue) {
		SharedPreferences pref;
		if(StringUtils.notEmpty(prefName) && prefName.equalsIgnoreCase(PREF_NAME_OTHER)) {
			pref = context.getSharedPreferences(PREF_NAME_OTHER, 0);
		} else {
			pref = context.getSharedPreferences(PREF_NAME, 0);
		}
		Map<String, ?> map = pref.getAll();
		Object value = map.get(tag);
		if(value instanceof Boolean)
			return pref.getBoolean(tag, ((Boolean)defaultValue).booleanValue());
		else if(value instanceof Integer)
			return pref.getInt(tag, ((Integer)defaultValue).intValue());
		else if(value instanceof Float)
			return pref.getFloat(tag, ((Float)defaultValue).floatValue());
		else if(value instanceof Long)
			return pref.getLong(tag, ((Long)defaultValue).longValue());
		else 
			return pref.getString(tag, (String)defaultValue);
	}

	public static void putString(Context context, String prefName, String tag, Object value) {
		SharedPreferences pref;
		if(StringUtils.notEmpty(prefName) && prefName.equalsIgnoreCase(PREF_NAME_OTHER)) {
			pref = context.getSharedPreferences(PREF_NAME_OTHER, 0);
		} else {
			pref = context.getSharedPreferences(PREF_NAME, 0);
		}
		SharedPreferences.Editor editor = pref.edit();
		if(value instanceof Boolean)
			editor.putBoolean(tag, (Boolean)value);
		else if(value instanceof Integer)
			editor.putInt(tag, (Integer)value);
		else if(value instanceof Float)
			editor.putFloat(tag, (Float)value);
		else if(value instanceof Long)
			editor.putLong(tag, (Long)value);
		else 
			editor.putString(tag, String.valueOf(value));
		editor.commit();
	}

	//	private SharedPreferences mSharedPref = null;
	//
	//	  private AppSettings(Context paramContext)
	//	  {
	//	    this.mSharedPref = PreferenceManager.getDefaultSharedPreferences(paramContext);
	//	  }
	//
	//	  public static AppSettings getInstance(Context paramContext)
	//	  {
	//	    if (mSelf == null)
	//	      mSelf = new AppSettings(paramContext);
	//	    return mSelf;
	//	  }

}

