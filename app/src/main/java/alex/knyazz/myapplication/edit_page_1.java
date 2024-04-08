
	 
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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class edit_page_1 extends Activity implements View.OnClickListener {


    private RelativeLayout authorisation, content_container, page_authorisation_ek1, frame_5;
    private View _bg__authorisation_ek2;
    private ImageView shape_with_text, shape_with_text_ek2, shape_with_text_ek3, shape_with_scanerious;
    private TextView scenName;
    private TableLayout table;
    private TableRow TableRowSc;
    private TextInputEditText a, b;
    private Button Return;


    SharedPreferences sPref;

    public ArrayList<String> fileNames = new ArrayList<String>();

    //int clickNum = 0; // кол-во нажатий на кнопку

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_page_1);

        /*files();
        fillTableWithFileData();
        */

        authorisation = (RelativeLayout) findViewById(R.id.authorisation);
        content_container = (RelativeLayout) findViewById(R.id.content_container);
        page_authorisation_ek1 = (RelativeLayout) findViewById(R.id.page_authorisation_ek1);
        frame_5 = (RelativeLayout) findViewById(R.id.frame_5);
        _bg__authorisation_ek2 = (View) findViewById(R.id._bg__authorisation_ek2);
        shape_with_text = (ImageView) findViewById(R.id.shape_with_text);
        shape_with_text_ek2 = (ImageView) findViewById(R.id.shape_with_text_ek2);
        shape_with_text_ek3 = (ImageView) findViewById(R.id.shape_with_text_ek3);
        shape_with_scanerious = (ImageView) findViewById(R.id.shape_with_scanerious);
        // устанавливаем в самом верху имя сценария
        scenName = (TextView) findViewById(R.id.scenName);
        scenName.setText(setName());

        table = (TableLayout) findViewById(R.id.table);
        TableRowSc = (TableRow) findViewById(R.id.TableRowSc);
        a = (TextInputEditText) findViewById(R.id.a);
        b = (TextInputEditText) findViewById(R.id.b);
        Return = (Button) findViewById(R.id.Return);

        //form1.setOnClickListener(this);

        //custom code goes here


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.form1) {
            addForm("form1Table");
        } else {
            return;
        }
        ;
    }

    // определяем имя текущего сценария
    public String setName() {
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        String name = sPref.getString("current_name", "");
        return name;
    }

    public String selected() {
        SharedPreferences filePrefs = getSharedPreferences("MyFiles", MODE_PRIVATE);
        // Получаем значение по ключу
        String name = filePrefs.getString("current_name", "");
        System.out.println("name: " + name);
        return name;
    }

    // добавляем название выбранного шаблона в файл сценария
    public void addForm(String s) {
        String name = selected();
        sPref = getSharedPreferences(name, MODE_PRIVATE); //сохраняем в файл, название которого = названию сценария
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("form", s);
        ed.commit();
    }

    public void addCurrent(String s) {
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        SharedPreferences.Editor ed3 = sPref.edit();
        ed3.putString("current_name", s);
        ed3.apply();
    }

    public void data(String s) {
        SharedPreferences filePrefs = getSharedPreferences(s, MODE_PRIVATE);

        // Получаем значения по ключам
        String name = filePrefs.getString("saved_name", "");
        String type = filePrefs.getString("saved_type", "");

        System.out.println("name: " + name + ", type: " + type);
    }

    public void toCreate1(View v) {
        //Intent intent = new Intent(edit_page.this, scenarious_create1.class);
        //startActivity(intent);
    }

    public void toReturn(View v) {
        Intent intent = new Intent(edit_page_1.this, frame_3_activity.class);
        startActivity(intent);
    }
}
	
	