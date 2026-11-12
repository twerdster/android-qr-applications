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
 * The Class ReceptionHourAdapter. Show reception hour information.
 */
public class ReceptionHourAdapter extends ArrayAdapter<ReceptionHour> {
	private ArrayList<ReceptionHour> items;
	private Context context;

	/**
	 * Instantiates a new reception hour adapter.
	 *
	 * @param context the context
	 * @param textViewResourceId the text view resource id
	 * @param items the items ArrayList
	 */
	public ReceptionHourAdapter(Context context, int textViewResourceId, ArrayList<ReceptionHour> items) {
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
			view = inflater.inflate(R.layout.base_hour_list_item, null);
		}

		ReceptionHour item = items.get(position);
		if (item!= null)
		{
			Room room = PHPGetter.instance().getRoomData(item.RoomID);
			Building building = PHPGetter.instance().getBuilding(room.BuildingID);

			TextView topTextView = (TextView) view.findViewById(R.id.toptext);
			TextView bottomTextView = (TextView) view.findViewById(R.id.bottomtext);
			String topText = String.format("%s %d",	building.Name,room.RoomNumber);
			String bottomText = String.format("%s, %s - %s",
					GlobalHelper.instance().getDayOfWeek(item.DayOfWeek),GlobalHelper.instance().getShortTimeString(item.StartTime) ,GlobalHelper.instance().getShortTimeString(item.EndTime));       	

			topTextView.setText(topText);
			bottomTextView.setText(bottomText);       

			ImageView image = (ImageView)view.findViewById(R.id.baseHourListTypeImageView);
			image.setImageDrawable(view.getResources().getDrawable(R.drawable.reception_48));
		}
		return view;
	}
}