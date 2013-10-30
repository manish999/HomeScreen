package in.manish.rtneuro.myslider;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;

import in.manish.rtneuro.R;

import java.util.ArrayList;

public class FragmentHomeMenuAlert extends SherlockListFragment
{
	private static final String KEY_CONTENT = "TestFragment:Content123";
	private String test = "test";
	private int position = 0;

	private int[] slider_menu_icon = new int[]{R.drawable.ic_launcher,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher};
	private String[] slider_menu_text = new String[]{"<<","Self","Adam",
			"Brie",
			"Cindy",
	"Jacob"};

	public static FragmentHomeMenuAlert newInstance() {
		FragmentHomeMenuAlert fragment = new FragmentHomeMenuAlert();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle fd = getSherlockActivity().getIntent().getExtras();
		//		this.accountToken = (String) AppSettings.getPrefernce(getSherlockActivity(), null, AppSettings.ACCOUNT_TOKEN, "");
		//		this.profileID = (String) AppSettings.getPrefernce(getSherlockActivity(), null, AppSettings.PROFILE_ID, "");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		setRetainInstance(true);
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if(savedInstanceState != null ) {
			//			whichTab  = savedInstanceState.getInt(Constants.TAB_TYPE);
			//			profileID  = savedInstanceState.getString(Constants.ID_PROFILE);
			//			accountToken  = savedInstanceState.getString(Constants.ID_ACCOUNT);
		}
		SampleAdapter adapter = new SampleAdapter(getActivity());
		for (int i = 0; i < 4; i++) {
			adapter.add(new SampleItem(slider_menu_text[i], slider_menu_icon[i]));
		}
		setListAdapter(adapter);
		//		if (savedInstanceState == null) {
		//            FragmentManager fragmentManager = getSherlockActivity().getSupportFragmentManager();
		//            FragmentTransaction transaction = fragmentManager.beginTransaction();
		//            Fragment fragmentGraph = FragmentGraph.instantiate(getSherlockActivity(), "fgraph");
		//            Fragment fragmentGraphList = FragmentGraph.instantiate(getSherlockActivity(), "fgraphList");
		//            transaction.add(R.id.frag_graph, fragmentGraph);
		//            transaction.add(R.id.frag_chartlist, fragmentGraphList);
		//            transaction.commit();
		//        }

		// it is used to get the data from fragmentsectionlist 

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		//		outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
		//		outState.putInt(Constants.TAB_TYPE, whichTab);
		//		outState.putString(Constants.ID_PROFILE, profileID);
		//		outState.putString(Constants.ID_ACCOUNT, accountToken);
		//		outState.putString(Constants.TYPE_TITLE, Constants.IMPRESSIONS);
		//		this.accountToken = (String) AppSettings.getPrefernce(getSherlockActivity(), null, AppSettings.ACCOUNT_TOKEN, "");
		//		this.profileID = (String) AppSettings.getPrefernce(getSherlockActivity(), null, AppSettings.PROFILE_ID, "");
		//		super.onSaveInstanceState(outState);
		//		outState.putInt("mColorRes", mColorRes);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		//		Fragment f =  getFragmentManager().findFragmentById(R.id.content_frame);
		//		if (f != null) 
		//			getFragmentManager().be ginTransaction().hide(f).commit();
	}

	//	private void updateVisitFrag(Bundle bundle) {
	//		FragmentTransaction transaction = getSherlockActivity().getSupportFragmentManager().beginTransaction();
	//		//		FragmentManager fm = getSherlockActivity().getSupportFragmentManager();
	//		FragmentGraph fragGraph = new FragmentGraph();
	//		FragmentChartList fragList = new FragmentChartList();
	//		//		Bundle args = new Bundle();
	//		//	args.putInt(ArticleFragment.ARG_POSITION, position);
	//		fragGraph.setArguments(bundle);
	//		fragList.setArguments(bundle);
	//
	//		// Replace whatever is in the fragment_container view with this fragment,
	//		// and add the transaction to the back stack so the user can navigate back
	//		transaction.replace(R.id.frag_graph, fragGraph);
	//		transaction.replace(R.id.frag_chartlist, fragList);
	//		//		transaction.addToBackStack(null);
	//
	//		// Commit the transaction
	//		transaction.commit();
	//		//    if (fm.findFragmentById(R.id.) == null) {
	//		//        fm.beginTransaction()
	//		//                .replace(placeholder, new MyListFragment(tabId),onResponseReceived tabId)
	//		//                .commit();
	//		//    }
	//	}

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
			//			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);
			icon.setVisibility(View.GONE);

			return convertView;
		}

		public void setList (ArrayList<SampleItem> list) {

		}

	}

	private class SampleItem {
		public String tag;
		//		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
			//			this.iconRes = iconRes;
		}
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		Bundle bundle = new Bundle();
		//pop all fragments from backstack on click sliding menu
		//		getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		switch (position) {
		case 0:
			newContent = new ColorMenuFragment();
			//			newContent = new ColorFragment(R.color.red);
			break;
			//		case 1:
			//			newContent = new FragmentSectionList();
			//			//			bundle.putString(Constants.TAB_TYPE, whichTab);
			//			//			bundle.putString(Constants.PROFILE, profile);
			//			//			bundle.putString(key, value);
			//			//			newContent.setArguments(args);
			//			break;
			//		case 2:
			//			//direct call fragment.
			//			newContent = FragmentAdwordsImpression.newInstance();
			//			// View pager with header slide
			////			newContent = new SampleTitlesStyledLayout();
			//			break;
			//		case 3:
			//			
			//			break;
			//		case 4:
			//			newContent = new ColorFragment(android.R.color.black);
			//			break;
		}
		if (newContent != null)
			switchMenuContent(newContent);
	}

	// the meat of switching the above fragment
	private void switchMenuContent(Fragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof FragmentChangeActivity) {
			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
			fca.switchMenuFragment(fragment);
		} 
	}


}
