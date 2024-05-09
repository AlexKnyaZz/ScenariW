
	 
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
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class info_page extends Activity implements View.OnClickListener {


    private Button btnBack;
    private TextView FZ;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.info_page);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        FZ = (TextView) findViewById(R.id.FZ);
        FZ.setMovementMethod(LinkMovementMethod.getInstance());
        FZ.setOnClickListener(this);

        //custom code goes here


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnBack) {
            toReturn(v);

        } else {
            return;
        }
        ;
    }


    public void toReturn(View v) {
        Intent intent = new Intent(info_page.this, frame_3_activity.class);
        startActivity(intent);
    }
}
	
	