package in.manish.rtneuro.myslider;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import in.manish.rtneuro.R;

import java.util.ArrayList;

public class FragmentChangeActivity extends BaseSliderActivity {

	private Fragment mContent;
	private String mProfileName = "manuish";
	public static final String TAG_BACKSTACK = "backstacks";
	ArrayList<String> profileTitles = new ArrayList<String>();

	public FragmentChangeActivity() {
		super(R.string.changing_fragments);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the Above View
		//if savedinstancestate is not null that means activity is recreating on orientation changes
		if (savedInstanceState != null) {
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
			mSectionListContent = mContent;
		}
		if (mContent == null)
			mContent = new WelcomeFragment();

		// set the Above View
		setContentView(R.layout.content_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, mContent)
		.commit();

		// set onCreatethe Behind View
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new ColorMenuFragment())
		.commit();
		setSlidingActionBarEnabled(false);

		// customize the SlidingMenu
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		// navigation callback should call here
		profileTitles.clear();
		profileTitles.add(mProfileName);
		profileTitles.add("Change profile");
	}

	//	@Override
	//	public void onSaveInstanceState(Bundle outState) {
	//		outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
	//		super.onSaveInstanceState(outState);
	//		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	//	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// open application , cick visit , back , rotate... BUG:  Fragment visit is not in fragment manager
		outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
		if(mSectionListContent != null) {
			getSupportFragmentManager().putFragment(outState, "mContent", mContent);	
		}
		//		if(mContent != null && (!(mContent instanceof FragmentVisit))) {
		//			getSupportFragmentManager().putFragment(outState, "mContent", mContent);
		//			if(mSectionListContent != null) {
		//				getSupportFragmentManager().putFragment(outState, "sectionlistFrag", mSectionListContent);
		//			}
		//		} else {
		//			getSupportFragmentManager().putFragment(outState, "mContent", mSectionListContent);
		//		}
		super.onSaveInstanceState(outState);
	}

	Fragment mSectionListContent;
	public void switchContent(Fragment fragment) {
//		if(mContent instanceof FragmentSectionList) {
//			mSectionListContent = mContent;
//		}
		mContent = fragment;
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, fragment)
		.commit();
		getSlidingMenu().showContent();

		//		Fragment instanceFragment =
		//				getSupportFragmentManager().findFragmentById(R.id.content_frame);
		//		FragmentTransaction ft = getSupportFragmentManager()
		//				.beginTransaction();
		//		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		//
		//		if (instanceFragment instanceof FragmentRealTime && fragment instanceof FragmentRealTime) {
		//
		//		} else if (instanceFragment instanceof FragmentVisit && fragment instanceof FragmentVisit) {
		//
		//		} else {
		//			ft.hide(mContent)
		//			.replace(R.id.content_frame, fragment)
		//			.commit();
		//		} 
		//		getSlidingMenu().showContent();


		//		FragmentTransaction ft = getSupportFragmentManager()
		//				.beginTransaction();
		//		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		//		ft.hide(mContent)
		//		.replace(R.id.content_frame, fragment)
		//		.commit();
		//
		//		getSlidingMenu().showContent();


		//		if((mContent instanceof FragmentVisit && fragment instanceof FragmentVisit)
		//				||(mContent instanceof FragmentRealTime && fragment instanceof FragmentRealTime)) {
		//			ft.hide(fragment)
		//			.commit();
		//			getSlidingMenu().showContent();
		//			return;
		//		}
		//		mContent = fragment;
		//		ft.show(fragment)
		//		.replace(R.id.content_frame, fragment)
		//		.commit();
		//
		//		getSlidingMenu().showContent();
	}

		public void switchMenuFragment(Fragment fragment) {
			
			getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.menu_frame, fragment)
			.commit();
			
//			getSupportFragmentManager()
//			.beginTransaction()
//			.replace(R.id.content_frame, fragment)
//			.addToBackStack(null)
//			.commit();
//			//		getSupportFragmentManager().findFragmentByTag(arg0)
//			getSlidingMenu().showContent();
		}

//	public void onSectionItemPressed (Bundle bundle) {
//		Fragment newContent = FragmentVisit.newInstance();
//		newContent.setArguments(bundle);
//		mContent = newContent;
//
//		getSupportFragmentManager()
//		.beginTransaction()
//		.replace(R.id.content_frame, newContent)
//		.addToBackStack(null)
//		.commit();
//		//		getSupportFragmentManager().findFragmentByTag(arg0)
//		getSlidingMenu().showContent();
//	}

	@Override
	protected void setupActionBarAndMenuBar() {
	}

	@Override

	public void onBackPressed() {
//		int count = getSupportFragmentManager().getBackStackEntryCount();
//		AppLog.e("**************************"+count+"********************");
//		if(count < 1) {
//			AlertDialog.Builder builder = new AlertDialog.Builder(this);
//			builder.setTitle("Exit");
//			builder.setMessage("Are You Sure?");
//
//			builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//				public void onClick(DialogInterface dialog, int which) {
//					dialog.dismiss();
//					Constants.CLOSE_ALL_ACTIVITIES = true;
//					finish();
//				}
//			});
//
//			builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					dialog.dismiss();
//				}
//			});
//			AlertDialog alert = builder.create();
//			alert.show();
//		}
//		else
			super.onBackPressed();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem p_item) {
		switch (p_item.getItemId()) {
		case 0:
			return true;
//		case R.id.action_period:
//			openPeriodSelector();
//			return true;
		}
		return super.onOptionsItemSelected(p_item);
	}
}