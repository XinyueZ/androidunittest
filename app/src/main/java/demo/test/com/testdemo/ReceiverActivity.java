package demo.test.com.testdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * An {@link android.app.Activity} that can get an {@link android.content.Intent} and show some information of it.
 */
public final class ReceiverActivity extends Activity {
	private static final String EXTRAS_INTENT_TEXT = "demo.test.com.testdemo.INTENT_TEXT";
	private static final int LAYOUT = R.layout.activity_receiver;
	private TextView mIntentTv;

	/**
	 * Show single instance of {@link}
	 *
	 * @param cxt {@link android.content.Context}.
	 * @param msg  Extras information for {@link demo.test.com.testdemo.ReceiverActivity}.
	 */
	public static void showInstance(Context cxt, String msg) {
		Intent intent = new Intent(cxt, ReceiverActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra(EXTRAS_INTENT_TEXT, msg);
		cxt.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(LAYOUT);
		mIntentTv = (TextView) findViewById(R.id.intent_tv);
		handleIntent();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		handleIntent();
	}

	/**
	 * Get and set information from {@link android.content.Intent} to UI.
	 */
	private void handleIntent() {
		Intent i = getIntent();
		mIntentTv.setText(i.getStringExtra(EXTRAS_INTENT_TEXT));
	}
}
