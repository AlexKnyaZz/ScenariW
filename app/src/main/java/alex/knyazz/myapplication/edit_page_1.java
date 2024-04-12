
	 
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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
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
    private Button addRow;


    SharedPreferences sPref;

    public ArrayList<String> fileNames = new ArrayList<String>();

    //int clickNum = 0; // кол-во нажатий на кнопку
    String filename;
    int lastId = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_page_1);

        filename = selected();

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
        //a = (TextInputEditText) findViewById(R.id.a);
        //b = (TextInputEditText) findViewById(R.id.b);
        Return = (Button) findViewById(R.id.Return);
        addRow = (Button) findViewById(R.id.addRow);
        addRow.setOnClickListener(this);


        firstRow();


        //form1.setOnClickListener(this);

        //custom code goes here
        /*несколько способов создать таблицу
1) первая строчка tableRow создаётся программно с самого начала, ей присваивается id = 0 (переменная lastId = 0) и теги полей ("a"+0) и ("b"+0)
вторая строчка создаётся от lastId = lastId+1, id = lastId, теги = ("a"+lastId) и ("b"+lastId)

изначально есть
lastId = 0 создаётся в самом начале кода
countId = 0 создаётся перед циклом*/


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.addRow) {
            addRow();
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


    public void firstRow() {
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        TableRow clonedTableRow = new TableRow(this);
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        clonedTableRow.setLayoutParams(params);

        a = new TextInputEditText(this);
        a.setWidth(240);
        a.setGravity(Gravity.LEFT);
        //a.setHeight(500);
        a.setBackground(getDrawable(R.drawable.table));
        a.setPadding(5, 5, 5, 5);
        a.setId(lastId);
        a.setTag("a" + lastId);
        int aid = a.getId();
        String atag = (String) a.getTag();
        System.out.println(aid);
        System.out.println(atag);

        a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // оставляем как есть
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // оставляем как есть
            }

            @Override
            public void afterTextChanged(Editable s) {
                String te = new String(String.valueOf(a.getText()));
                System.out.println("text - " + te);
                String ta = (String) a.getTag();
                System.out.println("ta = " + ta);

                saveData(te, ta);

                // пытаемся выровнять ячейки

                int leftHeight = a.getHeight();
                System.out.println("leftHeight" + leftHeight);
                int rightHeight = b.getHeight();
                System.out.println("rightHeight" + rightHeight);


                /*if (leftHeight < rightHeight) {

                    params.height = rightHeight;
                    a.setHeight(rightHeight);
                    clonedTableRow.setLayoutParams(params);
                } else {
                    b.setHeight(leftHeight);
                    clonedTableRow.setMinimumHeight(leftHeight);

                    System.out.println("leftHeight"+leftHeight);
                    System.out.println("rightHeight"+rightHeight);

                    //params.height = leftHeight;
                    //b.setLayoutParams(params);
                    //System.out.println("params: "+params);
                    //clonedTableRow.setLayoutParams(params);
                    //System.out.println("params111: "+params);

                    //b.setHeight(leftHeight);
                }*/

                /*a.post(() -> {
                    int leftHeight = a.getHeight();
                    int rightHeight = b.getHeight();
                    if (leftHeight < rightHeight) {
                        a.setHeight(rightHeight);
                    } else {
                        b.setHeight(leftHeight);
                    }
                });*/
            }
        });


        b = new TextInputEditText(this);
        b.setWidth(240);
        //b.setHeight(500);
        b.setPadding(5, 5, 5, 5);
        //b.setHeight(100);
        b.setBackground(getDrawable(R.drawable.table));
        b.setId(lastId);
        b.setTag("b" + lastId);
        int bid = b.getId();
        String btag = (String) b.getTag();
        System.out.println(bid);
        System.out.println(btag);

        b.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // оставляем как есть
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // оставляем как есть
            }

            @Override
            public void afterTextChanged(Editable s) {
                String te = new String(String.valueOf(b.getText()));
                System.out.println("text?????? - " + te);
                String ta = (String) b.getTag();
                System.out.println("ta = " + ta);

                saveData(te, ta);

                // пытаемся выровнять ячейки

                /*int leftHeight = a.getHeight();
                System.out.println("leftHeight"+leftHeight);
                int rightHeight = b.getHeight();
                System.out.println("rightHeight"+rightHeight);


                if (leftHeight < rightHeight) {

                    params.height = rightHeight;
                    a.setHeight(rightHeight);
                    clonedTableRow.setLayoutParams(params);
                } else {
                    b.setHeight(leftHeight);
                    clonedTableRow.setMinimumHeight(leftHeight);

                    System.out.println("leftHeight"+leftHeight);
                    System.out.println("rightHeight"+rightHeight);

                    //params.height = leftHeight;
                    //b.setLayoutParams(params);
                    //System.out.println("params: "+params);
                    //clonedTableRow.setLayoutParams(params);
                    //System.out.println("params111: "+params);

                    //b.setHeight(leftHeight);
                }*/

                /*a.post(() -> {
                    int leftHeight = a.getHeight();
                    int rightHeight = b.getHeight();
                    if (leftHeight < rightHeight) {
                        a.setHeight(rightHeight);
                    } else {
                        b.setHeight(leftHeight);
                    }
                });*/
            }
        });


        clonedTableRow.addView(a);
        clonedTableRow.addView(b);
        stk.addView(clonedTableRow);
    }

    /*a.post(() -> {
        int leftHeight = a.getHeight();
        int rightHeight = b.getHeight();
        if (leftHeight < rightHeight) {
            a.setHeight(rightHeight);
        } else {
            b.setHeight(leftHeight);
        }
    });*/

    // заполнение таблицы данными
    public void fillData() {
        /*несколько способов создать таблицу
1) первая строчка tableRow создаётся программно с самого начала, ей присваивается id = 0 (переменная lastId = 0) и теги полей ("a"+0) и ("b"+0)
вторая строчка создаётся от lastId = lastId+1, id = lastId, теги = ("a"+lastId) и ("b"+lastId)

изначально есть
lastId = 0 создаётся в самом начале кода
countId = 0 создаётся перед циклом*/

        // инициализация или что-то вроде того
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        // обнуление всех созданных дубликатов //
        if (stk.getChildCount() > 0) {
            stk.removeAllViews();
        }
        int countId = 0; // счётчик для установки id
        for (int i = 0; i<=lastId; i++) { // здесь мы создаём таблицы на основе имеющихся  данных
            // возможно стоит использовать id
            // допустим, цифра последнего id = n
            // итак, получаем for (countId == 0, lastId)
            // увеличиваем счётчик
            countId += 1;
            // получаем данные для этой ячейки
            SharedPreferences sPref = getSharedPreferences(filename, MODE_PRIVATE);
            String aText = sPref.getString("a"+countId, "");
            String bText = sPref.getString("b"+countId, "");
            // копируем строку таблицы
            TableRow clonedTableRow  = new TableRow(this);
            // копируем первую ячейку
            TextInputEditText a = new TextInputEditText(this);
            // параметры //
            // присваиваем id созданному элементу
            a.setId(countId);
            a.setTag("a"+countId);
            // устанавливаем данные из файла
            a.setText(aText);
            // добавляем в tableRow
            clonedTableRow.addView(a);
/*
            // Получаем SharedPreferences для текущего файла
            SharedPreferences filePrefs = getSharedPreferences(fileName, MODE_PRIVATE);
            // Получаем значения по ключам
            String name = filePrefs.getString("saved_name", "");
            String type = filePrefs.getString("saved_type", "");
            // копируем строку таблицы
            TableRow clonedTableRow = new TableRow(this);
            // копируем первую ячейку
            TextView clonedNameTextView = new TextView(this);
            // устанавливаем параметры отображения
            clonedNameTextView.setWidth(600);
            clonedNameTextView.setTextSize(25);
            clonedNameTextView.setPadding(60, 15, 0, 15);
            clonedNameTextView.setGravity(Gravity.LEFT);
            clonedNameTextView.setId(countId); // устанавливаем id
            clonedNameTextView.setClickable(true);
            clonedNameTextView.setOnClickListener(this);
            // копируем вторую ячейку
            TextView clonedTypeTextView = new TextView(this);
            clonedTypeTextView.setTextSize(25);
            clonedTypeTextView.setPadding(0, 15, 5, 15);
            clonedTypeTextView.setGravity(Gravity.CENTER);
            clonedTypeTextView.setClickable(true);
            clonedTypeTextView.setOnClickListener(this);
            // устанавливаем тег
            clonedNameTextView.setTag(name);
            clonedTableRow.setTag(name);
            // Устанавливаем данные из файла SharedPreferences в клонированные элементы
            clonedNameTextView.setText(name);
            clonedTypeTextView.setText(type);
            // Добавляем ячейки с данными в строку таблицы
            clonedTableRow.addView(clonedNameTextView);
            clonedTableRow.addView(clonedTypeTextView);
            // Добавляем клонированную строку в таблицу
            stk.addView(clonedTableRow);
            System.out.println("table 4"); */
        }
    }

    public void addRow() {
        lastId += 1;
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        TableRow clonedTableRow = new TableRow(this);
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        clonedTableRow.setLayoutParams(params);

        a = new TextInputEditText(this);
        a.setWidth(240);
        //a.setHeight(500);
        a.setBackground(getDrawable(R.drawable.table));
        a.setPadding(5, 5, 5, 5);
        a.setId(lastId);
        a.setTag("a" + lastId);
        int aid = a.getId();
        String atag = (String) a.getTag();
        System.out.println(aid);
        System.out.println(atag);

        a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // оставляем как есть
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // оставляем как есть
            }

            @Override
            public void afterTextChanged(Editable s) {
                String te = new String(String.valueOf(a.getText()));
                System.out.println("text - " + te);
                String ta = (String) a.getTag();
                System.out.println("ta = " + ta);

                saveData(te, ta);

                // пытаемся выровнять ячейки

                int leftHeight = a.getHeight();
                System.out.println("leftHeight" + leftHeight);
                int rightHeight = b.getHeight();
                System.out.println("rightHeight" + rightHeight);

            }
        });

        b = new TextInputEditText(this);
        b.setWidth(240);
        a.setGravity(Gravity.LEFT);
        //b.setHeight(500);
        b.setPadding(5, 5, 5, 5);
        b.setGravity(Gravity.LEFT);
        //b.setHeight(100);
        b.setBackground(getDrawable(R.drawable.table));
        b.setId(lastId);
        b.setTag("b" + lastId);
        int bid = b.getId();
        String btag = (String) b.getTag();
        System.out.println(bid);
        System.out.println(btag);

        b.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // оставляем как есть
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // оставляем как есть
            }

            @Override
            public void afterTextChanged(Editable s) {
                String te = new String(String.valueOf(b.getText()));
                System.out.println("text?????? - " + te);
                String ta = (String) b.getTag();
                System.out.println("ta = " + ta);

                saveData(te, ta);

                // пытаемся выровнять ячейки


            }
        });

        clonedTableRow.addView(a);
        clonedTableRow.addView(b);
        stk.addView(clonedTableRow);
    }

    public void deleteRow() {
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        TableRow clonedTableRow = new TableRow(this);
        a = new TextInputEditText(this);
        b = new TextInputEditText(this);
        stk.removeView(findViewById(lastId));
        lastId -= 1;
    }

    public void saveData(String text, String tag) {
        sPref = getSharedPreferences(filename, MODE_PRIVATE);
        SharedPreferences.Editor ed1 = sPref.edit();
        ed1.putString(tag, text);
        ed1.commit();
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