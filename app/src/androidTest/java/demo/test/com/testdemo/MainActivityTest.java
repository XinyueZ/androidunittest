package demo.test.com.testdemo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

/**
 * Sample test-case for the {@link demo.test.com.testdemo.MainActivity}.
 *
 * @author Xinyue Zhao
 */
public final class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	public MainActivityTest() {
		super(MainActivity.class);
	}

	@SmallTest
	public void testHelloTvNotNull() {
		Activity activity = getActivity();
		TextView helloTv = (TextView) activity.findViewById(R.id.hello_tv);
		assertNotNull("TextView shows helloworld was not available.", helloTv);
	}
}
