
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		frame_3
	 *	@date 		Monday 25th of March 2024 03:56:20 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package alex.knyazz.myapplication;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.RelativeLayout;
    import android.widget.TextView;

public class frame_3_activity extends Activity {


	private RelativeLayout frame_3;

	private RelativeLayout content_container;
	private TextView AppName;
	private ImageView shape_with_text_ek3;
	private ImageView shape_with_text_ek4;
	private TextView textView;
	private Button UserInfo;


	private static int  WELCOME_TIMEOUT = 4000;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_3);

		frame_3 = (RelativeLayout) findViewById(R.id.frame_3);
		content_container = (RelativeLayout) findViewById(R.id.content_container);
		AppName = (TextView) findViewById(R.id.AppName);
		shape_with_text_ek3 = (ImageView) findViewById(R.id.shape_with_text_ek3);
		shape_with_text_ek4 = (ImageView) findViewById(R.id.shape_with_text_ek4);
		textView = (TextView)  findViewById(R.id.textView);
		UserInfo = (Button) findViewById(R.id.UserInfo);
		//---------------------------------

		/*new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent welcome = new Intent(frame_3_activity.this, scenarious.class);
				startActivity(welcome);
				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				finish();
			}
		}, WELCOME_TIMEOUT); */
				//custom code goes here


	}
	public void toScenarious(View v){
		Intent intent = new Intent(frame_3_activity.this, scenarious.class);
		startActivity(intent);

	}
}
	
	