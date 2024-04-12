
	 
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
    private Button removeRow;


    SharedPreferences sPref;

    public ArrayList<String> fileNames = new ArrayList<String>();

    //int clickNum = 0; // кол-во нажатий на кнопку
    String filename;
    int lastId;
    int rowsCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_page_1);


        filename = selected();
        sPref = getSharedPreferences(filename, MODE_PRIVATE);


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
        // инициализация таблиц
        table = (TableLayout) findViewById(R.id.table);
        TableRowSc = (TableRow) findViewById(R.id.TableRowSc);

        // инициализация кнопок и создание слушателей
        Return = (Button) findViewById(R.id.Return);

        addRow = (Button) findViewById(R.id.addRow);
        addRow.setOnClickListener(this);

        removeRow = (Button) findViewById(R.id.removeRow);
        removeRow.setOnClickListener(this);

        System.out.println("onCreate: lastId " + lastId);

        // наполнение данными
        fillData();

        //custom code goes here


    }

    // обработчик нажатий
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.addRow) {
            fillData();
            addRow();
            fillData();
        } else if (id == R.id.removeRow) {
            deleteRow();
            fillData();
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


    // заполнение таблицы данными
    public void fillData() {

        // инициализация или что-то вроде того
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        // обнуление всех созданных дубликатов //
        if (stk.getChildCount() > 0) {
            stk.removeAllViews();
        }

        // для проверки, содержит ли файл число
        String lastIdString = sPref.getString("lastId", "");
        if (!lastIdString.isEmpty() && lastIdString.matches("\\d+")) {
            lastId = Integer.parseInt(lastIdString);
        } else {
            lastId = 0;
            System.out.println("fillData : строка lastId не может быть преобразована в число");
        }

        String rowsCountString = sPref.getString("rowsCount", "");
        if (!rowsCountString.isEmpty() && rowsCountString.matches("\\d+")) {
            rowsCount = Integer.parseInt(rowsCountString);
        } else {
            rowsCount = 0;
            System.out.println("fillData : строка rowsCount не может быть преобразована в число");
        }

        //rowsCount = Integer.parseInt(sPref.getString("rowsCount", "")); // берём значение кол-ва строк из файла
        //lastId = Integer.parseInt(sPref.getString("lastId", "")); // берём значение последнего добавленного id из файла
        System.out.println("до кода, lastId в fillData: " + lastId);

        if (rowsCount == 0) {
            // если не создано ни одной строчки, создаём

            System.out.println("fillData : вызываем метод addRow....");

            addRow();

            System.out.println("fillData: rowsCount = " + rowsCount);
        } else {
            // если строчки уже есть
            for (int i = 0; i <= lastId; i++) { // здесь мы создаём таблицы на основе имеющихся  данных

                System.out.println("lastId в цикле fillData: " + lastId);

                // получаем данные
                SharedPreferences sPref = getSharedPreferences(filename, MODE_PRIVATE);
                String aText = sPref.getString("a" + i, "");
                String bText = sPref.getString("b" + i, "");
                String cText = sPref.getString("c" + i, "");

                System.out.println("fillData: a" + i + " aText " + aText);
                System.out.println("fillData: b" + i + " bText " + bText);
                System.out.println("fillData: c" + i + " cText " + cText);

                // копируем строку таблицы
                TableRow clonedTableRow = new TableRow(this);
                // копируем первую ячейку
                TextInputEditText a = new TextInputEditText(this);
                // параметры //
                a.setWidth(240);
                a.setGravity(Gravity.LEFT);
                //a.setHeight(500);
                a.setBackground(getDrawable(R.drawable.table));
                a.setPadding(5, 5, 5, 5);
                // присваиваем id созданному элементу
                a.setId(i);
                a.setTag("a" + i);
                // устанавливаем данные из файла
                a.setText(aText);
                // добавляем в tableRow
                clonedTableRow.addView(a);

                // слушатель
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

                        System.out.println("вызывается fillData, a");

                        String te = new String(String.valueOf(a.getText()));
                        System.out.println("fillData: text - " + te);
                        String ta = (String) a.getTag();
                        System.out.println("tag = " + ta);

                        saveData(te, ta);

                    }
                });

                TextInputEditText b = new TextInputEditText(this);
                b.setWidth(240);
                //b.setHeight(500);
                b.setPadding(5, 5, 5, 5);
                //b.setHeight(100);
                b.setBackground(getDrawable(R.drawable.table));
                // присваиваем id созданному элементу
                b.setId(i);
                b.setTag("b" + i);
                // устанавливаем данные из файла
                b.setText(bText);
                // добавляем в tableRow
                clonedTableRow.addView(b);

                String tag = (String) b.getTag();
                System.out.println("fillData : до изменения текста внутри, tag = " + tag);

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

                        System.out.println("вызывается fillData, b");

                        //String te = new String(String.valueOf(b.getText()));
                        String te = b.getText().toString();
                        System.out.println("fillData: text - " + te);
                        String ta = (String) b.getTag();
                        System.out.println("tag = " + ta);

                        saveData(te, ta);
                    }
                });

                /*
                // копируем первую ячейку
                TextInputEditText c = new TextInputEditText(this);
                // параметры //
                c.setWidth(200);
                c.setGravity(Gravity.LEFT);
                //a.setHeight(500);
                c.setBackground(getDrawable(R.drawable.table));
                c.setPadding(5, 5, 5, 5);
                // присваиваем id созданному элементу
                c.setId(i);
                c.setTag("c"+i);
                // устанавливаем данные из файла
                c.setText(cText);
                // добавляем в tableRow
                clonedTableRow.addView(c);

                // слушатель
                c.addTextChangedListener(new TextWatcher() {
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

                        System.out.println("вызывается fillData, c");

                        String te = new String(String.valueOf(c.getText()));
                        System.out.println("fillData: text - " + te);
                        String ta = (String) c.getTag();
                        System.out.println("tag = " + ta);

                        saveData(te, ta);

                    }
                });*/


                // Добавляем клонированную строку в таблицу
                stk.addView(clonedTableRow);
            }
        }

        // для проверки после заполнения
        lastId = Integer.parseInt(sPref.getString("lastId", ""));
        System.out.println("после кода, lastId в fillData: " + lastId);


    }

    public void addRow() {

        // для проверки, содержит ли файл число
        String lastIdString = sPref.getString("lastId", "");
        if (!lastIdString.isEmpty() && lastIdString.matches("\\d+")) {
            lastId = Integer.parseInt(lastIdString);
        } else {
            lastId = 0;
            System.out.println("fillData : строка lastId не может быть преобразована в число");
        }

        String rowsCountString = sPref.getString("rowsCount", "");
        if (!rowsCountString.isEmpty() && rowsCountString.matches("\\d+")) {
            rowsCount = Integer.parseInt(rowsCountString);
        } else {
            rowsCount = 0;
            System.out.println("fillData : строка rowsCount не может быть преобразована в число");
        }

        //lastId = Integer.parseInt(sPref.getString("lastId", "")); // берём значение последнего id

        System.out.println("lastId in addRow  = " + lastId);

        // добавляем всё нужное
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

        /*a.addTextChangedListener(new TextWatcher() {
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

                System.out.println("вызывается addRow, a");

                String te = new String(String.valueOf(a.getText()));
                System.out.println("text - " + te);
                String ta = (String) a.getTag();
                System.out.println("ta = " + ta);

                saveData(te, ta);

            }
        });*/

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

        /*b.addTextChangedListener(new TextWatcher() {
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

                System.out.println("вызывается addRow, b");

                String te = new String(String.valueOf(b.getText()));
                System.out.println("text?????? - " + te);
                String ta = (String) b.getTag();
                System.out.println("ta = " + ta);

                saveData(te, ta);


            }
        });*/

        /*
        TextInputEditText c = new TextInputEditText(this);
        c.setWidth(200);
        //a.setHeight(500);
        c.setBackground(getDrawable(R.drawable.table));
        c.setPadding(5, 5, 5, 5);
        c.setId(lastId);
        c.setTag("c" + lastId);
        int cid = c.getId();
        String ctag = (String) c.getTag();
        System.out.println(cid);
        System.out.println(ctag);  */


        clonedTableRow.addView(a);
        clonedTableRow.addView(b);
        //clonedTableRow.addView(c);
        stk.addView(clonedTableRow);

        // обновляем lastId и rowsCount
        // при следующем вызове объекту будет дан увеличенный id
        lastId += 1;
        SharedPreferences.Editor ed1 = sPref.edit();
        ed1.putString("lastId", String.valueOf(lastId));
        ed1.commit();
        System.out.println("addRow, результат, lastId = " + lastId);

        rowsCount += 1; // добавляем единицу, поскольку теперь строчка есть
        // обновляем кол-во строчек в файле
        ed1.putString("rowsCount", String.valueOf(rowsCount));
        ed1.commit();
        System.out.println("addRow, результат, rowsCount = " + rowsCount);
    }

    public void deleteRow() {
        TableLayout stk = (TableLayout) findViewById(R.id.table);
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


// вырезано из кода, сохранено здесь на случай если понадобится


// заполнение таблицы данными
    /*public void fillData() {

        // инициализация или что-то вроде того
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        // обнуление всех созданных дубликатов //
        if (stk.getChildCount() > 0) {
            stk.removeAllViews();
        }

        if(lastId == 0){
            // если lastId = 0, 0 записывается в файл

            System.out.println("fillData: lastId  == 0");

            SharedPreferences.Editor ed1 = sPref.edit();
            ed1.putString("lastId", String.valueOf(lastId));
            ed1.commit();
        } else{
            System.out.println("fillData: lastId  != 0, lastId = "+lastId);
            lastId = Integer.parseInt(sPref.getString("lastId", ""));
        }

        lastId = Integer.parseInt(sPref.getString("lastId", ""));
        System.out.println("lastId в fillData: "+lastId);

        for (int i = 0; i<=lastId; i++) { // здесь мы создаём таблицы на основе имеющихся  данных

            System.out.println("lastId в цикле fillData: "+lastId);

            SharedPreferences sPref = getSharedPreferences(filename, MODE_PRIVATE);
            String aText = sPref.getString("a"+i, "");
            String bText = sPref.getString("b"+i, "");

            System.out.println("fillData: a"+i+" aText "+aText);
            System.out.println("fillData: b"+i+" bText "+bText);

            // копируем строку таблицы
            TableRow clonedTableRow  = new TableRow(this);
            // копируем первую ячейку
            TextInputEditText a = new TextInputEditText(this);
            // параметры //
            a.setWidth(240);
            a.setGravity(Gravity.LEFT);
            //a.setHeight(500);
            a.setBackground(getDrawable(R.drawable.table));
            a.setPadding(5, 5, 5, 5);
            // присваиваем id созданному элементу
            a.setId(i);
            a.setTag("a"+i);
            // устанавливаем данные из файла
            a.setText(aText);
            // добавляем в tableRow
            clonedTableRow.addView(a);

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

                    System.out.println("вызывается fillData, a");

                    String te = new String(String.valueOf(a.getText()));
                    System.out.println("fillData: text - " + te);
                    String ta = (String) a.getTag();
                    System.out.println("tag = " + ta);

                    saveData(te, ta);

                }
            });

            b = new TextInputEditText(this);
            b.setWidth(240);
            //b.setHeight(500);
            b.setPadding(5, 5, 5, 5);
            //b.setHeight(100);
            b.setBackground(getDrawable(R.drawable.table));
            // присваиваем id созданному элементу
            b.setId(i);
            b.setTag("b"+i);
            // устанавливаем данные из файла
            b.setText(bText);
            // добавляем в tableRow
            clonedTableRow.addView(b);

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

                    System.out.println("вызывается fillData, b");

                    //String te = new String(String.valueOf(b.getText()));
                    String te = b.getText().toString();
                    System.out.println("fillData: text - " + te);
                    String ta = (String) b.getTag();
                    System.out.println("tag = " + ta);

                    saveData(te, ta);
                }
            });

            // Добавляем клонированную строку в таблицу
            stk.addView(clonedTableRow);
        }
    }*/














/*
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

                System.out.println("вызывается firstRow, a");

                String te = new String(String.valueOf(a.getText()));
                System.out.println("text - " + te);
                String ta = (String) a.getTag();
                System.out.println("ta = " + ta);

                saveData(te, ta);

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

                System.out.println("вызывается firstRow, b");

                String te = new String(String.valueOf(b.getText()));
                System.out.println("text?????? - " + te);
                String ta = (String) b.getTag();
                System.out.println("ta = " + ta);

                saveData(te, ta);

            }
        });


        clonedTableRow.addView(a);
        clonedTableRow.addView(b);
        stk.addView(clonedTableRow);
    }
*/