package technion.ee.softlab.qroom.QRoom;
import java.util.ArrayList;

import technion.ee.softlab.qroom.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The Class AllRoomsAdapter. Used to supply information to a list in a AllRoomsActivity
 */
public class AllRoomsAdapter extends ArrayAdapter<ExtendedRoom> {
	private ArrayList<ExtendedRoom> items;
	private Context context;

	/**
	 * Instantiates a new all classes adapter.
	 *
	 * @param context the context
	 * @param textViewResourceId the text view resource id
	 * @param items the items ArrayList
	 */
	public AllRoomsAdapter(Context context, int textViewResourceId, ArrayList<ExtendedRoom> items) {
		super(context, textViewResourceId, items);
		this.context = context;
		this.items = items;
	}

	/**
	 * Builds a list element
	 * @param position the position of the item in the array list
	 * @return view the element in the list
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.single_line_list_item, null);
		}

		ExtendedRoom item = items.get(position);
		if (item!= null) {
			TextView textView = (TextView) view.findViewById(R.id.singleLineListItemTextView);
			String text = String.format("%s %d", item.BuildindData.Name,item.RoomNumber);


			textView.setText(text);
			
			ImageView image = (ImageView)view.findViewById(R.id.singleLineListItemImageView);

			if (item.Type==0)
			{
				// find the type. Library of Farm
				LibFarm libfarm = PHPGetter.instance().getLibFarmData(item.ID);
				if (libfarm.Type.equals("l"))
				{
					image.setImageDrawable(view.getResources().getDrawable(R.drawable.library_48));
				} else if (libfarm.Type.equals("f"))
				{
					image.setImageDrawable(view.getResources().getDrawable(R.drawable.farm_48));
				} else
				{
					image.setImageDrawable(view.getResources().getDrawable(R.drawable.classroom_48));
				}
			}
			else if (item.Type==1)
			{
				image.setImageDrawable(view.getResources().getDrawable(R.drawable.office_48));
			} else if (item.Type==2)
			{
				image.setImageDrawable(view.getResources().getDrawable(R.drawable.classroom_48));
			}           
		}
		return view;
	}
}