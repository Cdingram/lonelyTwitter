package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.lonelytwitter.R;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

    protected void setUp() throws Exception {
    	super.setUp();
    }
    
    public void testSendText(){
    	String text = "Hello";
    	IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
    	assertEquals("Is the activity getting my text?", text, activity.getText());
    }
    
    public void testDoubleText() {
    	String text = "Hi";
    	IntentReaderActivity activity = startWithText(text, IntentReaderActivity.DOUBLE);
    	assertEquals("correct?", text+text, activity.getText());
    }
    
    public void testDisplayText() {
    	IntentReaderActivity activity = startWithText("Hello", IntentReaderActivity.NORMAL);
    	TextView view = (TextView) activity.findViewById(R.id.intentText);
    	assertEquals("display correct text?", "Hello", view.getText());
    }
    
    public void testReverseText() {
    	IntentReaderActivity activity = startWithText("Hello", IntentReaderActivity.REVERSE);
    	TextView view = (TextView) activity.findViewById(R.id.intentText);
    	assertEquals("display correct text?", "olleH", view.getText());
    }
    
    public void testDefaultText() {
    	IntentReaderActivity activity = getActivity();
    	TextView view = (TextView) activity.findViewById(R.id.intentText);
    	assertEquals("dont distplay text", "Default", view.getText());
    	assertEquals("display in text view", null, activity.getText());

    }
    
    public void testViewableText() {
    	IntentReaderActivity activity = getActivity();
    	TextView view = (TextView) activity.findViewById(R.id.intentText);
    	ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);

    }
    
    private IntentReaderActivity startWithText(String text, int transform_code) {
		Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
    	intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, transform_code);
    	setActivityIntent(intent);
    	return (IntentReaderActivity) getActivity();
    }
       
}
