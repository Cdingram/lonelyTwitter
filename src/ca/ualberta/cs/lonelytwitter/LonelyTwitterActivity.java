package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> tweets;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button clearButton = (Button) findViewById(R.id.clear);
		
		clearButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				tweets.removeAll(tweets);
				adapter.notifyDataSetChanged();
				try {
					FileOutputStream fos = openFileOutput(FILENAME, 0);
					fos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				if (text.equals("")) {
					return;
				}
				saveInFile(text, new Date(System.currentTimeMillis()));
				tweets.add(text);
				adapter.notifyDataSetChanged();
				//finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		User u = new Author("Joe");
		
		u.getName();
		try{
			u.setName("Other Name");
		} catch (Exception e) {
			
		}
		
		//ArrayList<UserLike> users = new ArrayList<UserLike>();
		//ArrayList<Object> objects;
		
		
		
		
		
		super.onStart();
		tweets = loadFromFile();
		
		if(tweets == null){
			tweets = new ArrayList<String>();
		}
		
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private ArrayList<String> loadFromFile() {
		Gson gson = new Gson();
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader in = new InputStreamReader(fis);
			// Taken From http://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/index.html
			Type typeOfT = new TypeToken<ArrayList<String>>(){}.getType();
			tweets = gson.fromJson(in, typeOfT);
			fis.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;
	}
	
	private void saveInFile(String text, Date date) {
		Gson gson = new Gson();
		
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(tweets, osw);
			osw.flush();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}