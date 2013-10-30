package in.manish.rtneuro.myslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import in.manish.rtneuro.R;

import java.util.ArrayList;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<String> groups = new ArrayList<String>();
	private ArrayList<Account> children;

	public ExpandableListAdapter(Context context, ArrayList<String> accountGroup,
			ArrayList<Account> children) {
		this.context = context;
		this.groups = accountGroup;
		this.children = children;
	}

	/**
	 * A general add method, that allows you to add a Vehicle to this list
	 * 
	 * Depending on if the category opf the vehicle is present or not, the
	 * corresponding item will either be added to an existing group if it
	 * exists, else the group will be created and then the item will be added
	 * 
	 * @param vehicle
	 */
	public void addItem(ArrayList<Account> accountsList) {
		groups.clear();
		this.children = accountsList;
		for(int i =0; i< accountsList.size() ; i++){
			groups.add(accountsList.get(i).getAccountName());
		}
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return children.get(groupPosition).getProfiles().get((childPosition));
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	// Return a child view. You can load your custom layout here.
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		Profile vehicle = (Profile) getChild(groupPosition, childPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.child_layout, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.tvChild);
		tv.setText("   " + vehicle.getProfileName());
//		tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
//		tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.website, 0, 0, 0);
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return children.get(groupPosition).getProfiles().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groups.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return groups.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	// Return a group view. You can load your custom layout here.
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String group = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.group_layout, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.tvGroup);
		tv.setText(group);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return true;
	}

	@Override
	public boolean areAllItemsEnabled() {
		return true;
	}
}
