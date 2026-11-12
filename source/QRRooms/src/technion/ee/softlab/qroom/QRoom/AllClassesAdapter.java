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
 * The Class AllClassesAdapter. Used to supply information to a list in a AllClassesActivity
 */
public class AllClassesAdapter extends ArrayAdapter<EducationHour> {
	private ArrayList<EducationHour> items;
	private Context context;

	/**
	 * Instantiates a new all classes adapter.
	 *
	 * @param context the context
	 * @param textViewResourceId the text view resource id
	 * @param items the items ArrayList
	 */
	public AllClassesAdapter(Context context, int textViewResourceId, ArrayList<EducationHour> items) {
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

		EducationHour item = items.get(position);
		if (item!= null) {
			TextView topTextView = (TextView) view.findViewById(R.id.toptext);
			TextView bottomTextView = (TextView) view.findViewById(R.id.bottomtext);
			String topText = String.format("%s", item.Course.Name);
			String bottomText = String.format("%s, %s - %s",GlobalHelper.instance().getDayOfWeek(item.DayOfWeek),GlobalHelper.instance().getShortTimeString(item.StartTime) ,GlobalHelper.instance().getShortTimeString(item.EndTime));
			topTextView.setText(topText);
			bottomTextView.setText(bottomText);
			ImageView image = (ImageView)view.findViewById(R.id.baseHourListTypeImageView);

			if (item.LessonType.equals("l"))
			{
				image.setImageDrawable(view.getResources().getDrawable(R.drawable.lecture_48));
			}
			else if (item.LessonType.equals("t"))
			{
				image.setImageDrawable(view.getResources().getDrawable(R.drawable.tutorial_48));
			} else if (item.LessonType.equals("w"))
			{
				image.setImageDrawable(view.getResources().getDrawable(R.drawable.workshop_48));
			}
		}
		return view;
	}
}