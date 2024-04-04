
	 
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
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.RelativeLayout;
    import android.widget.ScrollView;
    import android.widget.TextView;

    public class scenarious_create1 extends Activity {


    private ScrollView authorisation;
    private RelativeLayout content_container;
    private RelativeLayout frame_5;
    private RelativeLayout page_authorisation_ek1;
    private View _bg__authorisation_ek2;
    private ImageView shape_with_text;
    private ImageView shape_with_text_ek2;
    private ImageView shape_with_text_ek1;
    private ImageView shape_with_text_ek3;
    private Button CreateNew;
    private Button Return;
    private Button CreateWLink;
    private TextView _____;
    private TextView __________________________________________________________________;
    private TextView ___________________;




    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenarious_create1);


        authorisation = (ScrollView) findViewById(R.id.authorisation);
        content_container = (RelativeLayout) findViewById(R.id.content_container);
        page_authorisation_ek1 = (RelativeLayout) findViewById(R.id.page_authorisation_ek1);
        frame_5 = (RelativeLayout) findViewById(R.id.frame_5);
        _bg__authorisation_ek2 = (View) findViewById(R.id._bg__authorisation_ek2);
        shape_with_text = (ImageView) findViewById(R.id.shape_with_text);
        shape_with_text_ek2 = (ImageView) findViewById(R.id.shape_with_text_ek2);
        shape_with_text_ek1 = (ImageView) findViewById(R.id.shape_with_text_ek1);
        shape_with_text_ek3 = (ImageView) findViewById(R.id.shape_with_text_ek3);
        CreateNew = (Button) findViewById(R.id.CreateNew);
        Return = (Button) findViewById(R.id.Return);
        CreateWLink = (Button) findViewById(R.id.CreateWLink);
        _____ = (TextView) findViewById(R.id._____);
        __________________________________________________________________ = (TextView) findViewById(R.id.__________________________________________________________________);
        ___________________ = (TextView) findViewById(R.id.___________________);





        //custom code goes here


    }
    public void toCreate2(View v){
        Intent intent = new Intent(scenarious_create1.this, scenarious_create2.class);
        //System.out.println("succeeeeeeeeeeeeeeeeees");
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
        public void toReturn(View v){
            Intent intent = new Intent(scenarious_create1.this, frame_3_activity.class);
            //System.out.println("succeeeeeeeeeeeeeeeeees");
            startActivity(intent);
        }
}
	
	