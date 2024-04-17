
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		authorisation
	 *	@date 		Monday 25th of March 2024 09:59:09 AM
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
    import android.widget.ImageView;
    import android.widget.TextView;

	public class authorisation_activity extends Activity {

	
	private View _bg__authorisation_ek2;
	private ImageView shape_with_text;
	private ImageView shape_with_text_ek1;
	private TextView _____;
	private TextView __________________________________________________________________;
	private ImageView shape_with_text_ek2;
	private TextView ______;
	private View _bg__frame_5_ek1;
	private ImageView ______ek1;
	private TextView __________________;
	private ImageView shape_with_text_ek3;
	private ImageView shape_with_text_ek4;
	private ImageView shape_with_text_ek5;
	private ImageView shape_with_text_ek6;
	private ImageView shape_with_text_ek7;
	private ImageView shape_with_text_ek8;
	private ImageView shape_with_text_ek9;
	private TextView ___________________;
	private TextView ivan293;
	private TextView ________;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.authorisation);

		
		_bg__authorisation_ek2 = (View) findViewById(R.id._bg__authorisation_ek2);
		shape_with_text = (ImageView) findViewById(R.id.shape_with_text);
		shape_with_text_ek1 = (ImageView) findViewById(R.id.shape_with_text_ek1);
		_____ = (TextView) findViewById(R.id._____);
		__________________________________________________________________ = (TextView) findViewById(R.id.__________________________________________________________________);
		shape_with_text_ek2 = (ImageView) findViewById(R.id.shape_with_text_ek2);
		______ = (TextView) findViewById(R.id.______);
		_bg__frame_5_ek1 = (View) findViewById(R.id._bg__frame_5_ek1);
		__________________ = (TextView) findViewById(R.id.__________________);
		shape_with_text_ek3 = (ImageView) findViewById(R.id.shape_with_text_ek3);
		shape_with_text_ek4 = (ImageView) findViewById(R.id.shape_with_text_ek4);
		shape_with_text_ek5 = (ImageView) findViewById(R.id.shape_with_text_ek5);
		___________________ = (TextView) findViewById(R.id.___________________);
		________ = (TextView) findViewById(R.id.________);
	
		
		//custom code goes here

	
	}
	public void startNewActivity(View v){
		Intent intent = new Intent(authorisation_activity.this, frame_3_activity.class);
		//System.out.println("succeeeeeeeeeeeeeeeeees");
		startActivity(intent);
	}
}
	
	