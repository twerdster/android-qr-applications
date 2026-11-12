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
 * The Class EducationHourAdapter. Used to supply information to a list in a EducationHourActivity
 */
public class EducationHourAdapter extends ArrayAdapter<EducationHour> {
    private ArrayList<EducationHour> items;
    private Context context;

	/**
	 * Instantiates a new education hour activity adapter.
	 *
	 * @param context the context
	 * @param textViewResourceId the text view resource id
	 * @param items the items ArrayList
	 */
    public EducationHourAdapter(Context context, int textViewResourceId, ArrayList<EducationHour> items) {
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
			
			Room room = PHPGetter.instance().getRoomData(item.RoomID);
			Building building = PHPGetter.instance().getBuilding(room.BuildingID);
			
			String groupText = "";
			if (item.GroupNumber!=0)
				groupText=String.format(" (Group #%d)", item.GroupNumber);
			String topText = String.format("%s %d%s",building.Name,room.RoomNumber, groupText);	
			
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
        	
        	/*
            TextView topTextView = (TextView) view.findViewById(R.id.toptext);
            TextView bottomTextView = (TextView) view.findViewById(R.id.bottomtext);
            String topText = String.format("%s #%s", item.Course.Name,item.Course.Number);
            String bottomText = String.format("%s at %s [%s - %s]",GlobalHelper.instance().getFullEducationHourType(item.LessonType),
            		GlobalHelper.instance().getDayOfWeek(item.DayOfWeek),item.StartTime,item.EndTime);
            topTextView.setText(topText);
            bottomTextView.setText(bottomText);   
            */
            
        }
        return view;
    }
}