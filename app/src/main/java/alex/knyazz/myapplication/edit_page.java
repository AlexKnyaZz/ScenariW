
	 
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
import android.widget.TextView;

import java.util.ArrayList;

public class edit_page extends Activity implements View.OnClickListener {


    private RelativeLayout content_container;
    private View _bg__authorisation_ek2;
    private ImageView shape_with_text;
    private TextView ___________________;
    private ImageView shape_with_text_ek3;
    private TableLayout table;
    private RelativeLayout frame_5;
    private Button Create;
    private Button Return;
    private Button form1;


    SharedPreferences sPref;

    public ArrayList<String> fileNames = new ArrayList<String>();

    //int clickNum = 0; // кол-во нажатий на кнопку

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_page);

        /*files();
        fillTableWithFileData();
        */
        content_container = (RelativeLayout) findViewById(R.id.content_container);
        _bg__authorisation_ek2 = (View) findViewById(R.id._bg__authorisation_ek2);
        shape_with_text = (ImageView) findViewById(R.id.shape_with_text);
        ___________________ = (TextView) findViewById(R.id.___________________);
        shape_with_text_ek3 = (ImageView) findViewById(R.id.shape_with_text_ek3);
        table = (TableLayout) findViewById(R.id.table);
        frame_5 = (RelativeLayout) findViewById(R.id.frame_5);

        Create = (Button) findViewById(R.id.Create);
        Create.setOnClickListener(this);
        Return = (Button) findViewById(R.id.Return);
        Return.setOnClickListener(this);
        form1 = (Button) findViewById(R.id.form1);
        form1.setOnClickListener(this);

        //custom code goes here


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.form1) {
            addForm("form1Table");
        } else if (id == R.id.Create) {
            toCreate1(v);
        } else {
            return;
        }
        ;
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

/*
    // список имён созданных файлов
    public void files(){
        // берём названия файлов
        // System.out.println("fileNames !!!! : " + fileNames);
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        ArrayList<String> savedFileNames = new ArrayList<String>(sPref.getStringSet("fileNames", new HashSet<>()));
        fileNames.addAll(savedFileNames);
        for (String fileName : fileNames) {
            System.out.println("fileNames: " + fileName);
        }
    }

    public void fillTableWithFileData() {
        int countId = 0; // счётчик для установки id
        for (String fileName : fileNames) {
            // увеличиваем счётчик
            countId += 1;

            // Получаем SharedPreferences для текущего файла
            SharedPreferences filePrefs = getSharedPreferences(fileName, MODE_PRIVATE);

            // Получаем значения по ключам
            String name = filePrefs.getString("saved_name", "");
            String type = filePrefs.getString("saved_type", "");

            // Клонируем существующие элементы
            TableLayout stk = (TableLayout) findViewById(R.id.table);
            TableRow clonedTableRow = new TableRow(this);
            TextView clonedNameTextView = new TextView(this);
            clonedNameTextView.setWidth(625);
            clonedNameTextView.setTextSize(25);
            clonedNameTextView.setPadding(80, 15, 5, 15);
            clonedNameTextView.setGravity(Gravity.LEFT);
            clonedNameTextView.setId(countId); // устанавливаем id
            clonedNameTextView.setClickable(true);

            //clonedNameTextView.setOnClickListener(this);


            TextView clonedTypeTextView = new TextView(this);
            //clonedTypeTextView.setLayoutParams(new ViewGroup.LayoutParams(10, 42));
            clonedTypeTextView.setTextSize(25);
            clonedTypeTextView.setPadding(5, 15, 5, 15);
            clonedTypeTextView.setGravity(Gravity.CENTER);

            clonedNameTextView.setId(countId); // устанавливаем id
            clonedNameTextView.setTag(name);
            clonedTableRow.setTag(name);

            clonedNameTextView.setClickable(true);

            System.out.println("table 1");

            // Устанавливаем данные из файла SharedPreferences в клонированные элементы
            clonedNameTextView.setText(name);
            clonedTypeTextView.setText(type);

            clonedTableRow.addView(clonedNameTextView);
            System.out.println("table 2");
            clonedTableRow.addView(clonedTypeTextView);
            System.out.println("table 3");

            // Добавляем клонированную строку в таблицу
            stk.addView(clonedTableRow);
            System.out.println("table 4");
        }
    }





    /*@Override
    public void onClick(View v) {
        clickNum += 1;
        System.out.println(clickNum);
        if (clickNum == 1) {
            // получаем тег нажатого элемента для дальнейших действий (тег = имя нового файла, что упрощает работу с данными)
            String naame = (String) v.getTag();
            v.setBackground(ContextCompat.getDrawable(this, R.color.bbb));
            // получаем данные этого элемента
            data(naame);

            addCurrent(naame);

        } else if (clickNum > 1) {
            // снимаем выделение с элемента
            v.setBackground(null);
            clickNum = 0;
        }
    }*/

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
        Intent intent = new Intent(edit_page.this, edit_page_1.class);
        startActivity(intent);
    }

    public void toReturn(View v) {
        Intent intent = new Intent(edit_page.this, frame_3_activity.class);
        startActivity(intent);
    }
}
	
	