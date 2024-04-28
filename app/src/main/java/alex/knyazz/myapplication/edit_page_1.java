
	 
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


    private RelativeLayout authorisation, content_container, page_authorisation_ek1, frame_5, assistent;
    private View _bg__authorisation_ek2;
    private ImageView shape_with_text, shape_with_text_ek2, shape_with_text_ek3, shape_with_scanerious;
    private TextView scenName, assist1, assist2, assist3, categoryAssist;
    private TableLayout table;
    private TableRow TableRowSc;
    private TextInputEditText a, b;
    private Button Return;
    private Button addRow;
    private Button removeRow;
    private Button dataToServer;


    SharedPreferences sPref;

    public ArrayList<String> fileNames = new ArrayList<String>();

    //int clickNum = 0; // кол-во нажатий на кнопку
    String filename;
    int lastId;
    int rowsCount;
    String old;

    int asiCall = 0; // кол-во вызовов подсказок ассистента
    int ageCategoryGlobal = 0;
    int termins = 0; // кол-во терминов из бд

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

        // ассистент
        assistent = (RelativeLayout) findViewById(R.id.assistent);
        assistent.setVisibility(View.INVISIBLE);
        assist1 = (TextView) findViewById(R.id.assist1);
        assist1.setVisibility(View.INVISIBLE);
        assist2 = (TextView) findViewById(R.id.assist2);
        assist2.setVisibility(View.INVISIBLE);
        assist3 = (TextView) findViewById(R.id.assist3);
        assist3.setVisibility(View.INVISIBLE);

        categoryAssist = (TextView) findViewById(R.id.categoryAssist);
        categoryAssist.setVisibility(View.INVISIBLE);
        old = (String) categoryAssist.getText();

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

        dataToServer = (Button) findViewById(R.id.dataToServer);
        dataToServer.setOnClickListener(this);

        removeRow = (Button) findViewById(R.id.removeRow);
        removeRow.setOnClickListener(this);


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
        } else if (id == R.id.dataToServer) {
            sendToServer();
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

        //lastId = sPref.getInt("lastId", 0);
        //rowsCount = sPref.getInt("rowsCount", 0);
        sPref = getSharedPreferences(filename, MODE_PRIVATE);

        String lastIdString = sPref.getString("lastId", "");
        if (!lastIdString.isEmpty() && lastIdString.matches("\\d+")) {
            lastId = Integer.parseInt(lastIdString);
            System.out.println("fillData : проверка, содержит ли число lastId; результат " + lastId);
        } else {
            lastId = 0;
            System.out.println("fillData : строка lastId не может быть преобразована в число");
        }

        String rowsCountString = sPref.getString("rowsCount", "");
        if (!rowsCountString.isEmpty() && rowsCountString.matches("\\d+")) {
            rowsCount = Integer.parseInt(rowsCountString);
            System.out.println("fillData : проверка, содержит ли число rowsCount; результат " + rowsCount);
        } else {
            rowsCount = 0;
            System.out.println("fillData : строка rowsCount не может быть преобразована в число");
        }

        System.out.println("до кода, lastId в fillData: " + lastId);

        if (rowsCount == 0) {
            // если не создано ни одной строчки, создаём

            // тестовое
            rowsCount += 1; // добавляем единицу, поскольку теперь строчка есть
            // обновляем кол-во строчек в файле
            SharedPreferences.Editor ed1 = sPref.edit();
            //ed1.putString("rowsCount", String.valueOf(rowsCount));
            ed1.putString("rowsCount", String.valueOf(rowsCount));
            ed1.commit();
            System.out.println("fillData : результат, rowsCount = " + rowsCount);



            // включаем подсказки ассистента
            // подксказка 1
            asiCall = 0;

            assistent.setVisibility(View.VISIBLE);
            assist1.setVisibility(View.VISIBLE);
            assist2.setVisibility(View.INVISIBLE);
            assist3.setVisibility(View.INVISIBLE);


            System.out.println("fillData : вызываем метод addRow....");
            addRow();

            System.out.println("fillData: rowsCount = " + rowsCount);
        } else {
            assist1.setVisibility(View.INVISIBLE);
            categoryAssist.setVisibility(View.VISIBLE);


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
                        ///////////////////////////////////////////////////

                        // проверяем возрастную категорию
                        System.out.println("fillData : пробуем выявить возрастную категорию...");

                        // создаем экземпляр DatabaseOfTerms
                        DatabaseOfTerms database = new DatabaseOfTerms(edit_page_1.this);

                        // вызываем метод через экземпляр
                        String[] words = te.split("\\s+"); // Разделить строку на отдельные слова
                        int ageCategory = 0;
                        termins = 0;
                        // пока есть слова
                        for (String word : words) {
                            word = word.toLowerCase();
                            ageCategory = database.getAgeCategoryByTerm(word);
                            if (ageCategory == -1) { // если слова нет в бд, возрастная  категория этого слова = 0
                                ageCategory = 0;
                            }

                            System.out.println("Word: " + word + ", Age Category: " + ageCategory);

                            System.out.println("a : ageCategory = " + ageCategory + ", ageCategoryGlobal = " + ageCategoryGlobal);

                            if (ageCategory >= ageCategoryGlobal) { // если слово есть в бд и его категория больше глобальной
                                ageCategoryGlobal = ageCategory; // обновляем глобальное
                                termins += 1; // прибавляем термин, отвечающий за кол-во таких слов

                                System.out.println("a : ageCategory = " + ageCategory + ", ageCategoryGlobal был изменён на " + ageCategoryGlobal);

                            } else {
                                ageCategory = ageCategoryGlobal; //
                            }
                        }
                        System.out.println("количество найденных терминов из БД = " + termins);

                        if (termins > 0) {
                            //ageCategoryGlobal = ageCategoryGlobal;
                        } else {
                            ageCategoryGlobal = 0;
                        }
                        System.out.println("fillData : определена  возрастная категория: " + ageCategoryGlobal);
                        // делаем видимой подсказку ассистента
                        assist1.setVisibility(View.INVISIBLE);
                        assist2.setVisibility(View.INVISIBLE);
                        assist3.setVisibility(View.INVISIBLE);
                        assistent.setVisibility(View.VISIBLE);
                        categoryAssist.setVisibility(View.VISIBLE);
                        categoryAssist.setText(old + " " + ageCategory + "+");

                    }
                });

                TextInputEditText b = new TextInputEditText(this);
                b.setWidth(240);
                //b.setHeight(500);
                b.setPadding(5, 5, 5, 5);
                b.setGravity(Gravity.LEFT);
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

                        ///////////////////////////////////////////////////

                        // проверяем возрастную категорию
                        System.out.println("fillData : пробуем выявить возрастную категорию...");

                        // создаем экземпляр DatabaseOfTerms
                        DatabaseOfTerms database = new DatabaseOfTerms(edit_page_1.this);

                        // вызываем метод через экземпляр
                        String[] words = te.split("\\s+"); // Разделить строку на отдельные слова
                        int ageCategory = 0;
                        termins = 0;
                        // пока есть слова
                        for (String word : words) {
                            word = word.toLowerCase();
                            ageCategory = database.getAgeCategoryByTerm(word);
                            if (ageCategory == -1) { // если слова нет в бд, возрастная  категория этого слова = 0
                                ageCategory = 0;
                            }
                            System.out.println("Word: " + word + ", Age Category: " + ageCategory);
                            System.out.println("b : ageCategory = " + ageCategory + ", ageCategoryGlobal = " + ageCategoryGlobal);

                            if (ageCategory >= ageCategoryGlobal) { // если слово есть в бд и его категория больше глобальной
                                ageCategoryGlobal = ageCategory; // обновляем глобальное
                                termins += 1; // прибавляем термин, отвечающий за кол-во таких слов

                                System.out.println("b : ageCategory = " + ageCategory + ", ageCategoryGlobal был изменён на " + ageCategoryGlobal);
                            } else {
                                ageCategory = ageCategoryGlobal; //
                            }
                        }
                        System.out.println("количество найденных терминов из БД = " + termins);

                        if (termins > 0) {
                            //ageCategoryGlobal = ageCategoryGlobal;
                        } else {
                            ageCategoryGlobal = 0;
                        }
                        System.out.println("fillData : определена  возрастная категория: " + ageCategoryGlobal);
                        // делаем видимой подсказку ассистента
                        assist1.setVisibility(View.INVISIBLE);
                        assist2.setVisibility(View.INVISIBLE);
                        assist3.setVisibility(View.INVISIBLE);
                        assistent.setVisibility(View.VISIBLE);
                        categoryAssist.setVisibility(View.VISIBLE);
                        categoryAssist.setText(old + " " + ageCategory + "+");

                    }
                });

                // Добавляем клонированную строку в таблицу
                stk.addView(clonedTableRow);
            }
        }

        sPref = getSharedPreferences(filename, MODE_PRIVATE);
        // для проверки после заполнения
        lastId = Integer.parseInt(sPref.getString("lastId", ""));
        System.out.println("после кода, lastId в fillData: " + lastId);


    }

    public void addRow() {
        sPref = getSharedPreferences(filename, MODE_PRIVATE);
        // для проверки, содержит ли файл число
        String lastIdString = sPref.getString("lastId", "");

        System.out.println("addRow : lastIdString " + lastIdString);

        if (!lastIdString.isEmpty() && lastIdString.matches("\\d+")) {
            lastId = Integer.parseInt(lastIdString);
            System.out.println("addRow : результат проверки lastId = " + lastId);
        } else {
            lastId = 0;
            System.out.println("addRow : строка lastId не может быть преобразована в число");
        }

        String rowsCountString = sPref.getString("rowsCount", "");

        System.out.println("addRow : rowsCountString " + rowsCountString);

        if (!rowsCountString.isEmpty() && rowsCountString.matches("\\d+")) {
            rowsCount = Integer.parseInt(rowsCountString);
            System.out.println("addRow : результат проверки rowsCount = " + rowsCount);
        } else {
            rowsCount = 0;
            System.out.println("addRow : строка rowsCount не может быть преобразована в число");
        }


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


        clonedTableRow.addView(a);
        clonedTableRow.addView(b);
        //clonedTableRow.addView(c);
        stk.addView(clonedTableRow);

        // обновляем lastId и rowsCount
        // при следующем вызове объекту будет дан увеличенный id
        lastId += 1;
        SharedPreferences.Editor ed1 = sPref.edit();
        //ed1.putString("lastId", String.valueOf(lastId));
        ed1.putString("lastId", String.valueOf(lastId));
        System.out.println("addRow, результат, lastId = " + lastId);

        rowsCount += 1; // добавляем единицу, поскольку теперь строчка есть
        // обновляем кол-во строчек в файле
        //ed1.putString("rowsCount", String.valueOf(rowsCount));
        ed1.putString("rowsCount", String.valueOf(rowsCount));
        ed1.commit();
        System.out.println("addRow, результат, rowsCount = " + rowsCount);
    }

    public void deleteRow() {
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        // узнаём lastId
        sPref = getSharedPreferences(filename, MODE_PRIVATE);
        String last = sPref.getString("lastId", "");
        System.out.println("deleteRow : last " + last);

        lastId = Integer.parseInt(last);
        System.out.println("deleteRow : lastId " + lastId);

        // очищаем данные перед удалением
        SharedPreferences.Editor ed1 = sPref.edit();
        ed1.remove("a" + lastId);
        ed1.remove("b" + lastId);

        // убираем строчку из таблицы
        stk.removeView(findViewById(lastId));

        // убавляем счётчик
        lastId -= 1;
        rowsCount -= 1;
        // фиксируем изменения
        ed1.putString("lastId", String.valueOf(lastId));
        ed1.putString("rowsCount", String.valueOf(rowsCount));

        ed1.commit();
    }

    public void saveData(String text, String tag) {
        sPref = getSharedPreferences(filename, MODE_PRIVATE);
        SharedPreferences.Editor ed1 = sPref.edit();
        ed1.putString(tag, text);
        ed1.commit();
    }

    public void checkFileWords(){
        String text;
        //sPref = getSharedPreferences(filename, MODE_PRIVATE);
    }

    // отправляем данные на сервер
    public void sendToServer() {

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
