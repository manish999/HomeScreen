package in.manish.rtneuro.myslider;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

import in.manish.rtneuro.R;
import in.manish.rtneuro.tab.TabBitmap;

/**
 * @author Manish Pathak
 *
 */
public class WelcomeFragment extends SherlockFragment {

	private static final String TAG_1 = "tab1";
	private static final String TAG_2 = "tab2";
	private static final String TAG_3 = "tab3";
	private static final String TAG_4 = "tab4";
	private static final String TAG_5 = "tab5";
	
	TabHost mTabHost;
	
	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.main, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setTabs();
	}

	private void setTabs() {
		mTabHost = (TabHost) getSherlockActivity().findViewById(android.R.id.tabhost);
		mTabHost.setup();
		
		addTab("Home", TAG_1, createTabDrawable(R.drawable.home), R.id.text_view_home);
		addTab("Search", TAG_2, createTabDrawable(R.drawable.search), R.id.text_view_search);
		addTab("Favourites", TAG_3, createTabDrawable(R.drawable.star), R.id.text_view_favourites);
		addTab("Settings", TAG_4, createTabDrawable(R.drawable.settings), R.id.text_view_settings);
		addTab("Home", TAG_5, createTabDrawable(R.drawable.home), R.id.text_view_home);
	}
	
	private Drawable createTabDrawable(int resId) {
		Resources res = getResources();
		StateListDrawable states = new StateListDrawable();

		final Options options = new Options();
		options.inPreferredConfig = Config.ARGB_8888;
		
		Bitmap icon = BitmapFactory.decodeResource(res, resId, options);
		
		Bitmap unselected = TabBitmap.createUnselectedBitmap(res, icon);
		Bitmap selected = TabBitmap.createSelectedBitmap(res, icon);
		
		icon.recycle();
		
		states.addState(new int[] { android.R.attr.state_selected }, new BitmapDrawable(res, selected));
		states.addState(new int[] { android.R.attr.state_enabled }, new BitmapDrawable(res, unselected));
		
		return states;
	}
	
	private View createTabIndicator(String label, Drawable drawable) {
		View tabIndicator = LayoutInflater.from(getSherlockActivity()).inflate(R.layout.tab_indicator, mTabHost.getTabWidget(), false);

		TextView txtTitle = (TextView) tabIndicator.findViewById(R.id.text_view_tab_title);
		txtTitle.setText(label);
		LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) txtTitle.getLayoutParams();
		txtTitle.setLayoutParams(params);

		ImageView imgIcon = (ImageView) tabIndicator.findViewById(R.id.image_view_tab_icon);
		imgIcon.setImageDrawable(drawable);
		
		return tabIndicator;
	}
	
	private void addTab(String label, String tag, Drawable drawable, int id) {
		TabHost.TabSpec spec = mTabHost.newTabSpec(tag);
		spec.setIndicator(createTabIndicator(label, drawable));
		spec.setContent(id);

		mTabHost.addTab(spec);
	}
}