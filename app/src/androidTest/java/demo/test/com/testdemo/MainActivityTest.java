package demo.test.com.testdemo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

/**
 * Created by czhao on 04.11.14.
 */
public final class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{
	public MainActivityTest( ) {
		super(MainActivity.class);
	}

	@SmallTest
	public void testHelloTvNotNull() {
		Activity activity = getActivity();
		TextView helloTv = (TextView) activity.findViewById(R.id.hello_tv);
		assertNotNull("textview for hello is not available", helloTv);
	}
}
