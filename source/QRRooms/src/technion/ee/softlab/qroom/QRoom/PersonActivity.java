package technion.ee.softlab.qroom.QRoom;

import java.util.ArrayList;
import technion.ee.softlab.qroom.R;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The Class PersonActivity. Show person's information.
 */
public class PersonActivity extends QRoomListActivity {
	private ImageView m_typeImageView;
	private TextView m_nameTextView;
	private TextView m_officeTextView;
	private TextView m_specializationTextView;;
	private TextView m_emailTextView;
	private TextView m_phoneTextView;
	private TextView m_faxTextView;
	private TextView m_receptionHoursTextView;
	private Person m_person;
	private ArrayList<ReceptionHour> m_receptionHourList = new ArrayList<ReceptionHour>();
	private int m_officeId;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.person);
		initComponents();
		
		//getting person's information
		int personId = getIntent().getExtras().getInt("personId");		
		m_person = PHPGetter.instance().getPerson(personId);
		m_receptionHourList = PHPGetter.instance().getPersonsReceptionHours(personId);
		m_nameTextView.setText(String.format("%s %s", m_person.FirstName, m_person.LastName));
	
		try {
			//if equals zero, than person doesn't has an office
			m_officeId = PHPGetter.instance().getOfficeIdByPersonId(personId);
			//TODO: try to reimplement office getter..  
			if (m_officeId!=0)
			{
				m_officeTextView.setText(String.format("%Office EXISTS, will be CLICKABLE"));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (!m_person.Specialization.equals(""))
		{
			m_specializationTextView.setText(String.format("Specialization: %s", m_person.Specialization));
		}
		if (!m_person.Email.equals(""))
		{
			m_emailTextView.setText(m_person.Email);
		}
		if (!m_person.Phone.equals(""))
		{
			m_phoneTextView.setText(String.format("Phone: %s", m_person.Phone));
		}
		if (!m_person.Fax.equals(""))
		{
			m_faxTextView.setText(String.format("Fax: %s", m_person.Fax));
		}
		if (m_receptionHourList.size()==0)
		{
			m_receptionHoursTextView.setText("");
		}
		if (m_person.WorkerType.equals("l"))
		{
			m_typeImageView.setImageDrawable(getResources().getDrawable(R.drawable.lecturer_128));
		}
		else if (m_person.WorkerType.equals("t"))
		{
			m_typeImageView.setImageDrawable(getResources().getDrawable(R.drawable.person_128));
		}
		setListAdapter(new ReceptionHourAdapter(this, R.layout.base_hour_list_item, m_receptionHourList));
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {
		m_typeImageView = (ImageView)findViewById(R.id.personImageView);
		m_nameTextView = (TextView)findViewById(R.id.personNameTextView);
		m_officeTextView = (TextView)findViewById(R.id.personOfficeTextView);
		m_specializationTextView = (TextView)findViewById(R.id.personCpecializationTextView);
		m_emailTextView = (TextView)findViewById(R.id.personEmailTextView);
		m_phoneTextView = (TextView)findViewById(R.id.personPhoneTextView);
		m_faxTextView = (TextView)findViewById(R.id.personFaxTextView);
		m_receptionHoursTextView = (TextView)findViewById(R.id.personReceptionHoursTextView);
	}
}