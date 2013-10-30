package in.manish.rtneuro.myslider;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.WindowManager;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import in.manish.rtneuro.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * This class is used to give the functionality of menu. 
 * @author Manish Pathak
 *
 */
public abstract class BaseSliderActivity extends SlidingFragmentActivity {

	private int mTitleRes;
	protected SherlockFragment mFrag;
	private Menu optionsMenu;
	boolean refresh = true;

	/** for different implementation of action and sliding menu bar in each screen*/
	protected abstract void setupActionBarAndMenuBar();

	public BaseSliderActivity(int titleRes) {
		mTitleRes = titleRes;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// default is to keep screen on , one can change it from setting.
		keepScreenOn();
		setTitle(mTitleRes);

		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = new ColorMenuFragment();
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else {
			mFrag = (SherlockFragment)this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
		}

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setBackgroundColor(getResources().getColor(android.R.color.white));
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setupActionBarAndMenuBar();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
//		case R.id.action_period:
//			return true;
//			
//		case R.id.action_refresh:
//			setRefreshActionButtonState(refresh);
//			refresh = !refresh;
//			return true;

		case R.id.action_settings:
//			Intent calslIntent = new Intent(this, SettingsActivity.class);
//			startActivity(calslIntent);
			return true;

//		case R.id.action_help:
//			Intent intent = new Intent(this, ActivityHelpDialog.class);
//			startActivity(intent);

			//			HelpDialog helpDialog = new HelpDialog(this);
			//			helpDialog.setTitle("Simpliti Analytics Help!");
			//			helpDialog.show();       
//			return true;

//		case R.id.action_feedback:
////			DeviceUtil.openFeedbackChooser(this, "mailto:manish.pathak@rampgreen.net");
//			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.optionsMenu = menu; 
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Change the refresh button state , this method should should call  invalidateoptionmenu().
	 * @param refreshing if refreshing true, loading bar will visible on action bar otherwise refresh icon will visible. 
	 */
	protected void setRefreshActionButtonState(final boolean refreshing) {
		if (optionsMenu != null) {
//			final MenuItem refreshItem = optionsMenu.findItem(R.id.action_refresh);
//			if (refreshItem != null) {
//				if (refreshing) {
//					refreshItem.setActionView(R.layout.actionbar_indeterminate_progress);
//				} else {
//					refreshItem.setActionView(null);
//					refreshItem.setVisible(false);
//				}
//			}
		}
	}

	/**
	 * To keep screen off , change the  sharing preferences keepscreenon to empty. otherwise, it should be non empty. 
	 */
	private void keepScreenOn() {
//		String screenOn = (String) AppSettings.getPrefernce(this, null, AppSettings.KEEP_SCREEN_ON_OFF, "1");
//		if(StringUtils.isEmpty(screenOn)) {
//			setKeepScreenOn(false);
//		} else {
//			setKeepScreenOn(true);
//		}
	}
	
	protected void setKeepScreenOn(boolean keepScreenOn) {
		if(keepScreenOn) {
			getWindow().
			addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		} else {
			getWindow().
			clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
	}
}
