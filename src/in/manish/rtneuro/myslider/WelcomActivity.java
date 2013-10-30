package in.manish.rtneuro.myslider;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.actionbarsherlock.view.MenuItem;
import in.manish.rtneuro.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * @author Manish Pathak
 *
 */
public class WelcomActivity extends BaseSliderActivity {

	public WelcomActivity() {
		super(R.string.app_name);
	}

	//	private ArrayList<AccountProfile> accountProfiles = new ArrayList<AccountProfile>();

	public ProgressDialog progressDialog;

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		// Up Icon + Logo + Hide title...
		getSupportActionBar().setDisplayHomeAsUpEnabled (true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayUseLogoEnabled  (true);
		setContentView(R.layout.arrowspage);
	}

	@Override
	protected void onResume() {
		super.onResume();
		//		if(Constants.CLOSE_ALL_ACTIVITIES) {
		//			finish();
		//		}
		//		refresh();
	}

	@Override
	protected void setupActionBarAndMenuBar()
	{
		// Up Icon + Logo + Hide title...
		getSupportActionBar().setDisplayHomeAsUpEnabled (true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayUseLogoEnabled  (true);

	}
	//}

	//	@Override
	//	public boolean onPrepareOptionsMenu(Menu menu) {
	//		menu.removeItem(R.id.action_period);
	//		return true;
	//	}

	//	@Override
	//	public boolean onOptionsItemSelected(MenuItem item) {
	//		switch (item.getItemId()) {
	//		// to close the sliding menu
	//		case android.R.id.home:
	//			return true;
	//		}
	//		return super.onOptionsItemSelected(item);
	//	}

	//	@Override
	//	public boolean onOptionsItemSelected(MenuItem item) {
	//		switch (item.getItemId()) {
	//		// to close the sliding menu
	//		case android.R.id.home:
	//			return true;
	//			
	//		case R.id.action_refresh:
	//			refresh();
	//			return true;
	//
	//		case R.id.action_settings:
	//			Intent calslIntent = new Intent(this, SettingsActivity.class);
	//			startActivity(calslIntent);
	//			return true;
	//
	//		case R.id.action_help:
	//			return true;
	//
	//		case R.id.action_feedback:
	//
	//			return true;
	//		}
	//		return true;
	//	}

	//
	//	@Override
	//	protected void setupActionBarAndMenuBar() {
	//		// customize the Action bar
	//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	//		getSupportActionBar().setDisplayShowTitleEnabled(true);
	//		getSupportActionBar().setDisplayUseLogoEnabled(true);
	//
	//		// customize the SlidingMenu
	////		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
	//	}
}