//package in.manish.rtneuro.myslider;
//
//import in.rampgreen.analytics.R;
//import in.rampgreen.analytics.model.Account;
//import in.rampgreen.analytics.model.AnalyticsResultBase;
//import in.rampgreen.analytics.model.Composer;
//import in.rampgreen.analytics.model.Data;
//import in.rampgreen.analytics.network.HttpResponseHandler;
//import in.rampgreen.analytics.network.NetworkDataHelper;
//import in.rampgreen.analytics.util.AppSettings;
//import in.rampgreen.analytics.util.Constants;
//import in.rampgreen.analytics.util.ValueUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.util.Pair;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//import br.com.dina.ui.model.BasicItem;
//import br.com.dina.ui.widget.UITableView;
//import br.com.dina.ui.widget.UITableView.ClickListener;
//
//import com.actionbarsherlock.app.SherlockFragmentActivity;
//import com.foound.widget.AmazingAdapter;
//import com.foound.widget.AmazingListView;
//
//public class FragmentSectionList extends BaseSherlockFragment {
//	AmazingListView lsComposer;
//	SectionComposerAdapter adapter;
//	View viewHEader;
//	private String accountToken;
//	private String profileID;
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		this.accountToken = (String) AppSettings.getPrefernce(getSherlockActivity(), null, AppSettings.ACCOUNT_TOKEN, "");
//		this.profileID = (String) AppSettings.getPrefernce(getSherlockActivity(), null, AppSettings.PROFILE_ID, "");
//	}
//
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//		setRetainInstance(true);
//
//		//		getSherlockActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//		View view = inflater.inflate(R	.layout.activity_section_demo,
//				container, false);
//		//		viewHEader = getLayoutInflater(savedInstanceState).from(getSherlockActivity()).inflate(R.layout.item_composer_header, lsComposer, false);
//		return view;
//	}
//
//	private void switchFragment(Fragment fragment) {
//		if (getActivity() == null)
//			return;
//
//		if (getActivity() instanceof FragmentChangeActivity) {
//			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
////			fca.onSectionItemPressed(fragment);
//		} 
//	}
//
//	public void setRefreshActionButtonState(boolean refreshing) {
//		if (getActivity() == null)
//			return;
//
//		if (getActivity() instanceof FragmentChangeActivity) {
//			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
//			fca.setRefreshActionButtonState(false);
//		} 
//	}
//	CustomClickListener listener;
//	@Override
//	public void onActivityCreated(Bundle savedInstanceState) {
//		super.onActivityCreated(savedInstanceState);
//		if(savedInstanceState != null ) {
//			profileID  = savedInstanceState.getString(Constants.ID_PROFILE);
//			accountToken  = savedInstanceState.getString(Constants.ID_ACCOUNT);
//		}
//		lsComposer = (AmazingListView) getSherlockActivity().findViewById(R.id.lsComposer);
//		viewHEader = getSherlockActivity().getLayoutInflater().from(getSherlockActivity()).inflate(R.layout.item_composer_header, lsComposer, false);
//
//		lsComposer.setPinnedHeaderView(viewHEader);
//		lsComposer.setAdapter(adapter = new SectionComposerAdapter());
//		lsComposer.setSelector(R.color.transparent);
//		listener = new CustomClickListener();
//		lsComposer.setOnItemClickListener(new OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//
//				Composer obj = (Composer)parent.getItemAtPosition(position);
//				String item = obj.name;
//
//				switchFragmentOnClick(position);
//				if(obj.name.equalsIgnoreCase(Constants.VISITS)) {
//					//					bundle.putInt(Constants.TAB_TYPE, Constants.VISITED_BY_DATE);
//
//					//					newContent.setArguments(bundle);
//				} else if(obj.name.equalsIgnoreCase(Constants.VISITORS)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.VISITS)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.PAGEVIEWS)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.BOUNCERATE)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.NEW_VISITS)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.LANGUAGE)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.COUNTRY)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.CITY)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.BROWSER)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.FLASH_VERSION)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.JAVA_SUPPORT)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.OPERATING_SYSTEM)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.SERVICE_PROVIDER)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.DEVICES)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.IS_MOBILE)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.OPERATING_SYSTEM)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.SERVICE_PROVIDER)) {
//
//				} else if(obj.name.equalsIgnoreCase(Constants.SCREEN_RESOLUTION)) {
//
//				}
//				//			     When clicked, show a toast with the TextView text
//				Toast.makeText(getSherlockActivity(),
//						item, Toast.LENGTH_SHORT).show();
//			}
//		});
//	}
//
//	@Override
//	public void onSaveInstanceState(Bundle outState) {
//		outState.putString(Constants.ID_PROFILE, profileID);
//		outState.putString(Constants.ID_ACCOUNT, accountToken);
//		super.onSaveInstanceState(outState);
//	}
//
//	@Override	
//	public void refresh() {
//		NetworkDataHelper networkDataHelper = new NetworkDataHelper(getSherlockActivity(), this , profileID, accountToken);
//		String query = networkDataHelper.prepareQueryForRequest(Constants.DASHBOARD_OVERVIEW);
//		networkDataHelper.makeRequest(query, HttpResponseHandler.REQUEST_FOR_FETCHING_ANALYTICS_DATA, true);
//	}
//
//	@Override
//	public void getProfileParsedData(ArrayList<AnalyticsResultBase> parsedData) {
//		//		Bundle bundle = this.getArguments();
//		//		bundle.putSerializable(Constants.FETCHED_PROFILE_DATA, parsedData);
//		updateView(parsedData);
//	}
//
//	private void updateView(ArrayList<AnalyticsResultBase> parsedData) {
//		for (AnalyticsResultBase analyticsResultBase : parsedData) {
//			Constants.overview = new Composer[]{
//					new Composer(Constants.VISITS, ""+analyticsResultBase.getVisits()),
//					new Composer(Constants.VISITORS, ""+analyticsResultBase.getVisitors()),
//					new Composer(Constants.PAGEVIEWS, ""+analyticsResultBase.getPageViews()),
//					new Composer(Constants.PAGEPERVISITS, ""+ValueUtil.roundTwoDecimals(analyticsResultBase.getPageViewPerVisit())),
//					new Composer(Constants.AVG_TIME_ONSITE, ""+ValueUtil.roundTwoDecimals(analyticsResultBase.getAvgTimeOnSite())),
//					new Composer(Constants.BOUNCERATE, ""+ValueUtil.roundTwoDecimals(analyticsResultBase.getVisitBounceRate())),
//					new Composer(Constants.NEW_VISITS, ""+analyticsResultBase.getNewVisits())
//			};
//			//			Date date = DateUtils.convertToCalender(analyticsResultBase.getDate(), DateUtils.FORMAT_YYYYMMDD).getTime();
//			//			series.add(date, y);
//		}
//		all = Data.getAllData();
//		lsComposer.getAdapter().notifyDataSetChanged();
//		//		lsComposer.invalidate();
//		//		adapter.notifyMayHaveMorePages();
//		//		adapter.notifyDataSetChanged();
//		//		adapter.notifyDataSetInvalidated();
//
//	}
//
//	@Override
//	public void getAccountProfileData(ArrayList<Account> parsedData) {
//
//	}
//
//	@Override
//	public void onPreExecute() {
//		SherlockFragmentActivity fragmentActivity = getSherlockActivity();
//		if (fragmentActivity == null)
//			return;
//
//		if (fragmentActivity instanceof FragmentChangeActivity) {
//			FragmentChangeActivity fragmentChangeActivity = (FragmentChangeActivity) fragmentActivity;
//			fragmentChangeActivity.invalidateOptionsMenu();
//			fragmentChangeActivity.setRefreshActionButtonState(true);
//		} 
//	}
//
//	@Override
//	public void onProgressUpdate(int percent) {
//
//	}
//
//	@Override
//	public void onCancelled() {
//		SherlockFragmentActivity fragmentActivity = getSherlockActivity();
//		if (fragmentActivity == null)
//			return;
//
//		if (fragmentActivity instanceof FragmentChangeActivity) {
//			FragmentChangeActivity fragmentChangeActivity = (FragmentChangeActivity) fragmentActivity;
//			fragmentChangeActivity.invalidateOptionsMenu();
//			fragmentChangeActivity.setRefreshActionButtonState(false);
//		} 
//	}
//
//	@Override
//	public void onPostExecute() {
//		SherlockFragmentActivity fragmentActivity = getSherlockActivity();
//		if (fragmentActivity == null)
//			return;
//
//		if (fragmentActivity instanceof FragmentChangeActivity) {
//			FragmentChangeActivity fragmentChangeActivity = (FragmentChangeActivity) fragmentActivity;
//			fragmentChangeActivity.invalidateOptionsMenu();
//			fragmentChangeActivity.setRefreshActionButtonState(false);
//		} 
//	}
//
//	List<Pair<String, List<Composer>>> all = Data.getAllData();
//	class SectionComposerAdapter extends AmazingAdapter {
//		UITableView tableView;
//
//		@Override
//		public int getCount() {
//			int res = 0;
//			for (int i = 0; i < all.size(); i++) {
//				res += all.get(i).second.size();
//			}
//			return res;
//		}
//
//		@Override
//		public Composer getItem(int position) {
//			int c = 0;
//			for (int i = 0; i < all.size(); i++) {
//				if (position >= c && position < c + all.get(i).second.size()) {
//					return all.get(i).second.get(position - c);
//				}
//				c += all.get(i).second.size();
//			}
//			return null;
//		}
//
//		@Override
//		public long getItemId(int position) {
//			return position;
//		}
//
//		@Override
//		protected void onNextPageRequested(int page) {
//		}
//
//		@Override
//		protected void bindSectionHeader(View view, int position, boolean displaySectionHeader) {
//			if (displaySectionHeader) {
//				view.findViewById(R.id.header).setVisibility(View.VISIBLE);
//				TextView lSectionTitle = (TextView) view.findViewById(R.id.header);
//				lSectionTitle.setText(getSections()[getSectionForPosition(position)]);
//			} else {
//				view.findViewById(R.id.header).setVisibility(View.GONE);
//			}
//		}
//
//
//		@Override
//		public View getAmazingView(int position, View convertView, ViewGroup parent) {
//			View res = convertView;
//			//			if (res == null){
//			//				res = getSherlockActivity().getLayoutInflater().inflate(R.layout.item_composer, null);
//			//				tableView = (UITableView) res.findViewById(R.id.tableView);
//			//				Composer composer = getItem(position);
//			//				
//			//				BasicItem i1 = new BasicItem(position+"");
//			////		    	i1.setSubtitle("Click here to search for friends");
//			//		    	i1.setDrawable(R.drawable.visitors);   	
//			//		    	tableView.cleaddBasicItem(i1);
//			//		    	tableView.commit();
//			//			}
//
//			if (res == null) {
//				res = getSherlockActivity().getLayoutInflater().inflate(R.layout.item_composer, null);
//
//			}
//			tableView  = (UITableView) res.findViewById(R.id.tableView);
//			tableView.clear();
//
//			Composer composer = getItem(position);
//			BasicItem i1 = new BasicItem(composer.name, composer.year);
//			switch (position) {
//			case 0:
//				i1.setDrawable(R.drawable.visit);   	
//				break;
//			case 1:
//				i1.setDrawable(R.drawable.unique_visitor);
//				break;
//			case 2:
//				i1.setDrawable(R.drawable.page_view);
//				break;
//			case 3:
//				i1.setDrawable(R.drawable.page_visit);
//				break;
//			case 4:
//				i1.setDrawable(R.drawable.visit_duration);
//				break;
//			case 5:
//				i1.setDrawable(R.drawable.bounce_rate);
//				break;
//
//			case 6:
//				i1.setDrawable(R.drawable.new_visit);
//				break;
//			case 7:
//				i1.setDrawable(R.drawable.language);
//				break;
//			case 8:
//				i1.setDrawable(R.drawable.country);
//				break;
//			case 9:
//				i1.setDrawable(R.drawable.city);
//				break;
//			case 10:
//				i1.setDrawable(R.drawable.browser);
//				break;
//			case 11:
//				i1.setDrawable(R.drawable.flash);
//				break;
//			case 12:
//				i1.setDrawable(R.drawable.java);
//				break;
//
//			case 13:
//				i1.setDrawable(R.drawable.os);
//				break;
//			case 14:
//				i1.setDrawable(R.drawable.service_provider);
//				break;
//			case 15:
//				i1.setDrawable(R.drawable.devices);
//				break;
//			case 16:
//				i1.setDrawable(R.drawable.is_mobile);
//				break;
//			case 17:
//				i1.setDrawable(R.drawable.os);
//				break;
//			case 18:
//				i1.setDrawable(R.drawable.service_provider);
//				break;
//			case 19:
//				i1.setDrawable(R.drawable.screen_resolution);
//				break;
//
//			default:
//				break;
//			}
//			tableView.setClickListener(listener);
//			tableView.addBasicItem(i1);
//			tableView.commit();
//			//			TextView lName = (TextView) res.findViewById(R.id.lName);
//			//			TextView lYear = (TextView) res.findViewById(R.id.lYear);
//			//
//			//
//			//			lName.setText(composer.name);
//			//			lYear.setText(composer.year);
//
//
//			//			TextView lName = (TextView) res.findViewById(R.id.lName);
//			//			TextView lYear = (TextView) res.findViewById(R.id.lYear);
//
//
//
//			//			lName.setText(composer.name);
//			//			lYear.setText(composer.year);
//
//			return res;
//		}
//
//		@Override
//		public void configurePinnedHeader(View header, int position, int alpha) {
//			// set header color
//			TextView lSectionHeader = (TextView)header;
//			lSectionHeader.setText(getSections()[getSectionForPosition(position)]);
//			lSectionHeader.setBackgroundColor(alpha << 24 | (0x4773b9));
//			lSectionHeader.setTextColor(alpha << 24 | (0xffffff));
//		}
//
//		@Override
//		public int getPositionForSection(int section) {
//			if (section < 0) section = 0;
//			if (section >= all.size()) section = all.size() - 1;
//			int c = 0;
//			for (int i = 0; i < all.size(); i++) {
//				if (section == i) { 
//					return c;
//				}
//				c += all.get(i).second.size();
//			}
//			return 0;
//		}
//
//		@Override
//		public int getSectionForPosition(int position) {
//			int c = 0;
//			for (int i = 0; i < all.size(); i++) {
//				if (position >= c && position < c + all.get(i).second.size()) {
//					return i;
//				}
//				c += all.get(i).second.size();
//			}
//			return -1;
//		}
//
//		@Override
//		public String[] getSections() {
//			String[] res = new String[all.size()];
//			for (int i = 0; i < all.size(); i++) {
//				res[i] = all.get(i).first;
//			}
//			return res;
//		}
//	}
//
//	private class CustomClickListener implements ClickListener {
//
//		@Override
//		public void onClick(int index) {
//			//			Toast.makeText(getSherlockActivity(), externClickIndex+" item clicked: " + index, Toast.LENGTH_SHORT).show();
//		}
//
//		@Override
//		public void onClick(View view) {
//			LinearLayout linearLayout = (LinearLayout)((LinearLayout)view).getChildAt(1); 
//			TextView textView = (TextView)linearLayout.getChildAt(0);
//			String textTitle = (String) textView.getText();
////			Toast.makeText(getSherlockActivity(), "item clicked: " + textView.getText(), Toast.LENGTH_SHORT).show();
//			int position = 0;
//			if(textTitle.equalsIgnoreCase(Constants.VISITS)) {
//				position = 0;
//			} else if(textTitle.equalsIgnoreCase(Constants.VISITORS)) {
//				position = 1;
//			} else if(textTitle.equalsIgnoreCase(Constants.PAGEVIEWS)) {
//				position = 2;
//			} else if(textTitle.equalsIgnoreCase(Constants.PAGEPERVISITS)) {
//				position = 3;
//			} else if(textTitle.equalsIgnoreCase(Constants.AVG_TIME_ONSITE)) {
//				position = 4;
//			} else if(textTitle.equalsIgnoreCase(Constants.BOUNCERATE)) {
//				position = 5;
//			} else if(textTitle.equalsIgnoreCase(Constants.NEW_VISITS)) {
//				position = 6;
//			} else if(textTitle.equalsIgnoreCase(Constants.LANGUAGE)) {
//				position = 7;
//			} else if(textTitle.equalsIgnoreCase(Constants.COUNTRY)) {
//				position = 8;
//			} else if(textTitle.equalsIgnoreCase(Constants.CITY)) {
//				position = 9;
//			} else if(textTitle.equalsIgnoreCase(Constants.BROWSER)) {
//				position = 10;
//			} else if(textTitle.equalsIgnoreCase(Constants.FLASH_VERSION)) {
//				position = 11;
//			} else if(textTitle.equalsIgnoreCase(Constants.JAVA_SUPPORT)) {
//				position = 12;
//			} else if(textTitle.equalsIgnoreCase(Constants.OPERATING_SYSTEM)) {
//				position = 13;
//			} else if(textTitle.equalsIgnoreCase(Constants.SERVICE_PROVIDER)) {
//				position = 14;
//			} else if(textTitle.equalsIgnoreCase(Constants.DEVICES)) {
//				position = 15;
//			} else if(textTitle.equalsIgnoreCase(Constants.IS_MOBILE)) {
//				position = 16;
//			} else if(textTitle.equalsIgnoreCase(Constants.MOBILE_OPERATING_SYSTEM)) {
//				position = 17;
//			} else if(textTitle.equalsIgnoreCase(Constants.MOBILE_SERVICE_PROVIDER)) {
//				position = 18;
//			} else if(textTitle.equalsIgnoreCase(Constants.SCREEN_RESOLUTION)) {
//				position = 19;
//			}
//			switchFragmentOnClick(position);
//		}
//	}
//
//	private void switchFragmentOnClick (int position) {
////		Fragment newContent = null;
//		Bundle bundle = new Bundle();
//		switch (position) {
//		case 0:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DASHBOARD_VISITS);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_LINE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.VISITS);
//			  
//			break;
//		case 1:	
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DASHBOARD_VISITORS);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_LINE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.VISITORS);
//			  
//			break;
//		case 2:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DASHBOARD_PAGEVIEWS);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_LINE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.PAGEVIEWS);
//			  
//			break;
//		case 3:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DASHBOARD_PAGEPERVISITS);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_LINE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.PAGEPERVISITS);
//			  
//			break;
//		case 4:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DASHBOARD_AVG_VISIT_DURATION);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_LINE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.AVG_TIME_ONSITE);
//			  
//			break;
//		case 5:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DASHBOARD_BOUNCERATE);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_LINE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.BOUNCERATE);
//			  
//			break;
//		case 6:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DASHBOARD_NEW_VISITS);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_LINE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.NEW_VISITS);
//			  
//			break;
//		case 7:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DEMOGRAPHIC_LANGUAGE);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.LANGUAGE);
//			  
//			break;
//		case 8:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DEMOGRAPHIC_COUNTRY);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.COUNTRY);
//			  
//			break;
//		case 9:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.DEMOGRAPHIC_CITY);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.CITY);
//			  
//			break;
//		case 10:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.SYSTEM_BROSWSER);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.BROWSER);
//			  
//			break;
//		case 11:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.SYSTEM_FALSH);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.FLASH_VERSION);
//			  
//			break;
//		case 12:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.SYSTEM_JAVASUPPORT);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.JAVA_SUPPORT);
//			  
//			break;
//		case 13:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.SYSTEM_OS);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.OPERATING_SYSTEM);
//			  
//			break;
//		case 14:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.SYSTEM_SERVICEPRO);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.SERVICE_PROVIDER);
//			  
//			break;
//		case 15:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.MOBILE_DEVICES);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.DEVICES);
//			  
//			break;
//		case 16:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.MOBILE__ISMOBILE);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, "Is mobile");
//			  
//			break;
//		case 17:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.MOBILE_OS);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.OPERATING_SYSTEM);
//			  
//			break;
//		case 18:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.MOBILE_SERVICEPRO);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.SERVICE_PROVIDER);
//			  
//			break;
//		case 19:
//			 
//			bundle.putInt(Constants.TAB_TYPE, Constants.MOBILE_SCREENRES);
//			bundle.putInt(Constants.CHART_TYPE, Constants.CHART_PIE);
//			bundle.putString(Constants.TYPE_TITLE, Constants.SCREEN_RESOLUTION);
//			  
//			break;
//		}
//		if (getActivity() == null)
//			return;
//
//		if (getActivity() instanceof FragmentChangeActivity) {
//			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
//			fca.onSectionItemPressed(bundle);
//		} 
////		if (newContent != null)
////			switchFragment(newContent);
//	}
//}