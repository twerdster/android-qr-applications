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
 * The Class OfficeAdapter. Used to supply information to a list in a OfficeActivity
 */
public class OfficeAdapter extends ArrayAdapter<Person> {
    private ArrayList<Person> items;
    private Context context;

    /**
     * Instantiates a new office adapter.
     *
     * @param context the context
     * @param textViewResourceId the text view resource id
     * @param items the items ArrayList
     */
    public OfficeAdapter(Context context, int textViewResourceId, ArrayList<Person> items) {
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

        Person item = items.get(position);
        if (item!= null) {
            TextView textTextView = (TextView) view.findViewById(R.id.singleLineListItemTextView);
            ImageView personImageView = (ImageView) view.findViewById(R.id.singleLineListItemImageView);

    		if (item.WorkerType.equals("l"))
    		{
    			personImageView.setImageDrawable(view.getResources().getDrawable(R.drawable.lecturer_48));
    		}
    		else if (item.WorkerType.equals("t"))
    		{
    			personImageView.setImageDrawable(view.getResources().getDrawable(R.drawable.person_48));
    		}
            
            String text = String.format("%s %s",item.FirstName, item.LastName);
            textTextView.setText(text);
           }
        return view;
    }
}