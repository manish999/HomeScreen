package in.manish.rtneuro.myslider;

import com.actionbarsherlock.app.SherlockFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import in.manish.rtneuro.R;
import in.manish.rtneuro.util.AppLog;

import java.util.ArrayList;

/**
 * This calss is used to implement the Menu bar as listfragment.
 * @author Manish Pathak
 *
 */
public class ColorMenuFragment extends SherlockFragment {

	private int[] slider_menu_icon = new int[]{R.drawable.ic_launcher,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher};
	private String[] slider_menu_text = new String[]{"A",
			"B",
			"C",
	"D"};
	private ArrayList<Profile> profilesList = new ArrayList<Profile>();
	private ArrayList<Account> accountList = new ArrayList<Account>();
	private ExpandableListAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.account_exp_list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] colors = new String[]{"mnaish", "pathak"};//getResources().getStringArray(R.array.color_names);
		//		ArrayAdapter<String> ad = new ArrayAdapter<String>(getActivity(),R.layout.list_sliding_menu,colors);
		//		setListAdapter(ad);
		//		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
		//				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
		//		setListAdapter(colorAdapter);
		init();
//		SampleAdapter adapter = new SampleAdapter(getActivity());
//		for (int i = 0; i < 4; i++) {
//			adapter.add(new SampleItem(slider_menu_text[i], slider_menu_icon[i]));
//		}
//		setListAdapter(adapter);

	}


	private class SampleItem {
		public String tag;
		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {
		ArrayList<SampleItem> listItem;
		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

		public void setList (ArrayList<SampleItem> list) {

		}

	}

//	@Override
//	public void onListItemClick(ListView lv, View v, int position, long id) {
//		Fragment newContent = null;
//		Bundle bundle = new Bundle();
//		//pop all fragments from backstack on click sliding menu
//		getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//		switch (position) {
//		case 0:
//			newContent = new ColorFragment(android.R.color.black);
//			//			newContent = new ColorFragment(R.color.red);
//			break;
////		case 1:
////			newContent = new FragmentSectionList();
////			//			bundle.putString(Constants.TAB_TYPE, whichTab);
////			//			bundle.putString(Constants.PROFILE, profile);
////			//			bundle.putString(key, value);
////			//			newContent.setArguments(args);
////			break;
////		case 2:
////			//direct call fragment.
////			newContent = FragmentAdwordsImpression.newInstance();
////			// View pager with header slide
//////			newContent = new SampleTitlesStyledLayout();
////			break;
////		case 3:
////			
////			break;
////		case 4:
////			newContent = new ColorFragment(android.R.color.black);
////			break;
//		}
//		if (newContent != null)
//			switchFragment(newContent);
//	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof FragmentChangeActivity) {
			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
			fca.switchContent(fragment);
		} 
	}
	
	public void init() {
		ExpandableListView listView = (ExpandableListView) getActivity().findViewById(R.id.listView);
		listView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				ExpandableListAdapter ad = (ExpandableListAdapter) parent.getExpandableListAdapter();
				Profile profile =(Profile) ad.getChild(groupPosition, childPosition);
//				AppSettings.setPreference(AccountListActivity.this, null, AppSettings.ACCOUNT_TOKEN, profile.getAccountToken());
//				AppSettings.setPreference(AccountListActivity.this, null, AppSettings.PROFILE_ID, profile.getProfileID());
//				Intent localIntent = new Intent(AccountListActivity.this, FragmentChangeActivity.class);
//				localIntent.putExtra(Constants.CALLING_ACTIVITY_TYPE, Constants.CALLING_ACTIVITY_ACCOUNTLISTACTIVITY);
//				localIntent.putExtra(Constants.PROFILE, profile);
//				localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//				startActivity(localIntent);
//				AccountListActivity.this.finish();
				AppLog.logToast(getActivity(), "Child clicked");
				return false;
			}
		});

		listView.setOnGroupClickListener(new OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				ExpandableListAdapter ad = (ExpandableListAdapter) parent.getExpandableListAdapter();
				String acName = (String) ad.getGroup(groupPosition);
//				AppSettings.setPreference(AccountListActivity.this, null, AppSettings.ACCOUNT_NAME, acName);
				AppLog.d("List", "Group clicked");
				return false;
			}
		});

		// Initialize the adapter with blank groups and children
		// We will be adding children on a thread, and then update the ListView
		adapter = new ExpandableListAdapter(getActivity(), new ArrayList<String>(),
				new ArrayList<Account>());
		Profile profile = new Profile();
		profile.setProfileName("a");
		profilesList.add(profile);
		profile = new Profile();
		profile.setProfileName("b");
		profilesList.add(profile);
		profile = new Profile();
		profile.setProfileName("c");
		profilesList.add(profile);
		
		Account account = new Account();
		account.setAccountName("ac1");
		account.setProfiles(profilesList);
		accountList.add(account);
		account = new Account();
		account.setAccountName("ac2");
		account.setProfiles(profilesList);
		accountList.add(account);
		
		adapter.addItem(accountList);
		// Set this blank adapter to the list view
		listView.setAdapter(adapter);
		//		setHeader((R.string.profiles), false, false, false);
	}
}
