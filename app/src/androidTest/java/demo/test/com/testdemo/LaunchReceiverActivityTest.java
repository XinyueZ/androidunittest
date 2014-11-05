package demo.test.com.testdemo;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

/**
 * Sample test-case for the {@link demo.test.com.testdemo.MainActivity} to start the  {@link
 * demo.test.com.testdemo.ReceiverActivity}.
 *
 * @author Xinyue Zhao
 */
public final class LaunchReceiverActivityTest extends ActivityUnitTestCase<MainActivity> {

	public LaunchReceiverActivityTest() {
		super(MainActivity.class);
	}


	@MediumTest
	public void testReceiverActivityWithIntent() {
		startActivity(new Intent(getInstrumentation()
				.getTargetContext(), MainActivity.class), null, null);

		Activity activity = getActivity();
		Button clickMeBtn = (Button) activity.findViewById(R.id.click_me_btn);
		clickMeBtn.performClick();

		// To test whether the ReceiverActivity would be started with an validate Intent or not.
		final Intent launchIntent = getStartedActivityIntent();
		assertNotNull("Intent for ReceiverActivity was null.", launchIntent);

		// To test the content of the Intent that starts the ReceiverActivity.
		final String payload =
				launchIntent.getStringExtra(ReceiverActivity.EXTRAS_INTENT_TEXT);
		assertEquals("Not an except word!", "Hello receiver!", payload);
	}
}
